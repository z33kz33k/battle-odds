package battleodds.units;

import battleodds.main.RegularUnit;

public class WoodElf extends RegularUnit {

	public WoodElf() {
		super(12, 2, "Wood Elf", 137);
		setForestTerrainBonus(10);
		setAntiair(10);
	}

}