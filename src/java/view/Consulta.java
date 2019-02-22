/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Dao;
import model.Locacao;

/**
 *
 * @author lab2
 */
public class Consulta {
    protected Dao dao;
    protected ArrayList<Locacao> l;
    private JFrame form;
    private JLabel loc;
    private JLabel locacoes;
    private int fromX;
    private JButton voltar;
    private Opcoes opc;
    
    public Consulta(Dao dao){
        this.dao = dao;
        iniciar();
    }
    
    private void iniciar(){
        form = new JFrame();
        form.setTitle("Consulta");
        form.setBounds(2, 2, 800, 600);
        form.setLayout(null);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container painel = form.getContentPane();
        
        locacoes = new JLabel("Lista de locacoes");
        locacoes.setBounds(5, 5, 100, 70);
        painel.add(locacoes);
        
        fromX = 50;
        l = dao.getLocacoes();
        for(Locacao x : l){
            loc = new JLabel(x.getF().getTitulo() + " - " + x.getC().getNome());
            loc.setBounds(5, fromX, 500, 30);
            painel.add(loc);
            fromX += 50;
        }
        
        voltar = FabricaDeBotoes.criaBotao("voltar", 5, 500, 100, 20);
        voltar.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               opc = new Opcoes(dao);
           }
        });
        painel.add(voltar);
        form.setVisible(true);
    }
}
