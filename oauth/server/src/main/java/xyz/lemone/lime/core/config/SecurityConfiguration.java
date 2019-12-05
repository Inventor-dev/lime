package xyz.lemone.lime.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        PasswordEncoder passwordEncoder = passwordEncoder();
        return new InMemoryUserDetailsManager(
                User.withUsername("marissa").password(passwordEncoder.encode("koala")).roles("USER").build()
                ,User.withUsername("paul").password(passwordEncoder.encode("emu")).roles("USER").build()
        );
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
//        忽略资源路径
//        @formatter:off
        web.ignoring().antMatchers(
                "/webjars/**", "/images/**","/css/**" ,"/scripts/**","/fonts/**",
                "/oauth/uncache_approvals", "/oauth/cache_approvals",
                "/login_form.html");
//        @formatter:on
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .authorizeRequests()
                .antMatchers("/login.html").permitAll()
                .anyRequest().hasRole("USER")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/login.html?authorization_error=true")
                .and()
                // TODO: put CSRF protection back into this endpoint
                .csrf()
                .requireCsrfProtectionMatcher(new AntPathRequestMatcher("/oauth/authorize"))
                .disable()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login.html")
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .failureUrl("/login.html?authentication_error=true")
                .loginPage("/login.html");
        // @formatter:on
    }
}
