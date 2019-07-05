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
import javax.swing.JOptionPane;
import modelo.Contato;

/**
 *
 * @author 20181bsi0172
 */
public class ContatoBD implements InterfaceBD{

    @Override
    public ArrayList select(String condicao) throws SQLException {
        ArrayList listContato = new ArrayList();
        Connection c;
        Statement stmt;
        c = ConexaoBD.getInstance();
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM CONTATO;");
        while (rs.next()) {

            //OS DOIS CAMPOS PREENCHIDOS NAO ACEITAM NULL, PROCURAR SOLUÇÃO
            Contato contato = new Contato();
            contato.setId_contato(rs.getInt("ID"));
            contato.setTelefone1(rs.getString("TELEFONE_01"));
            contato.setTelefone2(rs.getString("TELEFONE_02"));
            contato.setTelefone3(rs.getString("TELEFONE_03"));
            contato.setEmail(rs.getString("EMAIL"));


            listContato.add(contato);
        }
        
        rs.close();
        stmt.close();
        c.close();
        
        return listContato;
    }

    @Override
    public void insert(Object obj) throws SQLException {
        Connection c;
        c = ConexaoBD.getInstance();
        Statement stmt;
        Contato novo = (Contato)obj;
        ResultSet rs;
        stmt = c.createStatement();
        rs = stmt.executeQuery("INSERT INTO CONTATO(TELEFONE_01, TELEFONE_02, TELEFONE_03, EMAIL) values('"
                + ""+ novo.getTelefone1() +"','" + novo.getTelefone2() + "','" + novo.getTelefone3()+ "','"
                + novo.getEmail() + "') RETURNING id");
        
        
         
        if(rs.next()){
            novo.setId_contato(rs.getInt(1));
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
        String sql = "DELETE from CONTATO where ID=" + id + ";";
        
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
        Contato novo = (Contato)obj;
        String sql = "UPDATE CONTATO "
                + "SET TELEFONE_01 ="+ novo.getTelefone1() + ", "
                + "TELEFONE_02="+ novo.getTelefone2()+ ", "
                + "TELEFONE_03="+ novo.getTelefone3()+ ", "
                + "EMAIL="+ novo.getEmail()+ " "
                + "WHERE id ="+ novo.getId_contato()+ ";";
        stmt.executeUpdate(sql);
        stmt.close();
        c.close();
    }
    
}
