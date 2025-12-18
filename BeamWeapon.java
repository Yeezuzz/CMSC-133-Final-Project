package app;

public class BeamWeapon implements WeaponInt {
	private String name;
	private int chargeTime;
	private int damage;
	private int shieldPenetration;
	private int roomsHit;
	  
	public BeamWeapon(String name, int chargeTime, int damage, int shieldPenetration, int roomsHit) {
	   this.name = name;
	   this.chargeTime = chargeTime;
	   this.damage = damage;
	   this.shieldPenetration = shieldPenetration;
	   this.roomsHit = roomsHit;
	}

	 
	 public int fire() {
		 chargeTime = 4;
		 return damage * roomsHit;
	 }
	 
	 public void charge() {
		 if (chargeTime > 0) chargeTime--;
	 }
	 
	 public void deCharge() {
		 if (chargeTime < 4) chargeTime++;
	 }
	 
	 public String getStatus() {
		 if (chargeTime > 1) return "is not ready to fire"; 
		 if (chargeTime > 0) return "will be ready to fire next turn";
		 return "is ready to fire";
	 }
	 
	 public String getName() {
		 return name;
	 }
	 
	 public int getChargeTime() {
		 return chargeTime;
	 }
	 
	 public void setChargeTime(int chargeTime) {
		 this.chargeTime = chargeTime;
	 }
	 
}
