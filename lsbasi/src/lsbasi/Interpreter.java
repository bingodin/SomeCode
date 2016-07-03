package lsbasi;

import lsbasi.ast.AST;
import lsbasi.visit.NodeVisitor;

public class Interpreter {
	Parser parser;

	public Interpreter(Parser parser) {
		this.parser = parser;
	}

	int eval() throws Exception {
		AST node = parser.parser();
		int r = NodeVisitor.visit(node);
		return r;
	}
}
