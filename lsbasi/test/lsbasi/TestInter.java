package lsbasi;

import org.junit.Assert;
import org.junit.Test;

public class TestInter {

	@Test
	public void test1() throws Exception{
		Interpreter i = new Interpreter(new Lexer("(1+1)*2+(2*2)"));
		int r = i.expr();
		Assert.assertEquals(r, 8);
		
	}

}
