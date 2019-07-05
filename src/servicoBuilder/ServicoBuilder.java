/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicoBuilder;

import conexao.AplicacoesBD;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.*;

/**
 *
 * @author walla
 */
public class ServicoBuilder {
    
    Servico servico;
    Cliente cliente;
    Endereco enderecoOrig;
    Endereco enderecoDest;
    Veiculo veiculo;
    
    public ServicoBuilder(Cliente cliente, Endereco enderecoOrig, Endereco enderecoDest, Veiculo veiculo, Servico servico){
        this.servico = servico;
        this.cliente = cliente;
        this.enderecoDest = enderecoDest;
        this.enderecoOrig = enderecoOrig;
        this.veiculo = veiculo;
    }
    
    public void alocaEndOrigem(){
        servico.setEnderecoOrigem(enderecoOrig);
    }
    
    public void alocaEndDestino(){
        servico.setEnderecoDestino(enderecoDest);
    }
    
    public void alocaCliente (){
        servico.setCliente(cliente);
    }
    
    public void alocaVeiculo(){
        servico.setVeiculo(veiculo);
    }
    
    public Servico cadastraServico() throws SQLException{
        AplicacoesBD aplic = new AplicacoesBD();
        aplic.cadastraServico(servico);
        return servico;
    }
    
}
