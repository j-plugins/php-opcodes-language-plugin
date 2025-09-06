/* PHPOp JFlex Lexer for Pattern-Based Parsing */

package com.github.xepozz.php_opcodes_language.language.parser;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpTypes;
import java.util.Stack;

%%

%class PHPOpLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}


WHITESPACE = [ \t\f]
NEWLINE = \r\n|\r|\n
COMMENT = ";"[^\n]*

IDENTIFIER = [_a-zA-Z][a-zA-Z0-9_\-\\]*
NUMBER = [0-9]+
QUOTTED_STRING = "\""(\\\"|[^\"])*"\""

LPAREN = "("
RPAREN = ")"
LBRACE = "{"
RBRACE = "}"
LBRACKET = "["
RBRACKET = "]"
DOLLAR_SIGN = "$"
EQUALS_SIGN = "="
COLON = ":"
SLASH = "/"
BACKSLASH = "\\"
DASH = "-"
DOT = "."
COMMA = ","
AT_SIGN = "@"

%{
private Stack<Integer> stack = new Stack<>();

public void yypushState(int newState) {
  stack.push(yystate());
  yybegin(newState);
}

public void yypopState() {
  yybegin(stack.pop());
}
%}


%state YYINITIAL

%%

<YYINITIAL> {
    {LPAREN}                                     { return PHPOpTypes.LPAREN; }
    {RPAREN}                                     { return PHPOpTypes.RPAREN; }
    {LBRACE}                                     { return PHPOpTypes.LBRACE; }
    {RBRACE}                                     { return PHPOpTypes.RBRACE; }
    {LBRACKET}                                   { return PHPOpTypes.LBRACKET; }
    {RBRACKET}                                   { return PHPOpTypes.RBRACKET; }
    {DOLLAR_SIGN}                                { return PHPOpTypes.DOLLAR_SIGN; }
    {EQUALS_SIGN}                                { return PHPOpTypes.EQUALS_SIGN; }

    {IDENTIFIER}                                 { return PHPOpTypes.IDENTIFIER; }
    {COLON}                                      { return PHPOpTypes.COLON; }
    {SLASH}                                      { return PHPOpTypes.SLASH; }
    {BACKSLASH}                                  { return PHPOpTypes.BACKSLASH; }
    {DOT}                                        { return PHPOpTypes.DOT; }
    {COMMA}                                      { return PHPOpTypes.COMMA; }
    {AT_SIGN}                                    { return PHPOpTypes.AT_SIGN; }
    {DASH}                                       { return PHPOpTypes.DASH; }
    -?{NUMBER}\.{NUMBER}                         { return PHPOpTypes.FLOAT; }
    -?{NUMBER}                                   { return PHPOpTypes.INTEGER; }
    {QUOTTED_STRING}                             { return PHPOpTypes.QUOTTED_STRING; }

    {WHITESPACE}                                 { return TokenType.WHITE_SPACE; }
    {NEWLINE}                                    { return PHPOpTypes.EOL; }
    {COMMENT}                                    { return PHPOpTypes.COMMENT; }
}

// Catch any other character
[^]                                              { return TokenType.BAD_CHARACTER; }
