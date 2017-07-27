package battleodds.units;

import battleodds.main.RegularUnit;

public class Unicorn extends RegularUnit {

	public Unicorn() {
		super(30, 2, "Unicorn", 134);
		setNegateAura(3);
		setNegateTerrain(10);
	}

}
