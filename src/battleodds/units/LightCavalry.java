package battleodds.units;

import battleodds.main.RegularUnit;

public class LightCavalry extends RegularUnit {

	public LightCavalry() {
		super(10, 2, "Light Cavalry", 120);
		setOpenTerrainBonus(8);
	}
}