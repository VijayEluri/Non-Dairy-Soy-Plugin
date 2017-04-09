
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package net.venaglia.nondairy.soylang.lexer.cupparser;

/** CUP generated class containing symbol constants. */
public class SoyParserSymbols {
  /* terminals */
  public static final int AS = 64;
  public static final int SP_LITERAL = 53;
  public static final int GT = 85;
  public static final int DELPACKAGE = 42;
  public static final int TEMPLATE_TEXT = 2;
  public static final int PARAM = 41;
  public static final int NOTEQ = 96;
  public static final int TAB_LITERAL = 57;
  public static final int LBRACE_ERROR = 112;
  public static final int BRACE_IN_STRING = 109;
  public static final int PACKAGE_IDENTIFIER = 23;
  public static final int NAMESPACE = 43;
  public static final int RBRACK = 80;
  public static final int STRING_LITERAL_ESCAPE = 74;
  public static final int COMMA = 105;
  public static final int STRING_LITERAL_END = 72;
  public static final int RBRACE = 82;
  public static final int DIRECTIVE_COMMA = 63;
  public static final int RPAREN = 78;
  public static final int LBRACK = 79;
  public static final int LT = 86;
  public static final int LBRACE = 81;
  public static final int DELCALL = 40;
  public static final int LPAREN = 77;
  public static final int QUESTION_DOT = 91;
  public static final int LITERAL = 32;
  public static final int NOT = 87;
  public static final int INTEGER_LITERAL = 69;
  public static final int ILLEGAL_CLOSE_TAG = 115;
  public static final int TAG_RBRACE = 6;
  public static final int ILLEGAL_TAG_DECLARATION = 114;
  public static final int PARAMETER_REF = 21;
  public static final int UNEXPECTED_EOF_IN_LITERAL_BLOCK = 116;
  public static final int DUPLICATE_NAMESPACE_DECLARATION = 107;
  public static final int DOC_COMMENT_BAD_CHARACTER = 20;
  public static final int EQ = 83;
  public static final int TAG_LBRACE = 5;
  public static final int BAD_STRING_ESCAPE = 108;
  public static final int MOD = 102;
  public static final int BOOLEAN_LITERAL = 68;
  public static final int DOC_COMMENT_TAG = 15;
  public static final int CAPTURED_IDENTIFIER = 27;
  public static final int STRING_PARAMETER_REF = 22;
  public static final int PIPE = 103;
  public static final int ALIAS = 44;
  public static final int PLUS = 97;
  public static final int UNTERMINATED_TEMPLATE = 111;
  public static final int CR_LITERAL = 55;
  public static final int QUESTION = 90;
  public static final int LINE_COMMENT = 11;
  public static final int ELSE_IF = 47;
  public static final int CAPTURED_FUNCTION_IDENTIFIER = 28;
  public static final int SWITCH = 36;
  public static final int FOR = 38;
  public static final int TEMPLATE_IDENTIFIER = 25;
  public static final int DIV = 101;
  public static final int MULT = 100;
  public static final int DOC_COMMENT_WHITESPACE = 14;
  public static final int ELSE = 48;
  public static final int DOC_COMMENT_EOL = 13;
  public static final int TAG_END_RBRACE = 8;
  public static final int UNEXPECTED_EOF_DOC_COMMENT = 119;
  public static final int GTEQ = 95;
  public static final int DOT = 104;
  public static final int STRING_LITERAL_BEGIN = 71;
  public static final int RBRACE_ERROR = 113;
  public static final int NULL_LITERAL = 67;
  public static final int STRING_LITERAL = 73;
  public static final int EQEQ = 84;
  public static final int EOF = 0;
  public static final int LF_LITERAL = 56;
  public static final int TAG_END_LBRACE = 7;
  public static final int COMMENT = 10;
  public static final int DEFAULT = 50;
  public static final int NIL_LITERAL = 54;
  public static final int LITERAL_TEXT = 4;
  public static final int PRINT = 45;
  public static final int UNTERMINATED_STRING_LITERAL = 110;
  public static final int DUPLICATE_DELPACKAGE_DECLARATION = 106;
  public static final int LB_LITERAL = 58;
  public static final int MINUS = 99;
  public static final int LTEQ = 94;
  public static final int EMPTY_ARRAY_LITERAL = 75;
  public static final int LET_IDENTIFIER = 29;
  public static final int IGNORED_TEXT = 3;
  public static final int MSG = 33;
  public static final int NAMESPACE_IDENTIFIER = 24;
  public static final int IN = 65;
  public static final int OR = 89;
  public static final int DIRECTIVE_IDENTIFIER = 60;
  public static final int error = 1;
  public static final int DELTEMPLATE_IDENTIFIER = 26;
  public static final int DELTEMPLATE = 31;
  public static final int DOC_COMMENT_BEGIN = 18;
  public static final int WHITESPACE = 9;
  public static final int IF = 35;
  public static final int DOC_COMMENT_END = 19;
  public static final int IF_EMPTY = 51;
  public static final int COLON = 93;
  public static final int DIRECTIVE_PIPE = 61;
  public static final int DOC_COMMENT_IDENTIFIER = 17;
  public static final int TEMPLATE = 30;
  public static final int UNEXPECTED_EOF_IN_TAG_DECLARATION = 117;
  public static final int DIRECTIVE_COLON = 62;
  public static final int FOREACH = 37;
  public static final int DOC_COMMENT_PARAM_TAG = 16;
  public static final int CASE = 49;
  public static final int RANGE = 66;
  public static final int UNEXPECTED_EOF_IN_STRING_LITERAL = 118;
  public static final int RB_LITERAL = 59;
  public static final int AND = 88;
  public static final int UMINUS = 98;
  public static final int DOC_COMMENT = 12;
  public static final int LET = 34;
  public static final int EMPTY_OBJECT_LITERAL = 76;
  public static final int CALL = 39;
  public static final int PRINT_IMPLICIT = 46;
  public static final int CSS = 52;
  public static final int FLOATING_POINT_LITERAL = 70;
  public static final int ELVIS = 92;
  public static final String[] terminalNames = new String[] {
  "EOF",
  "error",
  "TEMPLATE_TEXT",
  "IGNORED_TEXT",
  "LITERAL_TEXT",
  "TAG_LBRACE",
  "TAG_RBRACE",
  "TAG_END_LBRACE",
  "TAG_END_RBRACE",
  "WHITESPACE",
  "COMMENT",
  "LINE_COMMENT",
  "DOC_COMMENT",
  "DOC_COMMENT_EOL",
  "DOC_COMMENT_WHITESPACE",
  "DOC_COMMENT_TAG",
  "DOC_COMMENT_PARAM_TAG",
  "DOC_COMMENT_IDENTIFIER",
  "DOC_COMMENT_BEGIN",
  "DOC_COMMENT_END",
  "DOC_COMMENT_BAD_CHARACTER",
  "PARAMETER_REF",
  "STRING_PARAMETER_REF",
  "PACKAGE_IDENTIFIER",
  "NAMESPACE_IDENTIFIER",
  "TEMPLATE_IDENTIFIER",
  "DELTEMPLATE_IDENTIFIER",
  "CAPTURED_IDENTIFIER",
  "CAPTURED_FUNCTION_IDENTIFIER",
  "LET_IDENTIFIER",
  "TEMPLATE",
  "DELTEMPLATE",
  "LITERAL",
  "MSG",
  "LET",
  "IF",
  "SWITCH",
  "FOREACH",
  "FOR",
  "CALL",
  "DELCALL",
  "PARAM",
  "DELPACKAGE",
  "NAMESPACE",
  "ALIAS",
  "PRINT",
  "PRINT_IMPLICIT",
  "ELSE_IF",
  "ELSE",
  "CASE",
  "DEFAULT",
  "IF_EMPTY",
  "CSS",
  "SP_LITERAL",
  "NIL_LITERAL",
  "CR_LITERAL",
  "LF_LITERAL",
  "TAB_LITERAL",
  "LB_LITERAL",
  "RB_LITERAL",
  "DIRECTIVE_IDENTIFIER",
  "DIRECTIVE_PIPE",
  "DIRECTIVE_COLON",
  "DIRECTIVE_COMMA",
  "AS",
  "IN",
  "RANGE",
  "NULL_LITERAL",
  "BOOLEAN_LITERAL",
  "INTEGER_LITERAL",
  "FLOATING_POINT_LITERAL",
  "STRING_LITERAL_BEGIN",
  "STRING_LITERAL_END",
  "STRING_LITERAL",
  "STRING_LITERAL_ESCAPE",
  "EMPTY_ARRAY_LITERAL",
  "EMPTY_OBJECT_LITERAL",
  "LPAREN",
  "RPAREN",
  "LBRACK",
  "RBRACK",
  "LBRACE",
  "RBRACE",
  "EQ",
  "EQEQ",
  "GT",
  "LT",
  "NOT",
  "AND",
  "OR",
  "QUESTION",
  "QUESTION_DOT",
  "ELVIS",
  "COLON",
  "LTEQ",
  "GTEQ",
  "NOTEQ",
  "PLUS",
  "UMINUS",
  "MINUS",
  "MULT",
  "DIV",
  "MOD",
  "PIPE",
  "DOT",
  "COMMA",
  "DUPLICATE_DELPACKAGE_DECLARATION",
  "DUPLICATE_NAMESPACE_DECLARATION",
  "BAD_STRING_ESCAPE",
  "BRACE_IN_STRING",
  "UNTERMINATED_STRING_LITERAL",
  "UNTERMINATED_TEMPLATE",
  "LBRACE_ERROR",
  "RBRACE_ERROR",
  "ILLEGAL_TAG_DECLARATION",
  "ILLEGAL_CLOSE_TAG",
  "UNEXPECTED_EOF_IN_LITERAL_BLOCK",
  "UNEXPECTED_EOF_IN_TAG_DECLARATION",
  "UNEXPECTED_EOF_IN_STRING_LITERAL",
  "UNEXPECTED_EOF_DOC_COMMENT"
  };

  /* non terminals */
  static final int string_literal_buf = 77;
  static final int closing_if_tag = 28;
  static final int foreach_seq = 56;
  static final int binary_operator = 78;
  static final int content_sequence = 67;
  static final int non_content_tag = 16;
  static final int expr = 70;
  static final int special_char_tag = 17;
  static final int begin_if_tag = 41;
  static final int string_literal = 76;
  static final int begin_param_tag = 45;
  static final int let_tag = 21;
  static final int simple_directive = 64;
  static final int begin_call_tag = 46;
  static final int special_char = 18;
  static final int skip_element = 4;
  static final int alias_tag = 6;
  static final int for_tag = 22;
  static final int dot_reference = 71;
  static final int template_ident = 11;
  static final int dir_expr_list = 69;
  static final int else_tag = 34;
  static final int case_tag = 35;
  static final int compound_directive = 65;
  static final int template_def = 10;
  static final int template_doc_buffer = 9;
  static final int switch_tag = 25;
  static final int end_switch_tag = 51;
  static final int content_tag = 15;
  static final int end_if_tag = 50;
  static final int begin_msg_tag = 39;
  static final int end_param_tag = 54;
  static final int attribute = 61;
  static final int end_for_tag = 53;
  static final int end_template_tag = 14;
  static final int ifempty_tag = 37;
  static final int end_let_tag = 49;
  static final int expr_list = 68;
  static final int for_range = 58;
  static final int template_tag = 12;
  static final int skip_element_list = 3;
  static final int for_seq = 57;
  static final int open_if_tag = 27;
  static final int namespace_ident = 7;
  static final int directive_list = 62;
  static final int param_tag = 23;
  static final int msg_tag = 20;
  static final int begin_switch_tag = 42;
  static final int null_safe_reference = 72;
  static final int default_tag = 36;
  static final int literal_value = 74;
  static final int foreach_tag = 26;
  static final int directive = 63;
  static final int literal_tag = 19;
  static final int if_tag = 24;
  static final int template_list = 1;
  static final int template_doc_comment = 8;
  static final int print_tag = 32;
  static final int end_foreach_tag = 52;
  static final int open_switch_tag = 29;
  static final int else_if_tag = 33;
  static final int key_value_list = 75;
  static final int template_file = 0;
  static final int begin_foreach_tag = 43;
  static final int begin_literal_tag = 38;
  static final int closing_switch_tag = 30;
  static final int alias_list = 2;
  static final int dir_expr = 73;
  static final int namespace_def = 5;
  static final int content_element = 66;
  static final int end_literal_tag = 47;
  static final int param_list = 59;
  static final int begin_for_tag = 44;
  static final int begin_template_tag = 13;
  static final int end_msg_tag = 48;
  static final int begin_let_tag = 40;
  static final int end_call_tag = 55;
  static final int attribute_list = 60;
  static final int call_tag = 31;
}

