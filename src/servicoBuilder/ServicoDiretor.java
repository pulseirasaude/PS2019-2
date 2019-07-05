/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicoBuilder;

import java.sql.SQLException;
import modelo.Servico;

/**
 *
 * @author walla
 */
public class ServicoDiretor {
    public Servico ServicoDiretor(ServicoBuilder build) throws SQLException{
        build.alocaCliente();
        build.alocaEndDestino();
        build.alocaEndOrigem();
        build.alocaVeiculo();
        return build.cadastraServico();
    }
}
