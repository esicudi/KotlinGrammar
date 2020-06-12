// Generated from Kotlin.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link KotlinParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface KotlinVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link KotlinParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(KotlinParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#codes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodes(KotlinParser.CodesContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#packageHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageHeader(KotlinParser.PackageHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#importHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportHeader(KotlinParser.ImportHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#headerName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeaderName(KotlinParser.HeaderNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(KotlinParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#prefixDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixDef(KotlinParser.PrefixDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(KotlinParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(KotlinParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(KotlinParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#multitype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultitype(KotlinParser.MultitypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#newFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewFunction(KotlinParser.NewFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(KotlinParser.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#returnVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnVal(KotlinParser.ReturnValContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#newVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewVal(KotlinParser.NewValContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#newVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewVar(KotlinParser.NewVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(KotlinParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(KotlinParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(KotlinParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(KotlinParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(KotlinParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum(KotlinParser.NumContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#minusNum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusNum(KotlinParser.MinusNumContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#conditionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionExpression(KotlinParser.ConditionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#conditionIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionIf(KotlinParser.ConditionIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#conditionElseIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionElseIf(KotlinParser.ConditionElseIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#conditionElse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionElse(KotlinParser.ConditionElseContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#inConditionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInConditionExpression(KotlinParser.InConditionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(KotlinParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#loopBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopBody(KotlinParser.LoopBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#when}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhen(KotlinParser.WhenContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#whenBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhenBody(KotlinParser.WhenBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#whenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhenExpression(KotlinParser.WhenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#whenElseExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhenElseExpression(KotlinParser.WhenElseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRange(KotlinParser.RangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#newClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewClass(KotlinParser.NewClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(KotlinParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#newInterface}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewInterface(KotlinParser.NewInterfaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#newComment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewComment(KotlinParser.NewCommentContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#lambda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda(KotlinParser.LambdaContext ctx);
}