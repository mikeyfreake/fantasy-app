package io.github.mikeyfreake.fantasy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.mikeyfreake.fantasy.domain.Owner;
import io.github.mikeyfreake.fantasy.repository.OwnerRepository;

@EnableAutoConfiguration
@SpringBootApplication
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);


	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(OwnerRepository repo) {
		return (args) -> {
			//Save some owners.
			repo.save(new Owner("James"));
			repo.save(new Owner("Mike"));
			repo.save(new Owner("Luke"));
			repo.save(new Owner("Ian"));
			
			//Fetch all owners.
			log.info("Owners found with findAll():");
			log.info("----------------------------");
			for (Owner o : repo.findAll()) {
				log.info(o.toString());
			}
			
		};
	}
}
