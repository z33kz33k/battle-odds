package battleodds.units;

import battleodds.main.RegularUnit;

public class Demon extends RegularUnit {

	public Demon() {
		super(25, 2, "Demon", 106);
		setSwarm(10);
		setSwarmCount(4);
		setFlyer(true);
	}

}
