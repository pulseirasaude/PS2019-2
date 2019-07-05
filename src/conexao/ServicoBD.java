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
import modelo.Servico;
/**
 *
 * @author 20181bsi0172
 */
public class ServicoBD implements InterfaceBD{

    @Override
    public ArrayList select(String condicao) throws SQLException {
        ArrayList listServico = new ArrayList();
        Connection c;
        Statement stmt;
        c = ConexaoBD.getInstance();
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM SERVICO" + condicao);
        while (rs.next()) {

            //OS DOIS CAMPOS PREENCHIDOS NAO ACEITAM NULL, PROCURAR SOLUÇÃO

            Servico servico = new Servico();
            servico.setIdServico(rs.getInt("ID"));
            servico.setStatus(rs.getString("STATUS"));
            servico.setValorContrato(rs.getFloat("VALOR_CONTRATO"));
            servico.setDataInicio(rs.getString("DATA_INICIO"));
            servico.setDataFim(rs.getString("DATA_FIM"));
            servico.setDistancia(rs.getString("DISTANCIA"));
            servico.setQuantidade(rs.getInt("QUANTIDADE"));
            servico.setVolume(rs.getFloat("VOLUME"));
            servico.setTipo(rs.getString("TIPO"));
            servico.setPeso(rs.getFloat("PESO"));
            servico.setCliente(null);
            servico.setIdFuncionario(rs.getInt("ID_FUNCIONARIO"));
            servico.setVeiculo(null);
            //Classes que compõe um funcionario

            //funcionario.setContato(rs.getString("CONTATO"));
            //funcionario.setEndereco(rs.getString("MOTORISTA"));

            listServico.add(servico);
        }
        rs.close();
        stmt.close();
        c.close();

        return listServico;    
    }

    @Override
    public void insert(Object obj) throws SQLException {
        Connection c;
        c = ConexaoBD.getInstance();
        Statement stmt;
        Servico novo = (Servico)obj;
        ResultSet rs;
        stmt = c.createStatement();
        rs = stmt.executeQuery("INSERT INTO SERVICO(STATUS, VALOR_CONTRATO, DATA_INICIO, DATA_FIM, "
                + "TIPO, PESO, VOLUME, QUANTIDADE, DISTANCIA, ID_CLIENTE, ID_FUNCIONARIO, ID_VEICULO) values("
                +"'"+ novo.getStatus()+
                "',"+ novo.getValorContrato()+ 
                ",'"+ novo.getDataInicio()+ 
                "','"+ novo.getDataFim()+
                "','"+ novo.getTipo()+
                "',"+ novo.getPeso()+
                ","+ novo.getVolume()+
                ","+ novo.getQuantidade()+
                ",'"+ novo.getDistancia()+
                "',"+ novo.getCliente().getId()+
                ",1," + novo.getVeiculo().getId()+") RETURNING id");
        if(rs.next()){
            novo.setIdServico(rs.getInt(1));
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
        String sql = "DELETE from SERVICO where ID=" + id + ";";
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
        Servico novo = (Servico)obj;
        String sql = "UPDATE SERVICO "
                + "SET STATUS ="+ novo.getStatus() + ", "
                + "VALOR_CONTRATO="+ novo.getValorContrato() + ", "
                + "DATA_INICIO="+ novo.getDataInicio() + ", "
                + "DATA_FIM="+ novo.getDataFim() + ", "
                + "TIPO="+ novo.getTipo() + ", "
                + "PESO="+ novo.getPeso() + ", "
                + "VOLUME="+ novo.getVolume() + ", "
                + "QUANTIDADE="+ novo.getQuantidade() + ", "
                + "DISTANCIA="+ novo.getDistancia() + ", "
                + "ID_CLIENTE="+ novo.getCliente() + ", "
                + "ID_FUNCIONARIO="+ novo.getIdFuncionario() + ", "
                + "ID_VEICULO="+ novo.getVeiculo() + " "
                + "WHERE id ="+ novo.getIdServico() + ";";
        stmt.executeUpdate(sql);
        stmt.close();
        c.close();   
    }
    
}
