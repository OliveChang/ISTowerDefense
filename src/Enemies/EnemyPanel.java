/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemies;

import istower.defense.v1.ObjectFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author lmo5113
 */
public class EnemyPanel extends JPanel{
    
    private JLabel damage; 
    private JLabel goldOnKill; 
    private JLabel Alive; 
    private JLabel maxHP; 
    private JLabel hitpoints; 
    private JLabel backgorund; 
    
    

    
    
    
    public EnemyPanel(Enemy enemy){
    JPanel JPanel = null;
    ObjectFrame objectFrame = new ObjectFrame(JPanel);
    setSize(200, 600);
//    enemy.damage();
//    enemy.background();
//    enemy.goldOnKill();
//    enemy.isAlive();
//    enemy.maxHP();
//    enemy.hitpoints();
    }
    
     
    
    
}


