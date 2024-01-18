package com.devsuperior.dsvendas.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.devsuperior.dsvendas.dto.PedidoDTO;

import java.util.List;

@Repository
public class PedidoRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PedidoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PedidoDTO> buscarPedidos() {
        String sql = "SELECT id_pedido, cliente, total FROM pedido";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PedidoDTO.class));
    }
}