/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import javax.swing.JButton;

/**
 *
 * @author adaao
 */

public class FabricaDeBotoes {
    public static JButton criaBotao(String label,int fromX, int fromY, int comprimento, int largura){
        JButton botao = new JButton(label);
        botao.setBounds(fromX, fromY, comprimento, largura);
        
        
        return botao;
    }
}
