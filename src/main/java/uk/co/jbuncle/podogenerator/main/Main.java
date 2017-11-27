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
package uk.co.jbuncle.podogenerator.main;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import uk.co.jbuncle.podogenerator.Pod;
import uk.co.jbuncle.podogenerator.PodoGenerator;
import uk.co.jbuncle.podogenerator.format.Formatter;

/**
 *
 * @author James Buncle <jbuncle@hotmail.com>
 */
public class Main {

    public static void main(String[] args) {

        final Map<String, Object> map = new HashMap<>();
        map.put("test", "somevalue");
        map.put("test1", "1");
        map.put("test3", "true");
        map.put("MyComplexObject", new HashMap(map));

        List<String> items = new LinkedList<>();
        items.add("listitem1");
        items.add("listitem2");
        items.add("listitem3");

        map.put("listItems", items);

        final PodoGenerator podoGenerator = new PodoGenerator("uk.co.jbuncle.client");
        podoGenerator.build("MyClient", map);

        for (Pod pods : podoGenerator.build(map)) {
            System.out.println(new Formatter().format(pods));
        }
    }
}
