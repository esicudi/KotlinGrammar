import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

@SuppressWarnings("deprecation")
public class Kotlin2Java extends KotlinBaseVisitor<String> implements KotlinVisitor<String> {

	public static String fileName = "output";
	public static String result = "";
	public static String parameters = "";

	public static void setFileName(String name) {
		fileName = name;
	}

	@Override
	public String visitProg(KotlinParser.ProgContext ctx) {
		this.visit(ctx.packageHeader());
		this.visit(ctx.importHeader());
		result += "\npublic class " + fileName + " {\n";
		this.visit(ctx.codes());
		result += "}";
		return result;
	}

	@Override
	public String visitPackageHeader(KotlinParser.PackageHeaderContext ctx) {
		result += ctx.PACKAGE() + " " + this.visit(ctx.headerName()) + ";\n";
		return "";
	}

	@Override
	public String visitImportHeader(KotlinParser.ImportHeaderContext ctx) {
		result += ctx.getText() + this.visit(ctx.headerName()) + ";\n";
		return "";
	}

	@Override
	public String visitHeaderName(KotlinParser.HeaderNameContext ctx) {
		return ctx.getText();
	}

	@Override
	public String visitCodes(KotlinParser.CodesContext ctx) {
		this.visitChildren(ctx);
		return "";
	}

	@Override
	public String visitCode(KotlinParser.CodeContext ctx) {
		this.visitChildren(ctx);
		return "";
	}

	@Override
	public String visitPrefixDef(KotlinParser.PrefixDefContext ctx) {
		String prefix;
		prefix = ctx.getText();
		if (ctx.OVERRIDE() != null)
			result += "@Override ";
		if (ctx.ABSTRACT() != null)
			result += prefix + " ";
		return "";
	}

	@Override
	public String visitParameters(KotlinParser.ParametersContext ctx) {
		parameters = "";
		this.visitChildren(ctx);
		return parameters.substring(0, parameters.length() - 2);
	}

	@Override
	public String visitParameter(KotlinParser.ParameterContext ctx) {
		parameters += this.visit(ctx.type()) + " " + ctx.NAME() + ", ";
		return "";
	}

	@Override
	public String visitType(KotlinParser.TypeContext ctx) {
		String type = ctx.getText();
		if (ctx.multitype() != null)
			type.toLowerCase();

		if (type.contentEquals("any")) {
			type = "Object";
		}
		if (type.contentEquals("string")) {
			type = "String";
		}
		return type;
	}

	/*
	 * @Override public String visitMultitype(KotlinParser.MultitypeContext ctx) {
	 * 
	 * return visitChildren(ctx); }
	 */

	@Override
	public String visitNewFunction(KotlinParser.NewFunctionContext ctx) {
		if (ctx.prefixDef() != null)
			this.visit(ctx.prefixDef());
		/*
		 * if (ctx.parent.toStringTree().startsWith("functionBody")) result += "class ";
		 * else
		 */
		result += "public static ";
		// main function
		if (ctx.NAME().getText() == "main") {
			result += "void main(String[] args) {\n";
			this.visit(ctx.functionBody());
			result += "\n}\n";
		}
		// other method
		else {
			// function type
			if (ctx.type() != null) {
				if (ctx.nullable == null)
					result += this.visit(ctx.type()) + " ";
				else {
					if (ctx.type().getText() != "Int")
						result += "Integer ";
					else
						result += ctx.type().getText() + " ";
				}
			} else {
				if (ctx.functionBody().toString().startsWith("="))
					result += "Object ";
				else
					result += "void ";
			}
			result += ctx.NAME() + "(";
			if (ctx.parameters() != null) {
				result += this.visit(ctx.parameters());
			}
			result += ") {\n";
			this.visit(ctx.functionBody());
			result += "\n}\n";
		}
		return "";
	}

	@Override
	public String visitFunctionBody(KotlinParser.FunctionBodyContext ctx) {
		if (ctx.returnVal() != null) {
			result += "return ";
		}
		this.visitChildren(ctx);
		return "";
	}

	@Override
	public String visitReturnVal(KotlinParser.ReturnValContext ctx) {
		result += "return ";
		if (ctx.expression() != null)
			this.visit(ctx.expression());
		else
			result += ";";
		return "";
	}

	@Override
	public String visitNewVal(KotlinParser.NewValContext ctx) {
		if (ctx.prefixDef() != null)
			this.visit(ctx.prefixDef());

		if (ctx.toString().contains("=")) {
			if (ctx.type() != null)
				result += "final " + this.visit(ctx.type()) + " ";
			else {
				if (ctx.expression() != null) {
					if (ctx.expression().STRING() != null)
						result += "final String ";
					else if (ctx.expression().num().INT() != null || ctx.expression().minusNum().num().INT() != null)
						result += "final int ";
					else if (ctx.expression().num().REAL() != null || ctx.expression().minusNum().num().REAL() != null)
						result += "final double ";
					else
						result += "final Object ";
				} else
					result += "final boolean ";
			}
			result += ctx.NAME().getText() + " = "
					+ (ctx.expression() != null ? ctx.expression().getText() : ctx.condition().getText()) + ";\n";

		} else {
			if (ctx.type() != null)
				result += "final " + this.visit(ctx.type()) + " ";
			else
				result += "final Object ";
			result += ctx.NAME().getText() + ";\n";
		}
		return "";
	}

	@Override
	public String visitNewVar(KotlinParser.NewVarContext ctx) {
		if (ctx.prefixDef() != null)
			this.visit(ctx.prefixDef());

		if (ctx.toString().contains("=")) {
			if (ctx.type() != null)
				result += this.visit(ctx.type()) + " ";
			else {
				if (ctx.expression() != null) {
					if (ctx.expression().STRING() != null)
						result += "String ";
					else if (ctx.expression().num().INT() != null || ctx.expression().minusNum().num().INT() != null)
						result += "int ";
					else if (ctx.expression().num().REAL() != null || ctx.expression().minusNum().num().REAL() != null)
						result += "double ";
					else
						result += "Object ";
				} else
					result += "boolean ";
			}
			result += ctx.NAME().getText() + " = "
					+ (ctx.expression() != null ? ctx.expression().getText() : ctx.condition().getText()) + ";\n";

		} else {
			if (ctx.type() != null)
				result += this.visit(ctx.type()) + " ";
			else
				result += "Object ";
			result += ctx.NAME().getText() + ";\n";
		}
		return "";
	}

	@Override
	public String visitExpression(KotlinParser.ExpressionContext ctx) {
		if (ctx.function() != null)
			this.visit(ctx.function());
		else if (ctx.OP() != null) {
			this.visit(ctx.expression(0));
			result += ctx.OP();
			this.visit(ctx.expression(1));
		} else if (ctx.toString().startsWith("(")) {
			result += "(";
			this.visit(ctx.expression(0));
			result += ")";
		} else if (ctx.toString().startsWith("!")) {
			result += "!";
			this.visit(ctx.expression(0));
		} else if (ctx.lambda() != null)
			this.visit(ctx.lambda());
		else {
			result += ctx.getText();
		}
		if (ctx.parent.getText().startsWith("{") || ctx.parent.getText().startsWith("="))
			result += ";\n";
		return "";
	}

	@Override
	public String visitAssignment(KotlinParser.AssignmentContext ctx) {
		if (ctx.newVal() != null)
			this.visit(ctx.newVal());
		else if (ctx.newVar() != null)
			this.visit(ctx.newVar());
		else
			result += ctx.getText() + ";\n";
		return "";
	}

	@Override
	public String visitCondition(KotlinParser.ConditionContext ctx) {
		// condition (OP_COMPARE | '<' | '>') condition
		if (ctx.OP_COMPARE() != null) {
			this.visit(ctx.condition(0));
			result += ctx.OP_COMPARE();
			this.visit(ctx.condition(1));
		} else if (ctx.children.get(1).getText() == "<") {
			this.visit(ctx.condition(0));
			result += "<";
			this.visit(ctx.condition(1));
		} else if (ctx.children.get(1).getText() == ">") {
			this.visit(ctx.condition(0));
			result += ">";
			this.visit(ctx.condition(1));
		} // expression
		else if (ctx.expression() != null)
			this.visit(ctx.expression());
		// '(' condition ')'
		else if (ctx.getText().startsWith("(")) {
			result += "(";
			this.visit(ctx.condition(0));
			result += ")";
		} // NAME ('!')? IS type
		else if (ctx.IS() != null) {
			result += ctx.NAME() + " instanceof " + ctx.type().getText();
			if (ctx.type().multitype() != null)
				result += "<*>";
		} // condition ('!')? IN range
		else if (ctx.IN() != null) {
			result += "Object " + ctx.NAME() + " : ";
			this.visit(ctx.range());
		} else
			result += ctx.getText();
		return "";
	}

	@Override
	public String visitFunction(KotlinParser.FunctionContext ctx) {
		if (ctx.NAME().equals("println") || ctx.NAME().equals("print"))
			result += "System.out.";
		result += ctx.NAME() + "(";
		this.visitChildren(ctx);
		result += ");\n";
		return "";
	}

	@Override
	public String visitNum(KotlinParser.NumContext ctx) {
		result += ctx.getText();
		return "";
	}

	@Override
	public String visitMinusNum(KotlinParser.MinusNumContext ctx) {
		result += ctx.getText();
		return "";
	}

	@Override
	public String visitConditionExpression(KotlinParser.ConditionExpressionContext ctx) {
		visitChildren(ctx);
		return "";
	}

	@Override
	public String visitConditionIf(KotlinParser.ConditionIfContext ctx) {
		result += "if(";
		this.visit(ctx.condition());
		result += ") {\n";
		this.visit(ctx.inConditionExpression());
		result += "}\n";
		return "";
	}

	@Override
	public String visitConditionElseIf(KotlinParser.ConditionElseIfContext ctx) {
		result += "else if(";
		this.visit(ctx.condition());
		result += ") {\n";
		this.visit(ctx.inConditionExpression());
		result += "}\n";
		return "";
	}

	@Override
	public String visitConditionElse(KotlinParser.ConditionElseContext ctx) {
		result += "else {\n";
		this.visit(ctx.inConditionExpression());
		result += "}\n";
		return "";
	}

	@Override
	public String visitInConditionExpression(KotlinParser.InConditionExpressionContext ctx) {
		this.visitChildren(ctx);
		return "";
	}

	@Override
	public String visitLoop(KotlinParser.LoopContext ctx) {
		// for
		if (ctx.FOR() != null)
			result += "for(";
		else
			result += "while(";
		this.visit(ctx.condition());
		result += " {\n";
		this.visitChildren(ctx);
		result += "}\n";
		return "";
	}

	@Override
	public String visitWhen(KotlinParser.WhenContext ctx) {
		result += "switch(";
		if (ctx.expression() != null)
			this.visit(ctx.expression());
		result += ")";
		this.visit(ctx.whenBody());
		return "";
	}

	@Override
	public String visitWhenBody(KotlinParser.WhenBodyContext ctx) {
		result += "{\n";
		this.visitChildren(ctx);
		result += "}\n";
		return "";
	}

	@Override
	public String visitWhenExpression(KotlinParser.WhenExpressionContext ctx) {
		/*
		 * // expression? ('!')? IN range ARROW (expression | returnVal) if(ctx.IN() !=
		 * null) { if(ctx.expression().size() == 2) this.visit(ctx.expression(0));
		 * result : } // expression? ('!')? IS type ARROW (expression | returnVal) else
		 * if(ctx.IS() != null) {
		 * 
		 * } // expression (',' expression)* ARROW (expression | returnVal) else {
		 * 
		 * }
		 */
		result += "case ";
		this.visit(ctx.expression(0));
		result += ": ";
		this.visit(ctx.expression(1));
		result += ";\n";
		result += "break;\n";
		return "";
	}

	@Override
	public String visitWhenElseExpression(KotlinParser.WhenElseExpressionContext ctx) {
		result += "default: ";
		this.visit(ctx.expression());
		result += ";\n";
		return "";
	}

	@Override
	public String visitRange(KotlinParser.RangeContext ctx) {
		if (ctx.toString().contains("..") || ctx.toString().contains("downTo")) {
			if (ctx.STEP() != null) {

			}
		}
		return visitChildren(ctx);
	}

	@Override
	public String visitNewClass(KotlinParser.NewClassContext ctx) {
		return visitChildren(ctx);
	}

	@Override
	public String visitNewInterface(KotlinParser.NewInterfaceContext ctx) {
		return visitChildren(ctx);
	}

	@Override
	public String visitNewComment(KotlinParser.NewCommentContext ctx) {
		return visitChildren(ctx);
	}

	@Override
	public String visitLambda(KotlinParser.LambdaContext ctx) {
		return visitChildren(ctx);
	}

	public static void main(String[] args) throws IOException {

		File fi = new File(args[0]);
		FileInputStream fin = new FileInputStream(fi);

		String s;
		s = "./" + args[1];
		File fo = new File(s);
		FileOutputStream fout = new FileOutputStream(fo);

		setFileName(s.substring(2, s.length() - 5));

		ANTLRInputStream input = new ANTLRInputStream(fin);
		KotlinLexer lexer = new KotlinLexer(input);
		KotlinParser parser = new KotlinParser(new CommonTokenStream(lexer));
		KotlinParser.ProgContext tree = parser.prog();
		KotlinBaseVisitor<String> visitor = new KotlinBaseVisitor();
		// KotlinVisitor visitor = new KotlinVisitor();
		String result = visitor.visit(tree);

		if (result == null) {
			result = "null";
		}
		OutputStream out = new FileOutputStream(fo);
		byte[] by = result.getBytes();
		out.write(by);

	}

}
