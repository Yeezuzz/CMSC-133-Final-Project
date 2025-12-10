public class beamWeapon implements weapon {

  private String name;
  private double chargeTime;
  private int damage;
  private int roomsHit;
  
  public beamWeapon(String name, double chargeTime, int damage, int roomsHit) {
    this.name = name;
    this.chargeTime = chargeTime;
    this.damage = damage;
    this.roomsHit = roomsHit;
  }

  public int fire() {
  }
  
}
