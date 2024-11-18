package practise_serialisation;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonPropertyOrder(
		value = {"createdBy",
				 "projectname",
				 "teamSize",
				 "status"}
		)
@JsonIgnoreProperties(
		value = {"status"}
		,allowSetters = true
				)
class Project{ //POJO class (Plain Old Java Object)
	private String projectname;
	@JsonProperty("created By")
	private String createdBy;
	private int teamSize;
	private String status;
	//public Project() {}
	public Project(String projectname, String createdBy, int teamSize, String status) {
		super();
		this.projectname = projectname;
		this.createdBy = createdBy;
		this.teamSize = teamSize;
		this.status = status;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
public class Run1_JacksonSerTest {

	public static void main(String[] args) throws Throwable {
		
		Project pobj = new Project("orange01", "chandan", 0, "Created");
		ObjectMapper om = new ObjectMapper();
		//converting java obj to JSON Obj
		om.writeValue(new File("./project.json"), pobj);
		System.out.println("======End======");
	}

}
