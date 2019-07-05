/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Financiamento;
/**
 *
 * @author 20181bsi0172
 */
public class FinanciamentoBD implements InterfaceBD{

    @Override
    public ArrayList select(String condicao) throws SQLException {
                ArrayList listFinanciamento = new ArrayList();
        Connection c;
        Statement stmt;
        c = ConexaoBD.getInstance();
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM FINANCIAMENTO;");
        while (rs.next()) {

            //OS DOIS CAMPOS PREENCHIDOS NAO ACEITAM NULL, PROCURAR SOLUÇÃO
            Financiamento financiamento = new Financiamento();
            financiamento.setIdFinanciamento(rs.getInt("ID"));
            financiamento.setValorParcela(rs.getFloat("VALOR_PARCELA"));
            financiamento.setParcelasTotais(rs.getInt("PARCELAS_TOTAIS"));
            financiamento.setParcelasPagas(rs.getInt("PARCELAS_PAGAS"));
            financiamento.setIdFinanciamento(rs.getInt("FINANCIADOR"));     
        



            listFinanciamento.add(financiamento);
        }
        
        rs.close();
        stmt.close();
        c.close();
        
        return listFinanciamento;
    }

    @Override
    public void insert(Object obj) throws SQLException {
        Connection c;
        c = ConexaoBD.getInstance();
        Statement stmt;
        Financiamento novo = (Financiamento)obj;
        ResultSet rs;
        stmt = c.createStatement();
        rs = stmt.executeQuery("INSERT INTO FINANCIAMENTO(VALOR_PARCELA, PARCELAS_TOTAIS, PARCELAS_PAGAS, FINANCIADOR) values("
                + novo.getValorParcela()+"," + novo.getParcelasTotais()+ "," + novo.getParcelasPagas()+ ",'"
                + novo.getBancoFinanciador()+ "') RETURNING id");
        
        if(rs.next()){
            novo.setIdFinanciamento(rs.getInt(1));
            
        }
        rs.close();
        stmt.close();
        c.close();
    }

    @Override
    public void delet(int id) throws SQLException {
        Connection c;
        Statement stmt;
        c = ConexaoBD.getInstance();
        stmt = c.createStatement();
        String sql = "DELETE from FINANCIAMENTO where ID=" + id + ";";
        
        stmt.executeUpdate(sql);
        stmt.close();
        c.close();
    }

    @Override
    public void update(Object obj) throws SQLException {
        Connection c;
        Statement stmt;
        c = ConexaoBD.getInstance();
        stmt = c.createStatement();
        Financiamento novo = (Financiamento)obj;
        String sql = "UPDATE FINANCIAMENTO "
                + "SET VALOR_PARCELA ="+ novo.getValorParcela() + ", "
                + "PARCELAS_TOTAIS="+ novo.getParcelasTotais() + ", "
                + "FINANCIADOR="+ novo.getBancoFinanciador() + " "             
                + "WHERE id ="+ novo.getIdFinanciamento() + ";";
        stmt.executeUpdate(sql);
        stmt.close();
        c.close();
    }
    
}
