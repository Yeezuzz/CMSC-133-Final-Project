package app;

import java.util.ArrayList;

public class Ship {
	
  private int hull, shield, engines, weapons, shieldBubbles, shieldsStun, enginesStun, weaponsStun;
  private double dodgeChance;
  private ArrayList<String> shipRooms = new ArrayList<String>();
  
  public Ship(int hull, int shield, int engines, int weapons, double dodgeChance, boolean Federation) {
    this.hull = hull;
    this.shield = shield;
    this.engines = engines;
    this.weapons = weapons;
    this.dodgeChance = dodgeChance;
    //shipRooms.add("engines");
    shipRooms.add("weapons");
    shipRooms.add("shields");
    shipRooms.add("hull");
    if (Federation) {
    	this.shieldBubbles = 3;
    } else {
    	this.shieldBubbles = 4;
    }
  }

  public Ship() {
    this(30, 6, 5, 7, 0.25, true);
  }

  public String dealDamage(int damage) {
    hull -= damage;
    if (hull < 0) hull = 0;
    return "Hull at " + hull;
  }

  public String damageSystem(String system, int damage) {
    
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

  public void setDodgeChance() {
    dodgeChance = engines * 0.05;
  }

  public int getHull() {
    return hull;
  }

  public int getShields() {
    return shield;
  }
  
  public void setShields(int shield) {
	  this.shield = shield;
  } 

  public int getEngines() {
    return engines;
  }
  
  public void setEngines(int engines) {
	  this.engines = engines;
  } 

  public int getEnginesStun() {
	  return enginesStun;
  }
  
  public int getShieldsStun() {
	  return shieldsStun;
  }
  
  public int getWeaponsStun() {
	  return weaponsStun;
  }
  
  public void setEnginesStun(int stun) {
	  enginesStun = stun;
  }
  
  public void setWeaponsStun(int stun) {
	  weaponsStun = stun;
  }
  
  public void setShieldsStun(int stun) {
	  shieldsStun = stun;
  }
  
  public void stunSystem(String system, int time) {
	  if (system.equals("engines")) {
		  enginesStun = time;
	  } else if (system.equals("shields")) {
		  shieldsStun = time;
	  } else {
		  weaponsStun = time;
	  }
  }

  public int getWeapons() {
    return weapons;
  }
  
  public void setWeapons(int weapons) {
	  this.weapons = weapons;
  }
  
  public int getShieldBubbles() {
	  return shieldBubbles;
  }
  
  public void setShieldBubbles(int shieldBubbles) {
	  this.shieldBubbles = shieldBubbles;
  }

  public double getDodgeChance() {
    return dodgeChance;
  }
  
}
