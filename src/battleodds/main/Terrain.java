package battleodds.main;

enum Terrain {
	OPEN, FOREST, SWAMP, HILL, DESERT, SNOW, OCEAN, CITY0, CITY5(5), CITY10(10), CITY15(15), RAZED, OPEN_TOWER5(5), OPEN_TOWER10(
			10), OPEN_TOWER15(15), FOREST_TOWER5(5), FOREST_TOWER10(10), FOREST_TOWER15(15), SWAMP_TOWER5(5), SWAMP_TOWER10(
			10), SWAMP_TOWER15(15), HILL_TOWER5(5), HILL_TOWER10(10), HILL_TOWER15(15), DESERT_TOWER5(5), DESERT_TOWER10(
			10), DESERT_TOWER15(15), SNOW_TOWER5(5), SNOW_TOWER10(10), SNOW_TOWER15(15), OCEAN_TOWER5(5), OCEAN_TOWER10(
			10), OCEAN_TOWER15(15);

	private final int wallBonus;

	private Terrain() {
		wallBonus = 0;
	}

	private Terrain(int aWallDefense) {
		wallBonus = aWallDefense;
	}

	public int getWallBonus() {
		return wallBonus;
	}

	@Override
	public String toString() {
		//only capitalize the first letter
		String s = super.toString();
		return s.substring(0, 1) + s.substring(1).toLowerCase();
	}
}
