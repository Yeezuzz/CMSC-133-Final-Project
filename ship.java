public class Ship {

  private int hull, shield, engines, weapons;
  private double dodgeChance;
  
  public Ship(int hull, int shield, int engines, int weapons, double dodgeChance) {
    this.hull = hull;
    this.shield = shield;
    this.engines = engines;
    this.weapons = weapons;
    this.double = dodgeChance;
  }

  public Ship() {
    this(30, 6, 5, 7, 0.25);
  }

  private String dealDamage(int damage) {
    hull -= damage;
    if (hull < 0) hull = 0;
    return "Hull at " + hull;
  }

  private String damageSystem(String system, int damage) {
    
    if (system.toLowerCase().equals("shield")) {
      shield -= damage;
      if (shield < 0) shield = 0;
      return "Shields hit for " + damage + " damage. Current level: " + shield;
    } else if (system.toLowerCase().equals("engines")) {
      engines -= damage;
      if (engines < 0) engines = 0;
      return "Engines hit for " + damage + " damage. Current level: " + engines;
    } else if (system.toLowerCase().equals("weapons")) {
      weapons -= damage;
      if (weapons < 0) weapons = 0;
      return "Weapons hit for " + damage + " damage. Current level: " + weapons;
    }
    return "";
    
  }

  public int setDodgeChance() {
    dodgeChance = engines * 0.05;
  }

  public int getHull() {
    return hull;
  }

  public int getShields() {
    return shields;
  }

  public int getEngines() {
    return engines;
  }

  public int getWeapons() {
    return weapons;
  }

  public int getDodgeChance() {
    return dodgeChance;
  }
  
}
