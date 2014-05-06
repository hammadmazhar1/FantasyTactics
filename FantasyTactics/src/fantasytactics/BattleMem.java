package fantasytactics;

import javafx.scene.image.Image;

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
    int curX;
    int curY;
    int mapX;
    int mapY;
    int mapZ;
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
        curX = 0;
        curY = 0;
        mapX = 0;
        mapY = 0;
        mapZ = 0;
        direction = 0;
    }
    BattleMem(int side, Member mem, int X, int Y, int Z, int cX, int cY) {
        member = mem;
        poison = false;
        confuse = false;
        charm = false;
        blind = false;
        disable = false;
        immobilize = false;
        faint = false;
        weak = false;
        mapX = X;
        mapY = Y;
        mapZ = Z;
        curX = cX;
        curY = cY;
        direction = 0;
        if (side == 0) {
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
}