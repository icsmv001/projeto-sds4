package com.devsuperior.dsvendas.repositories;

import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.devsuperior.dsvendas.dto.PedidoDTO;
@Repository
public class PedidoPageRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PedidoPageRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Page<PedidoDTO> buscarPedidosPage(org.springframework.data.domain.Pageable pageable) {
        String sql = "SELECT id_pedido, cliente, total FROM pedido";
        return new PageImpl<>(jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PedidoDTO.class)), pageable, 10);
    }
}