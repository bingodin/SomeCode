package lsbasi;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import lsbasi.ast.StatementAST;
import lsbasi.visit.NodeVisitor;

public class Debugger {
	Scanner s = new Scanner(System.in);
	private Map<String, Integer> scope;
	private List<StatementAST> list;
	private int index;

	public Debugger(List<StatementAST> list, Map<String, Integer> scope) {
		this.list = list;
		this.scope = scope;
		this.index = 0;
	}

	public void help() {
		System.out.println("h:help");
		System.out.println("n:next");
		System.out.println("w:watch");
	}

	public String waitUser() {
		return s.next();
	}

	public void debugger() throws Exception {
		help();
		while (index < list.size() ) {
			switch (waitUser()) {
			case "n":
				NodeVisitor.visit(list.get(index), scope);
				index++;
				break;
			case "h":
				help();
				break;
			case "w":
				System.out.println(scope);
				break;
			default:
				break;
			}
		}

	}

}
