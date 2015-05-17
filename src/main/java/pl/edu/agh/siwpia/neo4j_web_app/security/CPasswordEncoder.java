package pl.edu.agh.siwpia.neo4j_web_app.security;

import org.apache.log4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CPasswordEncoder implements PasswordEncoder {

	private static final Logger logger = Logger.getLogger(CPasswordEncoder.class);

	@Override
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return encodedPassword.equals(rawPassword.toString());
	}
}
