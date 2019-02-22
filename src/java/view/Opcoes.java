/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import model.Dao;

/**
 *
 * @author lab3
 */
public class Opcoes {
   private JFrame form;
   private JButton novaLocacao;
   private JButton consultar;
   private ActionListener alugar;
   protected Dao dao;
   
   public Opcoes(Dao dao){
       this.dao = dao;
       iniciarFormulario();
   }
   public void iniciarFormulario(){
       form = new JFrame();
       form.setTitle("Locadora Netflix");
       form.setBounds(350, 150, 400, 300);
       form.setLayout(null);
       form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       Container painel = form.getContentPane();
       
       /*
       alugar = new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
                Consulta consultaLocacoes = new Consulta();
            }
       };
       */
       
       
       novaLocacao = FabricaDeBotoes.criaBotao("Nova Locação", 50, 50, 250, 30);
       novaLocacao.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               RegistraLocacao reLoc = new RegistraLocacao(dao);
           }
       });
       form.add(novaLocacao);
       
       consultar = FabricaDeBotoes.criaBotao("Ver locacoes", 50, 100, 250, 30);
       consultar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Consulta consultaLocacoes = new Consulta(dao);
            }
       });
       form.add(consultar);
       
       
       form.setVisible(true);
       
       
       
   }
}
