/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import modelo.Seguro;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author 20181bsi0172
 */
public class SeguroBD implements InterfaceBD{

    @Override
    public ArrayList select(String condicao) throws SQLException{
                
        ArrayList listSeguro = new ArrayList();
        Connection c;
        Statement stmt;
        c = ConexaoBD.getInstance();
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM SEGURO;");
        while (rs.next()) {

            //OS DOIS CAMPOS PREENCHIDOS NAO ACEITAM NULL, PROCURAR SOLUÇÃO

            Seguro seguro = new Seguro();
            seguro.setIdSeguro(rs.getInt("ID"));
            seguro.setDataVencimento(rs.getNString("DATA_VENCIMENTO"));
            seguro.setFimContrato(rs.getNString("FIM_CONTRATO"));
            seguro.setStatus(rs.getNString("STATUS"));
            seguro.setValor(rs.getFloat("VALOR"));

            //Classes que compõe um funcionario

            //funcionario.setContato(rs.getString("CONTATO"));
            //funcionario.setEndereco(rs.getString("MOTORISTA"));

            listSeguro.add(seguro);
        }
        rs.close();
        stmt.close();
        c.close();

        return listSeguro;    
    }

    @Override
    public void insert(Object obj) throws SQLException {
        Connection c;
        c = ConexaoBD.getInstance();
        Statement stmt;
        Seguro novo = (Seguro)obj;
        ResultSet rs;
        stmt = c.createStatement();
        rs = stmt.executeQuery("INSERT INTO SEGURO(STATUS, DATA_VENCIMENTO, FIM_CONTRATO, VALOR) values('"+ novo.getStatus() + 
            "','"+ novo.getDataVencimento() +"','"+ novo.getFimContrato() +"'," +novo.getValor()+ ") RETURNING id");
        if(rs.next()){
            novo.setIdSeguro(rs.getInt(1));
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
        String sql = "DELETE from SEGURO where ID=" + id + ";";
        
        stmt.executeUpdate(sql);
        stmt.close();
        c.close();    }

    @Override
    public void update(Object obj) throws SQLException {
        Connection c;
        Statement stmt;
        c = ConexaoBD.getInstance();
        stmt = c.createStatement();
        Seguro novo = (Seguro)obj;
        String sql = "UPDATE SEGURO "
                + "SET STATUS ="+ novo.getStatus() + ", "
                + "DATA_VENCIMENTO="+ novo.getDataVencimento() + ", "
                + "FIM_CONTRATO="+ novo.getFimContrato() + ", "
                + "VALOR="+ novo.getValor() + " "
                + "WHERE id ="+ novo.getIdSeguro() + ";";
        stmt.executeUpdate(sql);
        stmt.close();
        c.close();      
    }
    
}
