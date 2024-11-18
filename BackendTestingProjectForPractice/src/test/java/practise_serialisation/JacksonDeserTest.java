package practise_serialisation;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonDeserTest {

	public static void main(String[] args) throws Throwable {
		ObjectMapper om = new ObjectMapper();
		
		//converting JSONObj to java obj
		Project pobj = om.readValue(new File("./project.json"), Project.class);
		
		System.out.println(pobj.getProjectname());
		System.out.println(pobj.getCreatedBy());
		System.out.println(pobj.getTeamSize());
		System.out.println(pobj.getStatus());
	}

}
