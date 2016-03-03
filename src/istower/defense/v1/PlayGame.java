package istower.defense.v1;

import Levels.*;
import Towers.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Paul
 */
public class PlayGame extends JFrame {

    private static int frameWidth = 800;
    private static int frameHeight = 600;
    private static int frameLocationX = 0;
    private static int frameLocationY = 100;
    private GridBagConstraints constraints = new GridBagConstraints();
    public static Level level;
    private OptionsPanel optionsPanel;
    private JPanel content = new JPanel();

    public PlayGame() {
        super();

        initUI();
        revalidate();
        setLocation(frameLocationX, frameLocationY);

        level.repaint();
        optionsPanel.repaint();
        setResizable(false);
        addActionListeners();
    }

    public Level getLevel() {
        return level;
    }

    public OptionsPanel getOptionsPanel() {
        return optionsPanel;
    }


    public void initUI() {

        setSize(frameWidth, frameHeight);
        setVisible(true);
        content.setSize(this.getSize());
        setLayout(new GridLayout());
        add(content);
        content.setLayout(new GridBagLayout());

        optionsPanel = new OptionsPanel(frameWidth, frameHeight);

        level = new LevelOne();

        setSize(frameWidth, frameHeight);
        constraints.weightx = .9;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        content.add(level, constraints);
        constraints.weightx = .1;
        constraints.weighty = 1.0;
        content.add(optionsPanel, constraints);
        setTitle("ISTower Defense");
        setContentPane(content);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void nextLevel(Level infLevel) {
        level = infLevel;
        content.removeAll();
        content.repaint();
        revalidate();

        constraints.weightx = .9;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        content.add(level, constraints);

        constraints.weightx = .1;
        constraints.weighty = 1.0;
        content.add(optionsPanel, constraints);

        optionsPanel.startLevel(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                level.startWaves();
                optionsPanel.getWaveTimer().start();
                optionsPanel.getStart().removeActionListener(this);

            }
        });
    }

    public void addActionListeners() {
        
        optionsPanel.quit(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        optionsPanel.startLevel(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                level.startWaves();
                optionsPanel.getWaveTimer().start();
                optionsPanel.getStart().removeActionListener(this);

            }
        });

        optionsPanel.pauseGame(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Level.pauseGame();
                Level.setIsPaused();
                System.out.println("pausing");

                if (Level.getIsPaused()) {
                    optionsPanel.getWaveTimer().stop();

                } else {
                    optionsPanel.getWaveTimer().start();

                }

            }
        });

        optionsPanel.mouseMrTower(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    //pop up jframe with medium range tower information
                } else if (e.getButton() == MouseEvent.BUTTON1) {
                    if (OptionsPanel.gold >= 200 && !Level.isBuilding) {

                        level.buildTower(new MRTower());
                        OptionsPanel.setGold(200);
                        optionsPanel.repaint();
                    }
                }
            }

        });

        optionsPanel.mouseSrTower(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    //pop up jframe with short range tower information
                } else if (e.getButton() == MouseEvent.BUTTON1) {
                    if (OptionsPanel.gold >= 200 && !Level.isBuilding) {

                        level.buildTower(new SRTower());
                        OptionsPanel.setGold(200);
                        optionsPanel.repaint();
                    }
                }
            }

        });

        optionsPanel.mouseLrTower(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    //pop up jframe with long range tower information
                } else if (e.getButton() == MouseEvent.BUTTON1) {
                    if (OptionsPanel.gold >= 200 && !Level.isBuilding) {

                        level.buildTower(new LRTower());
                        OptionsPanel.setGold(200);
                        optionsPanel.repaint();
                    }
                }
            }

        });

    }

    /**
     * @return the frameLocationX
     */
    public static int getFrameLocationX() {
        return frameLocationX;
    }

    /**
     * @return the frameLocationY
     */
    public static int getFrameLocationY() {
        return frameLocationY;
    }

    /**
     * @return the frameWidth
     */
    public static int getFrameWidth() {
        return frameWidth;
    }

    /**
     * @return the frameHeight
     */
    public static int getFrameHeight() {
        return frameHeight;
    }

}
