package fantasytactics;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class BattleMem {
    Member member;
    boolean poison;
    boolean confuse;
    boolean charm;
    boolean blind;
    boolean disable;
    boolean immobilize;
    boolean weak;
    boolean faint;
    Image img;
    int curHP;
    int curMP;
    Location mapLoc;
    Location pixLoc;
    int direction;
    Animator anm;
    BattleMem() {
        member = null;
        poison = false;
        confuse = false;
        charm = false;
        blind = false;
        disable = false;
        immobilize = false;
        faint = false;
        weak = false;
        img = null;
        anm = null;
        curHP = 0;
        curMP = 0;
        mapLoc = null;
        pixLoc = null;
        direction = 0;
    }
    BattleMem(int side, Member mem, Location m, Location p) {
        member = mem;
        curMP = 0;
        curHP = mem.getmaxHp();
        poison = false;
        confuse = false;
        charm = false;
        blind = false;
        disable = false;
        immobilize = false;
        faint = false;
        weak = false;
        pixLoc = p;
        mapLoc = m;
        direction = 0;
        if (side == 0) {
            direction = 0;
            switch (member.getJob().type) {
                case Stats.SOLDIER:
                    img = new Image("fantasytactics/images/soldier.png"
                                    ,530,390,false,false);
                    break;
                case Stats.HEALER:
                    img = new Image("fantasytactics/images/healer.png",
                                    530,390,false,false);
                    break;
                case Stats.MAGE:
                    img = new Image("fantasytactics/images/mage.png",
                                    530,390,false,false);
                    break;
                case Stats.THIEF:
                    img = new Image("fantasytactics/images/thief.png",
                                    530,390,false,false);
                    break;
                case Stats.ARCHER:
                    img = new Image("fantasytactics/images/archer.png",
                                    530,390,false,false);
                    break;
                case Stats.FIGHTER:
                    img = new Image("fantasytactics/images/fighter.png",
                                    530,390,false,false);
                    break;
                case Stats.NINJA:
                    img = new Image("fantasytactics/images/ninja.png",
                                    530,390,false,false);
                    break;
                case Stats.WIZARD:
                    img = new Image("fantasytactics/images/wizard.png",
                                    530,390,false,false);
                    break;
                case Stats.SEER:
                    img = new Image("fantasytactics/images/seer.png",
                                    530,390,false,false);
                    break;
                case Stats.HUNTER:
                    img = new Image("fantasytactics/images/hunter.png",
                                    530,390,false,false);
                    break;
            }
        } else {
            direction = 2;
            switch (member.getJob().type) {
                case Stats.SOLDIER:
                    img = new Image("fantasytactics/images/soldierE.png",
                                    530,390,false,false);
                    break;
                case Stats.HEALER:
                    img = new Image("fantasytactics/images/healerE.png",
                                    530,390,false,false);
                    break;
                case Stats.MAGE:
                    img = new Image("fantasytactics/images/mageE.png",
                                    530,390,false,false);
                    break;
                case Stats.THIEF:
                    img = new Image("fantasytactics/images/thiefE.png",
                                    530,390,false,false);
                    break;
                case Stats.ARCHER:
                    img = new Image("fantasytactics/images/archerE.png",
                                    530,390,false,false);
                    break;
                case Stats.FIGHTER:
                    img = new Image("fantasytactics/images/fighterE.png",
                                    530,390,false,false);
                    break;
                case Stats.NINJA:
                    img = new Image("fantasytactics/images/ninjaE.png",
                                    530,390,false,false);
                    break;
                case Stats.SEER:
                    img = new Image("fantasytactics/images/seerE.png",
                                    530,390,false,false);
                    break;
                case Stats.WIZARD:
                    img = new Image("fantasytactics/images/wizardE.png",
                                    530,390,false,false);
                    break;
                case Stats.HUNTER:
                    img = new Image("fantasytactics/images/hunterE.png",
                                    530,390,false,false);
                    break;
                    
            }
        }
        anm= new Animator(this);
    }
    public void updatePosition() {
        
        anm.view.setX(pixLoc.x);
        anm.view.setY(pixLoc.y);
        if (direction == 0) {
            anm.turnUp();
        } else if (direction == 1) {
            anm.turnLeft();
        } else if (direction == 2) {
            anm.turnDown();
        } else if (direction == 3) {
            anm.turnRight();
        }

    }
    public void executeAttack(final BattleMem vic){
        anm.curFrame = 0;
        vic.anm.curFrame = 0;
        if (mapLoc.x < vic.mapLoc.x) {
            if (mapLoc.y < vic.mapLoc.y) {
                direction =2;
                
            }else if (mapLoc.y > vic.mapLoc.y) {
                direction = 0;
            } else {
                direction = 3;
            }
        } else if (mapLoc.x > vic.mapLoc.x) {
            if (mapLoc.y < vic.mapLoc.y) {
                direction = 2;
            } else if (mapLoc.y > vic.mapLoc.y) {
                direction = 0;
            } else {
                direction = 1;
            }
        } else {
            if (mapLoc.y < vic.mapLoc.y) {
                direction = 2;
            } else {
                direction = 0;
            }
        }
        updatePosition();
        double prob = 1-((double)vic.member.getEvade()/100);
        Random r = new Random();
        boolean success =false;
        if (r.nextDouble() <= prob) {
            success = true;
        }
        Timeline time = new Timeline(new KeyFrame(Duration.millis(500), new EventHandler() {
            public void handle(Event e) {
               if (anm.curFrame == 0) {
                   anm.beginAttack();
               } else if (anm.curFrame == 1) {
                   anm.endAttack();
               } else {
                   updatePosition();
                   anm.curFrame = 0;
               }
            };
        }));
        time.setCycleCount(3);
        time.play();
        Timeline time2;
        if (success) {
            time2 = new Timeline(new KeyFrame(Duration.millis(500), new EventHandler() {
                public void handle(Event e) {
                    if (vic.anm.curFrame == 0) {
                        vic.anm.beginHit();
                    } else if (vic.anm.curFrame == 1) {
                        vic.anm.endHit();
                    } else {
                        vic.updatePosition();
                        vic.anm.curFrame = 0;
                    }
                }
            }));
            
            int dmg = (member.getAtk()-(vic.member.getDef()/2))/2;
            vic.curHP -= dmg;
            member.addExp(vic.member);
            boolean lup = member.levelUp();
        } else {
            if (direction == 0) {
                vic.direction = 2;
            } else if (direction == 1) {
                vic.direction = 3;
            } else if(direction == 2) {
                vic.direction = 0;
            } else if (direction == 3) {
                vic.direction = 1;
            }
            time2 = new Timeline(new KeyFrame(Duration.millis(500), new EventHandler() {
                public void handle(Event e) {
                    if (vic.anm.curFrame == 0) {
                        vic.anm.beginDodge();
                    }else if (vic.anm.curFrame == 1) {
                        vic.anm.endDodge();
                    } else {
                        vic.updatePosition();
                        vic.anm.curFrame = 0;
                    }
                }
            }));
        }
        time2.setCycleCount(3);
        time2.play();
    }
    public void toFront() {
        anm.view.toFront();
    }
}