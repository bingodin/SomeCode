package lsbasi;

public class TestDebug {
	public static void main(String[] args) throws Exception {
		Lexer lexer = new Lexer("{number=2;a=number;b=10*a+10;c=a--b};x=11;y=x*10");
		Parser p = new Parser(lexer);

		Interpreter i = new Interpreter(p);
		i.debugger();
		System.out.println(i.GLOBAL_SCOPE);

	}
}
