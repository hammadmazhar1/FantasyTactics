import java.util.*
public class Member {
	private String name;
	private int level;
	private int maxHp;
	private int maxMp;
	private int move;
	private int spd;
	private int jmp;
	private int evade;
	private int atk;
	private int def;
	private int mgc;
	private int res;
	private Job job;
	private ArrayList<AbilitySet> skills;
	private Weapon eqWeapon;
	private Armor eqArmor;
	private Headgear eqHat;
	private Accessory eqAcc;
	private AbilitySet primAbil;
	private AbilitySet secAbil;
	private PasAbil reactAbil;
	private PasAbil suppAbil;
	
	Member(String nm, Job jb){
		level = 1;
		name = nm;
		job = jb;
		maxHp= job.intHp;
		maxMp = job.intMp;
		move = job.intMove;
		spd = job.intSpd;
		jmp = job.intJmp;
		evade = job.intEvd;
		atk = job.intAtk;
		def = job.intDef;
		mgc = job.intMgc;
		res = job.intRes;
		eqWeapon = null;
		eqArmor = null;
		eqHat = null;
		eqAcc = null;
		skills = new ArrayList<AbilitySet>();
		skills.add(job.abilSet);
		primAbil = job.abilSet;
		secAbil = null;
		reactAbil = null;
		suppAbil = null;
	}
	Member(Member chr) {
		level = chr.lev;
		name = chr.name;
		job = chr.job;
		maxHp = chr.maxHp;
		maxMp = chr.maxMp;
		move = chr.move;
		spd = chr.spd;
		jmp = chr.jmp;
		evade = chr.evade;
		atk = chr.atk;
		def = chr.def;
		mgc = chr.mgc;
		res = chr.res;
		eqWeapon = chr.eqWeapon;
		eqArmor = chr.eqArmor;
		eqHat = chr.eqHat;
		eqAcc = chr.eqAcc;
		skills = chr.skills;
		primAbil = chr.primAbil;
		secAbil =chr.secAbil;
		reactAbil = chr.secAbil;
		suppAbil = chr.suppAbil;
	
	}
	public int getmaxHp() {
	}
	public int getmaxMp() {
	}
	public int getAtk() {
	}
	public int getDef() {
	}
	public int getMove() {
	}
	public int getJump() {
	}
	public int getEvade() {
	}
	public int getSpeed() {
	}
	public int getResist() {
	}
	public int getWeap() {
	}
	public int getArmor() {
	}
	public int getHat() {
	}
	public int get

}