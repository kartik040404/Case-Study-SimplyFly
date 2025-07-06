package com.example.simplyfly;
import java.util.Collection;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private UserDetailsService  userDetailsService;
@Autowired
private JWTFilter jwtFilter;
	@Bean 
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
			httpSecurity.csrf(csrf->csrf.disable())
			.authorizeHttpRequests(http->http
					.requestMatchers("/api/").permitAll()
					.requestMatchers("/api/auth/**").permitAll()
					.requestMatchers("/api/admin/**").hasRole("ADMIN")
					.anyRequest().authenticated()
			)       .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
			
			.httpBasic(Customizer.withDefaults());
			return httpSecurity.build();
	}
	
	@Bean 
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
	


	
}
