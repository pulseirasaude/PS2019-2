/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author walla
 */
public interface Relatorio {
    ArrayList <Resultado> lista_resultado = new ArrayList<Resultado>();
    public ArrayList relatorioTotalizandoValor() throws SQLException;
    public ArrayList relatorioDeCadaServico() throws SQLException;
}
