package com.freyvik.contacts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() throws Exception {
        List<UserDetails> users = List.of(
                User.withUsername("User1")
                        .password("$2y$10$4d/YE5kVkgpBGnseMetJ4OKUSQiLGTKTi/rt/Iy5JdcgL3Wmj9DpO")
                        .roles("USERS")
                        .build(),
                User.withUsername("User2")
                        .password("$2y$10$lkGjPI4OMk32ICh5HiJ5Yem3UPIeP6VEcmC3hmFfyKDNdG54pt9Bi")
                        .roles("OPERATOR")
                        .build(),
                User.withUsername("admin")
                        .password("$2y$10$BdaoiHmLjcTyEoPGfvRu.OJExRxlo1jr94UxyPnNwijSHcCWGM8Hq")
                        .roles("USERS", "ADMIN")
                        .build()
        );

        return new InMemoryUserDetailsManager(users);
    }
     */

    @Bean
    public JdbcUserDetailsManager usersDetailsJDBC() {
        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setDriverClassName("org.mariadb.jdbc.Driver");
        ds.setUrl("jdbc:mariadb://localhost:3306/security?serviceTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("root");

        JdbcUserDetailsManager jdbcDetails = new JdbcUserDetailsManager(ds);

        jdbcDetails.setUsersByUsernameQuery("SELECT user, pwd, enabled FROM USER WHERE user = ?");
        jdbcDetails.setAuthoritiesByUsernameQuery("SELECT user, rol FROM roles WHERE user = ?");

        return jdbcDetails;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(aut -> aut
                                .requestMatchers(HttpMethod.POST, "/contact").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/contacts/**").hasAnyRole("ADMIN", "OPERATOR")
                                .requestMatchers("/contacts").authenticated()
                                .anyRequest().permitAll()
                        )
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }

    // Passwords encrypted wth BCrypt
    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
