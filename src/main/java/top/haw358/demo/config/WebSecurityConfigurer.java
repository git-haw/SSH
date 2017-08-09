package top.haw358.demo.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by haw on 17-6-5.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("haw").password("haw358").roles("USER").and()
//                .withUser("admin").password("admin358").roles("USER", "ADMIN");

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select name as username, password, enabled "+
                        "from t_user where name=?")
                .authoritiesByUsernameQuery("select u.name as username, r.role as authority "+
                        "from t_user u, t_group g, t_role r "+
                        "where u.name=? and u.group_id=g.id and g.id=r.group_id");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/show").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();

    }

}
