package data;

public class Lexer {
	String text;
	int pos;

	char current_char;

	public Lexer(String text) {
		this.text = text;
		this.pos = 0;
		this.current_char = this.text.charAt(pos);
	}

	public void error() throws Exception {

		throw new Exception("·Ç·¨×Ö·û");

	}

	public void advance() {
		this.pos += 1;
		if (pos > text.length() - 1) {
			this.current_char = Character.MIN_VALUE;
		} else {

		}
	}

	public void skip_whitespace() {
		while (this.current_char != Character.MIN_VALUE
				&& isspace(text.charAt(pos))) {
			advance();
		}
	}

	public boolean isspace(char c) {
		return (c + "").trim().length() == 0;
	}

	public String integer() {
		String result = "";
		while (this.current_char != Character.MIN_VALUE
				&& Character.isDigit(text.charAt(pos))) {
			result += text.charAt(pos);
			advance();
		}
		return result;
	}

	public Token get_next_token() throws Exception {
		while (this.current_char != Character.MIN_VALUE) {
			char current = text.charAt(pos);
			if (isspace(current)) {
				skip_whitespace();
				continue;
			}
			if (Character.isDigit(current)) {
				return new Token(TokenType.INTEGER, integer());

			}

			if (current == TokenType.PLUS.getC()) {
				advance();
				return new Token(TokenType.PLUS, TokenType.PLUS.getC());

			}
			if (current == TokenType.MINUS.getC()) {
				advance();
				return new Token(TokenType.MINUS, TokenType.MINUS.getC());

			}
			if (current == TokenType.MUL.getC()) {
				advance();
				return new Token(TokenType.MUL, TokenType.MUL.getC());

			}
			if (current == TokenType.DIV.getC()) {
				advance();
				return new Token(TokenType.DIV, TokenType.DIV.getC());

			}
			if (current == TokenType.LPAREN.getC()) {
				advance();
				return new Token(TokenType.LPAREN, TokenType.LPAREN.getC());

			}
			if (current == TokenType.RPAREN.getC()) {
				advance();
				return new Token(TokenType.RPAREN, TokenType.RPAREN.getC());

			}
			error();
		}

		return new Token(TokenType.EOF, "EOF");
	}

}
