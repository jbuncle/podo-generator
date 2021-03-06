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

import uk.co.jbuncle.podogenerator.podo.Member;
import uk.co.jbuncle.podogenerator.podo.Podo;
import uk.co.jbuncle.podogenerator.util.StringUtility;

/**
 *
 * @author James Buncle <jbuncle@hotmail.com>
 */
public class Formatter {


    public String format(Podo pod) {
        StringBuilder sb = new StringBuilder();

        sb.append("package ").append(pod.getPackageName()).append(";\n");
        sb.append("\n");
        sb.append("import java.util.List;\n");
        sb.append("\n");
        sb.append("public class ").append(pod.getClassName()).append("{\n");
        sb.append("\n");
        sb.append(this.generateMembers(pod));
        sb.append("\n");
        sb.append(this.generateGetters(pod));
        sb.append("\n");
        sb.append(this.generateSetters(pod));
        sb.append("\n");
        sb.append("}\n");
        return sb.toString();
    }

    private String generateMembers(Podo pod) {
        final StringBuilder sb = new StringBuilder();

        for (final Member member : pod.getMembers()) {
            sb.append("    ").append("public ").append(member.getType()).append(" ").append(member.getName()).append(';').append('\n');
        }

        return sb.toString();
    }

    private String generateGetters(Podo pod) {
        final StringBuilder sb = new StringBuilder();
        for (Member member : pod.getMembers()) {
            sb.append(generateGetter(member));
        }
        return sb.toString();
    }

    private String generateGetter(final Member member) {
        final StringBuilder sb = new StringBuilder();
        sb.append("    ").append("public ").append(member.getType()).append(' ').append(memberToGetterMethodName(member)).append("(){").append('\n');
        sb.append("        return this.").append(member.getName()).append(";\n");
        sb.append("    }\n");
        return sb.toString();
    }

    private String generateSetters(Podo pod) {
        final StringBuilder sb = new StringBuilder();
        for (Member member : pod.getMembers()) {
            sb.append(generateSetter(member));
        }
        return sb.toString();
    }

    private String generateSetter(final Member member) {
        final StringBuilder sb = new StringBuilder();
        sb.append("    ").append("public void ").append(memberToSetterMethodName(member)).append("(").append(member.getType()).append(" ").append(member.getName()).append("){").append('\n');
        sb.append("        this.").append(member.getName()).append(" = ").append(member.getName()).append(";\n");
        sb.append("    }\n");
        return sb.toString();
    }

    private String memberToSetterMethodName(final Member member) {
        return "set" + StringUtility.ucfirst(member.getName());
    }

    private String memberToGetterMethodName(final Member member) {
        return "get" + StringUtility.ucfirst(member.getName());
    }

}
