/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import modelo.Categoria;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 20181bsi0172
 */
public class CategoriaBD implements InterfaceBD{

    @Override
    public ArrayList select(String condicao) throws SQLException{
        
        ArrayList listCategoria = new ArrayList();
        Connection c;
        Statement stmt;
        c = ConexaoBD.getInstance();
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM CATEGORIA;");
        while (rs.next()) {

            //OS DOIS CAMPOS PREENCHIDOS NAO ACEITAM NULL, PROCURAR SOLUÇÃO

            Categoria categoria = new Categoria();
            categoria.setIdCategoria(rs.getInt("ID"));
            categoria.setNome(rs.getString("NOME"));


            //Classes que compõe um funcionario

            //funcionario.setContato(rs.getString("CONTATO"));
            //funcionario.setEndereco(rs.getString("MOTORISTA"));

            listCategoria.add(categoria);
        }
        rs.close();
        stmt.close();
        c.close();

        return listCategoria;
    }

    @Override
    public void insert(Object obj) throws SQLException {
        Connection c;
        c = ConexaoBD.getInstance();
        Statement stmt;
        Categoria novo = (Categoria)obj;
        ResultSet rs;
        stmt = c.createStatement();
        rs = stmt.executeQuery("INSERT INTO CATEGORIA(NOME) values('"+ novo.getNome() +"')");
        rs.close();
        stmt.close();
        c.close();
    }

    @Override
    public void delet(int id) throws SQLException{
        Connection c;
        Statement stmt;
        c = ConexaoBD.getInstance();
        stmt = c.createStatement();
        String sql = "DELETE from CATEGORIA where ID=" + id + ";";
        
        stmt.executeUpdate(sql);
        stmt.close();
        c.close();
    }

    @Override
    public void update(Object obj) throws SQLException{
        Connection c;
        Statement stmt;
        c = ConexaoBD.getInstance();
        stmt = c.createStatement();
        Categoria novo = (Categoria)obj;
        String sql = "UPDATE CATEGORIA SET NOME ="+ novo.getNome() +" WHERE id ="+ novo.getIdCategoria() + ";";
        stmt.executeUpdate(sql);
        stmt.close();
        c.close();
    }
    
}
