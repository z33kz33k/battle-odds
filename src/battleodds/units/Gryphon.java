package battleodds.units;

import battleodds.main.RegularUnit;

public class Gryphon extends RegularUnit {

	public Gryphon() {
		super(25, 2, "Gryphon", 116);
		setCityTerrainBonus(20);
		setFlyer(true);
	}

}
