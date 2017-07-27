package battleodds.units;

import battleodds.main.RegularUnit;

public class Medusa extends RegularUnit {

	public Medusa() {
		super(25, 2, "Medusa", 123);
		setAura(-5);
		setAmbush(65);
	}

}
