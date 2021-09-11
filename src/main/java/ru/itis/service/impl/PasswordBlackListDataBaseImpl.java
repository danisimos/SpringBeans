package ru.itis.service.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.itis.service.PasswordBlackList;

import javax.sql.DataSource;

public class PasswordBlackListDataBaseImpl implements PasswordBlackList {
    //language=SQL
    private static final String SQL_SELECT_BY_PASSWORD = "SELECT password FROM passwords WHERE password = ?";

    private final JdbcTemplate jdbcTemplate;

    public PasswordBlackListDataBaseImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean contains(String password) {
        try {
            String ans = jdbcTemplate.queryForObject(SQL_SELECT_BY_PASSWORD, String.class, password);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}
