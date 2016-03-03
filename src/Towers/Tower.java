
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Towers;

//~--- JDK imports ------------------------------------------------------------
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author greg
 */
public abstract class Tower extends Rectangle {

    private boolean isFiring = false;
    protected String background;
    protected String name;
    protected double range;
    protected int damage;
    

    public Tower() {
        this.x = 0;
        this.y = 0;
        this.width = 50;
        this.height = 50;
    }

    public void setRect(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean whenToFire(double range, Rectangle enemy, Rectangle tower) {

        double xdistance = Math.abs(enemy.getCenterX() - tower.getCenterX());
        double ydistance = Math.abs(enemy.getCenterY() - tower.getCenterY());
        double enemyDistance = Math.sqrt(Math.pow(xdistance, 2) + Math.pow(ydistance, 2));

        while (enemyDistance <= range) {
            return true;
        }

        return false;
    }

    public boolean isFiring() {
        return isFiring;
    }

    public void setIsFiring(boolean firing) {
        isFiring = firing;
    }
    
    public boolean getIsFiring()
    {
        return isFiring;
    }

    public String getBackground() {
        return background;
    }

    public double getRange() {
        return range;
    }

    public int getDamage() {
        return damage;
    }
     public String getName()
    {
        return name;
    }


}


//~ Formatted by Jindent --- http://www.jindent.com
