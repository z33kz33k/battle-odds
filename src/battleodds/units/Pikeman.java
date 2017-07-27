package battleodds.units;

import battleodds.main.RegularUnit;

public class Pikeman extends RegularUnit {

	public Pikeman() {
		super(15, 2, "Pikeman", 127);
		setOpenTerrainBonus(10);
	}

}