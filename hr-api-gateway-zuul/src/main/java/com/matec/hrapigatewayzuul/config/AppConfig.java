package com.matec.hrapigatewayzuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfig {
	
	@Bean
	public JwtAccessTokenConverter accessTokenConvert() {		
		JwtAccessTokenConverter tokenConvert = new JwtAccessTokenConverter();
		tokenConvert.setSigningKey("MY-SECRET-KEY");
		return tokenConvert;
	}
	
	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConvert());
	}

}
