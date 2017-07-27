package battleodds.units;

import battleodds.main.Hero;

public class Barbarian extends Hero {

	public Barbarian() {
		super(30, 3, "Barbarian", 5);
		setNegateHeroism(1);
	}
}
