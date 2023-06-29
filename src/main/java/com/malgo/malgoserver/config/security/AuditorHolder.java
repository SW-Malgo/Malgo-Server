package com.malgo.malgoserver.config.security;

import com.malgo.malgoserver.util.token.AuthClaims;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@UtilityClass
public class AuditorHolder {

	public static AuthClaims get() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null
				|| !authentication.isAuthenticated()
				|| authentication.getPrincipal().equals("anonymousUser")) {
			throw new RuntimeException("fail to get authClaims");
		}
		return (AuthClaims) authentication.getPrincipal();
	}
}
