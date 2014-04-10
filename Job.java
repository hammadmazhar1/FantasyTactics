public class Job {
	String name;
	int type;
	int intHp;
	int intMp;
	int intMove;
	int intSpd;
	int intJmp;
	int intEvd;
	int intAtk;
	int intDef;
	int intMgc;
	int intRes;
	int HpF;
	int MpF;
	int AtkF;
	int DefF;
	int MgcF;
	int ResF;
	int level;
	int curJP;
	int totalJP;
	AbilitySet abilSet;

	Job(int typ) {
		level = 1;
		curJP = 0;
		totalJP = 0;
		type = typ;
		abilSet = new AbilitySet(typ);
		switch (typ) {
			case Stats.SOLDIER:
				name = "Soldier";
				intHP = Stats.HPSOlDIER;
				intMP = Stats.MPSOLDIER;
				intMove = 4;
				intJmp = 2;
				intSpd = Stats.SPDSOLDIER;
				intEvd = Stats.EVDSOLDIER;
				intAtk = Stats.ATKSOLDIER;
				intDef = Stats.DEFSOLDIER;
				intMgc = Stats.MGCSOLDIER;
				intRes = Stats.RESSOLDIER;
				HpF = Stats.HPFSOLDIER;
				MpF = Stats.MPFSOLDIER;
				AtkF = Stats.ATKFSOLDIER;
				DefF = Stats.DEFFSOLDIER;
				MgcF = Stats.MGCFSOLDIER;
				ResF = Stats.RESFSOLDIER;
				break;
			case Stats.THIEF:
				name = "Thief";
				intHP = Stats.HPTHIEF;
				intMP = Stats.MPTHIEF;
				intMove = 5;
				intJmp = 
				intSpd = Stats.SPDTHIEF;
				intEvd = Stats.EVDTHIEF;
				intAtk = Stats.ATKTHIEF;
				intDef = Stats.DEFTHIEF;
				intMgc = Stats.MGCTHIEF;
				intRes = Stats.RESTHIEF;
				HpF = Stats.ATKFTHIEF;
				MpF = Stats.MPFTHIEF;
				AtkF = Stats.ATKFTHIEF;
				DefF = Stats.DEFTHIEF;
				MgcF = Stats.MGCFTHIEF;
				ResF = Stats.RESFTHIEF;
				break;
			case Stats.HEALER:
				name = "Healer";
				intHP = Stats.HPHEALER;
				intMP = Stats.MPHEALER;
				intMove = 4;
				intSpd = Stats.SPDHEALER;
				intEvd = Stats.EVDHEALER;
				intAtk = Stats.ATKHEALER;
				intDef = Stats.DEFHEALER;
				intMgc = Stats.MGCHEALER;
				intRes = Stats.RESHEALER;
				HpF = Stats.HPFHEALER;
				MpF = Stats.MPFHEALER;
				AtkF = Stats.ATKFHEALER;
				DefF = Stats.DEFFHEALER;
				MgcF = Stats.MGCFHEALER;
				ResF = Stats.RESFHEALER;
			case Stats.MAGE:
				name = "Mage";
				intHP = Stats.HPMAGE;
				intMP = Stats.MPMAGE;
		}
	}
}