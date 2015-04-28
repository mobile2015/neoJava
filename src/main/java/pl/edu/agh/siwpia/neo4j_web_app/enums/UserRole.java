package pl.edu.agh.siwpia.neo4j_web_app.enums;

public enum UserRole {
	ADMIN("Administrator"), USER("Użytkownik");

	private final String text;

	private UserRole(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
