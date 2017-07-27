package battleodds.main;

/*
 * VERSION BREAKDOWN
 * 
 * 0.01 - Basic class & members layout.
 * 0.02 - Work on a general battle simulation mechanics and message printing. Classes: Battle, Simulation. Packaging layout. Unit classes and the Unit class inheritance tree.
 * 0.03 - Start of work on some specific stuff: implementing Terrain and Side (later renamed to Role) enums, first battle behaviours for armies (swarm, role and terrain bonuses).
 * 0.04 - Stack features for armies (wall & siege, morale & fear, negates, group ambush), situational bonuses added to battle mechanics (antiair, nowall).
 * 0.05 - Implementing some coding convention changes (delegating text-printing to separate classes, changing parameters naming convention), further polish (Terrain enum and terrain-based behaviours).
 * 0.06 - Improving the text-handling code (implementing a way to easily limit text output). 
 * 0.07 - Refactoring the code towards more OO: taking bonuses out of Unit class and its subclasses (Effect class and its subclasses).
 * 0.08 - Heroes features.
 * 0.10 - Start of GUI work [never actually happened]
 * 
*/

//TODO: check if it is good idea to make a seperate Round class

class Launcher {

	public static void main(String[] args) {
		Simulation s = new Simulation(1000, 1);
		s.simulate();
		System.exit(0);
	}
}
