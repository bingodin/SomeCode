package lsbasi;

public class Main {

	public static void main(String[] args) throws Exception {
		Interpreter i = new Interpreter("1+2");
		int r = i.expr();
		System.out.println(r);

	}

}
