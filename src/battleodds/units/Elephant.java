package battleodds.units;

import battleodds.main.RegularUnit;

public class Elephant extends RegularUnit {

	public Elephant() {
		super(30, 2, "Elephant", 111);
		setOpenTerrainAura(12);
		setDesertTerrainAura(12);
	}

}
