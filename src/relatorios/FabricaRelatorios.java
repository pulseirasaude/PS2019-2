/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios;

/**
 *
 * @author walla
 */
public class FabricaRelatorios {
    Relatorio relatorios;
    
    public Relatorio geraRelatorio (String tipo){
        
    
        if (tipo == "motorista"){
            relatorios = new RelatorioMotorista();
        }
        else if (tipo == "cliente"){
            relatorios = new RelatorioCliente();
        }
        return relatorios;
    }
    
}
