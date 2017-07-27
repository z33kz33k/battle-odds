package battleodds.units;

import battleodds.main.RegularUnit;

public class Pegasi extends RegularUnit {

	public Pegasi() {
		super(25, 2, "Pegasi", 126);
		setAura(5);
		setFlyer(true);
	}

}
