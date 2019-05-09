package xyz.lemone.lime.core.support.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 明文密码
 * @author lemon
 * @date 2019/5/8
 */
public class CleartextPasswordEncoder implements PasswordEncoder {
	@Override
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return encodedPassword.equals(rawPassword.toString());
	}
}
