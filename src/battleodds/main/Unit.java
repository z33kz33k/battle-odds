package battleodds.main;

public abstract class Unit {

	private final int id;
	private final String name;
	private int strength, hitPoints, ambush, groupAmbush;
	private Role role;

	private boolean isFlyer;
	private int antiair;

	private int negateHeroism;

	public Unit(int aStrength, int aHitPoints, String aName, int aID) {
		this.strength = aStrength;
		this.hitPoints = aHitPoints;
		this.name = aName;
		this.id = aID;
		this.role = Role.DEFENDER;
	}

	int rollAHitDie() {
		int hitRoll = (int) (100 * Math.random() + 1);
		return hitRoll;
	}

	public void addStrength(int aBonus) {
		strength += aBonus;
		// unit's strength has to be within 5-75 range
		if (strength > 75) {
			strength = 75;
		}
	}

	public void subtractStrength(int aDebuff) {
		strength -= aDebuff;
		// unit's strength has to be within 5-75 range
		if (strength < 5) {
			strength = 5;
		}
	}

	public void addAmbush(int aBonus) {
		ambush += aBonus;
	}

	protected void applyWound() {
		hitPoints -= 1;
	}

	protected void bless() {
		addStrength(5);
	}

	protected boolean isHero() {
		boolean isHero = false;
		if (getID() < 101) {
			isHero = true;
		}
		return isHero;
	}

	//getters & setters
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getID() {
		return id;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public String getName() {
		return name;
	}

	public int getAmbush() {
		return ambush;
	}

	public void setAmbush(int ambush) {
		this.ambush = ambush;
	}

	public int getGroupAmbush() {
		return groupAmbush;
	}

	public void setGroupAmbush(int groupAmbush) {
		this.groupAmbush = groupAmbush;
	}

	public boolean isFlyer() {
		return isFlyer;
	}

	public void setFlyer(boolean isFlyer) {
		this.isFlyer = isFlyer;
	}

	public int getAntiair() {
		return antiair;
	}

	public void setAntiair(int antiair) {
		this.antiair = antiair;
	}

	public int getNegateHeroism() {
		return negateHeroism;
	}

	public void setNegateHeroism(int negateHeroism) {
		this.negateHeroism = negateHeroism;
	}

}