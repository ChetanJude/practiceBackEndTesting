package practise_serialisation;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Project01 {

	   String projectName;
	   String projectStatus;
	   int teamSize;
	   List<String> teamMember;
	   ProjectManager projectManager;


	    public Project01(String projectName, String projectStatus, int teamSize, List<String> teamMember,
			ProjectManager projectManager) {
		super();
		this.projectName = projectName;
		this.projectStatus = projectStatus;
		this.teamSize = teamSize;
		this.teamMember = teamMember;
		this.projectManager = projectManager;
	}
		public void setProjectName(String projectName) {
	        this.projectName = projectName;
	    }
	    public String getProjectName() {
	        return projectName;
	    }
	    
	    public void setProjectStatus(String projectStatus) {
	        this.projectStatus = projectStatus;
	    }
	    public String getProjectStatus() {
	        return projectStatus;
	    }
	    
	    public void setTeamSize(int teamSize) {
	        this.teamSize = teamSize;
	    }
	    public int getTeamSize() {
	        return teamSize;
	    }
	    
	    public void setTeamMember(List<String> teamMember) {
	        this.teamMember = teamMember;
	    }
	    public List<String> getTeamMember() {
	        return teamMember;
	    }
	    
	    public void setProjectManager(ProjectManager projectManager) {
	        this.projectManager = projectManager;
	    }
	    public ProjectManager getProjectManager() {
	        return projectManager;
	    }
	    
	}

 class ProjectManager {

	   String name;
	   String id;

	    public ProjectManager(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
		public void setName(String name) {
	        this.name = name;
	    }
	    public String getName() {
	        return name;
	    }
	    
	    public void setId(String id) {
	        this.id = id;
	    }
	    public String getId() {
	        return id;
	    }
	    
	}
public class PojoClass {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		List<String> lst= new ArrayList<String>();
		lst.add("john");
		lst.add("devid");
		lst.add("steve");
		
		ProjectManager pm = new ProjectManager("chn", "tp01");
		
		Project01 pobj = new Project01("omg", "Created", 10, lst, pm);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(new File("./Project01.son"), pobj);
	}
}
