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
import modelo.Contato;
import modelo.Endereco;

/**
 *
 * @author walla
 */
public class ContatoCliente {
    public Contato select(int idCli) throws SQLException{
        Connection c;
        Contato contato = new Contato();
        Statement stmt;
        c = ConexaoBD.getInstance();
        stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM CONTATO "
                + "INNER JOIN CONTATO_CLIENTE AS EC ON(CONTATO.ID = EC.ID_CONTATO) "
                + "INNER JOIN CLIENTE AS CLI ON("+idCli+" = EC.ID_CLIENTE)");
        if (rs.next()) {

            //OS DOIS CAMPOS PREENCHIDOS NAO ACEITAM NULL, PROCURAR SOLUÇÃO
                       
            contato.setId_contato(rs.getInt("ID"));
            contato.setTelefone1(rs.getString("TELEFONE_01"));
            contato.setTelefone2(rs.getString("TELEFONE_02"));
            contato.setTelefone3(rs.getString("TELEFONE_03"));
            contato.setEmail(rs.getString("EMAIL"));
        }
        
        rs.close();
        stmt.close();
        c.close();
        return contato;
    }
    
}
