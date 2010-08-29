/*
 * Copyright 2010 Ed Venaglia
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package net.venaglia.nondairy.soylang;

import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;
import net.venaglia.nondairy.soylang.elements.AbsoluteTemplateNameRef;
import net.venaglia.nondairy.soylang.elements.CallParameterRefElement;
import net.venaglia.nondairy.soylang.elements.NamespaceDefElement;
import net.venaglia.nondairy.soylang.elements.NamespaceTagElement;
import net.venaglia.nondairy.soylang.elements.ParameterDefElement;
import net.venaglia.nondairy.soylang.elements.ParameterRefElement;
import net.venaglia.nondairy.soylang.elements.LocalTemplateNameDef;
import net.venaglia.nondairy.soylang.elements.LocalTemplateNameRef;
import net.venaglia.nondairy.soylang.elements.factory.PsiElementClass;
import org.jetbrains.annotations.NonNls;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by IntelliJ IDEA.
 * User: ed
 * Date: Aug 2, 2010
 * Time: 8:10:53 PM
 */
public final class SoyElement extends IElementType {

    private static final SortedMap<Short,SoyElement> ALL_ELEMENTS_BY_VALUE = new TreeMap<Short,SoyElement>();
    private static final SortedMap<String,SoyElement> ALL_ELEMENTS_BY_NAME = new TreeMap<String,SoyElement>();

    public static final SoyElement soy_file = new SoyElement(0, "soy_file");

    public static final SoyElement tag_pair = new SoyElement(1000, "tag_pair");
    public static final SoyElement tag = new SoyElement(1001, "tag");
    public static final SoyElement tag_between_braces = new SoyElement(1002, "tag_between_braces");
    public static final SoyElement tag_content_plain = new SoyElement(1003, "tag_content_plain");
    public static final SoyElement tag_content_html = new SoyElement(1004, "tag_content_html");
    public static final SoyElement tag_content_js = new SoyElement(1005, "tag_content_js");
    public static final SoyElement tag_and_doc_comment = new SoyElement(1006, "tag_and_doc_comment");
    public static final SoyElement iterator_tag = new SoyElement(1007, "iterator_tag");
    public static final SoyElement iterator_tag_pair = new SoyElement(1008, "iterator_tag_pair");

    @PsiElementClass(NamespaceTagElement.class)
    public static final SoyElement namespace_def = new SoyElement(1101, "namespace_def");
    @PsiElementClass(NamespaceDefElement.class)
    public static final SoyElement namespace_name = new SoyElement(1102, "namespace_name");

    public static final SoyElement template_tag = new SoyElement(1200, "template_tag");
    @PsiElementClass(LocalTemplateNameDef.class)
    public static final SoyElement template_name = new SoyElement(1201, "template_name");
    @PsiElementClass(LocalTemplateNameRef.class)
    public static final SoyElement template_name_ref = new SoyElement(1202, "template_name_ref");
    @PsiElementClass(AbsoluteTemplateNameRef.class)
    public static final SoyElement template_name_ref_absolute = new SoyElement(1203, "template_name_ref_absolute");
    public static final SoyElement template_tag_pair = new SoyElement(1204, "template_tag_pair");

    public static final SoyElement doc_comment = new SoyElement(1300, "doc_comment");
    public static final SoyElement doc_comment_text = new SoyElement(1301, "doc_comment_text");
    public static final SoyElement doc_comment_tag = new SoyElement(1302, "doc_comment_tag");
    @PsiElementClass(ParameterDefElement.class)
    public static final SoyElement doc_comment_param = new SoyElement(1303, "doc_comment_param");

    public static final SoyElement attribute = new SoyElement(1400, "attribute");
    public static final SoyElement attribute_key = new SoyElement(1401, "attribute_key");
    public static final SoyElement attribute_value = new SoyElement(1403, "attribute_value");

    public static final SoyElement directive = new SoyElement(1500, "directive");
    public static final SoyElement directive_key = new SoyElement(1502, "directive_key");
    public static final SoyElement directive_value = new SoyElement(1503, "directive_value");
    public static final SoyElement directive_value_list = new SoyElement(1504, "directive_value_list");

    public static final SoyElement command_keyword = new SoyElement(1600, "command_keyword");

    public static final SoyElement function_call = new SoyElement(1700, "function_call");
    public static final SoyElement function_call_name = new SoyElement(1701, "function_call_name");
    public static final SoyElement function_call_args = new SoyElement(1702, "function_call_args");
    public static final SoyElement function_call_arg_list = new SoyElement(1703, "function_call_arg_list");

    public static final SoyElement expression = new SoyElement(1800, "expression");
    public static final SoyElement constant_expression = new SoyElement(1801, "constant_expression");
    public static final SoyElement global_expression = new SoyElement(1802, "global_expression");
    @PsiElementClass(ParameterDefElement.class)
    public static final SoyElement parameter_def = new SoyElement(1803, "parameter_def");
    @PsiElementClass(ParameterRefElement.class)
    public static final SoyElement parameter_ref = new SoyElement(1804, "parameter_ref");
    @PsiElementClass(CallParameterRefElement.class)
    public static final SoyElement invocation_parameter_ref = new SoyElement(1805, "invocation_parameter_ref");
    public static final SoyElement member_property_ref = new SoyElement(1806, "member_property_ref");
    public static final SoyElement bracket_property_ref = new SoyElement(1807, "bracket_property_ref");

    public static final SoyElement call_tag = new SoyElement(1900, "call_tag");
    public static final SoyElement call_tag_pair = new SoyElement(1901, "call_tag_pair");
    public static final SoyElement param_tag = new SoyElement(1902, "param_tag");

    public static final SoyElement template_content = new SoyElement(4000, "template_content");

    public static final SoyElement ignored_text = new SoyElement(7000, "ignored_text");
    public static final SoyElement invalid_text = new SoyElement(7001, "invalid_text");
    public static final SoyElement tag_error = new SoyElement(7002, "tag_error");

    public static final SoyElement unexpected_symbol = new SoyElement(8000, "unexpected_symbol");

    static {
        for (Field field : SoyElement.class.getFields()) {
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers) &&
                Modifier.isFinal(modifiers) && SoyElement.class.equals(field.getType())) {
                try {
                    SoyElement soyElement = (SoyElement)field.get(null);
                    if (soyElement == null) {
                        throw new AssertionError("Token constant is null: " + field.getName());
                    }
                    if (!field.getName().equals(soyElement.name())) {
                        @SuppressWarnings({ "HardCodedStringLiteral" })
                        String declaration = String.format("SoyToken %s = new SoyToken(%d,\"%s\");",
                                                           field.getName(),
                                                           soyElement.value(),
                                                           soyElement.name());
                        throw new AssertionError("Field name does not match assigned name:\n\t" + declaration);
                    }
                    SoyElement identityElement = ALL_ELEMENTS_BY_VALUE.get(soyElement.value());
                    if (soyElement != identityElement) {
                        String msg = "Duplicate token value: %d assigned to '%s' and '%s'"; //NON-NLS
                        throw new AssertionError(String.format(msg, soyElement.value(), soyElement.name(), identityElement.name()));
                    }
                } catch (IllegalAccessException e) {
                    // shouldn't happen
                }
            }
        }
    }

    private final short value;
    private final String name;

    private SoyElement(int value, @NonNls String name) {
        this(value, name, SoyLanguage.INSTANCE);
    }

    private SoyElement(int value, @NonNls String name, Language l) {
        super(name, l, true);
        this.value = (short)value;
        this.name = name;
        ALL_ELEMENTS_BY_VALUE.put(this.value, this);
        ALL_ELEMENTS_BY_NAME.put(this.name, this);
    }

    public short value() {
        return value;
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SoyElement soyElement = (SoyElement)o;
        return value == soyElement.value;
    }

    @Override
    public int hashCode() {
        return (int)value;
    }

    @Override
    public String toString() {
        return name + "." + value;
    }

    public static SoyElement valueOf(String name) {
        return ALL_ELEMENTS_BY_NAME.get(name);
    }
}
