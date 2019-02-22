/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import view.Opcoes;

/**
 *
 * @author adaao
 */
public class Locadora {
    protected Dao dao;
    Cliente x = new Cliente("Adaao", "35805089890", "991506833", "constituicao", 151, "Santos", "SP");
    Cliente z = new Cliente("Juliana", "11122089890", "881506833", "conselheiro", 71, "Santos", "SP");
    Filme f = new Filme("Terminando a FATEC", "Drama");
    Filme g = new Filme("TCC", "Ação");
    
    
    public Locadora(){
        dao = new Dao();
        dao.clientes.add(x);
        dao.clientes.add(z);
        dao.filmes.add(f);
        dao.filmes.add(g);
    }
    
    public void start(){
        Opcoes opc = new Opcoes(dao);
    }
}
