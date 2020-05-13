/* Kotlin.g4 */
grammar Kotlin;

// parser rules
kotlinCode
	: ShebangLine? package importList code EOF;
name
	: NAME ('.' NAME)*;
package
	: (PACKAGE name)?;
import
	: IMPORT name '.*'?;
importList
	: import*;
code
	: newFunction;
newFunction
	: FUN NAME functionParameters (':' type)? (functionBody)?;
functionParameters
	: '(' (functionParameter (',' functionParameter)?)? ')';
parameter
	: NAME ':' type;
type
	: NAME;
nullableType
	: type '?';
functionBody
	: block
	| '=' expression;
block
	: '{' statement* '}';
expression
	:
statement
	: 
newVariable
	: ('var' | 'val') variableName ('=' expression)?;
deferredAssignment
	: variableName '=' expression;
conditionalExpression
	: 'if' '(' expression ')' (block | statement) ('else' (block|statement))?
forStatement
	: 'for' '(' variableName IN expression ')' (block | statement);
whileStatement
	: 'while' '(' expression' ')' (block | statement);
whenExpression
	: 'when' '(' expression ')' '{' whenEntry* '}';
whenEntry
	: whenCondition '->' 
	| 'else' '->' 
whenCondition
	:
variableName
	: NAME (':' type)?;

// lexer rules
ShebangLine: '#!' ~[\r\n]*;
PACKAGE: 'package';
IMPORT: 'import';
NAME: ([a-zA-Z] | '_')([a-zA-Z] | '_' | [0-9])*;
FUN: 'fun';
RETURN: 'return';
VAL: 'val';
VAR: 'var';
SingleComment: '//' ~[\r\n]* -> skip;
MultiComment: '/*' .*? '*/' -> skip;

IntLiteral: [0-9]+;
RealLiteral: [0-9]+ '.' [0-9]*;
NullLiteral: 'null';

IS: 'is'
NOT_IS: '!is';
IN: 'in'
NOT_IN: '!in'


WS: [ \t\r\n]+ -> skip;
