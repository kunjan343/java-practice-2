public class Person {

	private int id;
	private String name;
	private String email;

// constructor 1
	public Person(int id, String name, String email) {
		setId(id);
		setName(name);
		setEmail(email);
	}


	// constructor 2
	public Person(String row) {
		String[] fiedls = row.split(",\\s*");

		setId(Integer.parseInt(fiedls[0]));
		setName(fiedls[1]);
		setEmail(fiedls[2]);
	}



	public void setName(String name) {
		this.name = name;
	}

	public void setId(int age) {
		this.id = age;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() { return name; }
	public int getId() { return id; }
	public String getEmail() { return email; }

}
