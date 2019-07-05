/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JComboBox;

/**
 *
 * @author 20181bsi0172
 */
public class Seguro {
    
    private int idSeguro; //test
    private String status;
    private String dataVencimento;
    private String fimContrato;
    private float valor;
    //String status, String data_vencimento, String fim_contrato

    public String getDataVencimento() {
        return this.dataVencimento;
    }

    public String getFimContrato() {
        return this.fimContrato;
    }

    public int getIdSeguro() {
        return this.idSeguro;
    }

    public String getStatus() {
        return this.status;
    }

    public float getValor() {
        return this.valor;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public void setFimContrato(String fimContrato) {
        this.fimContrato = fimContrato;
    }

    public void setIdSeguro(int idSeguro) {
        this.idSeguro = idSeguro;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setValor(float valor) {
        this.valor = valor;
    } 
}
