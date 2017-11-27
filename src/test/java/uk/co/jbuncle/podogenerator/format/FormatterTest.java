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
package uk.co.jbuncle.podogenerator.format;

import uk.co.jbuncle.podogenerator.format.Formatter;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import static org.junit.Assert.*;
import uk.co.jbuncle.podogenerator.podo.Member;
import uk.co.jbuncle.podogenerator.podo.Podo;

/**
 *
 * @author James Buncle <jbuncle@hotmail.com>
 */
public class FormatterTest {

    /**
     * Test of format method, of class Formatter.
     */
    @Test
    public void testFormat() throws IOException {
        System.out.println("format");

        Podo pod = new Podo("my.test.package", "MyTestClass");
        pod.addMember(new Member("String", "Test"));

        Formatter instance = new Formatter();
        String result = instance.format(pod);
        final String expected = getResource("expected.txt");
        assertEquals(expected, result);
    }

    private String getResource(String path) throws IOException {
        InputStream inputStream
                = this.getClass().getClassLoader().getResourceAsStream(path);
        return streamToString(inputStream).replaceAll("\r\n", "\n");
    }

    private String streamToString(InputStream inputStream) throws UnsupportedEncodingException, IOException {
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        int result = bis.read();
        while (result != -1) {
            buf.write((byte) result);
            result = bis.read();
        }
// StandardCharsets.UTF_8.name() > JDK 7
        return buf.toString("UTF-8");
    }

}
