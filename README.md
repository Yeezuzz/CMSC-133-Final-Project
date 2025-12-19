# CMSC-133-Final-Project

I will be creating a text based recreation of the Rebel Flagship fight from FTL. The basic premise involves your ship fighting another ship. Each ship will take turns firing weapons and hitting systems. The first ship to have its hull reach 0 or have all its crew die loses [not implemented]. Each ship has systems of various levels. If these systems are damaged, they can partially or fully lose functionality. Shields block all non missile shots. Evasion dodges all non beam shots. If shields are down and a shot is not evaded, it will deal one damage to its targeted system and one damage to the hull.

# Instructions

Download project and run Main.java!

# Classes
Main ~ A driver that runs the game and shows the main menu. Handles the game state and all inputs from the player and the other classes.

Ship ~ Stores health, weapons, and systems. Weapons fire from one ship at another ship, crew move around and repair systems on a ship, and the first ship to stop existing loses. Manages damage, all subsystems, and tells weapons if they can fire. The most important class aside from Main!

Crew ~ Funny little guys that repair systems damage on ships. Very cool. Too bad they can't repair hull damage.

WeaponInt ~ An interface that BeamWeapon and ProjectileWeapon implement. Has a few basic methods to fire and charge the weapons.

ProjectileWeapon ~ Laser/Flak cannons, Missile launchers, and Ion weapons. Shoot things at a ship and hope they don't dodge. Also manages stun time.
BeamWeapon ~ Beam weapons. Fire a big blast and hope the other ship doesn't have its shields up. Also manages shield penetration.

# Features
Five minutes of gameplay!
Extremely inefficient code!
Terrible UI!
A pretty faithful remake of FTL if it was boring and not fun at all.

Several classes that work together to deliver a somewhat coherent experience, using many concepts learned in lecture?
Eh...

# What went wrong
The development process of this project was severely limited by my lack of understanding of what I was doing. Trying to sort my ideas out in a coherently designed system and getting all the classes to work together was a process. In my head, the Ship would just magically do everything, but trying to run everything in Main and have all these variables and cases juggling around was rather difficult.

This project ended up taking a lot more time than I envisioned. As a result, it's still not very clean and the crew health feature wasn't implemented (as well as the corresponding "win by crew death" scenario, and the fun realization that the Flagship would switch to being AI powered if you managed to kill all their crew... sigh...). I still believe I cranked out a suitable little demake, and feel proud of what I did. This was my first larger self directed project, after all.

I learned the importance of system design and planning things out, as well as considering ahead of time how classes will interact. If this was a group project, I would've been absolutely cooked. I will put more effort into designing before creating next time. At least I didn't start vibe coding? The mess is all mine!

# Other
Might put a demo video after dinner... maybe. If you see this assume I didn't. I swear it works on my end!!
