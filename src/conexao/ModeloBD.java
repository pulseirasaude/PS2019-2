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
import modelo.Modelo;
/**
 *
 * @author 20181bsi0172
 */
public class ModeloBD implements InterfaceBD{

    @Override
    public ArrayList select(String condicao) throws SQLException {
        ArrayList listModelo = new ArrayList();
        Connection c;
        Statement stmt;
        c = ConexaoBD.getInstance();
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM MODELO;");
        while (rs.next()) {

            //OS DOIS CAMPOS PREENCHIDOS NAO ACEITAM NULL, PROCURAR SOLUÇÃO
            Modelo modelo = new Modelo();
            modelo.setIdModelo(rs.getInt("ID"));
            modelo.setNome(rs.getString("MODELO"));
            modelo.setMarca(rs.getString("MARCA"));
            modelo.setAno(rs.getString("ANO"));
            modelo.setQuantEixos(rs.getInt("EIXO"));
            modelo.setPeso(rs.getFloat("PESO"));
            modelo.setAltura(rs.getFloat("ALTURA"));
            modelo.setLargura(rs.getFloat("LARGURA"));
            modelo.setComprimento(rs.getFloat("COMPRIMENTO"));
            modelo.setCor(rs.getString("COR"));



            listModelo.add(modelo);
        }
        
        rs.close();
        stmt.close();
        c.close();
        
        return listModelo;
    }

    @Override
    public void insert(Object obj) throws SQLException {
        Connection c;
        c = ConexaoBD.getInstance();
        Statement stmt;
        Modelo novo = (Modelo)obj;
        ResultSet rs;
        stmt = c.createStatement();
        rs = stmt.executeQuery("INSERT INTO MODELO(MODELO, MARCA, ANO, EIXO, PESO, ALTURA, LARGURA, COMPRIMENTO, COR) values('"
                + novo.getNome()+"','" + novo.getMarca()+ "','" + novo.getAno()+ 
                "',"+ novo.getQuantEixos() + 
                "," + novo.getPeso() +
                "," + novo.getAltura() +
                ","+ novo.getLargura() +
                ","+ novo.getComprimento() +
                ",'"+ novo.getCor() +"') RETURNING id");
         if(rs.next()){
            novo.setIdModelo(rs.getInt(1));
            
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
        String sql = "DELETE from MODELO where ID=" + id + ";";
        
        stmt.executeUpdate(sql);
        stmt.close();
        c.close();    }

    @Override
    public void update(Object obj) throws SQLException {
        Connection c;
        Statement stmt;
        c = ConexaoBD.getInstance();
        stmt = c.createStatement();
        Modelo novo = (Modelo)obj;
        String sql = "UPDATE MODELO "
                + "SET MODELO ="+ novo.getNome() + ", "
                + "MARCA="+ novo.getMarca() + ", "
                + "ANO="+ novo.getAno() + ", "
                + "EIXO="+ novo.getQuantEixos() + ", "
                + "PESO="+ novo.getPeso() + ", "
                + "ALTURA="+ novo.getAltura() + ", "
                + "LARGURA="+ novo.getLargura() + ", "
                + "COMPRIMENTO="+ novo.getComprimento() + ", "
                + "COR="+ novo.getCor() + " "
                + "WHERE id ="+ novo.getIdModelo() + ";";
        stmt.executeUpdate(sql);
        stmt.close();
        c.close();    
    }
    
}
