package battleodds.units;

import battleodds.main.RegularUnit;

public class Catapult extends RegularUnit {

	public Catapult() {
		super(20, 3, "Catapult", 103);
		setAttackBonus(10);
		setSiege(10);
	}

}