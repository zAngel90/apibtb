package org.com.ar.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "org.com.ar.api.btb.entities")
@ComponentScan(basePackages = "org.com.ar.api")
@EnableJpaRepositories(basePackages = {
	"org.com.ar.api.btb.repository",
	"org.com.ar.api.btb.repositories.readonly"
})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
