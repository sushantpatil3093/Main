package com.zosh.auth.controller;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

   
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	                .authorizeHttpRequests(auth -> auth
	                        // only allow login page and static files without login
	                        .requestMatchers("/login", "/css/**", "/js/**").permitAll()
	                        .anyRequest().authenticated()  // protect everything else
	                )
	                .formLogin(form -> form
	                        .loginPage("/login")                      // GET login page
	                        .loginProcessingUrl("/login")             // POST target
	                        .defaultSuccessUrl("/user/welcome", true) // after login success
	                        .permitAll()
	                )
	                .logout(logout -> logout
	                        .logoutSuccessUrl("/login?logout")
	                        .permitAll()
	                );

	        return http.build();
	    }

	    @Bean
	    public UserDetailsService userDetailsService() {
	        UserDetails user = User.withDefaultPasswordEncoder()
	                .username("sushant")
	                .password("1234")
	                .roles("USER")
	                .build();

	        return new InMemoryUserDetailsManager(user);
}
}
