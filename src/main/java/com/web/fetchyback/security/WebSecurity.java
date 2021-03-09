/**
 * 
 */
package com.web.fetchyback.security;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.web.fetchyback.jwt.JwtFilter;

import static com.web.fetchyback.security.SecurityConstants.*;


/**
 * @author abi
 * Class to integrate the security filters
 */
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private JwtFilter jwtFitler;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}
	
    /**
     * Method where we define which resources are public and which are secured
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
				.antMatchers(HttpMethod.POST, SIGN_UP_URL, LOG_IN_URL).permitAll()
				.antMatchers(HttpMethod.GET, HELLO_URL, ALL_USERS).permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        http.addFilterBefore(jwtFitler, UsernamePasswordAuthenticationFilter.class);
    }
    /**
     * Method where we defined a custom implementation of UserDetailsService 
     * to load user-specific data in the security framework
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Bean
	CorsConfigurationSource corsConfigurationSource() {
	   final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	   source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
	   return source;
	}

}
