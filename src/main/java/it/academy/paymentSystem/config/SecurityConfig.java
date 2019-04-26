package it.academy.paymentSystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}user123").roles("USER")
                .and()
                .withUser("admin").password("{noop}admin123").roles("ADMIN")
                ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .anyRequest().authenticated()
//                .antMatchers("/cashier").hasAnyRole("USER", "TELLER")
//                .antMatchers("/check").hasRole("SUPER")
//                .antMatchers("/general").hasAnyRole("TELLER", "SUPER")
//                .antMatchers("/shared").permitAll()
                .and()
                .httpBasic()
                .and()
                .logout();
    }
}
