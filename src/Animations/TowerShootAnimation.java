
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animations;

import Enemies.Enemy;
import Levels.Level;
import Towers.*;
import java.awt.Point;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author greg
 */
public class TowerShootAnimation implements Runnable {

    private double xscale = 0, yscale = 0;
    private double angle;
    private Enemy enemy;
    private Projectile projectile;
    private Level parent;
    private Tower tower;
    private ArrayList<Enemy> infEnemies;

    public TowerShootAnimation(Projectile projectile, Enemy enemy, Tower tower, Level parent, ArrayList<Enemy> infEnemies) {

        this.enemy = enemy;
        this.projectile = projectile;
        this.parent = parent;
        this.tower = tower;
        this.infEnemies = infEnemies;
        projectile.setLocation(tower.x, tower.y);
    }

    @Override
    public void run() {

        try {

            Point p = new Point(projectile.x, projectile.y);

            while (enemy.getHP() > 0 && tower.whenToFire(tower.getRange(), enemy, tower)) {

                angle = getAngle(tower.getLocation(), enemy.getLocation());
                yscale = Math.cos(Math.toRadians(angle));
                xscale = Math.sin(Math.toRadians(angle));
                p.setLocation(projectile.x + xscale * 2, projectile.y - yscale * 3);

                projectile.setLocation(p);

                Thread.sleep(15);

                if (projectile.getCenterX() - enemy.getCenterX() < 5 && projectile.y - enemy.getCenterY() < 5) {
                    projectile.setLocation(1000, 1000);
                    enemy.setHP(tower.getDamage());
                    Thread.sleep(400);
                    projectile.setLocation(tower.x, tower.y);
                }

                parent.repaint();
            }
            projectile.setLocation(2000, 2000);
            if(enemy.getHP() <= 0)
            {
                infEnemies.remove(enemy);
            }
            tower.setIsFiring(false);
            this.finalize();

        } catch (Exception e) {
        } catch (Throwable ex) {
        }
    }

    public double getAngle(Point center, Point target) {
        double theta = Math.atan2(target.y - center.y, target.x - center.x);
        theta += Math.PI / 2.0;
        double angle = Math.toDegrees(theta);
        if (angle < 0) {
            angle += 360;
        }
        return angle;
    }

}


//~ Formatted by Jindent --- http://www.jindent.com
