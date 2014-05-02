package fantasytactics;


import java.io.Serializable;
import java.util.ArrayList;

public class Mission implements Serializable {
	Clan enemy;
	String misName;
	String mapName;
	int[][] map;
	ArrayList<Item> spoils;
	Mission(){
		spoils = new ArrayList<Item>();
		mapName = null;
		misName= null;
		map = null;
	}
}