package data;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class TestInterpreter {
	@Test
	public void testTranslate() throws Exception {
		Lexer lexer = new Lexer("(1*(2+1))");
		Parser parser = new Parser(lexer);
		AST node = parser.parse();
		System.out.println("--------------------------");
		System.out.println(lexer.text);
		System.out.println(node.toBackStyle());
		System.out.println(node.toLispStyle());
		System.out.println("--------------------------");
	}

	@Test
	public void testVist() throws Exception {
		Lexer lexer = new Lexer("(1*(2+1))");
		Parser parser = new Parser(lexer);

		int r = new InterpreterVistor(parser).eval();
		System.out.println(r);
		assertEquals(r, 3);

	}

	@Test
	public void test() throws Exception {
		Lexer lexer = new Lexer("(1*(2+1))");
		int r = new Interpreter(lexer).expr();
		System.out.println(r);
		assertEquals(r, 3);

	}

	@Test
	public void test1() throws Exception {
		Lexer lexer = new Lexer("1*2+1*2*1+1-1");
		int r = new Interpreter(lexer).expr();
		System.out.println(r);
		assertEquals(r, 4);

	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("������ʽ,�磺1+2");
			try {

				String text = sc.next();

				Lexer lexer = new Lexer(text);
				Interpreter interpreter = new Interpreter(lexer);
				int result = interpreter.expr();
				print(result);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	private static void print(int r) {
		System.out.println(r);

	}
}
