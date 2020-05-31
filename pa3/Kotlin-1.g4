/* Kotlin.g4 */
grammar Kotlin;

// parser rule
prog
	: packageHeader? importHeader? code*;
packageHeader
	: PACKAGE NAME ('.' NAME)*;
importHeader
	: IMPORT NAME ('.' NAME)* ('.*')?;
code
	: newFunction
	| newVal
	| newVar
	| newClass
	| newInterface
	| newComment;
prefixDef
	: OVERRIDE? ABSTRACT?;
parameters
	: parameter (',' parameter)*;
parameter
	: (VAL | VAR)? NAME COLON type;
type
	: SingleType
	| multitype
	| AnyType;
multitype
	: MultiType LANGLE SingleType RANGLE;

newFunction
	: (prefixDef FUN | FUN) NAME '(' parameters? ')' (COLON type ('?')?)? functionBody?;
functionBody
	: '{' (expression | assignment | condition | conditionExpression | loop | when | returnVal)* returnVal?'}'
	| '=' (expression | conditionExpression | when | condition);
returnVal
	: RETURN expression?;
newVal
	: (prefixDef VAL | VAL) NAME (COLON type)? ('get()'? '=' (expression | condition))?;
newVar
	: (prefixDef VAR | VAR) NAME (COLON type)? ('get()'? '=' (expression | condition))?;
expression
	: expression OP expression
	| function
	| NULL
	| num
	| minusNum
	| NAME '.' NAME
	| NAME
	| STRING
	| '(' expression ')'
	| expression ('++' | '--')
	| ('++' | '--' | '!') expression
	| lambda;
assignment
	: newVal
	| newVar
	| NAME '=' expression
	| NAME OP_ASSIGNMENT expression;
condition
	: condition (OP_COMPARE | '<' | '>') condition
	| expression
	| '(' condition ')'
	| NAME ('!')? IS type
	| condition ('!')? IN range;
function
	: (NAME '.')* NAME '(' (expression (',' expression)*)?')';
num
	: INT
	| REAL;
minusNum
	: '-' num;
conditionExpression
	: IF '(' condition ')' ( '{' (expression | assignment | conditionExpression | loop | when)* returnVal? '}' | (expression | assignment | when | returnVal)) (ELSE IF '(' condition ')' ('{' (expression | assignment | conditionExpression | loop | when) returnVal? '}' | (expression | assignment | when | returnVal)))* (ELSE ('{' (expression | assignment | conditionExpression | loop | when)* returnVal? '}' | (expression | assignment | when | returnVal)))?;
loop
	: FOR '(' NAME ('!')? IN range ')' '{' (expression | assignment | conditionExpression | loop | when | returnVal)* '}'
	| WHILE '(' condition ')' '{' (expression | assignment | conditionExpression | loop | when | returnVal)* '}';
when
	: WHEN ('(' expression ')')? '{' whenExpression+ (ELSE ARROW expression)? '}';
whenExpression
	: expression (',' expression)* ARROW (expression | returnVal)
	| expression? ('!')? IN range ARROW (expression | returnVal)
	| expression? ('!')? IS type ARROW (expression | returnVal);
range
	: ('0..' | '1..' | '2..' | '3..' | '4..' | '5..' | '6..' | '7..' | '8..' | '9..' | '10..') expression (STEP INT)?
	| expression '..' expression (STEP INT)?
	| expression 'downTo' expression (STEP INT)?
	| NAME '.' NAME
	| NAME;
newClass
	: (prefixDef CLASS | CLASS) NAME '(' parameters ')' (COLON NAME ('(' (expression (',' expression)*)? ')')? (',' NAME ('(' (expression (',' expression)*)? ')')? )* )? '{' (assignment ','? | newFunction ','?)* '}';
newInterface
	: INTERFACE NAME '{' (assignment ','? | newFunction ','?)* '}';
newComment
	: SingleComment | MultiComment;
lambda
	: NAME ('.' expression '{' (parameters ARROW)? expression '}')*;

// lexer rule
PACKAGE: 'package';
IMPORT: 'import';
FUN: 'fun';
RETURN: 'return';
NULL: 'null';
VAL: 'val';
VAR: 'var';
IF: 'if';
ELSE: 'else';
FOR: 'for';
STEP: 'step';
WHILE: 'while';
WHEN: 'when';
IN: 'in';
IS: 'is';
ARROW: '->';
CLASS: 'class';
ABSTRACT: 'abstract';
INTERFACE: 'interface';
OVERRIDE: 'override';
LANGLE: '<';
RANGLE: '>';
LPAREN: '(';
RPAREN: ')';
LCURL: '{';
RCURL: '}';
LSQUARE: '[';
RSQUARE: ']';
COLON: ':';
SingleType: 'Int' | 'Short' | 'Byte' | 'Long' | 'Float' | 'Double' | 'Char' | 'String' | 'Boolean' | 'Unit' | 'Nothing';
MultiType: 'List' | 'MutableList' | 'ArrayList' | 'Map' | 'MutableMap' | 'HashMap' | 'LinkedHashMap' | 'SortedMap' | 'Set' | 'MutableSet' | 'HashSet' | 'LinkedHashSet' | 'TreeSet' | 'Array';
AnyType: 'Any';
OP_LANGLE: LANGLE -> type(LANGLE);
OP_RANGLE: RANGLE -> type(RANGLE);
OP: '*' | '/' | '%' | '+' | '-';
OP_ASSIGNMENT: '+=' | '-=' |'*=' | '/=' | '%=';
OP_COMPARE: '==' | '!=' | OP_LANGLE | OP_RANGLE | '<=' | '>=' | '&&' | '||';
NAME: [a-zA-Z_$][0-9a-zA-Z_$]*;
INT: [0-9]+('L')?;
REAL: [0-9]+('.'[0-9]*)?;
STRING: (['] ~[']* [']) | (["] ~["]* ["]);
SingleComment: '//' ~[\r\n]* -> skip;
MultiComment: '/*' .*? '*/' -> skip;
WS: [ \t\r\n]+ -> skip;
