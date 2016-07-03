package lsbasi.ast;

import java.util.LinkedList;
import java.util.List;

public class StatementListAST extends StatementAST {
	List<StatementAST> list;

	public List<StatementAST> getList() {
		return list;
	}

	public StatementListAST(StatementAST first) {
		super();
		this.list = new LinkedList<>();
		list.add(first);
	}

	public void add(StatementAST s) {
		list.add(s);
	}

	@Override
	public String toString() {
		return "StatementListAST [list=" + list + "]";
	}
}
