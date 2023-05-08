package hu.sigmalimited.sigmawebshop;

import hu.sigmalimited.sigmawebshop.domain.data.user.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
class PreloadDatabase {
    @Autowired
    private PasswordEncoder passwordEncoder;
    private static final Logger log = LoggerFactory.getLogger(PreloadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository){
        return args -> {

            User admin = new User();
            admin.setEmail("admin@hu.hu");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setFirstName("Sigma");
            admin.setLastName("Sigmason");
            admin.setRoles(List.of(UserRole.ADMIN));
            admin.setEnabled(true);
            log.info("Preloading " + userRepository.save(admin));

            User support = new User();
            support.setEmail("support@hu.hu");
            support.setPassword(passwordEncoder.encode("support"));
            support.setFirstName("Little");
            support.setLastName("Joe");
            support.setRoles(List.of(UserRole.SUPPORT));
            support.setEnabled(true);
            log.info("Preloading " + userRepository.save(support));

            User customer = new User();
            customer.setEmail("customer@hu.hu");
            customer.setPassword(passwordEncoder.encode("customer"));
            customer.setFirstName("Buyer");
            customer.setLastName("Mayer");
            customer.setRoles(List.of(UserRole.CUSTOMER));
            customer.setEnabled(true);
            log.info("Preloading " + userRepository.save(customer));
            log.info(customer.getRoles().toString());
        };
    }
}