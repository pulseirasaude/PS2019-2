/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 20181bsi0172
 */
public class Financiamento 
{
    private int idFinanciamento;
    private float valorParcela;
    private int parcelasTotais;
    private int parcelasPagas;
    private String bancoFinanciador;

    public String getBancoFinanciador() {
        return this.bancoFinanciador;
    }

    public int getIdFinanciamento() {
        return this.idFinanciamento;
    }

    public int getParcelasPagas() {
        return this.parcelasPagas;
    }

    public int getParcelasTotais() {
        return this.parcelasTotais;
    }

    public float getValorParcela() {
        return this.valorParcela;
    }

    public void setBancoFinanciador(String bancoFinanciador) {
        this.bancoFinanciador = bancoFinanciador;
    }

    public void setIdFinanciamento(int idFinanciamento) {
        this.idFinanciamento = idFinanciamento;
    }

    public void setParcelasPagas(int parcelasPagas) {
        this.parcelasPagas = parcelasPagas;
    }

    public void setParcelasTotais(int parcelasTotais) {
        this.parcelasTotais = parcelasTotais;
    }

    public void setValorParcela(float valorParcela) {
        this.valorParcela = valorParcela;
    }
 
    
    
}
