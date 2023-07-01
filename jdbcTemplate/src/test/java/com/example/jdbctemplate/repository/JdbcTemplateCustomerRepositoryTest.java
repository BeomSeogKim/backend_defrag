package com.example.jdbctemplate.repository;

import com.example.jdbctemplate.domain.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class JdbcTemplateCustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void save() {
        // given
        Customer customer = new Customer("Tommy", 20, "010-1234-5678");

        // when
        Customer savedCustomer = customerRepository.save(customer);

        // then
        Customer findCustomer = customerRepository.findById(savedCustomer.getId()).get();
        Assertions.assertThat(findCustomer).isEqualTo(savedCustomer);
    }

    @Test
    void updateCustomer() {
        // given
        Customer customer = new Customer("Tommy", 20, "010-1234-5678");
        Customer savedCustomer = customerRepository.save(customer);
        Long customerId = savedCustomer.getId();

        // when
        CustomerUpdateDto updateParam = new CustomerUpdateDto("new Tommy", 30, "010-9876-5432");
        customerRepository.update(customerId, updateParam);

        // then
        Customer findCustomer = customerRepository.findById(customerId).get();
        assertThat(findCustomer.getCustomerName()).isEqualTo("new Tommy");
        assertThat(findCustomer.getAge()).isEqualTo(30);
        assertThat(findCustomer.getPhoneNumber()).isEqualTo("010-9876-5432");
    }

    @Test
    void findAll() {

        // given
        Customer customer1 = new Customer("Tommy", 20, "010-1234-5678");
        Customer customer2 = new Customer("Tommy1", 21, "010-1234-5678");
        Customer customer3 = new Customer("Tommy2", 22, "010-1234-5678");

        // when
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        // then
        assertThat(customerRepository.findAll().size()).isEqualTo(3);
    }
}
