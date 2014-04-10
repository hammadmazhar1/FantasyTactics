import java.util.*;
public class Ability {
	String name;
	int abilType;
	int atkType;
	int atk;
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
		atk =0;
		statuses = new ArrayList<Integer>();
		element = 0;
		accuracy = 0;
		reqJP = 0;
		acquired = false;
		reqMP = 0;
		range = 0;
	}
	public void doAction(Character vic) {
	}
}