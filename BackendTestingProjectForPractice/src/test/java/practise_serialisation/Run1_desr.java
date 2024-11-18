package practise_serialisation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

public class Run1_desr {

	public static void main(String[] args) throws Throwable {
		
		//inorder to access the binary data file
		FileInputStream fis = new FileInputStream("./f.txt");
		
		//to achieve Deserialization
		ObjectInputStream Ois = new ObjectInputStream(fis);
		
		//converting java obj into NFSGame
		NFSGame user1Obj =(NFSGame)Ois.readObject();
		
		System.out.println(user1Obj.name);
		System.out.println(user1Obj.life);
		System.out.println(user1Obj.score);
		System.out.println(user1Obj.level);
	}
}
