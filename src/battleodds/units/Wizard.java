package battleodds.units;

import battleodds.main.RegularUnit;

public class Wizard extends RegularUnit {

	public Wizard() {
		super(25, 2, "Wizard", 135);
		setAntiair(15);
	}

}
