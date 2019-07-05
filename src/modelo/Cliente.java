package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author 20181bsi0172
 */
public class Cliente{
        private int id;
        private String nome;
        private String cnpj;
        private String cpf;
        private int id_endereco;
        private String data_atual;
        private String tipo_cliente;
        private String email;
        private int idContato;
        private String status;

    public String retornaStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
        
        
    public String getCnpj(){
        return this.cnpj;
    }
    
    public void setId_endereco(int id){
        this.id_endereco = id;
    }


    public String getData_atual() {
        return this.data_atual;
    }

    public String getEmail() {
        return this.email;
    }

    public int getId() {
        return this.id;
    }
    
    public void setData_atual() {
        Date dataHoraAtual = new Date();
        this.data_atual = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);    
    }
    
    public int getIdContato() {
        return this.idContato;
    }

    public int getId_endereco() {
        return this.id_endereco;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo_cliente() {
        return this.tipo_cliente;

    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdContato(int idContato) {
        this.idContato = idContato;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipo_cliente = tipoCliente;
    }
 
        
}
