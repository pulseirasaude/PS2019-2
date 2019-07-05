/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import modelo.Veiculo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Motorista;

/**
 *
 * @author 20181bsi0172
 */
public class VeiculoBD implements InterfaceBD{

    @Override
    public ArrayList select(String condicao) throws SQLException {
        List<Veiculo> listVeiculos = new ArrayList<Veiculo>();
        Connection c;
        Statement stmt;
       /* if (condicao.length() > 0){
            
            condicao = "where nome ilike '%" + condicao + "%'";
            
        }*/
        c = ConexaoBD.getInstance();
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM VEICULO " + condicao);
        while (rs.next()) {
            Veiculo veiculo = new Veiculo();
            veiculo.setId(rs.getInt("ID"));
            veiculo.setNome(rs.getString("NOME"));            
            veiculo.setPlaca(rs.getString("PLACA"));
            veiculo.setChassi(rs.getString("CHASSI"));
            veiculo.setStatus(rs.getString("STATUS"));
            veiculo.setTipoCombustivel(rs.getString("COMBUSTIVEL"));
            veiculo.setIdCategoria(rs.getInt("ID_CATEGORIA"));
            veiculo.setMotorista(new Motorista());
            veiculo.setIdModelo(rs.getInt("ID_MODELO"));
            veiculo.setIdSeguro(rs.getInt("ID_SEGURO"));
            veiculo.setIdFinanciamento(rs.getInt("ID_FINANCIAMENTO"));
            

            //Classes que compõe um motorista

            //veiculo.setModelo(rs.getString("MODELO"));
            //veiculo.setMotorista(rs.getString("MOTORISTA"));
            //veiculo.setSeguro(rs.getInt("SEGURO"));
            //veiculo.setFinanciamento(rs.getInt("FIANCIAMENTO"));
            listVeiculos.add(veiculo);
        }
        rs.close();
        stmt.close();
        c.close();

        return (ArrayList) listVeiculos;
    }

    @Override
    public void insert(Object obj) throws SQLException {
                Connection c;
        c = ConexaoBD.getInstance();
        Statement stmt;
        Veiculo novo = (Veiculo)obj;
        stmt = c.createStatement();
        System.out.println(novo.getIdCategoria());
        stmt.executeQuery("INSERT INTO VEICULO(NOME, CHASSI, PLACA, STATUS, "
                + "COMBUSTIVEL, ID_CATEGORIA, ID_FINANCIAMENTO, ID_SEGURO, ID_MODELO, ID_MOTORISTA) values("
                +"'"+ novo.getNome()+
                "','"+ novo.getChassi()+ 
                "','"+ novo.getPlaca()+ 
                "','"+ novo.getStatus()+ 
                "','"+ novo.getTipoCombustivel()+
                "',"+ novo.getIdCategoria()+
                ","+ novo.getIdFinanciamento()+
                ","+ novo.getIdSeguro()+
                ","+ novo.getIdModelo()+
                ","+ novo.getMotorista().getIdMotorista() +") RETURNING id");
        
        stmt.close();
        c.close();  
    }

    @Override
    public void delet(int id) throws SQLException {
        Connection c;
        Statement stmt;
        c = ConexaoBD.getInstance();
        stmt = c.createStatement();
        String sql = "DELETE from VEICULO where ID=" + id + ";";
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
        Veiculo novo = (Veiculo)obj;
        String sql = "UPDATE VEICULO "
                + "SET NOME ="+ novo.getNome() + ", "
                + "CHASSI="+ novo.getChassi() + ", "
                + "PLACA="+ novo.getPlaca() + ", "
                + "COMBUSTIVEL="+ novo.getTipoCombustivel() + ", "
                + "ID_CATEGORIA="+ novo.getIdCategoria() + ", "
                + "ID_MODELO="+ novo.getIdModelo() + ", "
                + "ID_MOTORISTA="+ novo.getMotorista().getIdMotorista() + " "
                + "WHERE id ="+ novo.getIdModelo() + ";";
        stmt.executeUpdate(sql);
        stmt.close();
        c.close();    
    }
    
}
