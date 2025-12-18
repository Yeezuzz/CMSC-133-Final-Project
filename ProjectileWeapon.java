package app;

public class ProjectileWeapon implements WeaponInt {
	private String name;
	private int chargeTime;
	private int damage;
	private int shotsFired;
	private boolean ignoresShield;
	private int stunTime;
	
	public ProjectileWeapon(String name, int chargeTime, int damage, int shotsFired, boolean ignoresShield, int stunTime) {
	  this.name = name;
	  this.chargeTime = chargeTime;
	  this.damage = damage;
	  this.shotsFired = shotsFired;
	  this.ignoresShield = ignoresShield;
	  this.stunTime = stunTime;
	  }
	
	  public ProjectileWeapon() {
	    this("Burst Laser Mk. II", 3, 1, 3, false, 0);
	  }
	
	  public int fire() {
		  if (name.contains("Missile")) {
			  chargeTime = 4;
		  } else {
			  chargeTime = 3;
		  }
		  return damage * shotsFired;
	  }
	  
	  public int fire(int shots) {
	    if (name.contains("Missile")) {
	    	chargeTime = 4;
	    } else if (name.contains("Ion")) {
	    	chargeTime = 3;
	    	return stunTime * shots;
	    }
	    chargeTime = 3;
	    return damage * shots;
	  }
	
	  public void charge() {
	    if (chargeTime > 0) chargeTime--;
	  }
	  
	  public void deCharge() {
		  if (name.contains("Missile")) {
			  if (chargeTime < 4) chargeTime++;
		  } else {
			  if (chargeTime < 3) chargeTime++;
		  }
	  }
	  
	  public void setChargeTime(int chargeTime) {
		  this.chargeTime = chargeTime;
	  }
	
	  public String getStatus() {
		if (chargeTime > 2) return "is not ready to fire";
	    if (chargeTime == 2) return "will be ready to fire in two turns"; 
	    if (chargeTime == 1) return "will be ready to fire next turn";
	    return "is ready to fire";
	  }
	  
	  public String getName() {
		  return name;
	  }
	  
	  public int getChargeTime() {
		  return chargeTime;
	  }
	  
	  public int getShotsFired() {
		  return shotsFired;
	  }
	  
	}
