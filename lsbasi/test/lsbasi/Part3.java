package lsbasi;

import org.junit.Assert;
import org.junit.Test;

public class Part3 {


//	@Test
//	public void test1() throws Exception{
//		Interpreter i = new Interpreter("3-1+10-10");
//		int r = i.expr();
//		Assert.assertEquals(r, 2);
//		
//	}
	@Test
	public void test1() throws Exception{
		Interpreter i = new Interpreter("3*10/10*2/2");
		int r = i.expr();
		Assert.assertEquals(r, 3);
		
	}
}
