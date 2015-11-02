package fantasytactics;


import java.io.Serializable;
import java.util.ArrayList;

public class Mission implements Serializable {
	Clan enemy;
	String misName;
	String mapName;
	Location[][] map;
        Location[] enCoor;
        Location[] enmapCoor;
        Location[] playCoor;
        Location[] playmapCoor;
	ArrayList<Item> spoils;
        int gold;
        int xLimit;
        int yLimit;
        int width;
        int height;
	Mission(){
                enemy = null;
		spoils = new ArrayList<Item>();
		mapName = null;
		misName= null;
		map = null;
                enCoor = null;
                playCoor = null;
                xLimit = 0;
                yLimit = 0;
	}
}