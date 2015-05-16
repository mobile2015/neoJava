package pl.edu.agh.siwpia.neo4j_web_app.security;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityImpl implements GrantedAuthority {

	private static final long serialVersionUID = 8704647544605564555L;

	private String authority;

	public GrantedAuthorityImpl(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return authority;
	}

	@Override
	public String toString() {
		return authority;
	}

}
