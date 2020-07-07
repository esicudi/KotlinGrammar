import java.lang.*;
import java.util.*;
import java.io.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class ExprEvalApp {
	public static void main(String[] args) throws IOException {

		String filename = null;
		if (0<args.length){
			filename = args[0];
		}
		

		// Get lexer
		ExprLexer lexer = new ExprLexer(CharStreams.fromFileName(filename));
		// Get a list of matched tokens
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		// Pass tokens to parser
		ExprParser parser = new ExprParser(tokens);
		// Walk parse-tree and attach our listener
		ParseTreeWalker walker = new ParseTreeWalker();
		EvalListener listener = new EvalListener();

		// walk from the root of parse tree
		walker.walk(listener, parser.prog());
		
		listener.result();
	}
}

class EvalListener extends ExprBaseListener {
	// hash-map for variables' integer value for assignment
	Map<String, Double> vars = new HashMap<String, Double>();

	// stack for expression tree evaluation
	Stack<Double> evalStack = new Stack<Double>();

	@Override
	public void exitIntReal(ExprParser.IntRealContext ctx) {
		Double real = Double.parseDouble(ctx.getChild(0).getText());
		evalStack.push(real);
	}
	
	@Override
	public void exitId(ExprParser.IdContext ctx) {
		Double real = vars.get(ctx.getChild(0).getText());
		evalStack.push(real);
	}
	
	@Override
	public void exitAssen(ExprParser.AssenContext ctx) {
		vars.put(ctx.ID().getText(), Double.parseDouble(ctx.num().getChild(0).getText()));
	}
	
	@Override
	public void exitMulDiv(ExprParser.MulDivContext ctx) {
		Double r = evalStack.pop();
		Double l = evalStack.pop();
		if(ctx.op.getType() == ExprParser.MUL) {
			evalStack.push(l*r);
		}else {
			evalStack.push(l/r);
		}
	}
	
	@Override
	public void exitAddSub(ExprParser.AddSubContext ctx) {
		Double r = evalStack.pop();
		Double l = evalStack.pop();
		if(ctx.op.getType() == ExprParser.ADD) {
			evalStack.push(l+r);
		}else {
			evalStack.push(l-r);
		}
	}

	@Override
	public void visitTerminal(TerminalNode node) {
	}
	
	public void result() {
		int i=0;
		while(i < evalStack.size()) {
			System.out.println(evalStack.get(i++));
		}
	}
}
