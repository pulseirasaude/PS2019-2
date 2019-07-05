/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios;

import conexao.ConexaoBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author walla
 */
public class RelatorioCliente implements Relatorio {
        
    @Override
    public ArrayList relatorioTotalizandoValor() throws SQLException{
        Connection c;
        Statement stmt;
        c = ConexaoBD.getInstance();
        stmt = c.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("select  cli.id, cli.nome, sum(valor_contrato) as valor\n" +
        "from servico as sr inner join cliente as cli on(sr.id_cliente = cli.id) group by cli.id, cli.nome;");
        while (rs.next()) {
            Resultado resultado = new Resultado();
            resultado.setCodigo(rs.getInt("ID"));
            resultado.setNome(rs.getString("NOME"));
            resultado.setValor(rs.getFloat("VALOR"));
            lista_resultado.add(resultado);
        }
        rs.close();
        stmt.close();
        c.close();
        return lista_resultado;
    }

    @Override
    public ArrayList relatorioDeCadaServico() throws SQLException {
        Connection c;
        Statement stmt;
        c = ConexaoBD.getInstance();
        stmt = c.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("select  cli.id, cli.nome, valor_contrato as valor\n" +
        "from servico as sr inner join cliente as cli on(sr.id_cliente = cli.id);");
        while (rs.next()) {
            Resultado resultado = new Resultado();
            resultado.setCodigo(rs.getInt("ID"));
            resultado.setNome(rs.getString("NOME"));
            resultado.setValor(rs.getFloat("VALOR"));
            lista_resultado.add(resultado);
        }
        rs.close();
        stmt.close();
        c.close();
        return lista_resultado;
    }
   
}
