package battleodds.units;

import battleodds.main.RegularUnit;

public class Kraken extends RegularUnit {

	public Kraken() {
		super(25, 3, "Kraken", 119);
		setAura(-2);
		setSwampTerrainAura(-4);
		setOceanTerrainAura(-8);
	}

}