package com.malgo.malgoserver.util.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TokenResolver {

	private static final String MEMBER_ID_CLAIM_KEY = "memberId";
	private static final String COMPANY_ID_CLAIM_KEY = "companyId";

	@Value("${security.jwt.token.secretkey}")
	private String secretKey;

	/** 토큰에서 memberId 조회 */
	public Optional<AuthClaims> resolveToken(String token) {
		try {
			Claims body =
					Jwts.parserBuilder()
							.setSigningKey(secretKey.getBytes())
							.build()
							.parseClaimsJws(token)
							.getBody();
			return Optional.ofNullable(
					AuthClaims.builder()
							.id(body.get(MEMBER_ID_CLAIM_KEY, Long.class))
							.company(body.get(COMPANY_ID_CLAIM_KEY, String.class))
							.build());
		} catch (Exception e) {
			log.warn("Failed to get memberId. token: {}", token);
			return Optional.empty();
		}
	}
}
