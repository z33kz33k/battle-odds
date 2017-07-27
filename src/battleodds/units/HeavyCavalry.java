package battleodds.units;

import battleodds.main.RegularUnit;

public class HeavyCavalry extends RegularUnit {

	public HeavyCavalry() {
		super(25, 2, "Heavy Cavalry", 117);
		setOpenTerrainBonus(10);
		setDesertTerrainBonus(10);
		setSnowTerrainBonus(5);
	}
}