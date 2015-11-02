package fantasytactics;

import java.util.*;
import java.io.*;
public class Item implements Status, Serializable{
    public int itemType;
    String name;
    int move;
    int jmp;
    int evd;
    int atk;
    int def;
    int mgc;
    int res;
    int spd;
    int cost;
    int element;
    String imgname;
    String btimg;
    ArrayList<Integer> protects;
    ArrayList<Integer> effects;
    Item() {
        itemType = 0;
	move =0;
	jmp = 0;
	evd =0;
	atk =0;
	def = 0;
	mgc = 0;
	res = 0;
	spd = 0;
	name = null;
	element = 0;
	protects = new ArrayList<Integer>();
	effects = new ArrayList<Integer>();
        cost = 0;
        btimg = null;
        imgname = null;
    }
    Item(String nm) {
	name = nm;
        switch (nm) {
		//TODO add ITEM stats and types here
            case "Dagger":
                itemType = Stats.KNIVES;
                move = 0;
                jmp = 0;
                evd = 2;
                atk = 20;
                def = 0;
                mgc = 0;
                res = 0;
                spd = 0;
                element = 0;
                protects = null;
                effects = null;
                cost = 80; 
                imgname = "dagger.png";
                btimg = "dagBT.img";
                break;
            case "Scramasax":
                 itemType = Stats.KNIVES;
                 move = 0;
                 evd = 2;
                 jmp = 0;
                 def = 0;
                 atk = 30;
                 mgc = 0;
                 res = 0;
                 spd = 0;
                 element = 0;
                 protects = null;
                 effects = null;
                 cost = 500;
                 imgname = "scramasax.png";
                 btimg = "scrBT.img";
                 break;
            case "Shortsword":
                 itemType = Stats.SWORDS;
                 move = 0;
                 jmp = 0;
                 evd = 0;
                 atk = 22;
                 def = 0;
                 mgc = 0;
                 res = 0;
                 spd = 0;
                 element = 0;
                 protects = null;
                 effects = null;
                 cost = 100;
                 imgname = "shortsword.png";
                 btimg = "shrtBT.png";
                 break;
            case "Burglar Sword":
                 itemType = Stats.SWORDS;
                 move =0;
                 jmp = 0;
                 evd = 0;
                 atk = 35;
                 def = 0;
                 mgc = 0;
                 res = 0;
                 spd = 0;
                 element = 0;
                 protects = null;
                 effects =null;
                 cost = 1000;
                 imgname = "burglarsword.png";
                 btimg = "burgBT.png";
                 break;
             case "Iron Blade":
                 itemType = Stats.BLADES;
                 move = 0;
                 jmp = 0;
                 evd = 0;
                 atk = 25;
                 def = 0;
                 mgc = 0;
                             res = 0;
                 element = 0;
                 spd = 0;
                 protects = null;
                 effects = null;
                 cost = 150;
                 imgname = "ironblade.png";
                 btimg = "irbBT.png";
                 break;
            case "Atomos Blade":
                 itemType = Stats.BLADES;
                 move = 0;
                 jmp = 0;
                 evd = 0;
                 atk = 38;
                 def = 0;
                 mgc = 0;
                 res = 0;
                 spd = 0;
                 element = Stats.LIGHTNING;
                 protects = null;
                 effects = null;
                 cost = 1200;
                 imgname = "atomosblade.png";
                 btimg = "atomBT.png";
                 break;
             case "Kunai":
                 itemType = Stats.KATANAS;
                 move = 0;
                 jmp = 0;
                 evd = 0;
                 atk = 31;
                 def = 0;
                 mgc =0;
                 res = 0;
                 spd = 0;
                 element = 0;
                 protects = null;
                 effects = null;
                 cost = 500;
                 imgname = "kunai.png";
                 btimg = "kunBT.png";
                 break;
             case "Osafune":
                 itemType = Stats.KATANAS;
                 move = 0;
                 jmp = 0;
                 evd = 0;
                 atk = 34;
                 def = 2;
                 mgc = 0;
                 res = 0;
                 spd = 0;
                 element = 0;
                 protects = null;
                 effects = null;
                 cost = 880;
                 imgname = "osafune.png";
                 btimg = "osaBT.png";
                 break;
             case "Shortbow":
                 itemType = Stats.BOWS;
                 move = 0;
                 evd = 0;
                 jmp = 0;
                 atk = 17;
                 def = 0;
                 mgc = 0;
                 res = 0;
                 spd = 0;
                 element = 0;
                 protects = null;
                 effects = null;
                 cost = 100;
                 imgname = "shortbow.png";
                 btimg = "shrtbBT.png";
                 break;
             case "Nail Bow":
                 itemType = Stats.BOWS;
                 move = 0;
                 jmp = 0;
                 evd = 0;
                 atk = 29;
                 def = 0;
                 mgc = 0;
                 res = 0;
                 spd = 0;
                 element= 0;
                 protects = null;
                 effects = null;
                 cost = 3800;
                 imgname = "nailbow.png";
                 btimg = "nailBT.png";
                 break;
             case "Composite Bow":
                 itemType = Stats.GREATBOWS;
                 move = 0;
                 jmp = 0;
                 evd= 0;
                 atk = 21;
                 def = 0;
                 mgc = 0;
                 res = 0;
                 spd = 0;
                 element = 0;
                 protects = null;
                 effects = null;
                 cost = 220;
                 imgname = "compositebow.png";
                 btimg = "compBT.img";
                 break;
             case "Hunting Bow":
                 itemType = Stats.GREATBOWS;
                 move = 0;
                 evd =0;
                 jmp  = 0;
                 atk = 32;
                 def = 0;
                 mgc = 0;
                 res = 0;
                 spd = 0;
                 element = 0;
                 protects = null;
                 effects = null;
                 cost = 4800;
                 imgname = "huntingbow.png";
                 btimg = "huntBT.png";
                 break;
             case "Rod":
                 itemType = Stats.RODS;
                 move = 0;
                 jmp = 0;
                 evd = 0;
                 atk = 18;
                 def = 0;
                 mgc = 2;
                 res = 0;
                 spd = 0;
                 element = 0;
                 protects = null;
                 effects = null;
                 cost = 60;
                 imgname = "rod.png";
                 btimg = "rodBT.png";
                 break;
             case "Force Rod":
                 itemType = Stats.RODS;
                 move = 0;
                 jmp = 0;
                 evd = 0;
                 atk = 25;
                 def = 0;
                 mgc = 5;
                 res = 0;
                 spd = 0;
                 element = 0;
                 protects = null;
                 effects = null;
                 cost = 850;
                 imgname = "forcerod.png";
                 btimg = "forBT.png";
                 break;
             case "White Staff":
                 itemType = Stats.STAVES;
                 move = 0;
                 jmp = 0;
                 evd = 0;
                 atk = 19;
                 def = 0;
                 mgc = 0;
                 res = 5;
                 spd = 0;
                 element = Stats.HOLY;
                 protects = null;
                 effects = null;
                 cost = 100;
                 imgname = "whitestaff.png";
                 btimg = "whiteBT.png";
                 break;
             case "Cleansing Staff":
                 itemType = Stats.STAVES;
                 move = 0;
                 jmp = 0;
                 evd = 0;
                 atk = 25;
                 def = 0;
                 mgc = 0;
                 res = 5;
                 spd = 0;
                 protects = null;
                 element = Stats.HOLY;
                 effects = null;
                 cost = 850;
                 imgname = "cleansingstaff.png";
                 btimg = "cleanBT.img";
                 break;
             case "Battle Folio":
                 itemType = Stats.BOOKS;
                 move = 0;
                 jmp = 0;
                 evd = 0;
                 atk = 24;
                 def = 0;
                 mgc = 5;
                 res = 5;
                 spd = 0;
                 protects = null;
                 effects = null;
                 element = 0;
                 cost = 180;
                 imgname = "battlefolio.png";
                 btimg = "battleBT.png";
                 break;
             case "Mage Manual":
                 itemType = Stats.BOOKS;
                 move = 0;
                 jmp = 0;
                 evd = 0;
                 atk =31;
                 def = 0;
                 mgc = 8;
                 res = 8;
                 spd = 0;
                 protects = null;
                 effects = null;
                 element = 0;
                 cost = 600;
                 imgname = "magemanual.png";
                 btimg = "magemanBT.png";
                 break;
             case "Bronze Helm":
                 itemType = Stats.HELMETS;
                 move = 0;
                 jmp = 0;
                 evd = 0;
                 atk = 0;
                 def = 4;
                 mgc = 0;
                 res = 2;
                 spd = 0;
                 protects = null;
                 effects = null;
                 element = 0;
                 cost = 200;
                 imgname = "bronzehelm.png";
                 btimg = null;
                 break;
             case "Platinum Helm":
                 itemType = Stats.HELMETS;
                 move = 0;
                 jmp = 0;
                 evd = 0;
                 atk = 0;
                 def = 10;
                 mgc = 0;
                 res = 4;
                 spd = 0;
                 protects = null;
                 effects = null;
                 element = 0;
                 cost =1200;
                 imgname = "platinumhelm.png";
                 btimg = null;
                 break;
             case "Plumed Hat":
                 itemType = Stats.HATS;
                 move = 0;
                 jmp = 0;
                 evd = 0;
                 atk = 0;
                 def = 2;
                 mgc = 0;
                 res = 5;
                 spd = 0;
                 protects = null;
                 effects = null;
                 element = 0;
                 cost = 100;
                 imgname = "plumedhat.png";
                 btimg = null;
                 break;
             case "Gold Hairpin":
                 itemType = Stats.HATS;
                 move = 0;
                 jmp = 0;
                 evd = 0;
                 atk = 0;
                 def = 4;
                 mgc = 2;
                 res = 15;
                 spd = 0;
                 protects =null;
                 effects = null;
                 element = 0;
                 cost = 960;
                 imgname = "goldhairpin.png";
                 btimg = null;
                 break;
             case "Thief's Hat":
                 itemType = Stats.HATS;
                 move = 0;
                 jmp = 0;
                 evd = 5;
                 atk = 0;
                 def = 8;
                 mgc =0;
                 res = 6;
                 spd =0;
                 protects = null;
                 effects = null;
                 element = 0;
                 cost = 1280;
                 imgname = "thiefshat.png";
                 btimg = null;
                 break;
             case "Linen Cuirass":
                 itemType = Stats.ARMOR;
                 move = 0;
                 jmp = 0;
                 evd = 0;
                 atk = 0;
                 def = 28;
                 mgc = 0;
                 res = 0;
                 spd = 0;
                 protects = null;
                 effects = null;
                 element = 0;
                 cost = 220;
                 imgname = "linencuirass.png";
                 btimg = null;
                 break;
             case "Platemail":
                 itemType = Stats.ARMOR;
                 move = 0;
                 jmp = 0;
                 evd = 0;
                 atk = 0;
                 def = 38;
                 mgc =0;
                 res = 3;
                 spd = 0;
                 protects = null;
                 effects = null;
                 element = 0;
                 cost = 1400;
                 imgname = "platemail.png";
                 btimg = null;
                 break;
             case "Leather Clothing":
                 itemType = Stats.CLOTHES;
                 move = 0;
                 jmp =0;
                 evd = 0;
                 atk= 0;
                 def = 24;
                 mgc =0;
                 res = 4;
                 spd = 0;
                 element = 0;
                 protects =null;
                 effects = null;
                 cost = 190;
                 imgname = "leatherclothing.png";
                 btimg = null;
                 break;
             case "Brigandine":
                 itemType = Stats.CLOTHES;
                 move = 0;
                 jmp = 0;
                 evd = 0;
                 atk = 0;
                 def = 33;
                 mgc =0;
                 res = 6;
                 spd = 0;
                 element = 0;
                 protects = null;
                 effects = null;
                 cost = 1280;
                 imgname = "brigandine.png";
                 btimg = null;
                 break;
             case "Hempen Robe":
                 itemType = Stats.ROBES;
                 move = 0;
                 jmp = 0;
                 evd =0;
                 atk = 0;
                 def = 17;
                 mgc = 0;
                 res = 32;
                 spd = 0;
                 element = 0;
                 protects = null;
                 effects = null;
                 cost = 150;
                 imgname = "hempenrobe.png";
                 btimg = null;
                 break;
             case "Chameleon Robe":
                 itemType = Stats.ROBES;
                 move = 0;
                 jmp = 0;
                 evd = 0;
                 atk = 0;
                 def = 21;
                 mgc = 0;
                 res = 38;
                 spd = 0;
                 element = Stats.HOLY;
                 protects = null;
                 effects = null;
                 cost = 1240;
                 imgname = "chameleonrobe.png";
                 btimg = null;
                 break;
             case "Blaze Robe":
                 itemType = Stats.ROBES;
                 move = 0;
                 jmp = 0;
                 evd = 0;
                 atk = 0;
                 def = 21;
                 mgc = 0;
                 res = 38;
                 spd = 0;
                 element = Stats.FIRE;
                 protects = null;
                 effects = null;
                 cost = 1240;
                 imgname = "blazerobe.png";
                 btimg = null;
                 break;
             case "Battle Boots":
                 itemType = Stats.ACCESSORY;
                 move = 0;
                 jmp = 0;
                 evd = 0;
                 atk = 0;
                 def = 7;
                 mgc = 0;
                 res = 0;
                 spd = 0;
                 element = 0;
                 protects = null;
                 effects = null;
                 cost = 1000;
                 imgname = "battleboots.png";
                 btimg = null;
                 break;
             case "Spiked Boots":
                 itemType = Stats.ACCESSORY;
                 move = 0;
                 jmp = 1;
                 evd = 0;
                 atk  =0;
                 def = 4;
                 mgc = 0;
                 res = 0;
                 spd = 0;
                 element = 0;
                 protects = null;
                 effects = null;
                 cost = 1000;
                 imgname = "spikedboots.png";
                 btimg = null;
                 break;
             case "Sprint Shoes":
                 itemType = Stats.ACCESSORY;
                 move = 1;
                 jmp = 0;
                 evd = 0;
                 atk = 0;
                 def = 2;
                 mgc = 0;
                 res = 0;
                 element = 0;
                 protects = null;
                 effects = null;
                 cost = 2000;
                 imgname = "sprintshoes.png";
                 btimg = null;
                 break;
        }
		
    }
    @Override
    public int getAtk() {
        return atk;
    }
    @Override
    public int getDef() {
        return def;
    }
    @Override
    public int getMove() {
        return move;
    }
    @Override
    public int getJmp() {
        return jmp;
    }
    @Override
    public int getMgc() {
        return mgc;
    }
    @Override
    public int getEvade() {
        return evd;
    }
    @Override
    public int getSpd() {
        return spd;
    }
    @Override
    public int getResist() {
        return res;
    }
    @Override
    public ArrayList<Integer> getProtects() {
        return protects;
    }
    @Override
    public ArrayList<Integer> getEffects(){
        return effects;
    }
    @Override
    public String getName() {
        return name;
    }
    public int getType() {
        return itemType;
    }
    public int getCost() {
        return cost;
    }
}