package lsbasi.visit;

import lsbasi.ast.AST;
import lsbasi.ast.BinOpAST;
import lsbasi.ast.NumberAST;

public class NodeVisitor {
	public static int visit(AST node) throws Exception{
		if(node instanceof NumberAST){
			return  NumberVisitor.visit((NumberAST) node);
		}else if(node instanceof BinOpAST){
			return BinVisitor.visit((BinOpAST) node);
		}
		throw new Exception("error");
	}
}
