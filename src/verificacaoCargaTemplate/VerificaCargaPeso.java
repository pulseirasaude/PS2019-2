/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificacaoCargaTemplate;

import conexao.AplicacoesBD;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Servico;

/**
 *
 * @author leona
 */
public class VerificaCargaPeso extends VerificaCargaTemplate{
    
    ArrayList<Servico> servicoL;
    @Override
    protected boolean verificaCarga(Servico servico, double peso) {
        
        double pesoServ = servico.getQuantidade();
        //double peso = Integer.parseInt(JOptionPane.showInputDialog("Digite o peso constatado na chegada\n"));
        if (peso == pesoServ){
            JOptionPane.showMessageDialog(null,"Peso iguais, carga confirmada.\n");
            resultado++;
            return true;
        } else {
            JOptionPane.showMessageDialog(null,"Peso diferentes, carga rejeitada.\nRelatar Central.");
        }
        return false;
        
    }    
}
