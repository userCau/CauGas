package com.bd.sitebd.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class ClienteDAO {
    /* DAO = Data Acssess Object */

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserir(Cliente cli){
        String sql = "INSERT INTO cliente(nome,cpf,celular,endereco) VALUES (?,?,?,?);";
        Object[] parametros = new Object[4];
        parametros[0] = cli.getNome();
        parametros[1] = cli.getCpf();
        parametros[2] = cli.getCelular();
        parametros[3] = cli.getEndereco();
        jdbc.update(sql,parametros);
    }

    //[ {id: 1, nome: teste1, cpf: 123456789-00}
    //, {id: 2, nome: teste2, cpf: 323456789-00}
    //]
    public List<Map<String,Object>> obterTodosClientes(){
        String sql = "Select * from cliente;";
        return jdbc.queryForList(sql);
    }

    public void atualizarCliente(int id, Cliente cli){
        String sql = "UPDATE cliente SET ";
        sql += "nome = ?, cpf = ?, celular = ?, endereco = ? WHERE id = ?";
        jdbc.update(sql, cli.getNome(), cli.getCpf(), cli.getCelular(), cli.getEndereco(), id);
    }

    public Cliente obterCliente(int id){
        String sql = "Select * from cliente where id = ?";
        return Tool.converterCliente(jdbc.queryForMap(sql,id));
    }

    public void deletarCliente(int id){
        String sql = "DELETE FROM cliente where id = ?";
        jdbc.update(sql,id);
    }


}
