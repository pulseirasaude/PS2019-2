package modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 20181bsi0172
 */
public class Veiculo {

    private int id;
    private String chassi;
    private String placa;
    private String status;
    private String tipoCombustivel;
    private int idCategoria = 1;
    private int idSeguro;
    private int idModelo;   //referente ao ID
    private Motorista motorista;
    private int idFinanciamento;
    private String nome;

    public String getChassi() {
        return this.chassi;
    }

    public int getIdCategoria() {
        return this.idCategoria;
    }

    public int getIdFinanciamento() {
        return this.idFinanciamento;
    }

    public int getIdModelo() {
        return this.idModelo;
    }

    public Motorista getMotorista() {
        return this.motorista;
    }

    public int getIdSeguro() {
        return this.idSeguro;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getPlaca() {
        return this.placa;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTipoCombustivel() {
        return this.tipoCombustivel;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setIdFinanciamento(int idFinanciamento) {
        this.idFinanciamento = idFinanciamento;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public void setMotorista(Motorista idMotorista) {
        this.motorista = idMotorista;
    }

    public void setIdSeguro(int idSeguro) {
        this.idSeguro = idSeguro;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public Object get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}