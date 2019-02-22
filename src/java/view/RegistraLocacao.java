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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Cliente;
import model.Dao;
import model.Filme;
import model.Locacao;

/**
 *
 * @author adaao
 */
public class RegistraLocacao {
    private JFrame form;
    private JLabel idCliente;
    private JLabel nmCliente;
    private JLabel nomeEncontrado;
    private JLabel id_Filme;
    private JTextField recebeIdCliente;
    private JButton localizar;
    private JButton adicionar;
    private JButton voltar;
    private JButton concluir;
    private Cliente x;
    protected Dao dao;
    protected Filme f;
    protected JTextField recebeIdFilme;
    protected Locacao l;
    protected Opcoes opc;
    
    public RegistraLocacao(Dao dao){
        this.dao = dao;
        iniciaComponentes();
    }
    
    private void iniciaComponentes(){
        form = new JFrame();
        form.setTitle("Nova Locação");
        form.setBounds(2, 2, 800, 600);
        form.setLayout(null);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container painel = form.getContentPane();
        
        idCliente = new JLabel("ID do cliente: ");
        idCliente.setBounds(5, 5, 100, 30);
        painel.add(idCliente);
        
        recebeIdCliente = new JTextField();
        recebeIdCliente.setBounds(101, 10, 50, 20);
        painel.add(recebeIdCliente);
        
        localizar = FabricaDeBotoes.criaBotao("localizar", 160, 10, 100, 20);
        localizar.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               int id = 0;
               try {
                    id = Integer.parseInt(recebeIdCliente.getText());
                    x = dao.findClient(id);
                    if(x == null){
                        JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
                    }else{

                        String s = x.getNome();
                        nomeEncontrado = new JLabel(s);
                        nomeEncontrado.setBounds(80, 35, 70, 30);
                        painel.add(nomeEncontrado);
                        JOptionPane.showMessageDialog(null, "Cliente adicionado: " + x.getNome());
                        System.out.println("painel adicionado");
                        System.out.println("encontrado " + s);
                    }
                } catch (NumberFormatException x) {
                    JOptionPane.showMessageDialog(null, "Formato de número inválido");
                }
                
           }
        });
        painel.add(localizar);
        
        nmCliente = new JLabel("Nome: ");
        nmCliente.setBounds(5, 35, 70, 30);
        painel.add(nmCliente);
        
        id_Filme = new JLabel("Id do filme: ");
        id_Filme.setBounds(5, 70, 70, 30);
        painel.add(id_Filme);
        
        recebeIdFilme = new JTextField();
        recebeIdFilme.setBounds(101, 70, 50, 20);
        painel.add(recebeIdFilme);
        
        
        adicionar = FabricaDeBotoes.criaBotao("Adicionar", 160, 70, 100, 20);
        adicionar.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               int id = 0;
               try {
                    id = Integer.parseInt(recebeIdFilme.getText());
                    f = dao.findFilme(id);
                    if(f == null){
                        JOptionPane.showMessageDialog(null, "Flme não encontrado!");
                    }else{

                        String s = f.getTitulo();
                        nomeEncontrado = new JLabel(s);
                        nomeEncontrado.setBounds(80, 35, 70, 30);
                        painel.add(nomeEncontrado);
                        System.out.println("painel adicionado");
                        System.out.println("encontrado " + s);
                        JOptionPane.showMessageDialog(null, "Filme adicionado: " + f.getTitulo());
                        
                    }
                } catch (NumberFormatException x) {
                    JOptionPane.showMessageDialog(null, "Formato de número inválido");
                }
                
           }
        });
        painel.add(adicionar);
        
        /*
        //incompleto
        remover = FabricaDeBotoes.criaBotao("Adicionar", 266, 70, 100, 20);
        remover.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               int id = 0;
               try {
                    id = Integer.parseInt(recebeIdFilme.getText());
                    f = dao.findFilme(id);
                    if(f == null){
                        JOptionPane.showMessageDialog(null, "Flme não está na lista de locacoes!");
                    }else{

                        System.out.println("painel adicionado");
                        System.out.println("encontrado " + s);
                        l = new Locacao(x, f);
                        dao.removeLocacao(l.getCdLocacao());
                    }
                } catch (NumberFormatException x) {
                    JOptionPane.showMessageDialog(null, "Formato de número inválido");
                }
                
           }
        });
        painel.add(remover);
        
        */
        
        concluir = FabricaDeBotoes.criaBotao("Concluir", 5, 360, 100, 20);
        concluir.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               l = new Locacao(x, f);
               dao.registraLocacao(l);
               JOptionPane.showMessageDialog(null, String.format("Locacao registrada: \n%s - %s",f.getTitulo(), x.getNome()));
               System.out.println("locacao registrada: " + f.getTitulo() + " - " + x.getNome());
           }
        });
        painel.add(concluir);
        
        voltar = FabricaDeBotoes.criaBotao("voltar", 5, 460, 100, 20);
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
