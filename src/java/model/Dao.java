/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author adaao
 */
public class Dao {
    protected ArrayList<Cliente> clientes;
    protected ArrayList<Filme> filmes;
    protected ArrayList<Locacao> locacoes;
    
    public Dao(){
        clientes = new ArrayList();
        filmes = new ArrayList();
        locacoes = new ArrayList();
    }
    
    public void salvarCliente(Cliente c){
    	clientes.add(c);
    }
	
    public Cliente removeCliente(int i){
        Cliente c = null;
        for (Cliente x : clientes) {
            if (i == x.cdCliente) {
                c = x;
                clientes.remove(x);
            }
        }
        return c;
    }
    
    public Cliente findClient(int x){
        Cliente z = null;
        for(Cliente y : clientes){
            if(x == y.cdCliente){
                z = y;
            }
        }
        return z;
    }

    public void salvarFilme(Filme f){
        filmes.add(f);
    }
	
    public Filme removeFilme(int i){
        Filme x = null;
        for (Filme y : filmes) {
            if (i == y.cdFilme) {
                x = y;
                filmes.remove(y);
            }
        }
        return x;
    }
    
    public Filme findFilme(int x){
        Filme z = null;
        for(Filme y : filmes){
            if(x == y.cdFilme){
                z = y;
            }
        }
        return z;
    }
    
    public void registraLocacao(Locacao l){
        locacoes.add(l);
    }
    
    public Locacao removeLocacao(int i){
        Locacao x = null;
        for (Locacao l : locacoes) {
            if (i == l.getCdLocacao()) {
                x = l;
                locacoes.remove(l);
            }
        }
        return x;

    }
    
    /*
     public void listaLocacoes(){
        for(Locacao l : locacoes){
            String.format("%s %s\n", l.getF().getTitulo(), l.getC().getNome());
        }
    }
    */
    
    public ArrayList getLocacoes(){
        return locacoes;
    }
}
