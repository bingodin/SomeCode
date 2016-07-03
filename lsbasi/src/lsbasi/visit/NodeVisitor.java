package lsbasi.visit;

import lsbasi.ast.AST;
import lsbasi.ast.BinOpAST;
import lsbasi.ast.NumberAST;
import lsbasi.ast.UnaryOpAST;

public class NodeVisitor {
	public static int visit(AST node) throws Exception{
		if(node instanceof NumberAST){
			return  NumberVisitor.visit((NumberAST) node);
		}else if(node instanceof BinOpAST){
			return BinVisitor.visit((BinOpAST) node);
		}else if(node instanceof UnaryOpAST){
			return UnaryVisitor.visit((UnaryOpAST) node);
		}
		throw new Exception("error");
	}
}
