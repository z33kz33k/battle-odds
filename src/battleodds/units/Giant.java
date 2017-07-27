package battleodds.units;

import battleodds.main.RegularUnit;

public class Giant extends RegularUnit {

	public Giant() {
		super(25, 2, "Giant", 113);
		setHillTerrainBonus(10);
	}

}