package app;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Ship kestrel = new Ship();
		Ship rebelFlagship = new Ship(20, 8, 2, 12, 0.15, false);
		ArrayList<Crew> federationCrew = new ArrayList<Crew>();
		ArrayList<Crew> rebelCrew = new ArrayList<Crew>();
		ArrayList<WeaponInt> kestrelWeapons = new ArrayList<WeaponInt>();
		ArrayList<WeaponInt> flagshipWeapons = new ArrayList<WeaponInt>();
		Scanner s = new Scanner(System.in);
		
		federationCrew.add(new Crew("Engi", 100, "Shields"));
		federationCrew.add(new Crew("Mantis", 100, "Weapons"));
		federationCrew.add(new Crew("Zoltan", 100, "Engines"));
		rebelCrew.add(new Crew("Alpha", 100, "Engines"));
		rebelCrew.add(new Crew("Bravo", 100, "Weapons"));
		rebelCrew.add(new Crew("Charlie", 100, "Shields"));
		rebelCrew.add(new Crew("Delta", 100, "Hull"));
		
		kestrelWeapons.add(new ProjectileWeapon("Burst Laser Mk. II ", 3, 1, 3, false, 0));
		kestrelWeapons.add(new ProjectileWeapon("Flak I ", 3, 1, 3, false, 0));
		kestrelWeapons.add(new BeamWeapon("Halberd Beam ", 4, 2, 1, 2));
		flagshipWeapons.add(new ProjectileWeapon("Boss Ion ", 3, 0, 3, false, 1));
		flagshipWeapons.add(new ProjectileWeapon("Boss Laser ", 3, 1, 3, false, 0));
		flagshipWeapons.add(new ProjectileWeapon("Boss Missile ", 4, 1, 3, true, 0));
		flagshipWeapons.add(new BeamWeapon("Boss Beam ", 4, 2, 1, 2));
		
		
		while (kestrel.getHull() > 0 && rebelFlagship.getHull() > 0 && federationCrew.isEmpty() == false) {
			
			kestrel.setEngines(kestrel.getEngines() + kestrel.getEnginesStun());
			kestrel.setWeapons(kestrel.getWeapons() + kestrel.getWeaponsStun());
			kestrel.setShields(kestrel.getShields() + kestrel.getShieldsStun());
			
			System.out.println("Your turn: Hull ~ " + kestrel.getHull() + ", Shields ~ " + kestrel.getShields() + ", Engines ~ " + kestrel.getEngines() + ", Weapons ~ " + kestrel.getWeapons() + ". Crew: " + federationCrew.toString());
			System.out.print("Ionized systems:");
			
			if (kestrel.getShieldsStun() > 0) System.out.print(" Shields Ion Level: " + kestrel.getShieldsStun());
			if (kestrel.getEnginesStun() > 0) System.out.print(" Engines Ion Level: " + kestrel.getEnginesStun());
			if (kestrel.getWeaponsStun() > 0) System.out.print(" Weapons Ion Level: " + kestrel.getWeaponsStun());
			System.out.println();
			System.out.println();
			
			System.out.println(kestrelWeapons.get(0).getName() + kestrelWeapons.get(0).getStatus());
			System.out.println(kestrelWeapons.get(1).getName() + kestrelWeapons.get(1).getStatus());
			System.out.println(kestrelWeapons.get(2).getName() + kestrelWeapons.get(2).getStatus());
			System.out.println();
			
			boolean check = true;
			
			while (check) {
				System.out.print("What would you like to do? (move, fire, finish) ");
				String response = s.nextLine();
				if (response.toLowerCase().equals("move")) {
					System.out.print("Which crew member? ");
					response = s.nextLine();
					for (Crew c : federationCrew) {
						if (c.getName().equals(response)) {
							System.out.println("Where would you like to move " + c.getName() + "? (Engines, Shields, Weapons, Hull) ");
							response = s.nextLine();
							if (response.toLowerCase().equals("shields")) {
								c.setPosition("Shields");
							} else if (response.toLowerCase().equals("engines")) {
								c.setPosition("Engines");
							} else if (response.toLowerCase().equals("weapons")) {
								c.setPosition("Weapons");
							} else if (response.toLowerCase().equals("hull")) {
								c.setPosition("Hull");
							} else {
								System.out.println("Invalid response.");
							}
							break;
						}
					}
				} else if (response.toLowerCase().equals("fire")) {
					System.out.print("Which weapon? (BL, FI, HB)");
					response = s.nextLine();
					WeaponInt selectedWeapon = null;
					if (response.toLowerCase().equals("bl") && kestrelWeapons.get(0).getChargeTime() == 0) {
						selectedWeapon = kestrelWeapons.get(0);
					} else if (response.toLowerCase().equals("fi") && kestrelWeapons.get(1).getChargeTime() == 0) {
						selectedWeapon = kestrelWeapons.get(1);
					} else if (response.toLowerCase().equals("hb") && kestrelWeapons.get(2).getChargeTime() == 0) {
						selectedWeapon = kestrelWeapons.get(2);
					} else {
						System.out.println("Invalid response.");
					}
					
					if (selectedWeapon != null) {
						System.out.print("Which room? (Engines, Shields, Weapons) ");
						response = s.nextLine();
						String target = null;
						if (response.toLowerCase().equals("engines")) {
							target = "engines";
						} else if (response.toLowerCase().equals("shields")) {
							target = "shields";
						} else if (response.toLowerCase().equals("weapons")) {
							target = "weapons";
						} else {
							System.out.println("Invalid response.");
						}
						
						if (target != null) {
							if (selectedWeapon.getChargeTime() == 0) {
								if (selectedWeapon instanceof ProjectileWeapon) {
									
									int shotsHit = 0;
									ProjectileWeapon w = (ProjectileWeapon) selectedWeapon;
									for (int i = 0; i < w.getShotsFired(); i++) {
										double miss = Math.random();
										if (miss > rebelFlagship.getDodgeChance()) shotsHit++;
									}
									
									if (rebelFlagship.getShieldBubbles() > 0) {
										rebelFlagship.setShieldBubbles(rebelFlagship.getShieldBubbles() - shotsHit);
										if (rebelFlagship.getShieldBubbles() < 0) {
											rebelFlagship.damageSystem(target, w.fire(Math.abs(rebelFlagship.getShieldBubbles())));
											rebelFlagship.dealDamage(w.fire(Math.abs(rebelFlagship.getShieldBubbles())));
											rebelFlagship.setShieldBubbles(0);
										} 
									} else {
										rebelFlagship.damageSystem(target, w.fire(shotsHit));
										rebelFlagship.dealDamage(w.fire(shotsHit));
									}
									
								} else {
									
									BeamWeapon w = (BeamWeapon) selectedWeapon;
									if (rebelFlagship.getShieldBubbles() == 0) {
										rebelFlagship.damageSystem(target, w.fire());
										rebelFlagship.dealDamage(w.fire());
									} else if (rebelFlagship.getShieldBubbles() == 1) {
										rebelFlagship.damageSystem(target, w.fire()/2);
										rebelFlagship.dealDamage(w.fire()/2);
									} else {
										w.setChargeTime(4);
										System.out.println("The beam failed to penetrate their shields");
									}
									
								}
							} else {
								System.out.println("Weapon is not ready to fire.");
							}
							
						}
						
				} 
				System.out.println();
			} else if (response.toLowerCase().equals("finish")) {
				check = false;
			} else {
				System.out.println("Invalid response.");
			}
			
			
		}
			
			//Repair systems based on crew locations
			for (Crew c : federationCrew) {
				if (c.getPosition().equals("shields")) {
			  		if (kestrel.getShields() < 6) kestrel.setShields(kestrel.getShields() + 1);
			  	} else if (c.getPosition().equals("weapons")) {
			  		if (kestrel.getWeapons() < 8) kestrel.setEngines(kestrel.getEngines() + 1);
			  	} else if (c.getPosition().equals("engines")) {
			  		if (kestrel.getEngines() < 5) kestrel.setWeapons(kestrel.getWeapons() + 1);
			  	}
			}
			
			//Apply ionization to system status calculations
			kestrel.setEngines(kestrel.getEngines() - kestrel.getEnginesStun());
			if (kestrel.getEngines() < 0) kestrel.setEngines(0);
			kestrel.setWeapons(kestrel.getWeapons() - kestrel.getWeaponsStun());
			if (kestrel.getWeapons() < 0) kestrel.setWeapons(0);
			kestrel.setShields(kestrel.getShields() - kestrel.getShieldsStun());
			if (kestrel.getShields() < 0) kestrel.setShields(0);
			
			//Charge weapons based on status
			if (kestrel.getWeapons() > 2) {
				kestrelWeapons.get(0).charge();	
			} else {
				kestrelWeapons.get(0).deCharge();
			}
			if (kestrel.getWeapons() > 4) {
				kestrelWeapons.get(1).charge();
			} else {
				kestrelWeapons.get(1).deCharge();
			}
			if (kestrel.getWeapons() == 8) {
				kestrelWeapons.get(2).charge();
			} else {
				kestrelWeapons.get(2).deCharge();
			}
			
			//Update ionization
			if (kestrel.getEnginesStun() > 0) kestrel.setEnginesStun(kestrel.getEnginesStun() - 1);
			if (kestrel.getShieldsStun() > 0) kestrel.setShieldsStun(kestrel.getShieldsStun() - 1);
			if (kestrel.getWeaponsStun() > 0) kestrel.setWeaponsStun(kestrel.getWeaponsStun() - 1);
			
			//Update shield bubbles and dodge chance for enemy turn
			kestrel.setShieldBubbles(kestrel.getShields()/2);
			kestrel.setDodgeChance();
			
			System.out.println();
			System.out.println("Enemy turn: Hull ~ " + rebelFlagship.getHull() + ", Shields ~ " + rebelFlagship.getShields() + ", Engines ~ " + rebelFlagship.getEngines() + ", Weapons ~ " + rebelFlagship.getWeapons() + ". Crew: " + rebelCrew.toString());
			for (WeaponInt w : flagshipWeapons) {
				
				if (w.getChargeTime() == 0) {
					String target;
					double t = Math.random();
					if (t < 0.3) {
						target = "engines";
					} else if (t < 0.6) {
						target = "shields";
					} else if (t < 0.9) {
						target = "weapons";
					} else {
						target = "hull";
					}
					
					if (w instanceof ProjectileWeapon) {
						
						int shotsHit = 0;
						ProjectileWeapon weapon = (ProjectileWeapon) w;
						
						for (int i = 0; i < weapon.getShotsFired(); i++) {
							double miss = Math.random();
							if (miss > kestrel.getDodgeChance()) shotsHit++;
						}
						
						if (kestrel.getShieldBubbles() > 0) {
							kestrel.setShieldBubbles(kestrel.getShieldBubbles() - shotsHit);
							if (kestrel.getShieldBubbles() < 0) {
								
								if (weapon.getName().contains("Ion")) {
									kestrel.stunSystem(target, shotsHit);
								} else {
									kestrel.damageSystem(target, weapon.fire(Math.abs(kestrel.getShieldBubbles())));
									kestrel.dealDamage(weapon.fire(Math.abs(kestrel.getShieldBubbles())));									
								}

								kestrel.setShieldBubbles(0);
							} 
						} else {
							kestrel.damageSystem(target, weapon.fire(shotsHit));
							kestrel.dealDamage(weapon.fire(shotsHit));
						}
						
					} else {
						
						BeamWeapon weapon = (BeamWeapon) w;
						if (kestrel.getShieldBubbles() == 0) {
							kestrel.damageSystem(target, weapon.fire());
							kestrel.dealDamage(weapon.fire());
						} else if (rebelFlagship.getShieldBubbles() == 1) {
							rebelFlagship.damageSystem(target, weapon.fire()/2);
							rebelFlagship.dealDamage(weapon.fire()/2);
						} else {
							weapon.setChargeTime(4);
						}
						
					}
					
				}
			}
			
			//Repair systems based on crew
			for (Crew c : rebelCrew) {
				if (c.getPosition().equals("shields")) {
			  		if (rebelFlagship.getShields() < 6) rebelFlagship.setShields(rebelFlagship.getShields() + 1);
			  	} else if (c.getPosition().equals("weapons")) {
			  		if (rebelFlagship.getWeapons() < 8) rebelFlagship.setEngines(rebelFlagship.getEngines() + 1);
			  	} else if (c.getPosition().equals("engines")) {
			  		if (rebelFlagship.getEngines() < 5) rebelFlagship.setWeapons(rebelFlagship.getWeapons() + 1);
			  	}
			}
			for (WeaponInt w : flagshipWeapons) {
				w.charge();
			}
			
			if (rebelFlagship.getWeapons() > 2) {
				flagshipWeapons.get(0).charge();	
			} else {
				flagshipWeapons.get(0).deCharge();
			}
			if (rebelFlagship.getWeapons() > 4) {
				flagshipWeapons.get(1).charge();
			} else {
				flagshipWeapons.get(1).deCharge();
			}
			if (rebelFlagship.getWeapons() == 8) {
				flagshipWeapons.get(2).charge();
			} else {
				flagshipWeapons.get(2).deCharge();
			}
			
			rebelFlagship.setShieldBubbles(rebelFlagship.getShields()/2);
			rebelFlagship.setDodgeChance();
			System.out.println();
			
			//Print more info (charge times, what systems were hit)
			//Clean up and make methods
			//Crew health decreases on hit
			
		}
		
		if (kestrel.getHull() <= 0) {
			System.out.println("One last explosion marks your fate as your ship is torn apart.");
		} else if (federationCrew.isEmpty()) {
			System.out.println("All crew members have died. Your ship will continue to drift for eternity, or until looters destroy it.");
		} else {
			System.out.println("Congratulations! You've defeated the Rebel Flagship and ensured the victory of the Federation!");
		}
		s.close();

	}
}
