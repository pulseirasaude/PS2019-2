/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.*;

/**
 *
 * @author 20171BSI0367
 */
public class CriacaoBanco 
{
    public synchronized void  createTable()
    {
        Connection c = null;
        Statement stmt = null;
        try {
            
            c = ConexaoBD.getInstance();
            stmt = c.createStatement();
            String sql = "DROP TABLE IF EXISTS ENDERECO_CLIENTE;\n" +
                            "\n" +
                            "DROP TABLE IF EXISTS CONTATO_CLIENTE;\n" +
                            "\n" +
                            "DROP TABLE IF EXISTS ENDERECO_FUNCIONARIO;\n" +
                            "\n" +
                            "DROP TABLE IF EXISTS CONTATO_FUNCIONARIO;\n" +
                            "\n" +
                            "DROP TABLE IF EXISTS FINANCIAMENTO CASCADE;\n" +
                            "\n" +
                            "DROP TABLE IF EXISTS SERVICO CASCADE;\n" +
                            "\n" +
                            "DROP TABLE IF EXISTS ENDERECO_SERVICO;\n" +
                            "\n" +
                            "DROP TABLE IF EXISTS SEGURO CASCADE;\n" +
                            "\n" +
                            "DROP TABLE IF EXISTS VEICULO ;\n" +
                            "\n" +
                            "DROP TABLE IF EXISTS MOTORISTA;\n" +
                            "\n" +
                            "DROP TABLE IF EXISTS CLIENTE;\n" +
                            "\n" +
                            "DROP TABLE IF EXISTS FUNCIONARIO;\n" +
                            "\n" +
                            "DROP TABLE IF EXISTS CONTATO;\n" +
                            "\n" +
                            "DROP TABLE IF EXISTS ENDERECO;\n" +
                            "\n" +
                            "DROP TABLE IF EXISTS MODELO;\n" +
                            "\n" +
                            "DROP TABLE IF EXISTS CATEGORIA;\n" +
                            "\n" +
                            "CREATE TABLE CLIENTE (\n" +
                            "  ID SERIAL,\n" +
                            "  NOME VARCHAR(45),\n" +
                            "  TIPO_CLIENTE CHAR(1),\n" +
                            "  CNPJ VARCHAR(18),\n" +
                            "  CPF VARCHAR(14),\n" +
                            "  DATA_CADASTRO DATE,\n" +
                            "  PRIMARY KEY (ID)\n" +
                            ");\n" +
                            "\n" +
                            "CREATE TABLE FUNCIONARIO (\n" +
                            "  ID SERIAL,\n" +
                            "  NOME VARCHAR(45),\n" +
                            "  CPF VARCHAR(14),\n" +
                            "  CARGO VARCHAR(30),\n" +
                            "  SALARIO FLOAT,\n" +
                            "  SEXO CHAR(1),\n" +
                            "  DATA_CADASTRO DATE,\n" +
                            "  DATA_NASCIMENTO DATE,\n" +
                            "  PRIMARY KEY (ID)\n" +
                            ");\n" +
                            "\n" +
                            "\n" +
                            "CREATE TABLE MOTORISTA (\n" +
                            "  ID SERIAL,\n" +
                            "  CNH VARCHAR(11),\n" +
                            "  DATA_VENCIMENTO DATE,\n" +
                            "  CATEGORIA_CNH VARCHAR(2),\n" +
                            "  ID_FUNCIONARIO INT NOT NULL,\n" +
                            "  PRIMARY KEY (ID),\n" +
                            "  FOREIGN KEY (ID_FUNCIONARIO)\n" +
                            "  REFERENCES FUNCIONARIO (ID)\n" +
                            ");\n" +
                            "\n" +
                            "\n" +
                            "CREATE TABLE CONTATO (\n" +
                            "  ID SERIAL,\n" +
                            "  TELEFONE_01 VARCHAR(12),\n" +
                            "  TELEFONE_02 VARCHAR(12),\n" +
                            "  TELEFONE_03 VARCHAR(12),\n" +
                            "  EMAIL VARCHAR(45),\n" +
                            "  PRIMARY KEY (ID)\n" +
                            ");\n" +
                            "\n" +
                            "CREATE TABLE ENDERECO (\n" +
                            "  ID SERIAL,\n" +
                            "  ENDERECO VARCHAR(45),\n" +
                            "  LOGRADOURO VARCHAR(20),\n" +
                            "  NUMERO INT,\n" +
                            "  CEP VARCHAR(9),\n" +
                            "  COMPLEMENTO VARCHAR(20),\n" +
                            "  CIDADE VARCHAR(35),\n" +
                            "  ESTADO VARCHAR(20),\n" +
                            "  BAIRRO VARCHAR(20),\n" +
                            "  PONTOREFERENCIA VARCHAR(20),\n" +
                            "  PRIMARY KEY (ID)\n" +
                            ");\n" +
                            "\n" +
                            "CREATE TABLE CATEGORIA (\n" +
                            "  ID SERIAL,\n" +
                            "  NOME VARCHAR(45),\n" +
                            "  PRIMARY KEY (ID)\n" +
                            ");\n" +
                            "\n" +
                            "\n" +
                            "CREATE TABLE MODELO (\n" +
                            "  ID SERIAL,\n" +
                            "  MODELO VARCHAR(45),\n" +
                            "  MARCA VARCHAR(20),\n" +
                            "  ANO VARCHAR(4),\n" +
                            "  EIXO INT,\n" +
                            "  PESO FLOAT,\n" +
                            "  ALTURA FLOAT,\n" +
                            "  LARGURA FLOAT,\n" +
                            "  COMPRIMENTO FLOAT,\n" +
                            "  COR VARCHAR(20),\n" +
                            "  PRIMARY KEY (ID)\n" +
                            ");\n" +
                            "\n" +
                             "CREATE TABLE SEGURO (\n" +
                            "  ID SERIAL,\n" +
                            "  STATUS VARCHAR(20),\n" +
                            "  DATA_VENCIMENTO DATE,\n" +
                            "  FIM_CONTRATO DATE,\n" +                           
                            "  VALOR FLOAT,\n" +
                            "  PRIMARY KEY (ID)\n" +
                            ");\n" +
                            "\n" +
                            "\n" +
                    
                            "CREATE TABLE FINANCIAMENTO (\n" +
                            "  ID SERIAL,\n" +
                            "  VALOR_PARCELA FLOAT,\n" +
                            "  PARCELAS_TOTAIS INT,\n" +
                            "  PARCELAS_PAGAS INT,\n" +
                            "  FINANCIADOR VARCHAR(45),\n" +
                            //"  ID_VEICULO INT NOT NULL,\n" +
                            "  PRIMARY KEY (ID)\n" +
                            //"  FOREIGN KEY (ID_VEICULO)\n" +
                            //"  REFERENCES VEICULO (ID)\n" +
                            ");\n" +
                            "\n" +
                            "\n" +
                    
                            "CREATE TABLE VEICULO (\n" +
                            "  ID SERIAL,\n" +
                            "  NOME VARCHAR(45),\n" +
                            "  CHASSI VARCHAR(45),\n" +
                            "  PLACA VARCHAR(7),\n" +
                            "  STATUS VARCHAR(20),\n" +
                            "  COMBUSTIVEL VARCHAR(15),\n" +
                            "  ID_CATEGORIA INT NOT NULL,\n" +
                            "  ID_FINANCIAMENTO INT NOT NULL,\n" +
                            "  ID_SEGURO INT NOT NULL,\n" +
                            "  ID_MODELO INT NOT NULL,\n" +
                            "  ID_MOTORISTA INT,\n" +
                            "  PRIMARY KEY (ID),\n" +
                            "  FOREIGN KEY (ID_CATEGORIA)\n" +
                            "  REFERENCES CATEGORIA (ID),\n" +
                            "  FOREIGN KEY (ID_SEGURO)\n" +
                            "  REFERENCES SEGURO(ID),\n" +
                            "  FOREIGN KEY (ID_FINANCIAMENTO)\n" +
                            "  REFERENCES FINANCIAMENTO(ID),\n" + 
                            "  FOREIGN KEY (ID_MODELO)\n" +
                            "  REFERENCES MODELO (ID),\n" +
                            "  FOREIGN KEY (ID_MOTORISTA)\n" +
                            "  REFERENCES MOTORISTA (ID)\n" +
                            ");\n" +
                            "\n" +
                           
                            "CREATE TABLE SERVICO (\n" +
                            "  ID SERIAL,\n" +
                            "  STATUS VARCHAR(15),\n" +
                            "  VALOR_CONTRATO FLOAT,\n" +
                            "  DATA_INICIO DATE,\n" +
                            "  DATA_FIM DATE,\n" +
                            "  TIPO VARCHAR(45),\n" +
                            "  PESO FLOAT,\n" +
                            "  VOLUME VARCHAR(45),\n" +
                            "  QUANTIDADE INT,\n" +
                            "  DISTANCIA VARCHAR(45),\n" +                    
                            "  ID_CLIENTE INT NOT NULL,\n" +
                            "  ID_FUNCIONARIO INT NOT NULL,\n" +
                            "  ID_VEICULO INT NOT NULL,\n" +                           
                            "  PRIMARY KEY (ID),\n" +                           
                            "  FOREIGN KEY (ID_CLIENTE)\n" +
                            "  REFERENCES CLIENTE (ID),\n" +
                            "  FOREIGN KEY (ID_FUNCIONARIO)\n" +
                            "  REFERENCES FUNCIONARIO (ID),\n" +
                            "  FOREIGN KEY (ID_VEICULO)\n" +
                            "  REFERENCES VEICULO (ID)\n" +
                            ");\n" +
                            "\n" +
                            "CREATE TABLE ENDERECO_SERVICO (\n" +
                            "  ID SERIAL,\n" +
                            "  TIPO CHAR,\n" +
                            "  ID_ENDERECO INT NOT NULL,\n" +
                             "  ID_SERVICO INT NOT NULL,\n" +
                            "  PRIMARY KEY (ID),\n" +
                            "  FOREIGN KEY (ID_SERVICO)\n" +
                            "  REFERENCES SERVICO (ID),\n" +
                            "  FOREIGN KEY (ID_ENDERECO)\n" +
                            "  REFERENCES ENDERECO (ID)\n" +
                            ");\n" +
                            "\n" +
                            "CREATE TABLE ENDERECO_CLIENTE (\n" +
                            "  ID SERIAL,\n" +
                            "  ID_CLIENTE INT NOT NULL,\n" +
                            "  ID_ENDERECO INT NOT NULL,\n" +
                            "  PRIMARY KEY (ID),\n" +
                            "  FOREIGN KEY (ID_CLIENTE)\n" +
                            "  REFERENCES CLIENTE (ID),\n" +
                            "  FOREIGN KEY (ID_ENDERECO)\n" +
                            "  REFERENCES ENDERECO (ID)\n" +
                            ");\n" +
                            "\n" +
                            "CREATE TABLE ENDERECO_FUNCIONARIO (\n" +
                            "  ID SERIAL,\n" +
                            "  ID_FUNCIONARIO INT NOT NULL,\n" +
                            "  ID_ENDERECO INT NOT NULL,\n" +
                            "  PRIMARY KEY (ID),\n" +
                            "  FOREIGN KEY (ID_FUNCIONARIO)\n" +
                            "  REFERENCES FUNCIONARIO (ID),\n" +
                            "  FOREIGN KEY (ID_ENDERECO)\n" +
                            "  REFERENCES ENDERECO (ID)\n" +
                            ");\n" +
                            "\n" +
                            "CREATE TABLE CONTATO_FUNCIONARIO (\n" +
                            "  ID SERIAL,\n" +
                            "  ID_CONTATO INT NOT NULL,\n" +
                            "  ID_FUNCIONARIO INT NOT NULL,\n" +
                            "  PRIMARY KEY (ID),\n" +
                            "  FOREIGN KEY (ID_CONTATO)\n" +
                            "  REFERENCES CONTATO (ID),\n" +
                            "  FOREIGN KEY (ID_FUNCIONARIO)\n" +
                            "  REFERENCES FUNCIONARIO (ID)\n" +
                            ");\n" +
                            "\n" +
                            "CREATE TABLE CONTATO_CLIENTE (\n" +
                            "  ID SERIAL,\n" +
                            "  ID_CONTATO INT NOT NULL,\n" +
                            "  ID_CLIENTE INT NOT NULL,\n" +
                            "  PRIMARY KEY (ID),\n" +
                            "  FOREIGN KEY (ID_CONTATO)\n" +
                            "  REFERENCES CONTATO (ID),\n" +
                            "  FOREIGN KEY (ID_CLIENTE)\n" +
                            "  REFERENCES CLIENTE (ID)\n" +
                            ");";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
            System.out.println("Table created successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
        
    }
    
}
