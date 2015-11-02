package fantasytactics;

import java.util.*;
import java.io.*;
public class Member implements Status, Serializable {
	final private String name;
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
	private HashMap<Integer,Job> jobs;
	private Item eqWeapon;
	private Item eqShield;
	private Item eqArmor;
	private Item eqHat;
	private Item eqAcc;
	private AbilitySet primAbil;
	private AbilitySet secAbil;
	private Ability reactAbil;
	private Ability suppAbil;
	
	Member(String nm, int jb){
		level = 1;
		jobs = new HashMap<Integer,Job>();
		jobs.put(Stats.SOLDIER,new Job(Stats.SOLDIER));
		jobs.put(Stats.THIEF, new Job(Stats.THIEF));
		jobs.put(Stats.HEALER,new Job(Stats.HEALER));
		jobs.put(Stats.MAGE,new Job(Stats.MAGE));
		jobs.put(Stats.ARCHER,new Job(Stats.ARCHER));
		jobs.put(Stats.FIGHTER, new Job(Stats.FIGHTER));
		jobs.put(Stats.NINJA, new Job(Stats.NINJA));
		jobs.put(Stats.SEER, new Job(Stats.SEER));
		jobs.put(Stats.WIZARD, new Job(Stats.WIZARD));
		jobs.put(Stats.HUNTER, new Job(Stats.HUNTER));
		name = nm;
		job = jobs.get(jb);
		maxHp= job.intHP;
		maxMp = job.intMP;
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
		primAbil = job.abilSet;
		secAbil = null;
		reactAbil = null;
		suppAbil = null;
	}
	Member(Member chr) {
		level = chr.level;
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
		jobs = chr.jobs;
		primAbil = chr.primAbil;
		secAbil =chr.secAbil;
		reactAbil = chr.reactAbil;
		suppAbil = chr.suppAbil;
	
	}
	public int getmaxHp() {
		return maxHp;
	}
	public int getmaxMp() {
		return maxMp;
	}
	public int getLevel() {
		return level;
	}
	public int getAtk() {
            int ans = 0;
		if (eqWeapon != null) {
			ans = atk + eqWeapon.getAtk();
		} else {
			ans = atk + job.atkBon;
		}
                if (eqArmor != null) {
                    ans += eqArmor.getAtk();
                }
                if (eqHat != null) {
                    ans += eqHat.getAtk();
                }
                if (eqAcc != null) {
                    ans += eqAcc.getAtk();
                }
            return ans;
	}
	public int getDef() {
            int ans = def;
		if (eqArmor != null) {
			ans +=eqArmor.getDef();
                }
                if (eqHat != null) {
                    ans += eqHat.getDef();
                }
                if (eqAcc != null) {
                    ans += eqAcc.getAtk();
                }
            return ans;
	}
	public int getMove() {
            int ans = move;
		if (eqAcc != null) {
			ans += eqAcc.getMove();
		}
            return ans;
	}
	public int getJmp() {
		if (eqAcc != null ) {
                    
			return jmp + eqAcc.getJmp();
		} else {
			return jmp;
		}
	}
	public int getMgc() {
		int ans = mgc; 
		if (eqAcc != null) {
			ans += eqAcc.getMgc();
		}
                if (eqArmor != null) {
                    ans += eqArmor.getMgc();
                }
		if (eqWeapon != null) {
			ans += eqWeapon.getMgc();
		}
		return ans;
	}
        @Override
	public int getEvade() {
		int ans = evade;
		if (eqAcc != null) {
			ans+=eqAcc.getEvade();
		}
		if (eqArmor != null) {
			ans += eqArmor.getEvade();
		}
		if (eqHat != null) {
			ans += eqHat.getEvade();
		}
		if (eqShield != null) {
			ans+= eqShield.getEvade();
		}
		if (eqWeapon != null) {
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
        @Override
	public int getSpd() {
		int ans = spd;
		if (eqAcc != null) {
			ans += eqAcc.getSpd();
		}
		return ans;
	}
        @Override
	public int getResist() {
		int ans = res;
		if (eqArmor != null) {
			ans += eqArmor.getResist();
		}
		if (eqHat != null) {
			ans += eqHat.getResist();
		}
		if (eqShield != null) {
			ans += eqShield.getResist();
		}
		return ans;
	}
	public Job getJob() {
		return job;
	}
	public boolean setJob(Job jb) {
		for (PreReq i : jb.required) {
			if (jobs.get(i.typ).level < i.level) {
				return false;
			}
		}
		job = jb;
                job.avail = true;
		primAbil = job.abilSet;
		return true;
	}
	public Item getWeap() {
		return eqWeapon;
	}
	public boolean setWeap(Item wpn) {
		if (wpn.getType() == job.weapType) {
			eqWeapon = wpn;
			return true;
		}
		return false;
	}
	public boolean remWeap() {
		eqWeapon = null;
		return true;
	}
	public Item getArmor() {
		return eqArmor;
	}
	public boolean remArmor() {
		eqArmor = null;
		return true;
	}
	public boolean setArmor(Item amr) {
		if (amr.getType() == job.armorType) {
			eqArmor = amr;
			return true;
		}
		return false;
	}
	public Item getHat() {
		return eqHat;
	}
	public boolean setHat(Item hg) {
		if (hg.getType() == job.hatType) {
			eqHat = hg;
			return true;
		}
		return false;
	}
	public boolean remHat() {
		eqHat = null;
		return true;
	}
	public Item getAcc() {
		return eqAcc;
	}
	public boolean setAcc(Item acc) {
		if (acc.itemType == Stats.ACCESSORY) {
			eqAcc= acc;
			return true;
		}
		return false;
	}
	// public ArrayList<AbilitySet> getSkills() {
		// ArrayList<AbilitySet> skills = new ArrayList<AbilitySet>();
		// for (Job i : jobs) {
			// skills.add(i.abilSet);
		// }
		// return skills;
	// }
	public Ability getReact() {
		return reactAbil;
	}
	public boolean setReact(Ability pa) {
		if (pa.abilType == Stats.REACTIVE) {
			reactAbil = pa;
			return true;
		}
		return false;
		
	}
	public Ability getSupp() {
		return suppAbil;
	}
	public boolean setSupp(Ability pa) {
		if (pa.abilType == Stats.PASSIVE) {
			suppAbil = pa;
			return true;
		}
		return false;
	}
	public AbilitySet getPrimAbil() {
		return primAbil;
	}
	public boolean setPrimAbil(AbilitySet abil){
		if (job.abilSet.equals(abil)) {
			primAbil =abil;
			return true;
		}
		return false;
	}
	public AbilitySet getSecAbil() {
		return secAbil;
	}
	public boolean setSecAbil(AbilitySet abil){
		secAbil = abil;
		return true;
	}
	public boolean levelUp() {
		if (exp < 100) {
			return false;
		} else {
			exp -= 100;
			atk += ((job.AtkF)+9)/10;
			def += ((job.DefF)+9)/10;
			mgc += ((job.MgcF)+9)/10;
			Random r = new Random();
			if (r.nextDouble() <= job.SpdF) {
				if (spd <197){
					spd++;
				}
			}
			maxHp += ((job.HpF)+9)/10;
			maxMp += ((job.MpF)+9)/10;
			res += ((job.ResF)+9)/10;
			return true;
		}
	}
	public String getName() {
		return name;
	}
	public ArrayList<Integer> getEffects() {
		return null;
	}
	public ArrayList<Integer> getProtects() {
		return null;
	}
        public ArrayList<Ability> getreactAbils() {
            ArrayList<Ability> ans = new ArrayList<Ability>();
            for (Job j : jobs.values()) {
                for (Ability a : j.abilSet.abilities) {
                    if (a.abilType == Stats.REACTIVE) {
                        if (a.acquired) {
                            ans.add(a);
                        }
                    }
                }
            }
            return ans;
        }
        public ArrayList<Ability> getsuppAbils() {
            ArrayList<Ability> ans = new ArrayList<Ability>();
            for (Job j : jobs.values()) {
                for (Ability a : j.abilSet.abilities) {
                    if (a.abilType == Stats.PASSIVE) {
                        if (a.acquired) {
                            ans.add(a);
                        }
                    }
                }
            }
            return ans;
        }
        public ArrayList<AbilitySet> getAbilSets() {
            ArrayList<AbilitySet> ans = new ArrayList<AbilitySet>();
            for (Job j : jobs.values()) {
                if (j.avail) {
                   ans.add(j.abilSet);
                }
            }
            return ans;
        }

}