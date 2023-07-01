package com.example.jdbctemplate.repository;

import com.example.jdbctemplate.domain.Customer;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class JdbcTemplateCustomerRepository implements CustomerRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateCustomerRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Customer save(Customer customer) {
        String sql = "insert into customer(customer_name, age, phone_number) values (?, ?, ?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, customer.getCustomerName());
            ps.setInt(2, customer.getAge());
            ps.setString(3, customer.getPhoneNumber());
            return ps;
        }, keyHolder);
        long key = keyHolder.getKey().longValue();
        customer.setId(key);
        return customer;
    }

    @Override
    public void update(Long customerId, CustomerUpdateDto updateParam) {
        String sql = "update customer set customer_name = ?, age = ?, phone_number = ? where id = ?";
        jdbcTemplate.update(sql,
                updateParam.getCustomerName(),
                updateParam.getAge(),
                updateParam.getPhoneNumber(),
                customerId);
    }

    @Override
    public Optional<Customer> findById(Long customerId) {
        String sql = "select * from customer where id = ?";
        try {
            Customer customer = jdbcTemplate.queryForObject(sql, customerRowMapper(), customerId);
            return Optional.of(customer);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Customer> findAll() {
        String sql = "select * from customer";
        return jdbcTemplate.query(sql, customerRowMapper());
    }

    private RowMapper<Customer> customerRowMapper() {
        return (((rs, rowNum) -> {
            Customer customer = new Customer();
            customer.setId(rs.getLong("id"));
            customer.setCustomerName(rs.getString("customer_name"));
            customer.setAge(rs.getInt("age"));
            customer.setPhoneNumber(rs.getString("phone_number"));
            return customer;
        } ));
    }
}
