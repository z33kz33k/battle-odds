package battleodds.units;

import battleodds.main.RegularUnit;

public class SeaSerpent extends RegularUnit {

	public SeaSerpent() {
		super(20, 2, "Sea Serpent", 132);
		setSwampTerrainBonus(10);
		setOceanTerrainBonus(10);
	}

}