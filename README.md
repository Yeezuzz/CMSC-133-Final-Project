# CMSC-133-Final-Project

I will be creating a text based recreation of the Rebel Flagship fight from FTL. The basic premise involves your ship fighting another ship. Each ship will take turns firing weapons and hitting systems. The first ship to have its hull reach 0 or have all its crew die loses. Each ship has systems of various levels. If these systems are damaged, they can partially or fully lose functionality. Shields block all non missile shots. Evasion dodges all non beam shots. If shields are down and a shot is not evaded, it will deal one damage to its targeted system and one damage to the hull.

# Important

The project has changed slightly from the original plan. The code has been left uncleaned and is all over the place. There are duplicate methods and unused variables. This is because I genuinenly ran out of time to make this, and it was a lot harder to make than I thought. Oops.

# Information provided in game (you don't have to read this)

  As the AI captain of a Federation starship, you must direct your crew as they battle the Rebel Flagship. As you have no eyes, ears, or other senses, the  input from the terminal is all you can use to seize victory. Manage the ship, keep your crew alive, and destroy the Rebel Flagship to win!
  
  # More info:
  
  Laser weapons:
  The quintessential space combat armament! Both you and the Flagship sport burst laser cannons. They fire 3 shots that will break one shield bubble or do one system + hull damage to whatever they hit!
  
  Beam weapons:
  The most powerful weapon in your arsenal, a huge laser beam! Both you and the Flagship possess these formidable weapons. These weapons are capable of doing immense damage to systems and hull on hit, and can additionally pierce through one shield bubble to do half damage. Unfortunately, a ship with two or more shield bubbles will completely negate the beam's attack. Be careful!
  
  Missile launchers:
  The Flagship carries a missile launcher. This fires three missiles that ignore shields! Furthermore, the Flagship seems to be carrying a nearly infinite supply of ammunition! Pray that you dodge its shots.
  
  Flak cannons:
  Your unique weapon is a flak cannon! Functioning similarly to a laser weapon, it launches 3 pieces of scrap metal, tearing through one shield bubble and causing one system + hull damage on impact! Wait… it’s exactly the same as a laser weapon?
  
  Ion weapons:
  The Flagship also sports an ion weapon. This high tech device does no damage on hit, but instead creates an unrepairable electrical stun on any impacted system! The stun goes away over time, but can stack. Fortunately, ion shots “fizzle out” when hitting shield bubbles, simply removing one with no stun penalty. Additionally, they have no impact on the crew.
  
  # Tips:
  
  To prevent complete steamrolls, if a system is damaged and ionized, the total damage and ionization combined won’t exceed your system level – i.e. the system can’t be at 0 and ionized at the same time.
  
  While you would never go out of your way to hit nothing, the Flagship has a 10% chance of targeting no systems. If the attack hits, it only does hull damage. Crew might take damage.
  
  Hold your weapons at full charge to fire them in a coordinated salvo!
  
  Don’t worry about killing the crew on the Rebel Flagship. Trust me.
  
  It might be wise to temporarily pull crew out of systems if you know a big attack is coming. Count when the Flagship fires! This might backfire spectacularly though…
  
  It takes four points of damage to shut down the missile launcher! Keep this in mind!

  Keep in mind the enemy’s turn also counts as a turn! As long as you keep your weapon at the “ready to charge in two turns” state, you’ll have it at the next opportunity!

  Your weapons system has a “buffer” point! You only need 7 levels to power everything, but I gave you 8! Don’t say I never do anything for you.

  You can type in shorthand to move crew by just typing the first letter of the system. As long as you don’t get “invalid response” in return, it worked!
