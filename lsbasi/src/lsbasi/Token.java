package lsbasi;

public class Token {
	TokenType type;
	String value;

	public Token(TokenType type, String value) {
		super();
		this.type = type;
		this.value = value;
	}

	public TokenType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Token [type=" + type + ", value=" + value + "]";
	}

	public String getValue() {
		return value;
	}

}
