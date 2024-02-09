package com.init.products;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("admin")
		.password("{noop}123")
		.roles("ADMIN");
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http  // Deshabilitar CSRF para permitir la autenticación básica sin un formulario de login
            .authorizeRequests()
                .antMatchers("/logging/lista").authenticated()
                .and()
            .httpBasic();  // Habilitar autenticación básica
    }	
}
