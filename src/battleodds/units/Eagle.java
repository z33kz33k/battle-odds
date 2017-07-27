package battleodds.units;

import battleodds.main.RegularUnit;

public class Eagle extends RegularUnit {

	public Eagle() {
		super(13, 2, "Eagle", 109);
		setAntiair(17);
		setFlyer(true);
	}

	public static Eagle createEagleVer08() {
		Eagle eagleVer08 = new Eagle();
		eagleVer08.setAntiair(22);
		return eagleVer08;
	}
}