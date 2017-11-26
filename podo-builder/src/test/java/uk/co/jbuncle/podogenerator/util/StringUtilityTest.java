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

import uk.co.jbuncle.podogenerator.util.StringUtility;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author James Buncle <jbuncle@hotmail.com>
 */
public class StringUtilityTest {

    /**
     * Test of lcfirst method, of class StringUtility.
     */
    @Test
    public void testLcfirst() {
        System.out.println("lcfirst");
        assertEquals("lowerCaseMe", StringUtility.lcfirst("LowerCaseMe"));
        assertEquals("lOWERCASEME", StringUtility.lcfirst("LOWERCASEME"));
        assertEquals("1LOWERCASEME", StringUtility.lcfirst("1LOWERCASEME"));
        assertEquals("lower", StringUtility.lcfirst("lower"));
    }

    /**
     * Test of ucfirst method, of class StringUtility.
     */
    @Test
    public void testUcfirst() {
        System.out.println("ucfirst");
        assertEquals("UpperCaseMe", StringUtility.ucfirst("upperCaseMe"));
        assertEquals("UpperCaseMe", StringUtility.ucfirst("UpperCaseMe"));
        assertEquals("Upper", StringUtility.ucfirst("upper"));
        assertEquals("1as", StringUtility.ucfirst("1as"));
    }

}
