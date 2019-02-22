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

public class Filme {
    protected int cdFilme;
    protected String titulo;
    protected String genero;
    private static int indice=0;

    public Filme(String titulo, String genero) {
        this.titulo = titulo;
        this.genero = genero;
        indice++;
        cdFilme = indice;
    }

    public int getIdFilme() {
        return cdFilme;
    }

    public void setIdFilme(int cdFilme) {
        this.cdFilme = cdFilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
}
