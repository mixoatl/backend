package com.microservice.zuul.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(jwtTokenStore());
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/api/security/oauth/**").permitAll()
		.antMatchers(HttpMethod.GET, "/api/phone/list", "/api/tienda/list", "/api/us/usuarios").permitAll()
		.antMatchers(HttpMethod.GET, "/api/phone/celular/{id}", 
				"/api/tienda/celular/{id}/cantidad/{cantidad}", 
				"/api/us/usuarios/{id}").hasAnyRole("ADMIN", "USER")
		.antMatchers(HttpMethod.POST, "/api/phone/celular", "/api/us/usuarios").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/api/phone/celular/{id}", "/api/us/usuarios/{id}").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/phone/celular/{id}", "/api/us/usuarios/{id}").hasRole("ADMIN")
		.anyRequest().authenticated();
	}

	@Bean
	public JwtTokenStore jwtTokenStore() {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}
	
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey("llave");
		return tokenConverter;
	}
	
}
