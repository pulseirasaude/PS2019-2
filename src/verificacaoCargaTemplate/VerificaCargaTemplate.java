/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificacaoCargaTemplate;

import conexao.AplicacoesBD;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Funcionario;
import modelo.Servico;




public abstract class VerificaCargaTemplate {
    
    AplicacoesBD aplicacao = new AplicacoesBD();
    ArrayList<Servico> servicoL;
    ArrayList<Funcionario> funcionarioL;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    int resultado;

    public int getResultado() {
        return resultado;
    }
    public final void VerificaTemplate(Servico servico, double carga,String dataServ, String nomeMoto) throws ParseException{
        String data = servico.getDataFim();
        Date dataFim = formato.parse(data);
        Date dataForm = formato.parse(dataServ);
        this.verificaDataChegada(dataFim,dataForm);
        
        String funcionarioID = Integer.toString(servico.getIdFuncionario());
        funcionarioL = aplicacao.ProcuraFuncionarioID(funcionarioID);
        Funcionario funcionario = funcionarioL.get(0);
        String nome =  funcionario.getNome();
        this.verificaMotorista(nome,nomeMoto);
        //this.verificaEnderecoEntrega();
        this.verificaCarga(servico,carga);
    }
    
    protected void verificaDataChegada(Date dataFim, Date data) throws ParseException {
        //String data = JOptionPane.showInputDialog("Insira a data atual.\n");
        //Date dataFormatada = formato.parse(data);
        if (data.after(dataFim)){
            JOptionPane.showMessageDialog(null,"Entrega em atraso");
            resultado++;
        }else{
            JOptionPane.showMessageDialog(null,"Entrega dentro do prazo");
        }     
    }

    protected void verificaMotorista(String nome, String nomeMoto) {
        //String nomeMoto = JOptionPane.showInputDialog("Insira o nome do motorista.\n");
        if(nomeMoto.equalsIgnoreCase(nome)){
            JOptionPane.showMessageDialog(null,"Motorista verificado.");
            resultado++;
        }else{
            JOptionPane.showMessageDialog(null,"Motorista diferentes, verificar com central");
        }
    }

    //protected void verificaEnderecoEntrega() {}

    protected abstract boolean verificaCarga(Servico servico, double carga);
    
}
