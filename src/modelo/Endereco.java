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
public class Endereco 
{

    private int id;
    private String nome;
    private String estado;
    private String cidade;
    private String bairro ;
    private String referencia;
    private String logradouro;
    private String complemento;
    private int numero;
    private String cep;
   
    
    public String getComplemento() {
        return complemento;
    }

    public String getCep() {
        return this.cep;
    }

    public String getCidade() {
        return this.cidade;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEstado() {
        return this.estado;
    }

    public String getBairro() {
        return bairro;
    }

    public int getId() {
        return this.id;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getReferencia() {
        return this.referencia;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    public void setReferencia(String referencia){
        this.referencia = referencia;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}

