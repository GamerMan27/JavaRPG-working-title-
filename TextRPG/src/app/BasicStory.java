package app;
/* 
 * Designers		Contributions
 * Keith Davis 		Coding and main concepts
 * Sean Davis 		Design concepts and details
 *
 * This is a final project for CIS-165. It will be continued after class is over
 * in hopes of it becoming a fully fledged game. Demo goes as follows:
 *
 *
 * Basic story overview
 * 
 * _History_
 * Its year 3468. Humans have left Earth, after using Mercury to construct a dyson swarm and a stellar engine (kurzgesagt model)
 * Using this stellar drive, humans have moved their system out of the way of multiple previously undetected black holes and
 * supernovas, eventually exiting the milky way. As they went along, they colonized other systems and built similar dyson swarms, 
 * eventually creating a fleet of solar systems all heading towards the Andromeda Galaxy. As they got closer to Andromeda, they
 * started detecting signals that weren't static. Using advanced VIs (Virtual Intelligences, thanks Mass Effect) they were able to
 * analyze the signals and determine how to decode them. When they were decoded, they hear a sound they've never heard before. Analyzing the sound
 * reveals it was emitted at the same sound range as human hearing. As humanity got closer, they continue to analyze the signals, trying
 * to translate them. They continuously fail, yet they continue. After 10 Earth years of analyzing the signals, unidentified ships emerge from the galaxy, 
 * at about a 5000 AU (Astronomical Units) from the Vanguard Systems (Systems at the front of the fleet, designated so after the fleet left the Milky Way). 
 * High command starts to try to communicate with the fleet, hoping that the fleet isn't going to attack. Signals are continuously sent out, but no signal was returned.
 * As they get closer, Human High Command, located on Earth, orders the Vanguard Systems to prepare for contact, but not to fire unless ordered. 
 * As the unidentified ships closed in, finally a signal is returned. As command starts analyzing the signal, another fleet arrives and starts 
 * to fire at the first unidentified fleet. A war has begun. Command orders the Vanguard systems to defend the first unidentified fleet, leading to heavy 
 * losses but the successful defense of the convoy. After an ambassadorial mission to the unidentified fleet completes successfully, 
 * the species of the fleet identify themselves to Human High Command, and vice versa. They are called the Cobrik Resistance (rough approximation), and seem to be one of
 * the last convoys of their species. The other fleet was from the Kaarg Incursion. They had emerged from the Triangulum Galaxy around 500 Earth-years ago, and laid waste
 * to the Cobrik's vast galactic empire. Seeking refuge from the Kaarg, they bartered with the humans for access to some planets in their systems to settle, and in return
 * they shared their technology and knowledge of the Kaarg and might of their remaining military.
 * 
 * START DEMO
 * 
 * _Current Day/Pilot's Backstory_
 * 100 years later, Humanity has settled just inside Andromeda, in an unoccupied sector. Continuous communication with the Cobrik fleet has resulted in a Cobrik/Human alliance 
 * against the Kaarg growing into a joint government. You are a pilot in a Vanguard system, scrambled in defense of the first Kaarg invasion in 5 years. You are flying a standard 
 * Gregorian class fighter, with a fuel powered propulsion drive and small electric xenon propulsion drives installed above, below, at both sides, and in front of the cockpit. Your 
 * engine is powered by an Antares-class nuclear fusion reactor. You have 4 weapons, all miniaturized mass drivers using electromagnets to gather small dust particles, compress them 
 * into a rock, and fire them out of a railgun that is aimed by the computer. All you need to do is select a target and pull the trigger. Your fighter is also equpped with a 
 * standard plasma shield that is able to block energy weapon blasts and small particles usually found in space, but not larger projectiles usually favored in space battles. 
 * It also has a slight tracking distortion effect, usually only able to confound simple smart missile targeting systems. To dock and fire laser weapons, the shields need to be 
 * disabled. For that reason, laser weapons are mostly fitted onto capital ships engaging at long range, always with flak guns and fighter support.
 * 
 * As you fight in the battle, your ship becomes irreparably damaged. When you eject, an enemy ship grabs your lifeboat and brings you onboard the carrier. 
 * This is how became a prisoner.
 * 
 * _Chapter 1: Escape_
 * As your lifeboat is brought onto the carrier, you assess your options. After preparing, you hear the lifeboat impact the carrier floor. You didn't feel it, thanks to 
 * the shock absorbers built into the lifeboat. You take a breath, hold a pistol in your hand, and look outside with one of the multiple cameras lining the lifeboat.
 * At least 30 troops are stationed outside. You realize that if you exit fighting, you will be shot down. You press the "Fold" button on your gun, and it folds into a pendant without 
 * a necklace. You take off your dog tags and quickly thread the chain through the weapon. You run an atmosphere check to see if the air outside is breathable. The computer
 * says that it is. So, the Kaarg breathe a nitrogen oxygen mix similar to humans. You transmit the readings to High command, hoping that this new information will help
 * the Human/Cobrik alliance. Checking outside again, the group outside has doubled. With a renewed urgency, you start locking down the lifeboat and trigger a distress call, 
 * with the onboard VI starting to stream all camera footage to High command. You finally use the biolock to record your DNA, so that only you could restart the pod and unlock 
 * it. You quickly input the code (Player can input any code they want) and the lifeboat locks down. As you start to exit, you raise your hands in the air and surrender. A small 
 * team of 5 militants grab you, and bind your hands They then put a small bag over your head. They then take you to the prison.
 * 
 * In the prison, they strip you of your clothes and pendant. You are then run through what you can only hope is a decontamination shower, given your clothes back, and 
 * are shoved into a bright white cell with a camera like device with a red light in the corner of the ceiling. You check your pendant for damage, but it is locked up tight. 
 * You decide its too risky to open the pendant right now, where the Kaarg are surely watching. You start to search the cell, and find a loose panel on the wall. You use your 
 * dog tags to pry the panel off the wall. Inside the hole left behind are a mass of wires. Some of them start arcing, stop, and start again. You arn't sure if they are supposed 
 * to be doing that. Cautiously moving moving your hand, you unplug one wire. The light goes out at the top of your cell. You plug it back in, and try another non arcing wire. This one 
 * doesn't seem to do anything, until you look back at the camera. The red light is out. Working faster, you decide to use the unplugged video cable to unplug an arcing cable. Yanking hard, 
 * you manage to pull out the cable. Sparks start flying madly as the door clicks and starts to move. It gets halfway open and slams shut. It starts opening again and slams shut again.
 * You realize it is malfunctioning and you need to be fast to avoid getting smashed to red paste. Moving fast, you start to squeeze through when it is a quarter of the way open. 
 * You manage to squeeze out just as it reaches the halfway point, and slams shut again. 
 * 
 * Looking around, you notice you are inside a hallway. There is a light in the ceiling, that was flashing Yellow and Green. You unfold your pistol, and hold it at the ready.
 * You make your way down the hallway, and look around a corner. There is a single Kaarg soldier in front of you. You take aim, and fire at the Kaarg's head. The small metal fleck pierce's
 * the Kaarg's helmet, and it drops to the floor. Moving quickly, you search the body. On it, you find a keycard like device, a weapon, and some ammunition. You grab the weapon and 
 * ammunition, and try it out on a wall. It fires rapidly, in a figure 8 pattern. "Crowd control, probably." You say to yourself. With your new gear, you go through the winding corridors until
 * you reach a hangar. As you enter, you hug the wall and duck behind a metal box. Peering around it, you look around the hangar. Above you are solid catwalks, and you can see a Kaarg patrolling
 * above you. It doesn't look like he can see you. Looking around the rest of the hangar, you see some Kaarg in different uniform from the soldiers. "Probably workers. Every fleet
 * needs engineers." You whisper to yourself. "Now, where is a ship?" As you scan the rest of the hangar, you see your lifeboat. There arn't any workers nearby, and you think you can set
 * the self-destruct sequence for 90 seconds. More than enough time to grab a fighter and escape. As you input the sequence, you hear some inhuman screeching coming from the hallway you
 * entered the hangar from. Working faster, you finish inputting the self-destruct sequence and open a side compartment. Removing the device from the compartment, you sneak over to a fighter
 * and look for a hatch. Finding one on the bottom of the craft, you pop it open with the keycard-like device, and climb in. You shut the hatch, and look for a start control. Noticing
 * another slot the same size as the keycard, you insert it. Instantly the fighter starts up. Without panicing, you tug on the controls in front of you. Your craft starts to lift up, and you 
 * crash into another craft to the left. Testing out the controls, you get a good idea of the controls. A damage indicator on the craft's HUD pops up. The Kaarg are trying to shoot you down!
 * Pressing a button on a joystick, you fire the ship's weapons. Thinking fast, you drift to the left while firing the guns at the Kaarg Militants. Every shot causes a wave of energy that 
 * knocks the Kaarg on their backs. Eventually, you get to the opening of the hangar. Going forward, you fly out of the hangar and back into the battle.
 * 
 * 	As you approach the Human/Cobrik forces, you press the communications button on your survival pistol, opening a comm channel to the Earth Frequency. "Pilot [PLAYER NAME] 
 * inbound in a captured Thanatos Kaarg Fighter. Requesting immediate cover and escort to the nearest carrier! Repeat, Pilot [PLAYER NAME] inbound in a captured Thanatos Kaarg 
 * fighter! Please respond!" You scream into your survival pistol's microphone. 
 * 	After a second, you hear a response. "Reading you, [PLAYER NAME]. We thought we lost you. Your lifeboat just self-destructed. We have VI's analyzing the video footage now." 
 * says a comm analyst. 
 * 	"Great, but where do I dock?" You ask. "I'm in a captured Kaarg Fighter, and I don't want to be shot down by a friendly. Also, where's my fighter cover?"
 * 	"We're scrambling a team. They're picking off their last targets, and then coming to escort you. You want to head to the Concordia. We will do analysis and debrief there."
 * After a second, she asks another question. "Are you registering any damage?"
 * 	"Yeah, they shot at the craft as I exited the hangar. From the hologram on the HUD here, I think its damage to the engine or outer plating. I haven't had any issues
 * piloting, though." You respond.
 * 	"Can you engage the distress signal from your survival pistol?" the analyst asks. "It would be easier to pinpoint you that way."
 * 	"Roger. I'm heading to the Concordia." You reply. "Anything else before I end the comm?"
 * 	"Don't engage any Kaarg ships. Your primary objective is to reach the Concordia, no matter what. Is that clear?" responds the analyst.
 * 	"Orders accepted. Ending comm." You reply into the mic, before pressing the comm button again. Removing a panel on the grip of the pistol, you find the distress button and press it.
 * As you fly to the Concordia, you see the battle raging just a little bit aways. Your comrades fighting. Getting kills and suffering losses. You want to go help them, but 
 * continue on. Halfway through the flight, a squad of 6 Gregorians pull up next to your ship. They enter a circle formation, around his ship. Shortly after, a squad of Thanatos class
 * Kaarg fighters engage the Gregorians. They pull away, with two gregorians staying in formation with your ship. As you close in on the Concordia, all of a sudden the controls stop responding.
 * The Concordia grabbed the Thanatos with its tractor beam, and was towing it inside the hangar. Suddenly, the two Gregorians break off and you see a damage indicator light up.
 * You just took damage to the left wing of your fighter. You register two more hits before you are safely in the hangar.
 * 
 * END DEMO
 */