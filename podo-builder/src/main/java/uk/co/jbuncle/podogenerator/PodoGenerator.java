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
package uk.co.jbuncle.podogenerator;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import uk.co.jbuncle.podogenerator.util.StringUtility;
import uk.co.jbuncle.podogenerator.util.TypeInferer;

/**
 *
 * @author James Buncle <jbuncle@hotmail.com>
 */
public class PodoGenerator {

    private final Set<Pod> dataStructureClasses;
    private final String packageName;

    public PodoGenerator(final String packageName) {
        this.dataStructureClasses = new LinkedHashSet<>();
        this.packageName = packageName;
    }

    public Set<Pod> build(final String className, final Map<String, Object> members) {
        this.createForEntry(className, members);;
        return dataStructureClasses;
    }

    public Set<Pod> build(final Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Map) {
                this.createForEntry(key, (Map) value);
            } else {
                // Assume native type
            }
        }
        return dataStructureClasses;
    }

    private void createForEntry(final String className, final Map<String, Object> map) {
        final Pod pods = new Pod(packageName, className);
        this.dataStructureClasses.add(pods);

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            final String key = entry.getKey();
            final Object value = entry.getValue();
            pods.addMember(createMemberForEntry(key, value));
        }
    }

    private Member createMemberForEntry(final String name, final Object value) {
        final String type;
        if (value instanceof Map) {
            Map map = (Map) value;
            type = StringUtility.ucfirst(name);
            this.createForEntry(type, map);
        } else if (value instanceof List) {
            final List list = (List) value;
            type = (new TypeInferer()).inferListType(list);
        } else {
            type = (new TypeInferer()).inferType(value);
        }

        return new Member(type, name);
    }

}
