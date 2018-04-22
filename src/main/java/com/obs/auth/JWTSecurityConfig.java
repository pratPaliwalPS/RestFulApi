package com.obs.auth;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class JWTSecurityConfig extends WebSecurityConfigurerAdapter {
	/*@Override
	  protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().antMatchers("/accrualrule/**").hasRole("USER").antMatchers("/delete/**").hasRole("ADMIN").and().csrf().disable()
	        .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
	                UsernamePasswordAuthenticationFilter.class)
	        .addFilterBefore(new JWTAuthenticationFilter(),
	                UsernamePasswordAuthenticationFilter.class);
	  }

	  @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    // Create a default account
		  auth.inMemoryAuthentication().withUser("user").password("user").roles("USER").and().withUser("admin").password("admin").roles("USER", "ADMIN");
	    
	  }
*/
	
	
	  protected void configure(HttpSecurity http) throws Exception {
		    http.csrf().disable().authorizeRequests()
		     
		        .antMatchers(HttpMethod.POST, "/login").permitAll()
		        .antMatchers("/").permitAll()
		        .anyRequest().authenticated()
		        .and()
		        // We filter the api/login requests
		        .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
		                UsernamePasswordAuthenticationFilter.class)
		        // And filter other requests to check the presence of JWT in header
		        .addFilterBefore(new JWTAuthenticationFilter(),
		                UsernamePasswordAuthenticationFilter.class);
		  }

		  @Override
		  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		    // Create a default account
		    auth.inMemoryAuthentication()
		        .withUser("admin")
		        .password("admin")
		        .roles("ADMIN").and().withUser("user").password("user").roles("USER");
		  }
}
