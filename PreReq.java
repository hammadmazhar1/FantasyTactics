import java.io.*;
public class PreReq implements Serializable{
	int typ;
	int level;
	PreReq() {
		typ = 0;
		level = 1;
	}
	PreReq(int t, int levl) {
		typ = t;
		level = levl;
	}
}