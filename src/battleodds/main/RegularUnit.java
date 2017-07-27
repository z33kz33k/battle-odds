package battleodds.main;

public abstract class RegularUnit extends Unit {

	//role-based individual bonuses
	private int attackBonus, defenseBonus;
	//terrain-based individual bonuses
	private int openTerrainBonus, forestTerrainBonus, swampTerrainBonus, hillTerrainBonus, desertTerrainBonus,
			snowTerrainBonus, oceanTerrainBonus, cityTerrainBonus;
	//stack bonuses
	private int aura, openTerrainAura, forestTerrainAura, swampTerrainAura, hillTerrainAura, desertTerrainAura,
			snowTerrainAura, oceanTerrainAura, cityTerrainAura;
	//situational bonuses
	private int siege, swarm, swarmCount;
	//negating bonuses
	private int negateAura, negateTerrain;
	//special bonuses
	private boolean hasNoWall;

	public RegularUnit(int aStrength, int aHitPoints, String aName, int aID) {
		super(aStrength, aHitPoints, aName, aID);
	}

	//getters & setters for all 28 bonus fields
	public int getAttackBonus() {
		return attackBonus;
	}

	public void setAttackBonus(int attackBonus) {
		this.attackBonus = attackBonus;
	}

	public int getDefenseBonus() {
		return defenseBonus;
	}

	public void setDefenseBonus(int defenseBonus) {
		this.defenseBonus = defenseBonus;
	}

	public int getOpenTerrainBonus() {
		return openTerrainBonus;
	}

	public void setOpenTerrainBonus(int openTerrainBonus) {
		this.openTerrainBonus = openTerrainBonus;
	}

	public int getForestTerrainBonus() {
		return forestTerrainBonus;
	}

	public void setForestTerrainBonus(int forestTerrainBonus) {
		this.forestTerrainBonus = forestTerrainBonus;
	}

	public int getSwampTerrainBonus() {
		return swampTerrainBonus;
	}

	public void setSwampTerrainBonus(int swampTerrainBonus) {
		this.swampTerrainBonus = swampTerrainBonus;
	}

	public int getHillTerrainBonus() {
		return hillTerrainBonus;
	}

	public void setHillTerrainBonus(int hillTerrainBonus) {
		this.hillTerrainBonus = hillTerrainBonus;
	}

	public int getDesertTerrainBonus() {
		return desertTerrainBonus;
	}

	public void setDesertTerrainBonus(int desertTerrainBonus) {
		this.desertTerrainBonus = desertTerrainBonus;
	}

	public int getSnowTerrainBonus() {
		return snowTerrainBonus;
	}

	public void setSnowTerrainBonus(int snowTerrainBonus) {
		this.snowTerrainBonus = snowTerrainBonus;
	}

	public int getOceanTerrainBonus() {
		return oceanTerrainBonus;
	}

	public void setOceanTerrainBonus(int oceanTerrainBonus) {
		this.oceanTerrainBonus = oceanTerrainBonus;
	}

	public int getCityTerrainBonus() {
		return cityTerrainBonus;
	}

	public void setCityTerrainBonus(int cityTerrainBonus) {
		this.cityTerrainBonus = cityTerrainBonus;
	}

	public int getAura() {
		return aura;
	}

	public void setAura(int aura) {
		this.aura = aura;
	}

	public int getOpenTerrainAura() {
		return openTerrainAura;
	}

	public void setOpenTerrainAura(int openTerrainAura) {
		this.openTerrainAura = openTerrainAura;
	}

	public int getForestTerrainAura() {
		return forestTerrainAura;
	}

	public void setForestTerrainAura(int forestTerrainAura) {
		this.forestTerrainAura = forestTerrainAura;
	}

	public int getSwampTerrainAura() {
		return swampTerrainAura;
	}

	public void setSwampTerrainAura(int swampTerrainAura) {
		this.swampTerrainAura = swampTerrainAura;
	}

	public int getHillTerrainAura() {
		return hillTerrainAura;
	}

	public void setHillTerrainAura(int hillTerrainAura) {
		this.hillTerrainAura = hillTerrainAura;
	}

	public int getDesertTerrainAura() {
		return desertTerrainAura;
	}

	public void setDesertTerrainAura(int desertTerrainAura) {
		this.desertTerrainAura = desertTerrainAura;
	}

	public int getSnowTerrainAura() {
		return snowTerrainAura;
	}

	public void setSnowTerrainAura(int snowTerrainAura) {
		this.snowTerrainAura = snowTerrainAura;
	}

	public int getOceanTerrainAura() {
		return oceanTerrainAura;
	}

	public void setOceanTerrainAura(int oceanTerrainAura) {
		this.oceanTerrainAura = oceanTerrainAura;
	}

	public int getCityTerrainAura() {
		return cityTerrainAura;
	}

	public void setCityTerrainAura(int cityTerrainAura) {
		this.cityTerrainAura = cityTerrainAura;
	}

	public int getSiege() {
		return siege;
	}

	public void setSiege(int siege) {
		this.siege = siege;
	}

	public int getSwarm() {
		return swarm;
	}

	public void setSwarm(int swarm) {
		this.swarm = swarm;
	}

	public int getSwarmCount() {
		return swarmCount;
	}

	public void setSwarmCount(int swarmCount) {
		this.swarmCount = swarmCount;
	}

	public int getNegateAura() {
		return negateAura;
	}

	public void setNegateAura(int negateAura) {
		this.negateAura = negateAura;
	}

	public int getNegateTerrain() {
		return negateTerrain;
	}

	public void setNegateTerrain(int negateTerrain) {
		this.negateTerrain = negateTerrain;
	}

	public boolean hasNoWall() {
		return hasNoWall;
	}

	public void setNoWall(boolean hasNoWall) {
		this.hasNoWall = hasNoWall;
	}
}
