package lsbasi.visit;

import java.util.List;
import java.util.Map;

import lsbasi.ast.AST;
import lsbasi.ast.AssignmentAST;
import lsbasi.ast.BinOpAST;
import lsbasi.ast.NumberAST;
import lsbasi.ast.StatementAST;
import lsbasi.ast.StatementListAST;
import lsbasi.ast.UnaryOpAST;
import lsbasi.ast.VarAST;

public class NodeVisitor {
	public static int visit(AST node, Map<String, Integer> scope) throws Exception {
		if (node instanceof NumberAST) {
			return NumberVisitor.visit((NumberAST) node);
		} else if (node instanceof BinOpAST) {
			return BinVisitor.visit((BinOpAST) node, scope);
		} else if (node instanceof UnaryOpAST) {
			return UnaryVisitor.visit((UnaryOpAST) node, scope);
		} else if (node instanceof VarAST) {
			return VarVisitor.visit((VarAST) node, scope);
		}
		throw new Exception("error");
	}

	public static void visit(StatementListAST node, Map<String, Integer> scope) throws Exception {
		List<StatementAST> list = node.getList();
		for (StatementAST statementAST : list) {
			visit(statementAST, scope);
		}
	}

	public static void visit(StatementAST node, Map<String, Integer> scope) throws Exception {
		if (node instanceof AssignmentAST) {
			AssignVisitor.visit((AssignmentAST) node, scope);
		} else if (node instanceof StatementListAST) {
			visit((StatementListAST) node, scope);
		}
	}

	public static int visit(AST node) throws Exception {
		return visit(node, null);
	}
}
