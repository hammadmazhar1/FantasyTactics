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
	int element;
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
		
	}
	Item(String nm) {
		name = nm;
		// switch (nm) {
			//TODO add ITEM stats and types here
			// case ""
		// }
		
	}
	public int getAtk() {
		return atk;
	}
	public int getDef() {
		return def;
	}
	public int getMove() {
		return move;
	}
	public int getJmp() {
		return jmp;
	}
	public int getMgc() {
		return mgc;
	}
	public int getEvade() {
		return evd;
	}
	public int getSpd() {
		return spd;
	}
	public int getResist() {
		return res;
	}
	public ArrayList<Integer> getProtects() {
		return protects;
	}
	public ArrayList<Integer> getEffects(){
		return effects;
	}
	public String getName() {
		return name;
	}
	public int getType() {
		return itemType;
	}
}