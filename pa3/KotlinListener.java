// Generated from Kotlin.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KotlinParser}.
 */
public interface KotlinListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KotlinParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(KotlinParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(KotlinParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#packageHeader}.
	 * @param ctx the parse tree
	 */
	void enterPackageHeader(KotlinParser.PackageHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#packageHeader}.
	 * @param ctx the parse tree
	 */
	void exitPackageHeader(KotlinParser.PackageHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#importHeader}.
	 * @param ctx the parse tree
	 */
	void enterImportHeader(KotlinParser.ImportHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#importHeader}.
	 * @param ctx the parse tree
	 */
	void exitImportHeader(KotlinParser.ImportHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(KotlinParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(KotlinParser.CodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#prefixDef}.
	 * @param ctx the parse tree
	 */
	void enterPrefixDef(KotlinParser.PrefixDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#prefixDef}.
	 * @param ctx the parse tree
	 */
	void exitPrefixDef(KotlinParser.PrefixDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(KotlinParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(KotlinParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(KotlinParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(KotlinParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(KotlinParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(KotlinParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#multitype}.
	 * @param ctx the parse tree
	 */
	void enterMultitype(KotlinParser.MultitypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#multitype}.
	 * @param ctx the parse tree
	 */
	void exitMultitype(KotlinParser.MultitypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#newFunction}.
	 * @param ctx the parse tree
	 */
	void enterNewFunction(KotlinParser.NewFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#newFunction}.
	 * @param ctx the parse tree
	 */
	void exitNewFunction(KotlinParser.NewFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(KotlinParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(KotlinParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#returnVal}.
	 * @param ctx the parse tree
	 */
	void enterReturnVal(KotlinParser.ReturnValContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#returnVal}.
	 * @param ctx the parse tree
	 */
	void exitReturnVal(KotlinParser.ReturnValContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#newVal}.
	 * @param ctx the parse tree
	 */
	void enterNewVal(KotlinParser.NewValContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#newVal}.
	 * @param ctx the parse tree
	 */
	void exitNewVal(KotlinParser.NewValContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#newVar}.
	 * @param ctx the parse tree
	 */
	void enterNewVar(KotlinParser.NewVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#newVar}.
	 * @param ctx the parse tree
	 */
	void exitNewVar(KotlinParser.NewVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(KotlinParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(KotlinParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(KotlinParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(KotlinParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(KotlinParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(KotlinParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(KotlinParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(KotlinParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#num}.
	 * @param ctx the parse tree
	 */
	void enterNum(KotlinParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#num}.
	 * @param ctx the parse tree
	 */
	void exitNum(KotlinParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#minusNum}.
	 * @param ctx the parse tree
	 */
	void enterMinusNum(KotlinParser.MinusNumContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#minusNum}.
	 * @param ctx the parse tree
	 */
	void exitMinusNum(KotlinParser.MinusNumContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#conditionExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionExpression(KotlinParser.ConditionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#conditionExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionExpression(KotlinParser.ConditionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#conditionIf}.
	 * @param ctx the parse tree
	 */
	void enterConditionIf(KotlinParser.ConditionIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#conditionIf}.
	 * @param ctx the parse tree
	 */
	void exitConditionIf(KotlinParser.ConditionIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#conditionElseIf}.
	 * @param ctx the parse tree
	 */
	void enterConditionElseIf(KotlinParser.ConditionElseIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#conditionElseIf}.
	 * @param ctx the parse tree
	 */
	void exitConditionElseIf(KotlinParser.ConditionElseIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#conditionElse}.
	 * @param ctx the parse tree
	 */
	void enterConditionElse(KotlinParser.ConditionElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#conditionElse}.
	 * @param ctx the parse tree
	 */
	void exitConditionElse(KotlinParser.ConditionElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#inConditionExpression}.
	 * @param ctx the parse tree
	 */
	void enterInConditionExpression(KotlinParser.InConditionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#inConditionExpression}.
	 * @param ctx the parse tree
	 */
	void exitInConditionExpression(KotlinParser.InConditionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(KotlinParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(KotlinParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#when}.
	 * @param ctx the parse tree
	 */
	void enterWhen(KotlinParser.WhenContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#when}.
	 * @param ctx the parse tree
	 */
	void exitWhen(KotlinParser.WhenContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#whenExpression}.
	 * @param ctx the parse tree
	 */
	void enterWhenExpression(KotlinParser.WhenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#whenExpression}.
	 * @param ctx the parse tree
	 */
	void exitWhenExpression(KotlinParser.WhenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#range}.
	 * @param ctx the parse tree
	 */
	void enterRange(KotlinParser.RangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#range}.
	 * @param ctx the parse tree
	 */
	void exitRange(KotlinParser.RangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#newClass}.
	 * @param ctx the parse tree
	 */
	void enterNewClass(KotlinParser.NewClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#newClass}.
	 * @param ctx the parse tree
	 */
	void exitNewClass(KotlinParser.NewClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#newInterface}.
	 * @param ctx the parse tree
	 */
	void enterNewInterface(KotlinParser.NewInterfaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#newInterface}.
	 * @param ctx the parse tree
	 */
	void exitNewInterface(KotlinParser.NewInterfaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#newComment}.
	 * @param ctx the parse tree
	 */
	void enterNewComment(KotlinParser.NewCommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#newComment}.
	 * @param ctx the parse tree
	 */
	void exitNewComment(KotlinParser.NewCommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#lambda}.
	 * @param ctx the parse tree
	 */
	void enterLambda(KotlinParser.LambdaContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#lambda}.
	 * @param ctx the parse tree
	 */
	void exitLambda(KotlinParser.LambdaContext ctx);
}