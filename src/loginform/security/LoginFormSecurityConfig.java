package loginform.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class LoginFormSecurityConfig extends WebSecurityConfigurerAdapter {
	
	// security Data Source
	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// jdbc Authentication
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
		// users in memory
		
//		UserBuilder users = User.withDefaultPasswordEncoder();
//		auth.inMemoryAuthentication()
//			.withUser(users.username("henry").password("123123").roles("ADMIN"))
//			.withUser(users.username("nader").password("123123").roles("MANAGER"))
//			.withUser(users.username("temo").password("123123").roles("EMPLOYEE"));
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").hasAnyRole("EMPLOYEE","MANAGER","ADMIN")
			.antMatchers("/Leaders/**").hasRole("MANAGER")
			.antMatchers("/Systems/**").hasRole("ADMIN")
			.and()
			.formLogin()
			.loginPage("/LoginPage")
			.loginProcessingUrl("/AuthenticateUser")
			.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/AccessDenied");
		
	}
	
	
}
