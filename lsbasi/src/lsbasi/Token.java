package lsbasi;

public class Token {
	TokenType type;
	String value;

	public Token(TokenType type, String value) {
		super();
		this.type = type;
		this.value = value;
	}

	@Override
	public String toString() {
		return "Token [type=" + type + ", value=" + value + "]";
	}

}
