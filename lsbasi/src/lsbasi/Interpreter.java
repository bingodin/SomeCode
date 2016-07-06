package lsbasi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lsbasi.ast.AST;
import lsbasi.ast.StatementAST;
import lsbasi.ast.StatementListAST;
import lsbasi.visit.NodeVisitor;

public class Interpreter {
	Parser parser;
	Map<String, Integer> GLOBAL_SCOPE = new HashMap<>();

	public Interpreter(Parser parser) {
		this.parser = parser;
	}

	public Parser getParser() {
		return parser;
	}

	int eval() throws Exception {
		AST node = parser.parser();
		int r = NodeVisitor.visit(node);
		return r;
	}

	void run() throws Exception {
		StatementListAST node = parser.parser();
		NodeVisitor.visit(node, GLOBAL_SCOPE);
	}

	void debugger() throws Exception {
		StatementListAST node = parser.parser();
		List<StatementAST> list = node.getList();
		Debugger debugger = new Debugger(list, GLOBAL_SCOPE);
		debugger.debugger();

	}
}
