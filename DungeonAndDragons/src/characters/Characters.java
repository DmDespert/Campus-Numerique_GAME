package characters;

abstract public class Characters {
	
	//Char name
	private String name;
	
	//Char Class
	private String classType;
	
	//Char default HP
	private int health;
	
	//Max char HP
	private int maxHealth;
	
	//Char start attack power
	private int minAP;
	
	//Char max attack power
	private int maxAP;

	//Constructor
	public Characters(String name, String classType, int health, int maxHealth, int minAP, int maxAP) {
		this.name = name;
		this.classType = classType;
		this.health = health;
		this.maxHealth = maxHealth;
		this.minAP = minAP;
		this.maxAP = maxAP;
	}
	
	//Commons functions
	public void walk() {
		
	}

	//Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getMinAP() {
		return minAP;
	}

	public void setMinAP(int minAP) {
		this.minAP = minAP;
	}

	public int getMaxAP() {
		return maxAP;
	}

	public void setMaxAP(int maxAP) {
		this.maxAP = maxAP;
	}

}