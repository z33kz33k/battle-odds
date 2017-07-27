package battleodds.main;

public abstract class Hero extends Unit {

	private int heroism, attackHeroism, defendHeroism, antiairHeroism, openTerrainHeroism, cityTerrainHeroism;

	public Hero(int aStrength, int aHitPoints, String aName, int aID) {
		super(aStrength, aHitPoints, aName, aID);
	}

	//getters & setters for all 4 bonus fields
	public int getHeroism() {
		return heroism;
	}

	public void setHeroism(int heroism) {
		this.heroism = heroism;
	}

	public int getAttackHeroism() {
		return attackHeroism;
	}

	public void setAttackHeroism(int attackHeroism) {
		this.attackHeroism = attackHeroism;
	}

	public int getDefendHeroism() {
		return defendHeroism;
	}

	public void setDefendHeroism(int defendHeroism) {
		this.defendHeroism = defendHeroism;
	}

	public int getAntiairHeroism() {
		return antiairHeroism;
	}

	public void setAntiairHeroism(int antiairHeroism) {
		this.antiairHeroism = antiairHeroism;
	}

	public int getOpenTerrainHeroism() {
		return openTerrainHeroism;
	}

	public void setOpenTerrainHeroism(int openTerrainHeroism) {
		this.openTerrainHeroism = openTerrainHeroism;
	}

	public int getCityTerrainHeroism() {
		return cityTerrainHeroism;
	}

	public void setCityTerrainHeroism(int cityTerrainHeroism) {
		this.cityTerrainHeroism = cityTerrainHeroism;
	}

}
