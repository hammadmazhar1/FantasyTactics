package fantasytactics;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import fantasytactics.Location;
public class Start {
	public static void create() {
            Mission mis1 = new Mission();
            mis1.misName = "Training";
            mis1.mapName = "mis1.png";
            mis1.map = new Location[][]{
            {new Location(-10,160), new Location(26,130), new Location(70,135),new Location(115,110), new Location(145,95), new Location(190,45), new Location(220,30),new Location(250,15), new Location(280,-15), new Location(310,-30), new Location(340,-45), new Location(370,-60),null},
            {new Location(20,180), new Location(50,165), new Location(90,150),new Location(120,135), new Location(150,135), new Location(180,120), new Location(220,100),new Location(240,45), new Location(275,30), new Location(315,0), null, new Location(410,-55),null},
            {new Location(50,215), new Location(85,195), new Location(115,180),new Location(150,165), new Location(180,150), new Location(215,135), new Location(250,100),new Location(280,65), new Location(315,50), new Location(340,35), new Location(380,0), new Location(410,-15), new Location(440,-30)},
            {new Location(80,230), new Location(110,215), new Location(140,200),new Location(170,185), new Location(200,170), new Location(230,155), new Location(260,140),new Location(290,125), new Location(340,85), new Location(370,70), new Location(410,35), new Location(440,5), new Location(470,-10)},
            {new Location(110,245), new Location(140,230), new Location(170,215),new Location(200,200), new Location(230,185), new Location(260,170), new Location(290,155),new Location(320,140), new Location(350,125), new Location(430,85), new Location(460,70), new Location(490,55),new Location(520,40)},
            {new Location(140,260), new Location(170,245), new Location(200,230),new Location(230,215), new Location(260,200), new Location(290,185), new Location(320,170),new Location(350,155), new Location(380,140), new Location(410,125), new Location(440,90), new Location(470,75),new Location(500,60)},
            {new Location(170,275), new Location(200,260), new Location(230,245),new Location(260,230), new Location(290,215), new Location(320,200), new Location(350,185),new Location(380,170), new Location(410,155), new Location(440,140), new Location(470,100), new Location(500,85), new Location(530,70)},
            {new Location(200,290), null, new Location(260,260),new Location(290,245), new Location(320,230), new Location(350,215), new Location(380,200),new Location(410,185), new Location(440,170), new Location(475,150), new Location(515,125), new Location(545,110), new Location(575,95)},
            {new Location(240,310), new Location(270,295), new Location(300,280),new Location(330,265), new Location(360,250), new Location(390,235), new Location(420,220),new Location(450,205), new Location(480,190), new Location(510,160), new Location(540,135), new Location(570,120), new Location(600,105)},
            {new Location(270,325), new Location(300,310), new Location(330,295),new Location(360,280), new Location(390,265), new Location(420,250), new Location(450,235),new Location(480,220), new Location(510,205), new Location(540,190), new Location(580,160), new Location(610,145), new Location(640,130)},
            {new Location(300,340), new Location(330,325), new Location(360,310),new Location(390,295), new Location(420,280), new Location(450,265), new Location(480,250),new Location(510,235), new Location(540,220), new Location(570,205), new Location(610,175), new Location(640,160), new Location(670,145)},
            {new Location(330,355), new Location(360,340), new Location(390,325),new Location(420,310), new Location(450,295), new Location(480,280), new Location(510,265),new Location(540,250), new Location(570,235), new Location(600,210), new Location(630,185), new Location(660,170), new Location(690,155)},
            {new Location(360,370), new Location(390,355), new Location(420,340),new Location(450,325), new Location(480,310), new Location(510,295), new Location(540,280),new Location(570,265), new Location(600,250), new Location(630,235), new Location(660,195), new Location(690,180), new Location(720,165)},
            {new Location(405,375), new Location(435,360), new Location(465,345),new Location(495,330), new Location(495,315), null, new Location(555,285),new Location(585,270), new Location(615,255), new Location(645,240), new Location(670,195), new Location(705,175), new Location(735,160)},
            {new Location(435,390), new Location(465,375), new Location(495,360),new Location(525,345), new Location(555,330), new Location(585,315), new Location(615,300),new Location(645,285), new Location(685,270), new Location(715,255), new Location(755,210), new Location(785,200), new Location(815,185)},
            {new Location(465,415), new Location(495,400), new Location(535,375),new Location(565,365), new Location(595,350), new Location(625,335), new Location(655,320),new Location(685,305), new Location(715,290), new Location(745,275), new Location(785,260), new Location(815,210), new Location(845,195)}
            };
            mis1.yLimit = 15;
            mis1.xLimit = 12;
            mis1.width = 916;
            mis1.height = 552;
            mis1.enCoor = new Location[]{
                mis1.map[3][2],mis1.map[3][3],mis1.map[3][4],mis1.map[3][5],mis1.map[3][6]
            };
            mis1.enmapCoor = new Location[] {
                new Location(2,3), new Location(3,3), new Location(4,3), new Location(5,3), new Location(6,3)
            };
            mis1.playCoor = new Location[]{
              mis1.map[13][6],mis1.map[13][7],mis1.map[13][8],mis1.map[13][9],mis1.map[13][10]
            };
            mis1.playmapCoor = new Location[]{
                new Location(6,13), new Location(7,13) ,new Location(8,13), new Location(9,13), new Location(10,13)
            };
            mis1.enemy = new Clan("Yellow Wings");
            Member mem1 = new Member("Todd",Stats.THIEF);
            mem1.setWeap(new Item("Dagger"));
            mem1.setArmor(new Item("Leather Clothing"));
            mem1.setHat(new Item("Plumed Hat"));
            mis1.enemy.members.add(mem1);
            mem1 = new Member("Sweeny",Stats.SOLDIER);
            mem1.setWeap(new Item("Shortsword"));
            mem1.setArmor(new Item("Leather Cuirass"));
            mem1.setHat(new Item("Bronze Helm"));
            mis1.enemy.members.add(mem1);
            mem1 = new Member("Hugh",Stats.HEALER);
            mem1.setWeap(new Item("White Staff"));
            mem1.setArmor(new Item("Hempen Robe"));
            mem1.setHat(new Item("Plumed Hat"));
            mis1.enemy.members.add(mem1);
            mem1 = new Member("Jack",Stats.MAGE);
            mem1.setWeap(new Item("Rod"));
            mem1.setArmor(new Item("Hempen Robe"));
            mem1.setHat(new Item("Plumed Hat"));
            mis1.enemy.members.add(mem1);
            mem1 = new Member("Sweeny",Stats.ARCHER);
            mem1.setWeap(new Item("Shortbow"));
            mem1.setArmor(new Item("Leather Clothing"));
            mem1.setHat(new Item("Plumed Hat"));
            mis1.enemy.members.add(mem1);
            mis1.spoils.add(new Item("Battle Boots"));
            mis1.spoils.add(new Item("Mage Manual"));
            mis1.gold = 500;
            ArrayList<Mission> missions = new ArrayList<Mission>();
            missions.add(mis1);
            try {
                FileOutputStream fos = new FileOutputStream("Missions.ifo");
                ObjectOutputStream out = new ObjectOutputStream(fos);
                out.writeObject(missions);
                out.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

}