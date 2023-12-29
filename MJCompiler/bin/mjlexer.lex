
package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;



%%



%{
	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}
	
	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}
%}

%cup
%line
%column

%xstate COMMENT

%eofval{
	return new_symbol(sym.EOF);
%eofval}



%%

" " 	{ }
"\b" 	{ }
"\t" 	{ }
"\r\n" 	{ }
"\f" 	{ }

"program"   { return new_symbol(sym.PROG, yytext());}
"print" 	{ return new_symbol(sym.PRINT, yytext()); }
"void" 		{ return new_symbol(sym.VOID, yytext()); }
"+" 		{ return new_symbol(sym.PLUS, yytext()); }
"=" 		{ return new_symbol(sym.ASSIGN, yytext()); }
";" 		{ return new_symbol(sym.SEMI, yytext()); }
"," 		{ return new_symbol(sym.COMMA, yytext()); }
"(" 		{ return new_symbol(sym.LPAREN, yytext()); }
")" 		{ return new_symbol(sym.RPAREN, yytext()); }
"{" 		{ return new_symbol(sym.LBRACE, yytext()); }
"}"			{ return new_symbol(sym.RBRACE, yytext()); }
"-"			{ return new_symbol(sym.MINUS, yytext()); }
"*"			{ return new_symbol(sym.MUL, yytext()); }
"/"			{ return new_symbol(sym.DIV, yytext()); }
"%"			{ return new_symbol(sym.MOD, yytext()); }
"++"		{ return new_symbol(sym.INC, yytext()); }
"::"		{ return new_symbol(sym.DOUBLECOLON, yytext()); }
"["			{ return new_symbol(sym.LBRACKET, yytext()); }
"]"			{ return new_symbol(sym.RBRACKET, yytext()); }
"read"		{ return new_symbol(sym.READ, yytext()); }
"new"		{ return new_symbol(sym.NEW, yytext()); }
"namespace"	{ return new_symbol(sym.NAMESPACE, yytext()); }
"const"		{ return new_symbol(sym.CONST, yytext()); }
"--"		{ return new_symbol(sym.DEC, yytext()); }
"true"		{ return new_symbol(sym.BOOL, yytext()); }
"false"		{ return new_symbol(sym.BOOL, yytext()); }
">"			{ return new_symbol(sym.GREATER, yytext()); }
"<"			{ return new_symbol(sym.LESS, yytext()); }
">="		{ return new_symbol(sym.GREATEROREQUAL, yytext()); }
"<="		{ return new_symbol(sym.LESSOREQUAL, yytext()); }
"=="		{ return new_symbol(sym.EQUAL, yytext()); }
"!="		{ return new_symbol(sym.DIFFERENT, yytext()); }
"&&"		{ return new_symbol(sym.AND, yytext()); }
"||"		{ return new_symbol(sym.OR, yytext()); }




"//" {yybegin(COMMENT);}
<COMMENT> . {yybegin(COMMENT);}
<COMMENT> "\r\n" { yybegin(YYINITIAL); }


[0-9]+  { return new_symbol(sym.NUMBER, Integer.parseInt(yytext())); }
'.'		{ return new_symbol(sym.CHAR, yytext());}
[a-zA-Z][a-zA-Z0-9_]* 	{return new_symbol (sym.IDENT, yytext()); }




. { System.err.println("Leksicka greska ("+yytext()+") u liniji "+(yyline+1)); }




