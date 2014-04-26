import java.util.*;
public class Ability {
	String name;
	int abilType;
	int atkType;
	int power;
	ArrayList<Integer> statuses;
	int element;
	int accuracy;
	int reqJP;
	bool acquired;
	int reqMP;
	int range;
	
	Ability() {
		abilType = 0;
		atkType = 0;
		power =0;
		statuses = new ArrayList<Integer>();
		element = 0;
		accuracy = 0;
		reqJP = 0;
		acquired = false;
		reqMP = 0;
		range = 0;
	}
	Ability(String nm) {
		name = nm;
		switch (nm) {
			case 
		}
	}
	public void doAction(Member vic) {
	}
}