package com.example.jdbctemplate.repository;

import com.example.jdbctemplate.domain.Customer;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.transaction.reactive.GenericReactiveTransaction;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class NamedParameterJdbcTemplateCustomerRepository implements CustomerRepository{

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public NamedParameterJdbcTemplateCustomerRepository(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public Customer save(Customer customer) {
        String sql = "insert into customer(customer_name, age, phone_number) values (:customerName, :age, :phoneNumber)";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(customer);
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, param, keyHolder);

        long key = keyHolder.getKey().longValue();
        customer.setId(key);
        return customer;
    }

    @Override
    public void update(Long customerId, CustomerUpdateDto updateParam) {
        String sql = "update customer set customer_name = :customerName, age = :age, phone_number = :phoneNumber where id = :id";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("customerName", updateParam.getCustomerName())
                .addValue("age", updateParam.getAge())
                .addValue("phoneNumber", updateParam.getPhoneNumber())
                .addValue("id", customerId);

        jdbcTemplate.update(sql, param);
    }

    @Override
    public Optional<Customer> findById(Long customerId) {
        String sql = "select * from customer where id = :id";
        try {
            Customer customer = jdbcTemplate.queryForObject(sql, Map.of("id", customerId), customerRowMapper());
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

    return BeanPropertyRowMapper.newInstance(Customer.class);
//        return (((rs, rowNum) -> {
//            Customer customer = new Customer();
//            customer.setId(rs.getLong("id"));
//            customer.setCustomerName(rs.getString("customer_name"));
//            customer.setAge(rs.getInt("age"));
//            customer.setPhoneNumber(rs.getString("phone_number"));
//            return customer;
//        } ));
}
}
