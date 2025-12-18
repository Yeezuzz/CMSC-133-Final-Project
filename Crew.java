package app;

public class Crew {
	private String name;
	  private int health;
	  private String position;
	  
	  public Crew(String name, int health, String position) {
	    this.name = name;
	    this.health = health;
	    this.position = position;
	  }
	  
	  public Crew() {
	    this("Crew Member", 100, "Engines");
	  }

	  
	  public String move(String room) {
	  	if (room.equals("shields") || room.equals("weapons") || room.equals("engines") || room.equals("hull")) {
	  		position = room;
	  		return name + " moved to " + room;
	  	} else {
	  		return "Invalid room specified.";
	  	}
	  }
	  
	  public String getName() {
		  return name;
	  }
	  
	  public String getPosition() {
		  return position;
	  }
	  
	  public void setPosition(String position) {
		  this.position = position;
	  }
	  
	  public String toString() {
		  return "Name: " + name + ", Health: " + health + ", Position: " + position + "; ";
	  }
	  
}
