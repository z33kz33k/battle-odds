package battleodds.units;

import battleodds.main.RegularUnit;

public class Orc extends RegularUnit {

	public Orc() {
		super(10, 2, "Orc", 125);
		setSwampTerrainBonus(10);
		setAmbush(6);
	}
}
