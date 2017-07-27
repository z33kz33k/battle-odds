package battleodds.units;

import battleodds.main.RegularUnit;

public class BatteringRam extends RegularUnit {

	public BatteringRam() {
		super(20, 2, "Battering Ram", 102);
		setSiege(5);
	}
}