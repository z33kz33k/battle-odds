package battleodds.units;

import battleodds.main.RegularUnit;

public class Yeti extends RegularUnit {

	public Yeti() {
		super(20, 2, "Yeti", 138);
		setSnowTerrainBonus(15);
		setAura(-2);
	}
}