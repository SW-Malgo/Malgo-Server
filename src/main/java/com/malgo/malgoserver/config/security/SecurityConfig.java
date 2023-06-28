package com.malgo.malgoserver.config.security;

import com.malgo.malgoserver.config.security.auth.AuthProvider;
import com.malgo.malgoserver.config.security.exception.DelegatedAccessDeniedHandler;
import com.malgo.malgoserver.config.security.exception.DelegatedAuthenticationEntryPoint;
import com.malgo.malgoserver.config.security.filter.AuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

@EnableWebSecurity
@Configuration(value = "webSecurityConfig")
@RequiredArgsConstructor
public class SecurityConfig {

	private final AuthProvider authProvider;
	private final DelegatedAuthenticationEntryPoint authenticationEntryPoint;
	private final DelegatedAccessDeniedHandler accessDeniedHandler;

	@Bean
	public SecurityFilterChain localSecurityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.formLogin().disable();
		http.httpBasic().disable();

		http.authorizeHttpRequests()
				.mvcMatchers(HttpMethod.GET, "/bar/tokens")
				.permitAll()
				.mvcMatchers("/bar/**")
				.authenticated()
				.anyRequest()
				.denyAll();

		http.addFilterAt(authenticationFilter(), AbstractPreAuthenticatedProcessingFilter.class);

		http.exceptionHandling()
				.authenticationEntryPoint(authenticationEntryPoint)
				.accessDeniedHandler(accessDeniedHandler);

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		return http.build();
	}

	@Bean
	ProviderManager providerManager() {
		return new ProviderManager(authProvider);
	}

	@Bean
	public AuthenticationFilter authenticationFilter() {
		AuthenticationFilter authenticationFilter = new AuthenticationFilter();
		authenticationFilter.setAuthenticationManager(providerManager());
		return authenticationFilter;
	}
}
