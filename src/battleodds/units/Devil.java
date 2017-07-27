package battleodds.units;

import battleodds.main.RegularUnit;

public class Devil extends RegularUnit {

	public Devil() {
		super(35, 2, "Devil", 107);
		setAura(-2);
		setNegateAura(8);
	}

}
