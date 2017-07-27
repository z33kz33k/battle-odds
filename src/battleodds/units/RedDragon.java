package battleodds.units;

import battleodds.main.RegularUnit;

public class RedDragon extends RegularUnit {

	public RedDragon() {
		super(40, 2, "Red Dragon", 128);
		setAura(10);
		setFlyer(true);
	}

}
