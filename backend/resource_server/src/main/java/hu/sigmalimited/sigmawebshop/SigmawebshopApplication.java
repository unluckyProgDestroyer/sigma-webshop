package hu.sigmalimited.sigmawebshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;

@SpringBootApplication
public class SigmawebshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SigmawebshopApplication.class, args);
		new Jedis("localhost", 6379).flushAll();
	}

}
