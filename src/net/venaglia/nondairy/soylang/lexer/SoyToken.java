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

package net.venaglia.nondairy.soylang.lexer;

import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.intellij.psi.xml.XmlTokenType;
import net.venaglia.nondairy.soylang.SoyLanguage;
import org.jetbrains.annotations.NonNls;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by IntelliJ IDEA.
 * User: ed
 * Date: Jul 9, 2010
 * Time: 2:40:27 PM
 */
public final class SoyToken extends IElementType {

    private static final SortedMap<Short,SoyToken> ALL_TOKENS_BY_VALUE = new TreeMap<Short,SoyToken>();
    
    // non-code structures
    public static final SoyToken WHITESPACE = new SoyToken(0, "WHITESPACE");

    public static final SoyToken COMMENT = new SoyToken(100, "COMMENT");
    public static final SoyToken DOC_COMMENT = new SoyToken(101, "DOC_COMMENT");
    public static final SoyToken DOC_COMMENT_WHITESPACE = new SoyToken(102, "DOC_COMMENT_WHITESPACE");
    public static final SoyToken DOC_COMMENT_TAG = new SoyToken(103, "DOC_COMMENT_TAG");
    public static final SoyToken DOC_COMMENT_IDENTIFIER = new SoyToken(104, "DOC_COMMENT_IDENTIFIER");
    public static final SoyToken DOC_COMMENT_END = new SoyToken(105, "DOC_COMMENT_END");

    // everything not in braces or doc comments
//    public static final SoyToken TEMPLATE_TEXT = new SoyToken(150, "TEMPLATE_TEXT", Language.findLanguageByID("HTML")); //NON-NLS
    public static final SoyToken TEMPLATE_TEXT = new SoyToken(150, "TEMPLATE_TEXT");
//    public static final SoyToken IGNORED_TEXT = new SoyToken(151, "IGNORED_TEXT", Language.findLanguageByID("PlainText")); //NON-NLS
    public static final SoyToken IGNORED_TEXT = new SoyToken(151, "IGNORED_TEXT");
//    public static final SoyToken LITERAL_TEXT = new SoyToken(152, "LITERAL_TEXT", Language.findLanguageByID("HTML")); //NON-NLS
    public static final SoyToken LITERAL_TEXT = new SoyToken(152, "LITERAL_TEXT");

    // identifier tokens
    public static final SoyToken PARAMETER_REF = new SoyToken(200, "PARAMETER_REF");
    public static final SoyToken NAMESPACE_IDENTIFIER = new SoyToken(201, "NAMESPACE_IDENTIFIER");
    public static final SoyToken TEMPLATE_IDENTIFIER = new SoyToken(202, "TEMPLATE_IDENTIFIER");
    public static final SoyToken CAPTURED_IDENTIFIER = new SoyToken(203, "CAPTURED_IDENTIFIER");
    public static final SoyToken CAPTURED_FUNCTION_IDENTIFIER = new SoyToken(204, "CAPTURED_FUNCTION_IDENTIFIER");
    public static final SoyToken STRING_PARAMETER_REF = new SoyToken(205, "STRING_PARAMETER_REF");

    // command tag pairs
    public static final SoyToken TEMPLATE = new SoyToken(300, "TEMPLATE");
    public static final SoyToken LITERAL = new SoyToken(301, "LITERAL");
    public static final SoyToken MSG = new SoyToken(302, "MSG");
    public static final SoyToken IF = new SoyToken(303, "IF");
    public static final SoyToken SWITCH = new SoyToken(304, "SWITCH");
    public static final SoyToken FOREACH = new SoyToken(305, "FOREACH");
    public static final SoyToken FOR = new SoyToken(306, "FOR");
    public static final SoyToken CALL = new SoyToken(307, "CALL");
    public static final SoyToken PARAM = new SoyToken(308, "PARAM");

    // commands
    public static final SoyToken NAMESPACE = new SoyToken(400, "NAMESPACE");
    public static final SoyToken PRINT = new SoyToken(401, "PRINT");
    public static final SoyToken PRINT_IMPLICIT = new SoyToken(402, "PRINT_IMPLICIT");
    public static final SoyToken ELSE_IF = new SoyToken(403, "ELSE_IF");
    public static final SoyToken ELSE = new SoyToken(404, "ELSE");
    public static final SoyToken CASE = new SoyToken(405, "CASE");
    public static final SoyToken DEFAULT = new SoyToken(406, "DEFAULT");
    public static final SoyToken IF_EMPTY = new SoyToken(407, "IF_EMPTY");
    public static final SoyToken CSS = new SoyToken(408, "CSS");

    // special characters
    public static final SoyToken SP_LITERAL = new SoyToken(500, "SP_LITERAL");
    public static final SoyToken NIL_LITERAL = new SoyToken(501, "NIL_LITERAL");
    public static final SoyToken CR_LITERAL = new SoyToken(502, "CR_LITERAL");
    public static final SoyToken LF_LITERAL = new SoyToken(503, "LF_LITERAL");
    public static final SoyToken TAB_LITERAL = new SoyToken(504, "TAB_LITERAL");
    public static final SoyToken LB_LITERAL = new SoyToken(505, "LB_LITERAL");
    public static final SoyToken RB_LITERAL = new SoyToken(506, "RB_LITERAL");

    // template attributes
//    public static final SoyToken PRIVATE = new SoyToken(550, "PRIVATE");
//    public static final SoyToken AUTOESCAPE = new SoyToken(551, "AUTOESCAPE");

    // msg attributes
//    public static final SoyToken DESC = new SoyToken(560, "DESC");
//    public static final SoyToken MEANING = new SoyToken(561, "MEANING");

    // call attributes
//    public static final SoyToken DATA = new SoyToken(570, "DATA");

    // print directives
    public static final SoyToken DIRECTIVE_IDENTIFIER = new SoyToken(600, "DIRECTIVE_IDENTIFIER");
    public static final SoyToken DIRECTIVE_PIPE = new SoyToken(601, "DIRECTIVE_PIPE");
    public static final SoyToken DIRECTIVE_COLON = new SoyToken(602, "DIRECTIVE_COLON");
    public static final SoyToken DIRECTIVE_COMMA = new SoyToken(603, "DIRECTIVE_COMMA");
//    public static final SoyToken NO_AUTOESCAPE = new SoyToken(610, "NO_AUTOESCAPE");
//    public static final SoyToken ID = new SoyToken(611, "ID");
//    public static final SoyToken ESCAPE_HTML = new SoyToken(612, "ESCAPE_HTML");
//    public static final SoyToken ESCAPE_URI = new SoyToken(613, "ESCAPE_URI");
//    public static final SoyToken ESCAPE_JS = new SoyToken(614, "ESCAPE_JS");
//    public static final SoyToken INSERT_WORD_BREAKS = new SoyToken(615, "INSERT_WORD_BREAKS");
//    public static final SoyToken BIDI_SPAN_WRAP = new SoyToken(616, "BIDI_SPAN_WRAP");
//    public static final SoyToken BIDI_UNICODE_WRAP = new SoyToken(617, "BIDI_UNICODE_WRAP");

    // functions
//    public static final SoyToken IS_FIRST = new SoyToken(650, "IS_FIRST");
//    public static final SoyToken IS_LAST = new SoyToken(651, "IS_LAST");
//    public static final SoyToken INDEX = new SoyToken(652, "INDEX");
//    public static final SoyToken HAS_DATA = new SoyToken(653, "HAS_DATA");
//    public static final SoyToken LENGTH = new SoyToken(654, "LENGTH");
//    public static final SoyToken ROUND = new SoyToken(655, "ROUND");
//    public static final SoyToken FLOOR = new SoyToken(656, "FLOOR");
//    public static final SoyToken CEILING = new SoyToken(657, "CEILING");
//    public static final SoyToken MIN = new SoyToken(658, "MIN");
//    public static final SoyToken MAX = new SoyToken(659, "MAX");
//    public static final SoyToken RANDOM_INT = new SoyToken(660, "RANDOM_INT");
//    public static final SoyToken BIDI_GLOBAL_DIR = new SoyToken(661, "BIDI_GLOBAL_DIR");
//    public static final SoyToken BIDI_DIR_ATTR = new SoyToken(662, "BIDI_DIR_ATTR");
//    public static final SoyToken BIDI_MARK = new SoyToken(663, "BIDI_MARK");
//    public static final SoyToken BIDI_MARK_AFTER = new SoyToken(664, "BIDI_MARK_AFTER");
//    public static final SoyToken BIDI_START_EDGE = new SoyToken(665, "BIDI_START_EDGE");
//    public static final SoyToken BIDI_END_EDGE = new SoyToken(666, "BIDI_END_EDGE");
//    public static final SoyToken BIDI_TEXT_DIR = new SoyToken(667, "BIDI_TEXT_DIR");

    // iterator keywords
    public static final SoyToken IN = new SoyToken(700, "IN");
    public static final SoyToken RANGE = new SoyToken(701, "RANGE");

    // literals
    public static final SoyToken NULL_LITERAL = new SoyToken(750, "NULL_LITERAL");
    public static final SoyToken BOOLEAN_LITERAL = new SoyToken(751, "BOOLEAN_LITERAL");
    public static final SoyToken INTEGER_LITERAL = new SoyToken(752, "INTEGER_LITERAL");
    public static final SoyToken FLOATING_POINT_LITERAL = new SoyToken(753, "FLOATING_POINT_LITERAL");
    public static final SoyToken STRING_LITERAL_BEGIN = new SoyToken(754, "STRING_LITERAL_BEGIN");
    public static final SoyToken STRING_LITERAL = new SoyToken(755, "STRING_LITERAL");
    public static final SoyToken STRING_LITERAL_ESCAPE = new SoyToken(756, "STRING_LITERAL_ESCAPE");
    public static final SoyToken STRING_LITERAL_END = new SoyToken(757, "STRING_LITERAL_END");

    // surrounding pairs
    public static final SoyToken LPAREN = new SoyToken(800, "LPAREN");
    public static final SoyToken RPAREN = new SoyToken(801, "RPAREN");
    public static final SoyToken LBRACK = new SoyToken(802, "LBRACK");
    public static final SoyToken RBRACK = new SoyToken(803, "RBRACK");
    public static final SoyToken LBRACE = new SoyToken(804, "LBRACE");
    public static final SoyToken RBRACE = new SoyToken(805, "RBRACE");

    // tag surrounding pairs
    public static final SoyToken TAG_LBRACE = new SoyToken(850, "TAG_LBRACE");
    public static final SoyToken TAG_RBRACE = new SoyToken(851, "TAG_RBRACE");
//    public static final SoyToken TAG_OPEN_RBRACE = new SoyToken(852, "TAG_OPEN_RBRACE");
    public static final SoyToken TAG_END_LBRACE = new SoyToken(853, "TAG_END_LBRACE");
    public static final SoyToken TAG_END_RBRACE = new SoyToken(854, "TAG_END_RBRACE");

    // operators
    public static final SoyToken EQ = new SoyToken(900, "EQ");
    public static final SoyToken EQEQ = new SoyToken(901, "EQEQ");
    public static final SoyToken GT = new SoyToken(902, "GT");
    public static final SoyToken LT = new SoyToken(903, "LT");
    public static final SoyToken NOT = new SoyToken(904, "NOT");
    public static final SoyToken AND = new SoyToken(905, "AND");
    public static final SoyToken OR = new SoyToken(906, "OR");
    public static final SoyToken QUESTION = new SoyToken(907, "QUESTION");
    public static final SoyToken COLON = new SoyToken(908, "COLON");
    public static final SoyToken LTEQ = new SoyToken(909, "LTEQ");
    public static final SoyToken GTEQ = new SoyToken(910, "GTEQ");
    public static final SoyToken NOTEQ = new SoyToken(911, "NOTEQ");
    public static final SoyToken PLUS = new SoyToken(912, "PLUS");
    public static final SoyToken MINUS = new SoyToken(913, "MINUS");
    public static final SoyToken UMINUS = new SoyToken(914, "UMINUS"); // used by cup parser
    public static final SoyToken MULT = new SoyToken(915, "MULT");
    public static final SoyToken DIV = new SoyToken(916, "DIV");
    public static final SoyToken MOD = new SoyToken(917, "MOD");
    public static final SoyToken DOT = new SoyToken(918, "DOT");
    public static final SoyToken COMMA = new SoyToken(919, "COMMA");

    // errors
    public static final SoyToken DUPLICATE_NAMESPACE_DECLARATION = new SoyToken(1000, "DUPLICATE_NAMESPACE_DECLARATION");
    public static final SoyToken BAD_STRING_ESCAPE = new SoyToken(1001, "BAD_STRING_ESCAPE");
    public static final SoyToken UNTERMINATED_STRING_LITERAL = new SoyToken(1002, "UNTERMINATED_STRING_LITERAL");
    public static final SoyToken UNTERMINATED_TEMPLATE = new SoyToken(1003, "UNTERMINATED_TEMPLATE");
    public static final SoyToken LBRACE_ERROR = new SoyToken(1004, "LBRACE_ERROR");
    public static final SoyToken RBRACE_ERROR = new SoyToken(1005, "RBRACE_ERROR");
    public static final SoyToken ILLEGAL_TAG_DECLARATION = new SoyToken(1006, "ILLEGAL_TAG_DECLARATION");
    public static final SoyToken ILLEGAL_CLOSE_TAG = new SoyToken(1007, "ILLEGAL_CLOSE_TAG");

    public static final SoyToken UNEXPECTED_EOF_IN_LITERAL_BLOCK = new SoyToken(1100, "UNEXPECTED_EOF_IN_LITERAL_BLOCK");
    public static final SoyToken UNEXPECTED_EOF_IN_TAG_DECLARATION = new SoyToken(1101, "UNEXPECTED_EOF_IN_TAG_DECLARATION");
    public static final SoyToken UNEXPECTED_EOF_IN_STRING_LITERAL = new SoyToken(1102, "UNEXPECTED_EOF_IN_STRING_LITERAL");
    public static final SoyToken UNEXPECTED_EOF_DOC_COMMENT = new SoyToken(1103, "UNEXPECTED_EOF_DOC_COMMENT");

    // eof marker
    public static final SoyToken EOF = new SoyToken(-1, "EOF");

    public static final TokenSet WHITESPACE_TOKENS = TokenSet.create(WHITESPACE, DOC_COMMENT_WHITESPACE, XmlTokenType.TAG_WHITE_SPACE);
    public static final TokenSet COMMENT_TOKENS = TokenSet.orSet(fromValueRange(100, 149), XmlTokenType.COMMENTS);
    public static final TokenSet DOC_COMMENT_TOKENS = fromValueRange(100, 149, COMMENT);
    public static final TokenSet STRING_LITERAL_TOKENS = or(fromValueRange(STRING_LITERAL_BEGIN, STRING_LITERAL_END),
                                                            STRING_PARAMETER_REF,
                                                            BAD_STRING_ESCAPE);

    public static final TokenSet CAPTURED_TEXT = TokenSet.create(TEMPLATE_TEXT, LITERAL_TEXT);
    public static final TokenSet COMMANDS = fromValueRange(300, 499, PRINT_IMPLICIT);
    public static final TokenSet SPECIAL_CHARS = fromValueRange(500, 599);
    public static final TokenSet DIRECTIVE_OPERATORS = TokenSet.create(DIRECTIVE_PIPE, DIRECTIVE_COLON, DIRECTIVE_COMMA);
    public static final TokenSet NUMERIC_LITERALS = TokenSet.create(INTEGER_LITERAL, FLOATING_POINT_LITERAL);
    public static final TokenSet KEYWORDS = TokenSet.create(NOT, AND, OR, BOOLEAN_LITERAL, NULL_LITERAL, IN, RANGE );
    public static final TokenSet PARENS = TokenSet.create(LPAREN, RPAREN);
    public static final TokenSet BRACKETS = TokenSet.create(LBRACK, RBRACK);
    public static final TokenSet BRACES = TokenSet.create(LBRACE, RBRACE);
    public static final TokenSet TAG_BRACES = TokenSet.create(TAG_LBRACE, TAG_RBRACE, TAG_END_LBRACE, TAG_END_RBRACE);
    public static final TokenSet OPERATORS = fromValueRange(900, 999, NOT, AND, OR);
    public static final TokenSet ILLEGALS = fromValueRange(1000, 1099, BAD_STRING_ESCAPE);

    public static final TokenSet WORD_TOKENS = TokenSet.orSet(COMMANDS, SPECIAL_CHARS, KEYWORDS, NUMERIC_LITERALS);
    public static final TokenSet EXPRESSION_TOKENS = TokenSet.orSet(fromValueRange(750, 849, LBRACE, RBRACE),
                                                                    fromValueRange(900, 999, EQ, COMMA),
                                                                    TokenSet.create(PARAMETER_REF,
                                                                                    CAPTURED_IDENTIFIER,
                                                                                    CAPTURED_FUNCTION_IDENTIFIER));
    public static final TokenSet COMMAND_TOKENS = fromValueRange(300, 549);
    public static final TokenSet NAME_TOKENS = fromValueRange(200, 299);
    public static final TokenSet ATTRIBUTE_TOKENS = TokenSet.create(CAPTURED_IDENTIFIER, EQ, STRING_PARAMETER_REF);
    public static final TokenSet DIRECTIVE_TOKENS = fromValueRange(600, 649);
    public static final TokenSet TAG_SECTION_TOKENS = TokenSet.create(ELSE_IF, ELSE, CASE, DEFAULT, IF_EMPTY, PARAM);
    public static final TokenSet NON_TAG_TOKENS = fromValueRange(100, 199);

    static {
        for (Field field : SoyToken.class.getFields()) {
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers) &&
                Modifier.isFinal(modifiers) && SoyToken.class.equals(field.getType())) {
                try {
                    SoyToken soyToken = (SoyToken)field.get(null);
                    if (soyToken == null) {
                        throw new AssertionError("Token constant is null: " + field.getName());
                    }
                    if (!field.getName().equals(soyToken.name())) {
                        @SuppressWarnings({ "HardCodedStringLiteral" })
                        String declaration = String.format("SoyToken %s = new SoyToken(%d,\"%s\");",
                                                           field.getName(),
                                                           soyToken.value(),
                                                           soyToken.name());
                        throw new AssertionError("Field name does not match assigned name:\n\t" + declaration);
                    }
                    SoyToken identityToken = ALL_TOKENS_BY_VALUE.get(soyToken.value());
                    if (soyToken != identityToken) {
                        String msg = "Duplicate token value: %d refers to '%s' and '%s'"; //NON-NLS
                        throw new AssertionError(String.format(msg, soyToken.value(), soyToken.name(), identityToken.name()));
                    }
                } catch (IllegalAccessException e) {
                    // shouldn't happen
                }
            }
        }
    }

    private final short value;
    private final String name;

    private SoyToken(int value, @NonNls String name) {
        this(value, name, SoyLanguage.INSTANCE);
    }

    private SoyToken(int value, @NonNls String name, Language l) {
        super(name, l, true);
        this.value = (short)value;
        this.name = name;
        ALL_TOKENS_BY_VALUE.put(this.value, this);
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
        SoyToken soyToken = (SoyToken)o;
        return value == soyToken.value;
    }

    @Override
    public int hashCode() {
        return (int)value;
    }

    @Override
    public String toString() {
        return name + "." + value;
    }

    private static TokenSet or(TokenSet base, SoyToken... include) {
        return TokenSet.orSet(base, TokenSet.create(include));
    }

    private static TokenSet fromValueRange(SoyToken min, SoyToken max, SoyToken... exclude) {
        return fromValueRange(min.value(), max.value() + 1, exclude);
    }

    private static TokenSet fromValueRange(int min, int max, SoyToken... exclude) {
        SortedMap<Short, SoyToken> map = new TreeMap<Short, SoyToken>(ALL_TOKENS_BY_VALUE.subMap((short)min, (short)max));
        for (SoyToken token : exclude) {
            map.remove(token.value());
        }
        Collection<SoyToken> tokens = map.values();
        return TokenSet.create(tokens.toArray(new SoyToken[tokens.size()]));
    }

    
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    // The following members are used by the generated CUP parser, and are only to facilitate testing. //
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    private int parserValue = Integer.MIN_VALUE;

    public int parserValue() {
        return parserValue;
    }

    public static void importParserValues(Class<?> parserSymbolClass) {
        for (SoyToken token : ALL_TOKENS_BY_VALUE.values()) {
            try {
                token.parserValue = (Integer)parserSymbolClass.getField(token.name()).get(null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
