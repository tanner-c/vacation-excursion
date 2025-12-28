package com.tannercarter.ecommerce;

import com.tannercarter.ecommerce.dao.CountryRepository;
import com.tannercarter.ecommerce.dao.CustomerRepository;
import com.tannercarter.ecommerce.dao.DivisionRepository;
import com.tannercarter.ecommerce.entities.Customer;
import com.tannercarter.ecommerce.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@SpringBootApplication
@EnableJpaAuditing
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

    @Bean
    public CommandLineRunner loadData(CountryRepository countryRepository, DivisionRepository divisionRepository, CustomerRepository customerRepository) {
        return args -> {
            if (customerRepository.findByFirstNameAndLastName("Amos1", "Bluff1").isEmpty()) {
                Optional<Division> division = divisionRepository.findById(2L);

                for (int i = 1; i <= 5; i++) {
                    var customer = new Customer();
                    customer.setFirstName("Amos" + i);
                    customer.setLastName("Bluff" + i);
                    customer.setAddress("123 Main St Apt " + i);
                    customer.setPhone("555-1234-" + String.format("%04d", i));
                    customer.setDivision(division.orElse(null));
                    customer.setPostalCode("1234" + i);
                    customerRepository.save(customer);
                }
            }
        };
    }
}
