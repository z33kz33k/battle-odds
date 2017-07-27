package battleodds.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Army {

	private int capacity;
	private List<Unit> units;

	private int effectiveWallBonus; //value of this field is needed by class Battle for taking into account a NoWall ability of some units.

	public Army() {
		units = new LinkedList<Unit>();
		setCapacity(32);
	}

	public Army(Unit firstUnit) {
		units = new LinkedList<Unit>();
		units.add(firstUnit);
	}

	public Army(Unit firstUnit, Unit secondUnit) {
		units = new LinkedList<Unit>();
		units.add(firstUnit);
		units.add(secondUnit);
	}

	public Army(Unit firstUnit, Unit secondUnit, Unit thirdUnit) {
		units = new LinkedList<Unit>();
		units.add(firstUnit);
		units.add(secondUnit);
		units.add(thirdUnit);
	}

	public Army(Unit firstUnit, Unit secondUnit, Unit thirdUnit, Unit fourthUnit) {
		units = new LinkedList<Unit>();
		units.add(firstUnit);
		units.add(secondUnit);
		units.add(thirdUnit);
		units.add(fourthUnit);
	}

	public Army(Unit firstUnit, Unit secondUnit, Unit thirdUnit, Unit fourthUnit, Unit fifthUnit) {
		units = new LinkedList<Unit>();
		units.add(firstUnit);
		units.add(secondUnit);
		units.add(thirdUnit);
		units.add(fourthUnit);
		units.add(fifthUnit);
	}

	public Army(Unit firstUnit, Unit secondUnit, Unit thirdUnit, Unit fourthUnit, Unit fifthUnit, Unit sixthUnit) {
		units = new LinkedList<Unit>();
		units.add(firstUnit);
		units.add(secondUnit);
		units.add(thirdUnit);
		units.add(fourthUnit);
		units.add(fifthUnit);
		units.add(sixthUnit);
	}

	public Army(Unit firstUnit, Unit secondUnit, Unit thirdUnit, Unit fourthUnit, Unit fifthUnit, Unit sixthUnit,
			Unit seventhUnit) {
		units = new LinkedList<Unit>();
		units.add(firstUnit);
		units.add(secondUnit);
		units.add(thirdUnit);
		units.add(fourthUnit);
		units.add(fifthUnit);
		units.add(sixthUnit);
		units.add(seventhUnit);
	}

	public Army(Unit firstUnit, Unit secondUnit, Unit thirdUnit, Unit fourthUnit, Unit fifthUnit, Unit sixthUnit,
			Unit seventhUnit, Unit eighthUnit) {
		units = new LinkedList<Unit>();
		units.add(firstUnit);
		units.add(secondUnit);
		units.add(thirdUnit);
		units.add(fourthUnit);
		units.add(fifthUnit);
		units.add(sixthUnit);
		units.add(seventhUnit);
		units.add(eighthUnit);
	}

	void addUnit(Unit aUnit) {
		if (units.size() < capacity) {
			units.add(aUnit);
		}
	}

	void addGlobalStrength(int aGlobalBonus) {
		for (Unit u : units) {
			u.addStrength(aGlobalBonus);
		}
	}

	Unit getUnitAt(int aIndex) {
		Unit unit = null;
		for (int i = 0; i < units.size(); i++) {
			if (i == aIndex) {
				unit = units.get(i);
			}
		}
		return unit;
	}

	void blessUnitAt(int aIndex) {
		for (int i = 0; i < units.size(); i++) {
			if (i == aIndex) {
				units.get(i).bless();
			}
		}
	}

	void blessUnitsAt(int... aIndexes) {
		for (int i = 0; i < aIndexes.length; i++) {
			for (int j = 0; j < units.size(); j++) {
				if (aIndexes[i] == j) {
					units.get(j).bless();
				}
			}
		}
	}

	//methods distributing individual bonuses
	void distributeTerrainBonuses(Terrain aBattleTerrain, Army aOpponent) {
		int opponentsNegateTerrain = aOpponent.determineNegateTerrain();

		switch (aBattleTerrain) {
			case OPEN:
			case OPEN_TOWER5:
			case OPEN_TOWER10:
			case OPEN_TOWER15:
				for (Unit u : units) {
					if (!u.isHero()) {
						RegularUnit ru = (RegularUnit) u;
						int bonusToAdd = ru.getOpenTerrainBonus() - opponentsNegateTerrain;
						if (bonusToAdd > 0) {
							ru.addStrength(bonusToAdd);
						}
					}
				}
				break;
			case FOREST:
			case FOREST_TOWER5:
			case FOREST_TOWER10:
			case FOREST_TOWER15:
				for (Unit u : units) {
					if (!u.isHero()) {
						RegularUnit ru = (RegularUnit) u;
						int bonusToAdd = ru.getForestTerrainBonus() - opponentsNegateTerrain;
						if (bonusToAdd > 0) {
							ru.addStrength(bonusToAdd);
						}
					}
				}
				break;
			case SWAMP:
			case SWAMP_TOWER5:
			case SWAMP_TOWER10:
			case SWAMP_TOWER15:
				for (Unit u : units) {
					if (!u.isHero()) {
						RegularUnit ru = (RegularUnit) u;
						int bonusToAdd = ru.getSwampTerrainBonus() - opponentsNegateTerrain;
						if (bonusToAdd > 0) {
							ru.addStrength(bonusToAdd);
						}
					}
				}
				break;
			case HILL:
			case HILL_TOWER5:
			case HILL_TOWER10:
			case HILL_TOWER15:
				for (Unit u : units) {
					if (!u.isHero()) {
						RegularUnit ru = (RegularUnit) u;
						int bonusToAdd = ru.getHillTerrainBonus() - opponentsNegateTerrain;
						if (bonusToAdd > 0) {
							ru.addStrength(bonusToAdd);
						}
					}
				}
				break;
			case DESERT:
			case DESERT_TOWER5:
			case DESERT_TOWER10:
			case DESERT_TOWER15:
				for (Unit u : units) {
					if (!u.isHero()) {
						RegularUnit ru = (RegularUnit) u;
						int bonusToAdd = ru.getDesertTerrainBonus() - opponentsNegateTerrain;
						if (bonusToAdd > 0) {
							ru.addStrength(bonusToAdd);
						}
					}
				}
				break;
			case SNOW:
			case SNOW_TOWER5:
			case SNOW_TOWER10:
			case SNOW_TOWER15:
				for (Unit u : units) {
					if (!u.isHero()) {
						RegularUnit ru = (RegularUnit) u;
						int bonusToAdd = ru.getSnowTerrainBonus() - opponentsNegateTerrain;
						if (bonusToAdd > 0) {
							ru.addStrength(bonusToAdd);
						}
					}
				}
				break;
			case OCEAN:
			case OCEAN_TOWER5:
			case OCEAN_TOWER10:
			case OCEAN_TOWER15:
				for (Unit u : units) {
					if (!u.isHero()) {
						RegularUnit ru = (RegularUnit) u;
						int bonusToAdd = ru.getOceanTerrainBonus() - opponentsNegateTerrain;
						if (bonusToAdd > 0) {
							ru.addStrength(bonusToAdd);
						}
					}
				}
				break;
			case CITY0:
			case CITY5:
			case CITY10:
			case CITY15:
				for (Unit u : units) {
					if (!u.isHero()) {
						RegularUnit ru = (RegularUnit) u;
						int bonusToAdd = ru.getCityTerrainBonus() - opponentsNegateTerrain;
						if (bonusToAdd > 0) {
							ru.addStrength(bonusToAdd);
						}
					}
				}
				break;
			default:
				break;
		}
	}

	void distributeRoleBonuses() {
		Role r = getUnits().getFirst().getRole();

		if (Role.ATTACKER.equals(r)) {
			for (Unit u : units) {
				if (!u.isHero()) {
					RegularUnit ru = (RegularUnit) u;
					ru.addStrength(ru.getAttackBonus());
				}
			}
		} else {
			for (Unit u : units) {
				if (!u.isHero()) {
					RegularUnit ru = (RegularUnit) u;
					ru.addStrength(ru.getDefenseBonus());
				}
			}
		}
	}

	void distributeSwarm() {
		ArrayList<String> swarmNamesList = new ArrayList<String>();

		//first register all swarm-enabled units in a list...
		for (Unit u : units) {
			if (!u.isHero()) {
				RegularUnit ru = (RegularUnit) u;
				if (ru.getSwarm() > 0) {
					swarmNamesList.add(ru.getName());
				}
			}
		}
		//...then apply swarm bonus based on the above list
		for (Unit u : units) {
			if (!u.isHero()) {
				RegularUnit ru = (RegularUnit) u;
				int swarm = ru.getSwarm();
				if (swarm > 0) {
					String ruName = ru.getName();
					int counter = 0;
					for (String n : swarmNamesList) { //count how many such units there are
						if (ruName.equals(n)) {
							counter++;
						}
					}
					int swarmCount = ru.getSwarmCount(); //apply bonus accordingly
					if (counter > swarmCount) {
						ru.addStrength(swarm * swarmCount);
					} else {
						ru.addStrength(swarm * counter);
					}
				}
			}
		}
	}

	//methods distributing stack bonuses (with auxiliaries)
	//MORALE
	void distributeMorale(Terrain aBattleTerrain, Army aOpponent) {
		int opponentsNegateAura = aOpponent.determineNegateAura();
		int highestMorale = 0;

		for (Unit u : units) {
			if (!u.isHero()) {
				RegularUnit ru = (RegularUnit) u;
				int morale = ru.getAura(); //first check an ordinary morale
				if (morale > highestMorale) {
					highestMorale = morale;
				}
				int terrainMorale = determineTerrainAura(ru, aBattleTerrain); //next check a terrain one
				if (terrainMorale > highestMorale) {
					highestMorale = terrainMorale;
				}
			}
		}
		//now let's apply the highest determined morale to all units
		int moraleToAdd = highestMorale - opponentsNegateAura;
		if (moraleToAdd > 0) {
			for (Unit u : units) {
				u.addStrength(moraleToAdd);
			}
		}
	}

	private int determineTerrainAura(RegularUnit aUnit, Terrain aBattleTerrain) {
		int terrainAura = 0;

		switch (aBattleTerrain) {
			case OPEN:
			case OPEN_TOWER5:
			case OPEN_TOWER10:
			case OPEN_TOWER15:
				terrainAura = aUnit.getOpenTerrainAura();
				break;
			case FOREST:
			case FOREST_TOWER5:
			case FOREST_TOWER10:
			case FOREST_TOWER15:
				terrainAura = aUnit.getForestTerrainAura();
				break;
			case SWAMP:
			case SWAMP_TOWER5:
			case SWAMP_TOWER10:
			case SWAMP_TOWER15:
				terrainAura = aUnit.getSwampTerrainAura();
				break;
			case HILL:
			case HILL_TOWER5:
			case HILL_TOWER10:
			case HILL_TOWER15:
				terrainAura = aUnit.getHillTerrainAura();
				break;
			case DESERT:
			case DESERT_TOWER5:
			case DESERT_TOWER10:
			case DESERT_TOWER15:
				terrainAura = aUnit.getDesertTerrainAura();
				break;
			case SNOW:
			case SNOW_TOWER5:
			case SNOW_TOWER10:
			case SNOW_TOWER15:
				terrainAura = aUnit.getSnowTerrainAura();
				break;
			case OCEAN:
			case OCEAN_TOWER5:
			case OCEAN_TOWER10:
			case OCEAN_TOWER15:
				terrainAura = aUnit.getOceanTerrainAura();
				break;
			case CITY0:
			case CITY5:
			case CITY10:
			case CITY15:
				terrainAura = aUnit.getCityTerrainAura();
				break;
			default:
				break;
		}

		return terrainAura;
	}

	//FEAR
	void inflictFear(Army aArmyToInflictFearUpon, Terrain aBattleTerrain) {
		int fearToSubtract = determineFear(aBattleTerrain) - aArmyToInflictFearUpon.determineNegateAura();

		if (fearToSubtract > 0) {
			for (Unit u : aArmyToInflictFearUpon.getUnits()) {
				u.subtractStrength(fearToSubtract);
			}
		}
	}

	private int determineFear(Terrain aBattleTerrain) {
		int highestFear = 0;

		for (Unit u : units) {
			if (!u.isHero()) {
				RegularUnit ru = (RegularUnit) u;
				int fear = ru.getAura(); //first check an ordinary fear
				if (fear < highestFear) {
					highestFear = fear;
				}
				int terrainFear = determineTerrainAura(ru, aBattleTerrain); //next check a terrain one
				if (terrainFear < highestFear) {
					highestFear = terrainFear;
				}
			}
		}

		return -highestFear;
	}

	//NEGATES
	private int determineNegateAura() {
		int highestNegate = 0;

		for (Unit u : units) {
			if (!u.isHero()) {
				RegularUnit ru = (RegularUnit) u;
				int negate = ru.getNegateAura();
				if (negate > highestNegate) {
					highestNegate = negate;
				}
			}
		}

		return highestNegate;
	}

	private int determineNegateHeroism() {
		int highestNegate = 0;

		for (Unit u : units) {
			int negate = u.getNegateHeroism();
			if (negate > highestNegate) {
				highestNegate = negate;
			}
		}

		return highestNegate;
	}

	private int determineNegateTerrain() {
		int highestNegate = 0;
		for (Unit u : units) {
			if (!u.isHero()) {
				RegularUnit ru = (RegularUnit) u;
				int negate = ru.getNegateTerrain();
				if (negate > highestNegate) {
					highestNegate = negate;
				}
			}
		}
		return highestNegate;
	}

	//CITY&TOWER WALLS
	void distributeWallBonus(Terrain aBattleTerrain, Army aOpponent) {
		Role r = getUnits().getFirst().getRole();

		if (Role.DEFENDER.equals(r) && aBattleTerrain.getWallBonus() > 0) { //only applicable for defenders and when there's proper terrain
			int wallBonus = aBattleTerrain.getWallBonus() - aOpponent.determineSiege();

			if (wallBonus > 0) {
				setEffectiveWallBonus(wallBonus);

				for (Unit u : units) { //the no-wall feature has to be taken into account
					if (u.isHero()) { //if it's a hero it can't have no-wall, so apply a wall bonus
						u.addStrength(wallBonus);
					} else { //if it's a regular, first check if it has no-wall...
						RegularUnit ru = (RegularUnit) u;
						if (!ru.hasNoWall()) {
							ru.addStrength(wallBonus); //...then apply only when it hasn't
						}
					}
				}
			}
		}
	}

	int determineSiege() {
		int highestSiege = 0;

		for (Unit u : units) {
			if (!u.isHero()) {
				RegularUnit ru = (RegularUnit) u;
				int siege = ru.getSiege();
				if (siege > highestSiege) {
					highestSiege = siege;
				}
			}
		}

		return highestSiege;
	}

	//GROUP AMBUSH
	void distributeGroupAmbush() { // it's all cumulative so it's rather simple...
		int cumulative = 0;

		for (Unit u : units) {
			cumulative += u.getGroupAmbush();
		}

		for (Unit u : units) {
			u.addAmbush(cumulative);
		}
	}

	//other methods
	void changeRoleToDefender() { //defender is a default role
		for (Unit u : units) {
			u.setRole(Role.DEFENDER);
		}
	}

	void changeRoleToAttacker() { //defender is a default role
		for (Unit u : units) {
			u.setRole(Role.ATTACKER);
		}
	}

	//getters & setters
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public LinkedList<Unit> getUnits() {
		return (LinkedList<Unit>) units;
	}

	public int getEffectiveWallBonus() {
		return effectiveWallBonus;
	}

	public void setEffectiveWallBonus(int effectiveWallBonus) {
		this.effectiveWallBonus = effectiveWallBonus;
	}
}
