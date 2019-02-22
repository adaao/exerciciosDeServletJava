/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author adaao
 */
public class Cliente {
    protected String nome;
    protected String cpf;
    protected String telefone;
    protected Endereco endereco;
    private static int indice=0;
    protected int cdCliente;
    protected boolean isAtivo;

    public Cliente(String nome, String cpf, String telefone, String logradouro, int numero, String cidade, String estado) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        endereco = new Endereco(logradouro, numero, cidade, estado);
        indice++;
        cdCliente=indice;
        isAtivo = true;
    }
    
    public int GetCdCliente(){
        return cdCliente;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
}
