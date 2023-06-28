package com.malgo.malgoserver.util.token;

import io.jsonwebtoken.Jwts;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TokenResolver {

	private static final String MEMBER_ID_CLAIM_KEY = "memberId";

	@Value("${security.jwt.token.secretkey}")
	private String secretKey;

	/** 토큰에서 memberId 조회 */
	public Optional<Long> resolveToken(String token) {
		try {
			return Optional.ofNullable(
					Jwts.parserBuilder()
							.setSigningKey(secretKey.getBytes())
							.build()
							.parseClaimsJws(token)
							.getBody()
							.get(MEMBER_ID_CLAIM_KEY, Long.class));
		} catch (Exception e) {
			log.warn("Failed to get memberId. token: {}", token);
			return Optional.empty();
		}
	}
}
