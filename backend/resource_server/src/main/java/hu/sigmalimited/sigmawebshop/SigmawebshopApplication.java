package hu.sigmalimited.sigmawebshop;

import hu.sigmalimited.sigmawebshop.feature.file.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SigmawebshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SigmawebshopApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			//storageService.deleteAll();
			storageService.init();
		};
	}

}
