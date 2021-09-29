package nl.miwgroningen.se6.vincent.librarydemo.configuration;

import nl.miwgroningen.se6.vincent.librarydemo.repository.LibraryUserRepository;
import nl.miwgroningen.se6.vincent.librarydemo.service.LibraryUserDetailsService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 *
 * Determine what security should go where
 */

@Configuration
@EnableWebSecurity
public class LibrarySecurityConfiguration extends WebSecurityConfigurerAdapter {

    LibraryUserDetailsService libraryUserDetailsService;

    public LibrarySecurityConfiguration(LibraryUserDetailsService libraryUserDetailsService) {
        super();
        this.libraryUserDetailsService = libraryUserDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                    .password(passwordEncoder().encode("admin"))
                    .roles("USER", "ADMIN");
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/webjars/**").permitAll()
                .antMatchers("/", "/books", "/books/details/*").permitAll()
                .anyRequest().authenticated().and()
                .formLogin().and()
                .logout().logoutSuccessUrl("/books");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(libraryUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
}
