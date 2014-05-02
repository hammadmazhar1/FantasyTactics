package fantasytactics;

import java.util.*;
import java.io.*;
public class Clan implements Serializable{
	String clanName;
	ArrayList<Member> members;
	int gold;
	ArrayList<Item> inventory;
	Clan(String name) {
		clanName = name;
		members = new ArrayList<Member>();
		inventory = new ArrayList<Item>();
		gold = 5000;
	}
	
}