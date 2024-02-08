package loja.api.rest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import loja.api.rest.model.Category;

@SpringBootApplication
@EntityScan(basePackages = {"loja.api.rest.model"})
@ComponentScan(basePackages = {"loja.*"})
@EnableJpaRepositories(basePackages = {"loja.api.rest.repository"})
@EnableTransactionManagement
@EnableWebMvc
@RestController
@EnableAutoConfiguration
@EnableCaching
@Configuration
public class LojaspringrestapiApplication  implements WebMvcConfigurer  {

	public static void main(String[] args) {
		SpringApplication.run(LojaspringrestapiApplication.class, args);
		

	}
	
 
	
    /*Mapeamento Global que refletem em todo o sistema*/
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		
	registry.addMapping("/category/**")
	.allowedMethods("*")
	.allowedOrigins("*");
	
	registry.addMapping("/product/**")
	.allowedMethods("*","PUT","DELETE")
	.allowedOrigins("*");
	
	

	
	

	
	
	
}
	
	}


