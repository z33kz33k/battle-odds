package battleodds.units;

import battleodds.main.RegularUnit;

public class Sandworm extends RegularUnit {

	public Sandworm() {
		super(30, 3, "Sandworm", 129);
		setDesertTerrainAura(-5);
		setNoWall(true);
	}

}
