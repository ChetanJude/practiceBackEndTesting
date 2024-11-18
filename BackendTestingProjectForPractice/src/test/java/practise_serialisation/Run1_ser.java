package practise_serialisation;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NFSGame implements Serializable{
	String name;
	int level;
	long score;
	int life;
	
	public NFSGame(String name, int level, long score, int life) {
		super();
		this.name = name;
		this.level = level;
		this.score = score;
		this.life = life;
	}
	
}
public class Run1_ser {

	public static void main(String[] args) throws Throwable {

		NFSGame user1obj = new NFSGame("chandan", 15, 100000, 1);
		
		//inorder to save the data file
		FileOutputStream fos = new FileOutputStream("./f.txt");
		
		//to achieve serialization
	   ObjectOutputStream oos = new ObjectOutputStream(fos);
	   
	   oos.writeObject(user1obj);
	   System.out.println("======End======");
	}

}
