/*
 * The MIT License
 *
 * Copyright 2017 James Buncle <jbuncle@hotmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package uk.co.jbuncle.podogenerator.util;

import java.util.List;

/**
 *
 * @author James Buncle <jbuncle@hotmail.com>
 */
public class TypeInferer {

    public String inferListType(List list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Cannot infer type of empty list");
        }
        Object firstValue = list.get(0);
        return "List<" + StringUtility.ucfirst(inferType(firstValue)) + ">";
    }

    public String inferType(final Object value) {
        if (isBoolean(value)) {
            return "boolean";
        } else if (isInteger(value)) {
            return "int";
        } else if (isCharacter(value)) {
            return "char";
        } else if (isDouble(value)) {
            return "double";
        } else {
            return "String";
        }
    }

    private boolean isBoolean(final Object value) {
        if (value instanceof Boolean) {
            return true;
        }
        if (value instanceof String) {
            final String string = (String) value;
            return string.equalsIgnoreCase("true") || string.equalsIgnoreCase("false");
        }
        return false;
    }

    private boolean isCharacter(final Object value) {
        if (value instanceof Character) {
            return true;
        }
        if (value instanceof String) {
            final String string = (String) value;
            return string.length() == 1;
        }
        return false;
    }

    private boolean isInteger(final Object value) {
        if (value instanceof Integer) {
            return true;
        }
        if (value instanceof String) {
            final String string = (String) value;
            try {
                Integer.parseInt(string);
                return true;
            }
            catch (NumberFormatException nfe) {
                return false;
            }
        }
        return false;
    }

    private boolean isDouble(final Object value) {
        if (value instanceof Double) {
            return true;
        }
        if (value instanceof String) {
            final String string = (String) value;
            try {
                Double.parseDouble(string);
                return true;
            }
            catch (NumberFormatException nfe) {
                return false;
            }
        }
        return false;
    }

}
