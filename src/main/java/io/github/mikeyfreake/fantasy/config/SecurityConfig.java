/**
 * 
 */
package io.github.mikeyfreake.fantasy.config;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Manage application security.
 * @author mfreake
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Inject
    private AjaxAuthenticationSuccessHandler ajaxAuthenticationSuccessHandler;

    @Inject
    private AjaxAuthenticationFailureHandler ajaxAuthenticationFailureHandler;

    @Inject
	private AjaxLogoutSuccessHandler ajaxLogoutSuccessHandler;

	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/api/**").permitAll()
            .antMatchers("/api/**").authenticated()
            //.anyRequest().authenticated()
        .and()
        	.formLogin()
            .loginProcessingUrl("/login")
            .successHandler(ajaxAuthenticationSuccessHandler)
            .failureHandler(ajaxAuthenticationFailureHandler)
            .passwordParameter("password")
            .usernameParameter("username")
            .permitAll()
        .and()
        	.logout()
        	.logoutUrl("/logout")
        	.logoutSuccessHandler(ajaxLogoutSuccessHandler)
            .deleteCookies("JSESSIONID", "CSRF-TOKEN")
        	.permitAll()
        .and()
            .csrf().disable(); //TODO Correct this.        
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    auth
	        .inMemoryAuthentication()
	            .withUser("user").password("password").roles("USER")
	        .and().withUser("mikeyfreake@gmail.com").password("Openopen1").roles("USER");
	}
}
