
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package istower.defense.v1;

//~--- JDK imports ------------------------------------------------------------
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Paul
 */
public class OptionsPanel extends JPanel {

    private JLabel levelDisplay, waveDisplay, waveTimerDisplay, goldDisplay, textDisplay;
    private JButton towerOne, towerTwo, towerThree, start, pause, quit;
    private GridBagConstraints constraints;
    private int level, wave, waveTime;
    private static int gold;
    private boolean isPaused = false;

    public OptionsPanel(int frameWidth, int frameHeight) {
        super();
        setSize((frameWidth * (1 / 5)), frameHeight);
        setPreferredSize(new Dimension(200, 600));
        setBackground(Color.red);
        setLayout(new GridBagLayout());

        /*
        
         I used the extract method refactoring technique to isolate each part of how the variable is treated,
         first instantiated, then set up, then added to the component.
        
         Paul Johnson
        
         */
        initializeComponents();
        setupComponents();
        addComponents();
        /*
         Deleted echo
         */
    }

    public void initializeComponents() {
        level = 1;
        waveTime = 20;
        wave = 1;
        gold = 800;
        constraints = new GridBagConstraints();
        towerOne = new JButton(new ImageIcon("Images/lr_tower.png"));
        towerTwo = new JButton(new ImageIcon("Images/mr_tower.png"));
        towerThree = new JButton(new ImageIcon("Images/sr_tower.png"));
        towerOne.setContentAreaFilled(false);
        towerTwo.setContentAreaFilled(false);
        towerThree.setContentAreaFilled(false);
        start = new JButton("Start");
        pause = new JButton("Pause");
        quit = new JButton("Quit");
        levelDisplay = new JLabel("Level: " + level);
        setWaveDisplay(new JLabel("Wave: " + wave));
        waveTimerDisplay = new JLabel("Ends in: " + getWaveTime() + "s");
        goldDisplay = new JLabel("Gold: " + gold);
        textDisplay = new JLabel("cost: 200 Gold");
    }

    private void setupComponents() {
        /*
        Removed krimp
        
        Paul Johnson
        */
        levelDisplay.setBackground(Color.white);
    }


    public void addComponents() {
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = .05;
        constraints.insets = new Insets(2, 2, 2, 2);
        add(this.levelDisplay, constraints);
        constraints.gridy = 1;
        add(this.getWaveDisplay(), constraints);
        constraints.gridy = 2;
        add(this.waveTimerDisplay, constraints);
        constraints.gridy = 3;
        add(this.goldDisplay, constraints);
        constraints.weighty = 0.1;

        // constraints.insets = new Insets(10,0,0,10);
        constraints.gridy = 4;
        add(towerOne, constraints);

        add(textDisplay, constraints);
        constraints.gridy = 5;
        add(towerTwo, constraints);
        constraints.gridy = 6;
        add(towerThree, constraints);
        constraints.weighty = .05;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.gridy = 7;
        add(this.textDisplay, constraints);
        constraints.gridy = 8;
        add(start, constraints);
        constraints.gridy = 9;
        add(pause, constraints);
        constraints.gridy = 10;
        add(quit, constraints);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        /*
         Extracted method here to make the paintcomponent a little cleaner.
         */
        doDrawing(g);
    }

    public void doDrawing(Graphics g) {
        g.drawImage(new ImageIcon("Images/scroll.png").getImage(), 0, 0, super.getWidth(), super.getHeight(), null);
        goldDisplay.setText("Gold: " + gold);
        waveTimerDisplay.setText("Ends in: " + waveTime + "s");
        getWaveDisplay().setText("Wave: " + wave);
        levelDisplay.setText("Level: " + level);
    }

    public void startLevel(ActionListener al) {
        start.addActionListener(al);
    }

    public void quit(ActionListener al) {
        quit.addActionListener(al);

    }

    public void pauseGame(ActionListener al) {
        pause.addActionListener(al);
    }

    public void mouseSrTower(MouseAdapter al) {
        towerThree.addMouseListener(al);
    }

    public void mouseMrTower(MouseAdapter ma) {
        towerTwo.addMouseListener(ma);
    }

    public void mouseLrTower(MouseAdapter al) {
        towerOne.addMouseListener(al);
    }

    public JButton getStart() {
        return start;
    }

    public JButton getSRTower() {
        return towerOne;
    }

    public JButton getMRTower() {
        return towerTwo;
    }

    public JButton getLRTower() {
        return towerThree;
    }

    public JLabel getWaveDisplay() {
        return waveDisplay;
    }

    public void setWaveDisplay(JLabel waveDisplay) {
        this.waveDisplay = waveDisplay;
    }

    public int getWaveTime() {
        return waveTime;
    }


    public void setIsPaused() {
        this.isPaused = !isPaused;
    }

    public void setWaveTime(int set) {
        this.waveTime = set;
    }

    public void setLevel(int set) {
        this.level = set;
    }

    public int getLevel() {
        return level;
    }

    public int getWave() {
        return wave;
    }

    public int getGold() {
        return gold;
    }
    
    public void setupGold(int set)
    {
        gold = set;
    }

    public void setWave(int set) {
        wave = set;
    }

    public boolean getPause() {
        return isPaused;
    }

    public static void setGold(int amount) {
        gold -= amount;
    }

}


//~ Formatted by Jindent --- http://www.jindent.com
