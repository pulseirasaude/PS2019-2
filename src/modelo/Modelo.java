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
public class Modelo 
{
    private int idModelo;
    private String marca;
    private String ano;
    private String nome;
    private String cor;
    private int quantEixos;
    private float peso;
    private float altura;
    private float largura;
    private float comprimento;
    private float volume;

    public float getAltura() {
        return this.altura;
    }

    public String getAno() {
        return this.ano;
    }

    public float getComprimento() {
        return this.comprimento;
    }

    public String getCor() {
        return this.cor;
    }

    public int getIdModelo() {
        return this.idModelo;
    }

    public float getLargura() {
        return this.largura;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getNome() {
        return this.nome;
    }

    public float getPeso() {
        return this.peso;
    }

    public int getQuantEixos() {
        return this.quantEixos;
    }

    public float getVolume() {
        return this.volume;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setQuantEixos(int quantEixos) {
        this.quantEixos = quantEixos;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    
}
