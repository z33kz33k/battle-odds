package battleodds.units;

import battleodds.main.RegularUnit;

public class Mammoth extends RegularUnit {

	public Mammoth() {
		super(15, 4, "Mammoth", 122);
		setDefenseBonus(20);
		setSnowTerrainAura(5);
	}

}
