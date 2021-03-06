/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fantasytactics;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



/**
 *
 * @author Hammad
 */
public class Animator{
    public static final int colOffset = 66;
    public static final int rowOffset = 98;
    Image img;
    ImageView view;
    int curFrame;
    BattleMem puppet;
    public final int stdLeftC = 0;
    public final int stdLeftR = 0;
    public final int stdUpC = 1;
    public final int stdUpR = 0;
    public final int wlkLeftC = 2;
    public final int wlkLeftR = 0;
    public final int wlkUpC= 4;
    public final int wlkUpR = 0;
    public final int castLeftC = 6;
    public final int castLeftR = 0;
    public final int castUpC = 7;
    public final int castUpR = 0;
    public final int readyLeftC = 0;
    public final int readyLeftR = 1;
    public final int readyUpC = 1;
    public final int readyUpR = 1;
    public final int weakLeftC = 2;
    public final int weakLeftR = 1;
    public final int weakUpC = 3;
    public final int weakUpR = 1;
    public final int findLeftC = 4;
    public final int findLeftR = 1;
    public final int findUpC = 5;
    public final int findUpR = 1;
    public final int throwLeftC = 6;
    public final int throwLeftR = 1;
    public final int throwUpC = 7;
    public final int throwUp = 1;
    public final int attackLeftC = 0;
    public final int attackLeftR = 2;
    public final int attackUpC = 2;
    public final int attackUpR = 2;
    public final int sleepLeftC = 0;
    public final int sleepLeftR = 3;
    public final int sleepUpC = 1;
    public final int sleepUpR = 3;
    public final int hitLeftC = 2;
    public final int hitLeftR = 3;
    public final int hitUpC = 3;
    public final int hitUpR = 3;
    public final int prayLeftC = 4;
    public final int prayLeftR = 3;
    public final int prayUpC = 5;
    public final int prayUpR = 3;
    public final int talkLeftC = 6;
    public final int talkLeftR = 3;
    public final int talkUpC = 7;
    public final int talkUpR = 3;
    Animator() {
        img = null;
        view = null;
        curFrame=0;
        puppet = null;
    }
    Animator(BattleMem m) {
        img = m.img;
        puppet = m;
        curFrame = 0;
        view = new ImageView(img);
        view.setX(puppet.pixLoc.x);
        view.setY(puppet.pixLoc.y);
        if (puppet.direction == 0) {
            view.setViewport(new Rectangle2D(stdUpC*colOffset,stdUpR*rowOffset,colOffset,rowOffset));
        } else if (puppet.direction == 1) {
            view.setViewport(new Rectangle2D(stdLeftC*colOffset,stdLeftR*rowOffset,colOffset,rowOffset));
        } else if (puppet.direction == 2) {
            view.setViewport(new Rectangle2D(stdLeftC*colOffset,stdLeftR*rowOffset,colOffset,rowOffset));
            view.setScaleX(-1);
        } else if (puppet.direction == 3) {
            view.setViewport(new Rectangle2D(stdUpC*colOffset,stdUpR*rowOffset,colOffset,rowOffset));
            view.setScaleX(-1);
        }
        
    }
    public void turnUp() {
         view.setViewport(new Rectangle2D(stdUpC*colOffset,stdUpR*rowOffset,colOffset,rowOffset));
    }
    public void turnLeft() {
        view.setViewport(new Rectangle2D(stdLeftC*colOffset,stdLeftR*rowOffset,colOffset,rowOffset));
    }
    public void turnRight() {
        view.setViewport(new Rectangle2D(stdUpC*colOffset,stdUpR*rowOffset,colOffset,rowOffset));
        view.setScaleX(-1);
    }
    public void turnDown() {
        view.setViewport(new Rectangle2D(stdLeftC*colOffset,stdLeftR*rowOffset,colOffset,rowOffset));
        view.setScaleX(-1);
    }
    public void beginAttack() {
        if (puppet.direction ==0) {
            view.setViewport(new Rectangle2D(attackUpC*colOffset,attackUpR*rowOffset,colOffset,rowOffset));
        } else
        if (puppet.direction == 1) {
            view.setViewport(new Rectangle2D(attackLeftC*colOffset,attackLeftR*rowOffset,colOffset,rowOffset));
        } else
        if (puppet.direction == 2) {
            view.setViewport(new Rectangle2D(attackLeftC*colOffset,attackLeftR*rowOffset,colOffset,rowOffset));
            view.setScaleX(-1);
        } else
        if (puppet.direction == 3) {
            view.setViewport(new Rectangle2D(attackUpC*colOffset,attackUpR*rowOffset,colOffset,rowOffset));
            view.setScaleX(-1);
        }
        curFrame++;
    }
    public void endAttack() {
        if (puppet.direction ==0) {
            view.setViewport(new Rectangle2D((attackUpC*colOffset)+colOffset,attackUpR*rowOffset,colOffset,rowOffset));
        } else
        if (puppet.direction == 1) {
            view.setViewport(new Rectangle2D((attackLeftC*colOffset)+colOffset,attackLeftR*rowOffset,colOffset,rowOffset));
        } else
        if (puppet.direction == 2) {
            view.setViewport(new Rectangle2D((attackLeftC*colOffset)+colOffset,attackLeftR*rowOffset,colOffset,rowOffset));
            view.setScaleX(-1);
        } else
        if (puppet.direction == 3) {
            view.setViewport(new Rectangle2D((attackUpC*colOffset)+colOffset,attackUpR*rowOffset,colOffset,rowOffset));
            view.setScaleX(-1);
        } 
        curFrame++;
    }
    public void beginHit() {
        if (puppet.direction ==0) {
            view.setViewport(new Rectangle2D(hitUpC*colOffset,hitUpR*rowOffset,colOffset,rowOffset));
        } else
        if (puppet.direction == 1) {
            view.setViewport(new Rectangle2D(hitLeftC*colOffset,hitLeftR*rowOffset,colOffset,rowOffset));
        } else
        if (puppet.direction == 2) {
            view.setViewport(new Rectangle2D(hitLeftC*colOffset,hitLeftR*rowOffset,colOffset,rowOffset));
            view.setScaleX(-1);
        } else
        if (puppet.direction == 3) {
            view.setViewport(new Rectangle2D(hitUpC*colOffset,hitUpR*rowOffset,colOffset,rowOffset));
            view.setScaleX(-1);
        }
        curFrame++;
    }
    public void endHit() {
        curFrame++;
    }
    public void beginDodge() {
        if (puppet.direction ==0) {
            view.setViewport(new Rectangle2D(readyUpC*colOffset,readyUpR*rowOffset,colOffset,rowOffset));
        } else
        if (puppet.direction == 1) {
            view.setViewport(new Rectangle2D(readyLeftC*colOffset,readyLeftR*rowOffset,colOffset,rowOffset));
        } else
        if (puppet.direction == 2) {
            view.setViewport(new Rectangle2D(readyLeftC*colOffset,readyLeftR*rowOffset,colOffset,rowOffset));
            view.setScaleX(-1);
        } else
        if (puppet.direction == 3) {
            view.setViewport(new Rectangle2D(readyUpC*colOffset,readyUpR*rowOffset,colOffset,rowOffset));
            view.setScaleX(-1);
        }
        view.setX(view.getX()-10);
        curFrame++;
    }
    public void endDodge() {
        view.setX(view.getX()+10);
        curFrame++;
    }
    
}
