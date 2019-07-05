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
import static relatorios.Relatorio.lista_resultado;

/**
 *
 * @author walla
 */
public class RelatorioMotorista implements Relatorio{

    @Override
    public ArrayList relatorioTotalizandoValor() throws SQLException{
        Connection c;
        Statement stmt;
        c = ConexaoBD.getInstance();
        stmt = c.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("select  mt.id, fun.nome, sum(valor_contrato) as valor_total\n" +
        "from servico as sr inner join motorista as mt on(sr.id_motorista = mt.id)\n" +
        "inner join funcionario as fun on(fun.id = mt.id)\n" +
        "group by mt.id, fun.nome;");
        while (rs.next()) {
            Resultado resultado = new Resultado();
            resultado.setCodigo(rs.getInt("ID"));
            resultado.setNome(rs.getString("NOME"));
            resultado.setValor(rs.getFloat("VALOR_TOTAL"));
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
        rs = stmt.executeQuery("select  mt.id, fun.nome, valor_contrato as valor\n" +
        "from servico as sr inner join motorista as mt on(sr.id_motorista = mt.id)\n" +
        "inner join funcionario as fun on(fun.id = mt.id);");
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
