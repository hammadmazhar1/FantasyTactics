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
	private int exp;
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
		exp = 0;
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
		exp = chr.exp;
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
		return maxHp;
	}
	public int getmaxMp() {
		return maxMp
	}
	public int getAtk() {
		return atk+eqWeapon.getAtk()+job.getAtkBon();
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
	public Job getJob() {
	}
	public boolean setJob(Job jb) {}
	public Weapon getWeap() {
	}
	public boolean setWeap(Weapon wpn) {
	}
	public Armor getArmor() {
	}
	public boolean setArmor(Armor amr) {
	}
	public Headgear getHat() {
	}
	public boolean setHat(Headgear hg) {
	}
	public Accessory getAcc() {
	}
	public boolean setAcc(Accessory acc) {
	}
	public ArrayList<AbilitySet> getSkills() {
	}
	public PasAbil getReact() {
	}
	public boolean setReact(PasAbil pa) {
	}
	public PasAbil getSupp() {
	}
	public boolean setSupp(PasAbil pa) {
	}
	public AbilitySet getPrimAbil() {
	}
	public boolean setPrimAbil(AbilitySet abil){
	}
	public AbilitySet getSecAbil() {
	}
	public boolean setSecAbil(AbilitySet abil){
	}
	public boolean levelUp() {
	}

}