import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		Clan clan = new Clan("Gully");
		Member mem1 = new Member("Hammad", Stats.SOLDIER);
		Member mem2 = new Member("Asad",Stats.THIEF);
		clan.members.add(mem1);
		clan.members.add(mem2);
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream("Save.sav");
			out = new ObjectOutputStream(fos);
			out.writeObject(clan);
			out.close();
			System.out.println("Saved");
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Clan clan2 = null;
		try {
			fis = new FileInputStream("Save.sav");
			ois = new ObjectInputStream(fis);
			clan2 = (Clan)ois.readObject();
			ois.close();
			System.out.println("Loaded");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (clan2 != null) {
			System.out.println("Clan 1 Name: " + clan.clanName);
			System.out.println("Clan 2 Name: " + clan2.clanName);
			System.out.println("Member 1 Name: " + clan.members.get(0).getName());
			System.out.println("Member 1 Name: " + clan2.members.get(0).getName());
		}
	}
}