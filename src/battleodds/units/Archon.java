package battleodds.units;

import battleodds.main.RegularUnit;

public class Archon extends RegularUnit {

	public Archon() {
		super(25, 2, "Archon", 101);
		setNegateHeroism(6);
		setFlyer(true);
	}

}
