package hu.sigmalimited.sigmawebshop.security;

import hu.sigmalimited.sigmawebshop.auth.HomeUrlDistributorAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true)
public class SecurityConfig {
    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/assets/**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeHttpRequests(auth->{
            auth.requestMatchers("/admin/**").hasRole("ADMIN");
            auth.requestMatchers("/support/**").hasAnyRole("SUPPORT", "ADMIN");
            auth.requestMatchers("/orders").hasRole("CUSTOMER");
            auth.requestMatchers("/product/*").permitAll();
            auth.requestMatchers("/").permitAll();
            auth.anyRequest().denyAll();
        });

        http.formLogin(formLogin->{
            formLogin.loginPage("/login").permitAll();
            formLogin.defaultSuccessUrl("/");
            formLogin.usernameParameter("email");
            formLogin.successHandler(new HomeUrlDistributorAuthenticationSuccessHandler());
        });

        http.logout(logout-> {
            logout.logoutUrl("/logout");
            logout.invalidateHttpSession(true);
            logout.deleteCookies("JSESSIONID");
            logout.logoutSuccessUrl("/login?logout");
        });

        return http.build();
    }

    @Bean 
    public PasswordEncoder passwordEncoder() { 
        return new BCryptPasswordEncoder();
    } 
}