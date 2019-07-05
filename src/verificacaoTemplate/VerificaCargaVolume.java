/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificacaoTemplate;

import conexao.AplicacoesBD;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author leona
 */
public class VerificaCargaVolume extends VerificaTemplate{

    @Override
    protected void verificaCarga() {
        AplicacoesBD aplicacao = new AplicacoesBD();
        ArrayList servico;
        servico = aplicacao.ProcuraServico("1");
        int volumeServ = (int) servico.get(8);
        int volume = Integer.parseInt(JOptionPane.showInputDialog("Digite o volume constatado na chegada\n"));
        if (volume == volumeServ){
            System.out.println("Volume iguais, carga confirmada.\n");
            System.out.println("Proseguir com serviço.");
        } else {
            System.out.println("Volume diferentes, carga rejeitada.\n");
            System.out.println("Relatar Central.");
        }
    }
    
}
