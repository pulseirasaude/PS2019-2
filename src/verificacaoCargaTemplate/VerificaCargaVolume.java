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
public class VerificaCargaVolume extends VerificaCargaTemplate{
    
    ArrayList<Servico> servicoL;
    @Override
    protected boolean verificaCarga(Servico servico, double volume) {
        double volumeServ = servico.getVolume();
        //double volume = Integer.parseInt(JOptionPane.showInputDialog("Digite o volume constatado na chegada\n"));
        if (volume == volumeServ){
            JOptionPane.showMessageDialog(null,"Volume iguais, carga confirmada.\n");
            resultado++;
            return true;
        } else {
            JOptionPane.showMessageDialog(null,"Volume diferentes, carga rejeitada.\nRelatar Central");
        }
        return false;
    }
    
}
