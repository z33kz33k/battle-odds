package battleodds.units;

import battleodds.main.RegularUnit;

public class GreatArchon extends RegularUnit {

	public GreatArchon() {
		super(35, 2, "Great Archon", 114);
		setNegateHeroism(16);
		setFlyer(true);
	}

}
