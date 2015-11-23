package data.json;


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
	public String string() {
		String result = "";
		advance();
		this.current_char=text.charAt(pos);
		while (this.current_char != Character.MIN_VALUE
				&& this.current_char!='"') {
			result += text.charAt(pos);
			advance();
			this.current_char=text.charAt(pos);
		}
		advance();
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
				return new Token(JsonTokenType.NUMBER, integer());

			}
			if (current=='{') {
				advance();
				return new Token(JsonTokenType.LEFTbrace, '{');

			}
			if (current=='}') {
				advance();
				return new Token(JsonTokenType.RIGHTbrace, '}');

			}
			if (current=='[') {
				advance();
				return new Token(JsonTokenType.LEFTBRACKET, '[');

			}
			if (current==']') {
				advance();
				return new Token(JsonTokenType.RIGHTBRACKET, ']');

			}
			if (current==':') {
				advance();
				return new Token(JsonTokenType.COLON, ':');

			}
			if (current=='"') {
				return new Token(JsonTokenType.STRING, string());

			}
			if (current==',') {
				advance();
				return new Token(JsonTokenType.COMMA, ',');

			}
			error();
		}

		return new Token(JsonTokenType.EOF, "EOF");
	}

}
