public class projectileWeapon {

  private String name;
  private double chargeTime;
  private int damage;
  private int shotsFired;
  private boolean ignoresShield;
  private int stunTime;

  public projectileWeapon(String name, double chargeTime, int damage, int shotsFired, boolean ignoresShield, int stunTime) {
    this.name = name;
    this.chargeTime = chargeTime;
    this.damage = damage;
    this.shotsFired = shotsFired;
    this.ignoresShield = ignoresShield;
    this.stunTime = stunTime;
  }

  public projectileWeapon() {
    this("Burst Laser Mk. II", 3.0, 1, 3, false, 0);
  }

  private int fire() {
    if (name.contains("Missile") || name.contains("Beam")) {
      chargeTime = 4.0
    } else {
      chargeTime = 3.0;
    }
    return damage * shotsFired;
  }

  private boolean charge() {
    if (chargeTime > 0) {
      chargeTime--;
      return true;
    } else {
      return false;
    }
  }

  public double getChargeTime() {
    return chargeTime;
  }

}
