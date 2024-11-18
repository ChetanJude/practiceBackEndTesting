 package pojoclass.utility;

public class GitHubProjectPojo {

	String name;
	String description;
	
	public GitHubProjectPojo( ) {}

	public GitHubProjectPojo(String description) {
		super();
		this.description = description;
	}

	public GitHubProjectPojo(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	}
