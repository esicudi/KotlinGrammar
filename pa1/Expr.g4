/* Expr.g4 extended -Modify this for PA#1 */
grammar Expr;

// parser rules
prog  : (assen ';' NEWLINE? | expr ';' NEWLINE?)*;
expr  : expr op=('*'|'/') expr	# MulDiv
      | expr op=('+'|'-') expr	# AddSub
      | num			# IntReal
      | ID			# Id
      | '(' expr ')'		# Parens
      ;
assen : ID '=' num
      ;
num   : INT
      | REAL
      ;

// lexer rules
NEWLINE: [\r\n]+ ;
MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';
INT: ('+'|'-')? [0-9]+ ;		// should handle negatives
REAL: ('+'|'-')? [0-9]+'.'+[0-9]* ;	// should handle signs(+/-)
ID: [a-zA-Z]+ ;
WS: [ \t\r\n]+ -> skip;
