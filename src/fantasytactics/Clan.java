package fantasytactics;

import java.util.*;
import java.io.*;
public class Clan implements Serializable{
    String clanName;
    ArrayList<Member> members;
    int gold;
    ArrayList<Item> inventory;
    ArrayList<Mission> completed;
    Clan(String name) {
	clanName = name;
	members = new ArrayList<Member>();
	inventory = new ArrayList<Item>();
	gold = 5000;
        completed = new ArrayList<Mission>();
    }
    public boolean addMember(Member mem) {
        if (members.size() < 24) {
            members.add(mem);
            return true;
        } else {
            return false;
        }
    }
    public boolean remMember(Member mem) {
        if (members.size() > 1) {
            members.remove(mem);
            return true;
        } else {
            return false;
        }
    }
    public Member getMember(String name) {
        for (Member i: members) {
            if (i.getName().equals(name)) {
                return i;
            }
        }
        return null;
    }
    public ArrayList<Member> getClan() {
        return members;
    }

}