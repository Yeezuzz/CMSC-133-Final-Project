public class Crew {

  private String name;
  private int health;
  private String position
  
  public Crew(String name, int health, String position) {
    this.name = name;
    this.health = health;
    this.position = position;
  }
  
  public Crew() {
    this("Crew Member", 100, "Piloting");
  }

  /*
  public String move(String room) {
    Implement after Ship has been built
  }

  public int repairSystem() {
  
  }
  */

  
  
}
