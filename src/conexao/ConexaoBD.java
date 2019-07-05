/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 20171BSI0367
 */
public class ConexaoBD {
    private static Connection instance = null;        
    
    public static synchronized Connection getInstance() {
            try {
                Connection c;
                
                  
                /* String USUARIO = "nqygzcvg";;
                 String SENHA = "Mr6i5_qmB1mEiJRKTbiQPDB1qXaHGqZ1";
                 //String URL = "jdbc:postgresql://localhost:5432/CARGAPESADA_4";
                 String URL = "jdbc:postgresql://stampy.db.elephantsql.com:5432/nqygzcvg";
                */
                 
                 String USUARIO = "postgres";
                 String SENHA = "root";
                 //String URL = "jdbc:postgresql://localhost:5432/CARGAPESADA_4";
                 String URL = "jdbc:postgresql://localhost:5432/CARGAPESADA";
                 //String USUARIO = "postgres";
                 //String SENHA = "bancodedados";
                 //String URL = "jdbc:postgresql://localhost:5432/CARGAPESADA_4";
                 //String URL = "jdbc:postgresql://localhost:5432/CARGAPESADA";
                 
                 
             
                c =  DriverManager.getConnection(URL, USUARIO, SENHA);
                c.setAutoCommit(true);
                instance = c;
                System.out.println("Banco Conectado!");
            } catch (SQLException e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        
        return instance;
    }
    
}
