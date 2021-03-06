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
package uk.co.jbuncle.podogenerator.podo;

import java.util.Objects;
import uk.co.jbuncle.podogenerator.util.StringUtility;

/**
 *
 * @author James Buncle <jbuncle@hotmail.com>
 */
public class Member {

    private final String name;
    private final String type;

    public Member(String type, String name) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        if (isReservedType()) {
            return "_" + this.name;
        }
        return StringUtility.lcfirst(name);
    }

    private boolean isReservedType() {
        switch (this.name) {
            case "int":
                return true;
            case "char":
                return true;

            default:
                return false;
        }
    }

    public String getType() {
        return type;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.type);
        return hash;
    }
}
