package battleodds.units;

import battleodds.main.RegularUnit;

public class Ghost extends RegularUnit {

	public Ghost() {
		super(15, 2, "Ghost", 112);
		setAmbush(25);
		setGroupAmbush(8);
		setFlyer(true);
	}
}
