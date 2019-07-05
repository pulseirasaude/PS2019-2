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
public class VerificaCargaQuantidade extends VerificaCargaTemplate{
    
    ArrayList<Servico> servicoL;
    protected boolean verificaCarga(Servico servico, double quantidade) {
        int quantidadeServ = servico.getQuantidade();
        //int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a carga constatado na chegada\n"));
        if (quantidade == quantidadeServ){
            JOptionPane.showMessageDialog(null,"Quantidade iguais, carga confirmada.\n");
            resultado++;
            return true;
        } else {
            JOptionPane.showMessageDialog(null,"Quantidades diferentes, carga rejeitada.\nRelatar Central.");
        }
        return false;
    }
    
}
