package loginform.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="loginform")
@PropertySource("classpath:persistence-mysql.properties")
public class LoginFormConfig implements WebMvcConfigurer {
	
	// for handling mysql properties
	@Autowired
	private Environment environment;
	
	// security data source bean
	@Bean
	public DataSource securityDataSource() {
		
		// connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		
		try {
			// set database driver
			securityDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
			
		} catch (PropertyVetoException ex) {
			throw new RuntimeException(ex);
		}
		
		// set database user
		securityDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));                                                          
		securityDataSource.setUser(environment.getProperty("jdbc.user"));                                                            
		securityDataSource.setPassword(environment.getProperty("jdbc.password"));                                                    

		// set connection pool 
		securityDataSource.setInitialPoolSize(Integer.parseInt(environment.getProperty("connection.pool.initialPoolSize")));
		securityDataSource.setMinPoolSize(Integer.parseInt(environment.getProperty("connection.pool.minPoolSize")));
		securityDataSource.setMaxPoolSize(Integer.parseInt(environment.getProperty("connection.pool.maxPoolSize")));
		securityDataSource.setMaxIdleTime(Integer.parseInt(environment.getProperty("connection.pool.maxIdleTime")));

		return securityDataSource;
	}
	
	// View Resolver bean
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver(); 
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	// Resources handler
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
	
}


