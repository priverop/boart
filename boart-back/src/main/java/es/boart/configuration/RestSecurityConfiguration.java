package es.boart.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import es.boart.repository.UserRepositoryAuthenticationProvider;

@Configuration
@Order(1)
public class RestSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public UserRepositoryAuthenticationProvider userRepoAuthProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.antMatcher("/api/**");
		
		// URLs that need authentication to access to it
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/private_profile/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/private_profile/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/publication/**").hasRole("USER");	
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/like/**").hasRole("USER");	
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/like/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/upload/").hasRole("USER");	
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/group/create/").hasRole("USER");	
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/group/leave/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/group/join/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/publication/**").hasRole("USER");	
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/user/**").hasRole("USER");	
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/user/follow/**").hasRole("USER");	
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/user/unfollow/**").hasRole("USER");	



		
		// Other URLs can be accessed without authentication
		http.authorizeRequests().anyRequest().permitAll();

		// Disable CSRF protection (it is difficult to implement with ng2)
		http.csrf().disable();

		// Use Http Basic Authentication
		http.httpBasic();

		// Do not redirect when logout
		http.logout().logoutSuccessHandler((rq, rs, a) -> {	});
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Database authentication provider
		auth.authenticationProvider(userRepoAuthProvider);
	}
}