package com.springsecurity.focus.springsecurityfocus.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
private final PasswordEncoder passwordEncoder;

@Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
      UserDetails yassirRchi=  User.builder()
                .username("Yassir")
                .password(passwordEncoder.encode("123"))
                .roles(AppUserRole.EMPLOYEE.name()).build();
        UserDetails yahyaRchi=  User.builder()
                .username("yahya")
                .password(passwordEncoder.encode("123"))
                .roles(AppUserRole.ADMIN.name()).build();
        UserDetails adminTrainee=  User.builder()
                .username("trainee")
                .password(passwordEncoder.encode("123"))
                .roles(AppUserRole.ADMINTRAINEE.name()).build();
        return new InMemoryUserDetailsManager(yassirRchi,yahyaRchi);
    }

    @Override

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().
                antMatchers("/","index","/css/*","/js/*").permitAll().
                 antMatchers("/api/**").hasRole(AppUserRole.EMPLOYEE.name()).
                 antMatchers(HttpMethod.DELETE,"/management/api/**").hasAuthority(AppUserPresmission.CONTENT_WRITE.name())
                .antMatchers(HttpMethod.PUT,"/management/api/**").hasAuthority(AppUserPresmission.CONTENT_WRITE.name())
                . antMatchers(HttpMethod.POST,"/management/api/**").hasAuthority(AppUserPresmission.CONTENT_WRITE.name())
                .antMatchers(HttpMethod.GET,"/management/api/**").hasAnyRole(AppUserRole.ADMINTRAINEE.name())

    . anyRequest().
                authenticated().
                and().
                httpBasic();

    }
}
