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
public class Funcionario {

    private int idFuncionario;
    private String nome;
    private String cpf;
    private float salario;
    private String cargo;
    private String sexo;
    private String dataCadastro;
    private String dataNascimento;
    private int idEndereco;
    private int idContato;

    //private Endereco endereco;
    //private Contato contato;

    public String getCargo() {
        return this.cargo;
    }
    
    public void setDataCadastro() {
        Date dataHoraAtual = new Date();
        this.dataCadastro = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);    
    }
    
    public String getCpf() {
        return this.cpf;
    }

    public String getDataCadastro() {
        return this.dataCadastro;
    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public int getIdContato() {
        return this.idContato;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getIdEndereco() {
        return this.idEndereco;
    }

    public int getIdFuncionario() {
        return this.idFuncionario;
    }

    public String getNome() {
        return this.nome;
    }

    public float getSalario() {
        return this.salario;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setIdContato(int idContato) {
        this.idContato = idContato;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    
}
