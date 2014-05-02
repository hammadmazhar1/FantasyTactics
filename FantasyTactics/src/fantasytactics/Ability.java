package fantasytactics;

import java.util.*;
import java.io.*;
public class Ability implements Serializable {
	String name;
	int abilType;
	int atkType;
	ArrayList<Integer> statuses;
	int element;
	double accuracy;
	int reqJP;
	boolean acquired;
	boolean heal;
	int reqMP;
	int range;
	int aoe;
	boolean friFire;
	AbilityInterface abilAction;
	
	Ability() {
		abilType = 0;
		atkType = 0;
		statuses = new ArrayList<Integer>();
		element = 0;
		accuracy = 0;
		reqJP = 0;
		acquired = false;
		heal = false;
		reqMP = 0;
		range = 0;
		aoe = 0;
		friFire = false;
		abilAction = null;
	}
	Ability(String nm) {
		name = nm;
		switch (nm) {
			case "Counter":
				abilType = Stats.REACTIVE;
				atkType = Stats.PHYSICAL;
				statuses = null;
				element = 0;
				accuracy = 1d;
				reqJP = 300;
				range = 1;
				aoe = 1;
				friFire = true;
				
				
		}
	}
	
}