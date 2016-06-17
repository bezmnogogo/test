package com.totalizator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by kasyanov on 6/17/2016.
 */

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("operator").password("operator").roles("OPERATOR");
		auth.inMemoryAuthentication().withUser("tech").password("tech").roles("OPERATOR", "TECH");
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("OPERATOR", "TECH", "ADMIN");

//        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//super.configure(http);


//        http.authorizeRequests().antMatchers("/secured/data/**").access("hasAnyRole('ROLE_ADMIN',ROLE_TECH)")
//                .and().formLogin().defaultSuccessUrl("/", false);

		http.authorizeRequests() //operator rules
				.antMatchers("/monitoring/**", "/mixingRecipes/**", "/extruderRecipes/**", "/extruder/**")
				.access("hasAnyRole('ROLE_OPERATOR','ROLE_TECH','ROLE_ADMIN')")
				.and().formLogin().defaultSuccessUrl("/", false)
				.and().exceptionHandling().accessDeniedPage("/403");

		http.authorizeRequests()
				.antMatchers("/secured/settings/**","/secured/data/**")
				.access("hasAnyRole('ROLE_TECH','ROLE_ADMIN')")
				.and().formLogin().defaultSuccessUrl("/", false);



		http.csrf().disable();
	}
}