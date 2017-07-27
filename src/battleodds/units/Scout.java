package battleodds.units;

import battleodds.main.RegularUnit;

public class Scout extends RegularUnit {

	public Scout() {
		super(5, 2, "Scout", 131);
		setAntiair(5);
	}

}