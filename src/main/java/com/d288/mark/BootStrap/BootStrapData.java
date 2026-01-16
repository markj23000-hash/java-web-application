package com.d288.mark.BootStrap;

import com.d288.mark.dao.CountryRepository;
import com.d288.mark.dao.CustomerRepository;
import com.d288.mark.dao.DivisionRepository;
import com.d288.mark.entities.Country;
import com.d288.mark.entities.Customer;
import com.d288.mark.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    CustomerRepository customerRepository;
    DivisionRepository divisionRepository;
    CountryRepository countryRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository, CountryRepository countryRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public void run(String... args) throws Exception { //todo save vacation?

        if (customerRepository.count() <= 1 ){

            Customer customer1 = new Customer();

            customer1.setFirstName("Billy");
            customer1.setLastName("Jones");
            customer1.setAddress("200UpStateRd");
            customer1.setPostal_code("12345");
            customer1.setPhone("1234567890");
            Division division1 = divisionRepository.findById(54L)
                    .orElseThrow(() -> new RuntimeException("Division not found"));

            // Set the Division object on the Customer
            customer1.setDivision(division1);

            customerRepository.save(customer1);

            Customer customer2 = new Customer();

            customer2.setFirstName("Laura");
            customer2.setLastName("Rosepetal");
            customer2.setAddress("34MainStreet");
            customer2.setPostal_code("67932");
            customer2.setPhone("1827364957");
            Division division2 = divisionRepository.findById(45L)
                    .orElseThrow(() -> new RuntimeException("Division not found"));

            // Set the Division object on the Customer
            customer2.setDivision(division2);


            customerRepository.save(customer2);

            Customer customer3 = new Customer();

            customer3.setFirstName("Joseph");
            customer3.setLastName("Uphill");
            customer3.setAddress("22ThoughLane");
            customer3.setPostal_code("92736");
            customer3.setPhone("1621065743");
            Division division3 = divisionRepository.findById(101L)
                    .orElseThrow(() -> new RuntimeException("Division not found"));

            // Set the Division object on the Customer
            customer3.setDivision(division3);

            customerRepository.save(customer3);


            Customer customer4 = new Customer();

            customer4.setFirstName("Lilly");
            customer4.setLastName("Hookthen");
            customer4.setAddress("12AwestruckLN");
            customer4.setPostal_code("14957");
            customer4.setPhone("2957392674");
            Division division4 = divisionRepository.findById(42L)
                    .orElseThrow(() -> new RuntimeException("Division not found"));

            // Set the Division object on the Customer
            customer4.setDivision(division4);

            customerRepository.save(customer4);


            Customer customer5 = new Customer();

            customer5.setFirstName("Edmond");
            customer5.setLastName("Picklebottom");
            customer5.setAddress("987Monarch");
            customer5.setPostal_code("48576");
            customer5.setPhone("1234567890");
            Division division5 = divisionRepository.findById(66L)
                    .orElseThrow(() -> new RuntimeException("Division not found"));

            // Set the Division object on the Customer
            customer5.setDivision(division5);

            customerRepository.save(customer5);

        }
    }
}