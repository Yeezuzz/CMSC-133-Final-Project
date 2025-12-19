package app;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		boolean ck = true;
		
		while (ck) {
			System.out.println(" ______   ______   __            _____     ______     __    __     ______     __  __     ______    \n"
					+ "/\\  ___\\ /\\__  _\\ /\\ \\          /\\  __-.  /\\  ___\\   /\\ \"-./  \\   /\\  __ \\   /\\ \\/ /    /\\  ___\\   \n"
					+ "\\ \\  __\\ \\/_/\\ \\/ \\ \\ \\____     \\ \\ \\/\\ \\ \\ \\  __\\   \\ \\ \\-./\\ \\  \\ \\  __ \\  \\ \\  _\"-.  \\ \\  __\\   \n"
					+ " \\ \\_\\      \\ \\_\\  \\ \\_____\\     \\ \\____-  \\ \\_____\\  \\ \\_\\ \\ \\_\\  \\ \\_\\ \\_\\  \\ \\_\\ \\_\\  \\ \\_____\\ \n"
					+ "  \\/_/       \\/_/   \\/_____/      \\/____/   \\/_____/   \\/_/  \\/_/   \\/_/\\/_/   \\/_/\\/_/   \\/_____/ \n"
					+ "                                                                                                   ");
			System.out.println("As the AI captain of a Federation starship, you must direct your crew as they battle the Rebel Flagship. \nAs you have no eyes, ears, or other senses, the input from the terminal is all you can use to seize victory. \nManage the ship, keep your crew alive (not implemented lmao), and destroy the Rebel Flagship to win!");
			System.out.println();
			System.out.println("What would you like to do?");
			System.out.println("Play Game! (1)");
			System.out.println("More info! (2)");
			
			String r = s.nextLine();
			if (r.equals("2")) {
				while (ck) {
					System.out.println("Basic game info (1) or tips? (2) [3 to quit]");
					r = s.nextLine();
					if (r.equals("1")) {
						while (ck) {
							System.out.println();
							System.out.println("The goal of the game is to get the enemy's hull to 0 while keeping yours above 0. You have three systems to manage in addition: shields, engines, weapons.\nShields block most hits(one layer per 2 levels), engines give a chance to dodge almost all hits (5% per level), and weapons hit.\nIf systems are damaged, they work less efficiently or not at all. Use crew to repair them. Good luck!");
							System.out.println();
							System.out.println("Get info about weapons (1) or return to previous menu? (2)");
							r = s.nextLine();
							if (r.equals("1")) {
								System.out.println();
								System.out.println("Laser weapons, the quintessential space combat armament!\nFound on: Both ships. Damage: One shield bubble or hull point. Shots fired: 3");
								System.out.println();
								System.out.println("Beam weapons, the heaviest hitters!\nFound on: Both ships. Damage: Four hull points at no shields, two hull points at one shield layer. Shots fired: 1. Special conditions: Never misses");
								System.out.println();
								System.out.println("Flak cannons, your secret weapon!\nFound on: Your ship. Damage: One shield bubble or hull point. Shots fired: 3");
								System.out.println();
								System.out.println("Missile launchers, oppressive and intimidating!\nFound on: Enemy ship. Damage: One hull point. Shots fired: 3. Special conditions: Ignores shields.");
								System.out.println();
								System.out.println("Ion weapons, the weird one!\nFound on: Enemy ship. Damage: Zero. Shots fired: 3.\nSpecial conditions: Temporarily stuns systems, decreasing their level. Stun is irreparable, but goes away on its own. Stun is stackable!");
								System.out.println();
								System.out.println("Press enter to return to previous menu.");
								r = s.nextLine();
								break;
							} else if (r.equals("2")) {
								break;
							} else {
								System.out.println("Invalid response");
							}
						}
						
					} else if (r.equals("2")) {
						System.out.println();
						System.out.println("The Flagship has a 10% chance of targeting nothing! The resulting attack will only deal hull damage if it connects.");
						System.out.println();
						System.out.println("Hold your weapons at full charge until all are ready to fire them in a coordinated salvo! It's the only way to break their shields!");
						System.out.println();
						System.out.println("It takes four points of damage to shut down the missile launcher! Keep that in mind!");
						System.out.println();
						System.out.println("Your weapons system has a \"buffer\" point! If it takes only one point of damage, all weapons will keep charging!");
						System.out.println();
						System.out.println("You can type in shorthand to move your crew by typing the first letter of the system. Also, all inputs aren't case sensitive");
						System.out.println();
						System.out.println("The enemy's turn also counts as a turn! Don't forget that. Seriously.");
						System.out.println();
						System.out.println("Press enter to return to previous menu");
						System.out.println();
						r = s.nextLine();
					} else if (r.equals("3")) { 
						break;
					} else {
						System.out.println("Invalid response");
					}
				}
				ck = true;
			} else if (!(r.equals("1"))){
				System.out.println("Invalid response (you're gonna see this message a lot at this rate)");
			} else {
				ck = false;
			}
		}
		
		//Global variables
		System.out.println("Thanks to Subset Games and patorjk's text to ASCII art generator!");
		System.out.println("**************************************************");
		Ship kestrel = new Ship();
		Ship rebelFlagship = new Ship(20, 8, 2, 12, 0.15, false);
		ArrayList<Crew> federationCrew = new ArrayList<Crew>();
		ArrayList<Crew> rebelCrew = new ArrayList<Crew>();
		ArrayList<WeaponInt> kestrelWeapons = new ArrayList<WeaponInt>();
		ArrayList<WeaponInt> flagshipWeapons = new ArrayList<WeaponInt>();
		
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
		
		//Game handler
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
			//Player turn
			while (check) {
				System.out.print("What would you like to do? (move, fire, finish) ");
				String response = s.nextLine();
				if (response.toLowerCase().equals("move")) {
					System.out.print("Which crew member? ");
					response = s.nextLine();
					for (Crew c : federationCrew) {
						if (c.getName().toLowerCase().equals(response.toLowerCase())) {
							System.out.println("Where would you like to move " + c.getName() + "? (Engines, Shields, Weapons, Hull) ");
							response = s.nextLine();
							if (response.toLowerCase().equals("shields") || response.toLowerCase().equals("s")) {
								c.setPosition("Shields");
							} else if (response.toLowerCase().equals("engines") || response.toLowerCase().equals("e")) {
								c.setPosition("Engines");
							} else if (response.toLowerCase().equals("weapons") || response.toLowerCase().equals("w")) {
								c.setPosition("Weapons");
							} else if (response.toLowerCase().equals("hull") || response.toLowerCase().equals("h")) {
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
											System.out.println("Enemy " + rebelFlagship.damageSystem(target, w.fire(Math.abs(rebelFlagship.getShieldBubbles()))));
											System.out.println("Enemy " + rebelFlagship.dealDamage(w.fire(Math.abs(rebelFlagship.getShieldBubbles()))));
											rebelFlagship.setShieldBubbles(0);
										} else {
											w.fire();
											System.out.println("Enemy shields at " + rebelFlagship.getShieldBubbles() + " strength.");
										} 
									} else {
										System.out.println("Enemy " + rebelFlagship.damageSystem(target, w.fire(shotsHit)));
										System.out.println("Enemy " + rebelFlagship.dealDamage(w.fire(shotsHit)));
									}
									
								} else {
									
									BeamWeapon w = (BeamWeapon) selectedWeapon;
									if (rebelFlagship.getShieldBubbles() == 0) {
										System.out.println("Enemy " + rebelFlagship.damageSystem(target, w.fire()));
										System.out.println("Enemy " + rebelFlagship.dealDamage(w.fire()));
									} else if (rebelFlagship.getShieldBubbles() == 1) {
										System.out.println("Enemy " + rebelFlagship.damageSystem(target, w.fire()/2));
										System.out.println("Enemy " + rebelFlagship.dealDamage(w.fire()/2));
									} else {
										w.setChargeTime(4);
										System.out.println("The beam failed to penetrate their shields.");
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
				if (c.getPosition().equals("Shields")) {
			  		if (kestrel.getShields() < 6) kestrel.setShields(kestrel.getShields() + 1);
			  	} else if (c.getPosition().equals("Weapons")) {
			  		if (kestrel.getWeapons() < 8) kestrel.setWeapons(kestrel.getWeapons() + 1);
			  	} else if (c.getPosition().equals("Engines")) {
			  		if (kestrel.getEngines() < 5) kestrel.setEngines(kestrel.getEngines() + 1);
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
			
			//Repair systems based on crew
			for (Crew c : rebelCrew) {
				if (c.getPosition().equals("Shields")) {
			  		if (rebelFlagship.getShields() < 8) rebelFlagship.setShields(rebelFlagship.getShields() + 1);
			  	} else if (c.getPosition().equals("Weapons")) {
			  		if (rebelFlagship.getWeapons() < 12) rebelFlagship.setWeapons(rebelFlagship.getWeapons() + 1);
			  	} else if (c.getPosition().equals("Engines")) {
			  		if (rebelFlagship.getEngines() < 2) rebelFlagship.setEngines(rebelFlagship.getEngines() + 1);
			  	}
			}
			
			if (rebelFlagship.getWeapons() > 2) {
				flagshipWeapons.get(0).charge();	
			} else {
				flagshipWeapons.get(0).deCharge();
			}
			if (rebelFlagship.getWeapons() > 5) {
				flagshipWeapons.get(1).charge();
			} else {
				flagshipWeapons.get(1).deCharge();
			}
			if (rebelFlagship.getWeapons() > 8) {
				flagshipWeapons.get(2).charge();
			} else {
				flagshipWeapons.get(2).deCharge();
			}
			if (rebelFlagship.getWeapons() == 12) {
				flagshipWeapons.get(3).charge();
			} else {
				flagshipWeapons.get(3).deCharge();
			}
			
			rebelFlagship.setShieldBubbles(rebelFlagship.getShields()/2);
			rebelFlagship.setDodgeChance();
			System.out.println("**************************************************");
			//Enemy turn
			System.out.println("Enemy turn: Hull ~ " + rebelFlagship.getHull() + ", Shields ~ " + rebelFlagship.getShields() + ", Engines ~ " + rebelFlagship.getEngines() + ", Weapons ~ " + rebelFlagship.getWeapons() + ". Crew: [???]");
			System.out.println();
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
					
					System.out.print(w.getName() + "firing! ");
					
					if (w instanceof ProjectileWeapon) {
						
						int shotsHit = 0;
						ProjectileWeapon weapon = (ProjectileWeapon) w;
						
						for (int i = 0; i < weapon.getShotsFired(); i++) {
							double miss = Math.random();
							if (miss > kestrel.getDodgeChance()) shotsHit++;
						}
						
						if (kestrel.getShieldBubbles() > 0 && !(w.getName().contains("Missile"))) {
							kestrel.setShieldBubbles(kestrel.getShieldBubbles() - shotsHit);
							if (kestrel.getShieldBubbles() < 0) {
								
								if (weapon.getName().contains("Ion")) {
									kestrel.stunSystem(target, shotsHit);
									weapon.setChargeTime(3);
									System.out.println(target + " stunned for " + shotsHit + " turns.");
								} else {
									System.out.println("Our " + kestrel.damageSystem(target, weapon.fire(Math.abs(kestrel.getShieldBubbles()))));
									System.out.println("Our " + kestrel.dealDamage(weapon.fire(Math.abs(kestrel.getShieldBubbles()))));									
								}

								kestrel.setShieldBubbles(0);
							} else {
								System.out.println("Our shields at " + kestrel.getShieldBubbles() + " strength.");
								weapon.setChargeTime(3);
							} 
						} else {
							System.out.println("Our " + kestrel.damageSystem(target, weapon.fire(shotsHit)));
							System.out.println("Our " + kestrel.dealDamage(weapon.fire(shotsHit)));
						}
						
					} else {
						
						BeamWeapon weapon = (BeamWeapon) w;
						if (kestrel.getShieldBubbles() == 0) {
							System.out.println("Our " + kestrel.damageSystem(target, weapon.fire()));
							System.out.println("Our " + kestrel.dealDamage(weapon.fire()));
						} else if (kestrel.getShieldBubbles() == 1) {
							System.out.println("Our " + kestrel.damageSystem(target, weapon.fire()/2));
							System.out.println("Our " + kestrel.dealDamage(weapon.fire()/2));
						} else {
							weapon.setChargeTime(4);
							System.out.println("The beam failed to penetrate our shields!");
						}
						
					}
					
				}
			}
			
			//Repair systems based on crew
			for (Crew c : rebelCrew) {
				if (c.getPosition().equals("Shields")) {
			  		if (rebelFlagship.getShields() < 8) rebelFlagship.setShields(rebelFlagship.getShields() + 1);
			  	} else if (c.getPosition().equals("Weapons")) {
			  		if (rebelFlagship.getWeapons() < 12) rebelFlagship.setWeapons(rebelFlagship.getWeapons() + 1);
			  	} else if (c.getPosition().equals("Engines")) {
			  		if (rebelFlagship.getEngines() < 2) rebelFlagship.setEngines(rebelFlagship.getEngines() + 1);
			  	}
			}
			
			if (rebelFlagship.getWeapons() > 2) {
				flagshipWeapons.get(0).charge();	
			} else {
				flagshipWeapons.get(0).deCharge();
			}
			if (rebelFlagship.getWeapons() > 5) {
				flagshipWeapons.get(1).charge();
			} else {
				flagshipWeapons.get(1).deCharge();
			}
			if (rebelFlagship.getWeapons() > 8) {
				flagshipWeapons.get(2).charge();
			} else {
				flagshipWeapons.get(2).deCharge();
			}
			if (rebelFlagship.getWeapons() == 12) {
				flagshipWeapons.get(3).charge();
			} else {
				flagshipWeapons.get(3).deCharge();
			}
			
			rebelFlagship.setShieldBubbles(rebelFlagship.getShields()/2);
			rebelFlagship.setDodgeChance();
			
			//Repair systems based on crew locations
			for (Crew c : federationCrew) {
				if (c.getPosition().equals("Shields")) {
			  		if (kestrel.getShields() < 6) kestrel.setShields(kestrel.getShields() + 1);
			  	} else if (c.getPosition().equals("Weapons")) {
			  		if (kestrel.getWeapons() < 8) kestrel.setWeapons(kestrel.getWeapons() + 1);
			  	} else if (c.getPosition().equals("Engines")) {
			  		if (kestrel.getEngines() < 5) kestrel.setEngines(kestrel.getEngines() + 1);
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
			
			kestrel.setShieldBubbles(kestrel.getShields()/2);
			kestrel.setDodgeChance();
			System.out.println("**************************************************");

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
		//Under 500 lines! Nice!!! All glory to me!
	}
}
