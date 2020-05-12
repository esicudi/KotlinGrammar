/* Kotlin.g4 */
grammar Kotlin;

// lexer rules
ShebangLine: '#!' ~[\r\n]*;
PACKAGE: 'package';
IMPORT: 'import';
NAME: ([a-zA-Z] | '_')([a-zA-Z] | '_' | [0-9])*;
FUN: 'fun';
VAL: 'val';
VAR: 'var';
SingleComment: '//' ~[\r\n]* -> skip;
MultiComment: '/*' .*? '*/' -> skip;

WS: [ \t\r\n]+ -> skip;

// parser rules
kotlinCode
	: ShebangLine? package importList;
name
	: NAME ('.' NAME)*;
package
	: (PACKAGE name)?;
import
	: IMPORT name '.*'?;
importList
	: import*;
