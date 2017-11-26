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

import uk.co.jbuncle.podogenerator.util.TypeInferer;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author James Buncle <jbuncle@hotmail.com>
 */
public class TypeInfererTest {

    /**
     * Test of inferListType method, of class TypeInferer.
     */
    @Test
    public void testInferListType() {
        System.out.println("inferListType");
        List list = new LinkedList();
        list.add("1.1");

        String result = (new TypeInferer()).inferListType(list);
        assertEquals("List<Double>", result);
    }

    /**
     * Test of inferType method, of class TypeInferer.
     */
    @Test
    public void testInferType() {
        System.out.println("inferType");
        TypeInferer instance = new TypeInferer();
        assertEquals("boolean", instance.inferType("true"));
        assertEquals("boolean", instance.inferType("false"));
        assertEquals("double", instance.inferType("1.1"));
        assertEquals("int", instance.inferType("9"));
        assertEquals("char", instance.inferType("c"));
        assertEquals("String", instance.inferType("hello"));
        
    }

}
