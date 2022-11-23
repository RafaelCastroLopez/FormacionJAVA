package com.example.batch;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CafeRowMapper implements RowMapper<Cafe> {
    @Override
    public Cafe mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cafe cafe = new Cafe();
        cafe.setNombre(rs.getString("n"));
        cafe.setOrigen(rs.getString("o"));
        cafe.setCaracteristica(rs.getString("c"));
        System.out.println("hola rowMapper");
        return cafe;
    }
}
