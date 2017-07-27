package battleodds.units;

import battleodds.main.RegularUnit;

public class Dwarf extends RegularUnit {

	public Dwarf() {
		super(15, 2, "Dwarf", 108);
		setAttackBonus(5);
		setHillTerrainBonus(10);
	}

}
