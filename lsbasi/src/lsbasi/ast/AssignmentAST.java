package lsbasi.ast;

public class AssignmentAST extends StatementAST {
	String id;
	AST expr;

	public String getId() {
		return id;
	}

	public AST getExpr() {
		return expr;
	}

	public AssignmentAST(String id, AST expr) {
		super();
		this.id = id;
		this.expr = expr;
	}

	@Override
	public String toString() {
		return "AssignmentAST [id=" + id + ", expr=" + expr + "]";
	}

}
