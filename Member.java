import java.util.*
public class Member implements Status {
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
	private Shield eqShield;
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
		eqShield = null;
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
		eqShield = chr.eqShield;
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
	public int getLevel() {
		return level;
	}
	public int getAtk() {
		if (eqWeapon) {
			return atk + eqWeapon.getAtk();
		} else {
			return atk + job.getAtkBon();
		}
	}
	public int getDef() {
		if (eqArmor) {
			return def + eqArmor.getDef();
		} else {
			return def;
		}
	}
	public int getMove() {
		if (eqAcc) {
			return move + eqAcc.getMove();
		} else {
			return move;
		}
	}
	public int getJump() {
		if (eqAcc) {
			return jmp + eqAcc.getJmp();
		} else {
			return jmp;
		}
	}
	public int getMgc() {
		int ans = mgc; 
		if (eqAcc) {
			ans += eqAcc.getMgc();
		}
		if (eqWeapon) {
			ans += eqWeapon.getMgc();
		}
		return ans;
	}
	public int getEvade() {
		int ans = evade;
		if (eqAcc) {
			ans+=eqAcc.getEvade();
		}
		if (eqArmor) {
			ans += eqArmor.getEvade();
		}
		if (eqHat) {
			ans += eqHat.getEvade();
		}
		if (eqShield) {
			ans+= eqShield.getEvade();
		}
		if (eqWeapon) {
			ans += eqWeapon.getEvade();
		}
		return ans;
	}
	public int getExp() {
		return exp;
	}
	public int addExp(Member vic) {
		int ans = 0;
		if (level == vic.getLevel()) {
			 ans = 10;
		} else if (level+10 < vic.getLevel()) {
			ans = 20;
		} else if (vic.getLevel()+10 < level) {
			ans = 1;
		} else {
			ans = 10 + (level - vic.getLevel());
		}
		exp += ans; 
		return ans;
	}
	public int getSpd() {
		int ans = speed;
		if (eqAcc) {
			ans += eqAcc.getSpd();
		}
		return ans;
	}
	public int getResist() {
		int ans = res;
		if (eqArmor) {
			ans = eqArmor.getResist();
		}
		if (eqHat) {
			ans = eqHat.getResist();
		}
		if (eqShield) {
			ans = eqShield.getResist();
		}
		return ans;
	}
	public Job getJob() {
		return job;
	}
	public boolean setJob(Job jb) {
	}
	public Weapon getWeap() {
		return eqWeapon;
	}
	public boolean setWeap(Weapon wpn) {
	}
	public Armor getArmor() {
		return eqArmor;
	}
	public boolean setArmor(Armor amr) {
	}
	public Headgear getHat() {
		return eqHat;
	}
	public boolean setHat(Headgear hg) {
	}
	public Accessory getAcc() {
		return eqAcc;
	}
	public boolean setAcc(Accessory acc) {
	}
	public ArrayList<AbilitySet> getSkills() {
		return skills;
	}
	public PasAbil getReact() {
		return reactAbil;
	}
	public boolean setReact(PasAbil pa) {
		if (pa.reactive) {
			for (AbilitySet i : skills) {
				if (i.contains(pa)) {
					if (pa.aquired()) {
						reactAbil = pa;
						return true;
					} else {
						if (eqWeapon.hasAbil(pa) || eqArmor.hasAbil(pa)) {
							reactAbil = pa;
						}
					}
				}
			}
		}
		return false;
		
	}
	public PasAbil getSupp() {
		return setSupp;
	}
	public boolean setSupp(PasAbil pa) {
	}
	public AbilitySet getPrimAbil() {
		return primAbil;
	}
	public boolean setPrimAbil(AbilitySet abil){
	}
	public AbilitySet getSecAbil() {
		return secAbil;
	}
	public boolean setSecAbil(AbilitySet abil){
	}
	public boolean levelUp() {
		exp -= 100;
		atk += ((job.getAtkF()*4)+9)/10;
		def += ((job.getDefF()*4)+9)/10;
		mgc += ((job.getMgcF()*4)+9)/10;
		Random r = new Random();
		if (r.getDouble() <= job.getSpdF()) {
			spd++;
		}
		maxHp = ((job.getHpF()*4)+9)/10;
		maxMp = ((job.getMpF()*4)+9)/10;
		res += ((job.getResF()*4)+9)/10;
		
	}

}