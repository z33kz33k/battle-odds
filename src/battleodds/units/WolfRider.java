package battleodds.units;

import battleodds.main.RegularUnit;

public class WolfRider extends RegularUnit {

	public WolfRider() {
		super(20, 2, "Wolf Rider", 136);
		setAmbush(20);
		setForestTerrainAura(5);
		setSwampTerrainAura(5);
	}

}
