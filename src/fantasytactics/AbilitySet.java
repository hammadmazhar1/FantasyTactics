package fantasytactics;

import java.util.*;
import java.io.*;
public class AbilitySet implements Serializable {
	String name;
	ArrayList<Ability> abilities;
	AbilitySet(int typ) {
		abilities = new ArrayList<Ability>();
		switch (typ) {
			case Stats.SOLDIER:
				name = "Arts of War";
				break;
			case Stats.HEALER:
				name = "Curate";
				break;
			case Stats.MAGE:
				name = "Elemental";
				break;
			case Stats.THIEF:
				name = "Sleight of Hand";
				break;
			case Stats.ARCHER:
				name = "Sharpeye";
				break;
			case Stats.FIGHTER:
				name = "Pugilism";
				break;
			case Stats.SEER:
				name = "Enlightment";
				break;
			case Stats.WIZARD:
				name = "Forces of Nature";
				break;
			case Stats.NINJA:
				name = "Ninjitsu";
				break;
			case Stats.HUNTER:
				name = "Stakeout";
				break;
		}
	}
}