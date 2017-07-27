package battleodds.units;

import battleodds.main.Hero;

public class Assassin extends Hero {

	public Assassin() {
		super(25, 2, "Assassin", 4);
		setAmbush(20);
		setGroupAmbush(10);
		setCityTerrainHeroism(-1);
	}
}
