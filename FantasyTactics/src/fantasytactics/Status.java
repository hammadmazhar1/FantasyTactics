import java.util.*;
public interface Status {
	public int getAtk();
	public int getDef();
	public int getMove();
	public int getJmp();
	public int getMgc();
	public int getEvade();
	public int getSpd();
	public int getResist();
	public ArrayList<Integer> getProtects();
	public ArrayList<Integer> getEffects();
	public String getName();
}