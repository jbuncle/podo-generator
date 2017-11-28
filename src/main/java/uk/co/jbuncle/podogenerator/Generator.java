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

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import uk.co.jbuncle.podogenerator.format.Formatter;
import uk.co.jbuncle.podogenerator.podo.Podo;
import uk.co.jbuncle.podogenerator.podo.PodoFromMap;
import uk.co.jbuncle.podogenerator.util.FileUtil;

/**
 *
 * @author James Buncle <jbuncle@hotmail.com>
 */
public class Generator {

    private final Formatter formatter;
    private final PodoFromMap podoFromMap;

    public static Generator createGenerator() {
        final Formatter formatter = new Formatter();
        final PodoFromMap pfm = new PodoFromMap();
        return new Generator(formatter, pfm);
    }

    public Generator(final Formatter formatter, final PodoFromMap podoFromMap) {
        this.formatter = formatter;
        this.podoFromMap = podoFromMap;
    }

    public static void generateClasses(
            final Map<String, Object> map,
            final File dir,
            final String packageName
    ) throws IOException {
        Generator.createGenerator().generate(map, dir, packageName);
    }

    public void generate(
            final Map<String, Object> map,
            final File dir,
            final String packageName
    ) throws IOException {
        final Set<Podo> podos = this.podoFromMap.build(packageName, map);
        for (final Podo podo : podos) {
            final String classContent = formatter.format(podo);
            final File file = new File(dir, podo.getClassName() + ".java");
            FileUtil.write(file, classContent);
        }
    }
}
