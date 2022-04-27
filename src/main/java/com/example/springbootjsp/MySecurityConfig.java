package com.example.springbootjsp;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("zaur")
                .password("zaur")
                .authorities("IT")
                .and()
                .withUser("dzhavid")
                .password("dzhavid")
                .authorities("IT")
                .and()
                .withUser("dzhoha")
                .password("dzhoha")
                .authorities("UNKNOWN")
                .and()
                .withUser("mariya")
                .password("mariya")
                .authorities("SALES")
                .and()
                .withUser("denis")
                .password("denis")
                .authorities("MANAGER")
                .and()
                .withUser("oleg")
                .password("oleg")
                .authorities("HR")
                .and()
                .withUser("uktam")
                .password("uktam")
                .authorities("FOOD");

    }

}