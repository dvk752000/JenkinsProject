package com.springboot.Jenkins;

import java.io.Console;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	        .authorizeRequests()
	            .antMatchers("/locations").authenticated()
	        .and()
	            .httpBasic();
	        http.csrf().disable();
	    }

	    @Bean
	    public UserDetailsService userDetailsService() {

	        String username = null;
	        String password = null;

	        System.out.println("\nPlease set the admin credentials for this web application (will be required when browsing to the web application)");
	        username = "vadudduk";
	        password = "password";
	        /*
	        Console console = System.console();

	        // Read the credentials from the user console: 
	        // Note: 
	        // Console supports password masking, but is not supported in IDEs such as eclipse; 
	        // thus if in IDE (where console == null) use scanner instead:
	        if (console == null) {
	            // Use scanner:
	            Scanner scanner = new Scanner(System.in);
	            while (true) {
	                System.out.print("Username: ");
	                username = scanner.nextLine();
	                System.out.print("Password: ");
	                password = scanner.nextLine();
	                System.out.print("Confirm Password: ");
	                String inputPasswordConfirm = scanner.nextLine();

	                if (username.isEmpty()) {
	                    System.out.println("Error: user must be set - please try again");
	                } else if (password.isEmpty()) {
	                    System.out.println("Error: password must be set - please try again");
	                } else if (!password.equals(inputPasswordConfirm)) {
	                    System.out.println("Error: password and password confirm do not match - please try again");
	                } else {
	                    break;
	                }
	                System.out.println("");
	            }
	            scanner.close();
	        } else {
	            // Use Console
	            while (true) {
	                username = console.readLine("Username: ");
	                char[] passwordChars = console.readPassword("Password: ");
	                password = String.valueOf(passwordChars);
	                char[] passwordConfirmChars = console.readPassword("Confirm Password: ");
	                String passwordConfirm = String.valueOf(passwordConfirmChars);

	                if (username.isEmpty()) {
	                    System.out.println("Error: Username must be set - please try again");
	                } else if (password.isEmpty()) {
	                    System.out.println("Error: Password must be set - please try again");
	                } else if (!password.equals(passwordConfirm)) {
	                    System.out.println("Error: Password and Password Confirm do not match - please try again");
	                } else {
	                    break;
	                }
	                System.out.println("");

	            }
	        }*/

	        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	        if (username != null && password != null) {
	            String encodedPassword = passwordEncoder().encode(password);
	            manager.createUser(User.withUsername(username).password(encodedPassword).roles("USER").build());
	        }
	        return manager;
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
}