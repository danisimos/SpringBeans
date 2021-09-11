package ru.itis.service.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.itis.service.EmailValidator;

import javax.sql.DataSource;

public class EmailValidatorDataBaseImpl implements EmailValidator {
    //language=SQL
    private static final String SQL_SELECT_BY_EMAIL = "SELECT email FROM emails WHERE email = ?";

    private final JdbcTemplate jdbcTemplate;

    public EmailValidatorDataBaseImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean contains(String email) {
        try {
            String ans = jdbcTemplate.queryForObject(SQL_SELECT_BY_EMAIL, String.class, email);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}
