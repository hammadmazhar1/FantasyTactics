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
	int totalJP
	AbilitySet abilSet;
	Job(int typ) {
		if (typ == Stats.SOLDIER) {
			name = "Soldier";
			type = typ;
			intHP = Stats.HPSOlDIER;
			intMP = Stats.MPSOLDIER;
			intMove = 4;
			intSpd = Stats.SPDSOLDIER;
			intEvd = Stats.EVDSOLDIER;
		}
	}
}