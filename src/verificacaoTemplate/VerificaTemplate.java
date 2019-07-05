/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificacaoTemplate;

import conexao.AplicacoesBD;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Servico;




public abstract class VerificaTemplate {
    
    AplicacoesBD aplicacao = new AplicacoesBD();
    ArrayList servico;
    ArrayList funcionario;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    
    public final void VerificaTemplate() throws ParseException{
        servico = aplicacao.ProcuraServico("1");
        String data = (String) servico.get(5);
        Date dataFim = formato.parse(data);
        this.verificaDataChegada(dataFim);
        
        String funcionarioID = (String) servico.get(12);
        funcionario = aplicacao.ProcuraFuncionarioID(funcionarioID);
        String nome = (String) funcionario.get(2);
        this.verificaMotorista(nome);
        //this.verificaEnderecoEntrega();
        this.verificaCarga();
    }
    
    protected void verificaDataChegada(Date dataFim) throws ParseException {
        String data = JOptionPane.showInputDialog("Insira a data atual.\n");
        Date dataFormatada = formato.parse(data);
        if (dataFormatada.after(dataFim)){
            System.out.println("Entrega em atraso");
        }else{
            System.out.println("Entrega dentro do prazo");
        }     
    }

    protected void verificaMotorista(String nome) {
        String nomeMoto = JOptionPane.showInputDialog("Insira o nome do motorista.\n");
        if(nomeMoto.equalsIgnoreCase(nome)){
            System.out.println("Motorista verificado.");
        }else{
            System.out.println("Motorista diferentes, verificar com central");
        }
    }

    //protected void verificaEnderecoEntrega() {}

    protected abstract void verificaCarga();
    
}
