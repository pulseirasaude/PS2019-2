    package modelo;

import conexao.*;
import view.CadastroSeguro;
import java.sql.SQLException;
import java.util.ArrayList;
import view.Home1;
import view.TABELA;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author 20181bsi0172
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        // Cria funcionario
        //CriacaoBanco b1 = new CriacaoBanco();
        //b1.createTable();
       //CategoriaBDtest b2 = new CategoriaBDtest();
       
        //TABELA tabela = new TABELA();
        Home1 seg = new Home1();
        seg.setVisible(true);
        /*
        VeiculoBD veiculoBD = new VeiculoBD();
        ArrayList enderecos = veiculoBD.select("");
        System.out.print(enderecos);
        tabela.dadostabelV(enderecos);
        tabela.setVisible(true);
        //System.out.print("TESTE TESTE");
        /*
        Endereco endereco_funcionario= new Endereco("Av. Dos sem teto","Terra do nunca",666,62456375);
        Contato contato_funcionario = new Contato(998887691,995852463,"larikamanhosa@gmail.com");
        Funcionario funcionario = new Funcionario("Josevaldo araujo nanico",12345678996L,1500.45F,"Motorista",endereco_funcionario,contato_funcionario);
        
        // Cria cliente
        
        Endereco endereco_cliente= new Endereco("Av. Dos que tem casa","Terra do sempre",777,62456375);
        Contato contato_cliente = new Contato(896325645,99521648,"abusadamente@gmail.com");
        Cliente cliente = new Cliente("Marmoaria Alves silva",12345678912345L,12345678996L,endereco_cliente,contato_cliente);
        
        // Cria veiculo 
        
        Seguro seguro_veiculo1 = new Seguro("Ativo","20/04/2020","21/04/2050");
        Modelo modelo_veiculo1  = new Modelo("fiat",1998,"Amarok",4,5000.0F,4.0F,2.5F,4.0F,5.0F);
        Financiamento financiamento_veiculo1  = new Financiamento(800.0F,20,4,"Dacasa financeira");
        Motorista motorista_veiculo1  = new Motorista("jose da silva pinto",12345678996L,78945612345L,4000.0F);
        Veiculo veiculo = new Veiculo("9BW ZZZ377 VT 004251","BMW-1569","Ativo","Flex","B",seguro_veiculo1,modelo_veiculo1,motorista_veiculo1,financiamento_veiculo1);
        
        // Cria Servico
        
        Servico servico_1 = new Servico("Progresso","Av. Dos expedicionarios","Av. Dos sem teto",54.0F,"20/05/1999","05/06/2020",cliente,funcionario,veiculo);
        */
        
}
    
}
