package battleodds.main;

import battleodds.text.TextGenie;

class Battle {

	private final Army attackingArmy, defendingArmy;
	private Unit attacker, defender;

	private int roundsCounter;

	private final int ordinal;
	private TextGenie textGenie;

	public Battle(Army[] aArmies, int aOrdinal, TextGenie aTextGenie) {
		ordinal = aOrdinal;
		textGenie = aTextGenie;

		attackingArmy = aArmies[0];
		defendingArmy = aArmies[1];
	}

	private void calculateAmbush() {
		if (attacker.getAmbush() > 0 && defender.getAmbush() > 0) { //case 1: both have ambush
			textGenie.makeSpace(1);
			textGenie.writeAnnouncement("Ambush");
			int attackerResult = attacker.rollAHitDie();
			textGenie.writeAboutUnitAmbushRoll(attacker, attackerResult);
			int defenderResult = defender.rollAHitDie();
			textGenie.writeAboutUnitAmbushRoll(defender, defenderResult);
			if (attacker.getAmbush() >= attackerResult && !(defender.getAmbush() >= defenderResult)) { //attacker wins
				textGenie.writeAboutUnitDeathByAmbush(defender);
				killDefender();
			} else if (!(attacker.getAmbush() >= attackerResult) && defender.getAmbush() >= defenderResult) { //defender wins
				textGenie.writeAboutUnitDeathByAmbush(attacker);
				killAttacker();
			}
			textGenie.makeSpace(1);

		} else if (attacker.getAmbush() > 0 && !(defender.getAmbush() > 0)) { //case 2: only attacker has ambush
			textGenie.writeAnnouncement("Ambush");
			int attackerResult = attacker.rollAHitDie();
			textGenie.writeAboutUnitAmbushRoll(attacker, attackerResult);
			if (attacker.getAmbush() >= attackerResult) {
				textGenie.writeAboutUnitDeathByAmbush(defender);
				killDefender();
			}
			textGenie.makeSpace(1);

		} else if (!(attacker.getAmbush() > 0) && defender.getAmbush() > 0) { //case 3: only defender has ambush
			textGenie.writeAnnouncement("Ambush");
			int defenderResult = defender.rollAHitDie();
			textGenie.writeAboutUnitAmbushRoll(defender, defenderResult);
			if (defender.getAmbush() >= defenderResult) {
				textGenie.writeAboutUnitDeathByAmbush(attacker);
				killAttacker();
			}
			textGenie.makeSpace(1);
		}
		//ambush can only be used once a battle
		if (attacker != null)
			attacker.setAmbush(0);
		if (defender != null)
			defender.setAmbush(0);
	}

	private void calculateFight() {
		textGenie.makeSpace(1);
		textGenie.writeAnnouncement("Fighting");

		//resolving situational bonuses
		//ANTIAIR
		int antiairGrantingCase = activateAntiair();
		//NOWALL
		boolean noWallActivated = false;
		if (defendingArmy.getEffectiveWallBonus() > 0 && !attacker.isHero()) {
			RegularUnit ruAttacker = (RegularUnit) attacker;

			if (ruAttacker.hasNoWall()) {
				if (!defender.isHero()) {
					RegularUnit ruDefender = (RegularUnit) defender;
					if (!ruDefender.hasNoWall()) {
						activateNoWall();
						noWallActivated = true;
					}
				} else {
					activateNoWall();
					noWallActivated = true;
				}
			}
		}

		do {
			int attackerResult = attacker.rollAHitDie();
			textGenie.writeAboutUnitRoll(attacker, attackerResult);
			int defenderResult = defender.rollAHitDie();
			textGenie.writeAboutUnitRoll(defender, defenderResult);

			if (attacker.getStrength() >= attackerResult && !(defender.getStrength() >= defenderResult)) { //defender takes a hit
				defender.applyWound();
				textGenie.writeAboutUnitHit(defender);
				if (defender.getHitPoints() == 0) { //...and dies
					textGenie.writeAboutUnitDeath(defender);
					killDefender();
				}
			} else if (!(attacker.getStrength() >= attackerResult) && defender.getStrength() >= defenderResult) { //attacker takes a hit
				attacker.applyWound();
				textGenie.writeAboutUnitHit(attacker);
				if (attacker.getHitPoints() == 0) { //...and dies
					textGenie.writeAboutUnitDeath(attacker);
					killAttacker();
				}
			}
			textGenie.makeSpace(1);

		} while (attacker != null && defender != null);

		//erasing the effects of situational bonuses
		//ANTIAIR
		deactivateAntiair(antiairGrantingCase);
		//NOWALL
		if (noWallActivated && attacker == null) {
			deactivateNoWall();
		}
	}

	private void killAttacker() {
		attackingArmy.getUnits().removeFirst(); //attacker dies
		attacker = null;
	}

	private void killDefender() {
		defendingArmy.getUnits().removeFirst(); //defender dies
		defender = null;
	}

	private int activateAntiair() {
		int granted = 0; //case 0: no one has been granted an antiair bonus

		if (defender.isFlyer() && !attacker.isFlyer()) {
			int antiair = attacker.getAntiair();
			if (antiair > 0) {
				attacker.addStrength(antiair);
				textGenie.writeAboutGrantingAntiairToUnit(attacker);
				granted = 1; //case 1: only attacker has been granted an antiair bonus
			}

		} else if (!defender.isFlyer() && attacker.isFlyer()) {
			int antiair = defender.getAntiair();
			if (antiair > 0) {
				defender.addStrength(antiair);
				textGenie.writeAboutGrantingAntiairToUnit(defender);
				granted = 2; //case 2: only defender has been granted an antiair bonus
			}

		} else if (defender.isFlyer() && attacker.isFlyer()) {
			int attackerAntiair = attacker.getAntiair();
			int defenderAntiair = defender.getAntiair();
			if (defenderAntiair == 0 && attackerAntiair > 0) {
				attacker.addStrength(attackerAntiair);
				textGenie.writeAboutGrantingAntiairToUnit(attacker);
				granted = 1; //case 1: only attacker has been granted an antiair bonus
			} else if (defenderAntiair > 0 && attackerAntiair == 0) {
				defender.addStrength(defenderAntiair);
				textGenie.writeAboutGrantingAntiairToUnit(defender);
				granted = 2; //case 2: only defender has been granted an antiair bonus
			} else if (defenderAntiair > 0 && attackerAntiair > 0) {
				attacker.addStrength(attackerAntiair);
				textGenie.writeAboutGrantingAntiairToUnit(attacker);
				defender.addStrength(defenderAntiair);
				textGenie.writeAboutGrantingAntiairToUnit(defender);
				granted = 3; //case 3: both attacker and defender have been granted an antiair bonus
			}
		}
		return granted;
	}

	private void deactivateAntiair(int aAntiairGrantingCase) {
		if (aAntiairGrantingCase == 1) { //case 1 in grantAntiair()
			if (attacker != null) {
				attacker.subtractStrength(attacker.getAntiair());
				textGenie.writeAboutRevokingAntiairFromUnit(attacker);
			}

		} else if (aAntiairGrantingCase == 2) { //case 2 in grantAntiair()
			if (defender != null) {
				defender.subtractStrength(defender.getAntiair());
				textGenie.writeAboutRevokingAntiairFromUnit(defender);
			}

		} else if (aAntiairGrantingCase == 3) { //case 3 in grantAntiair()
			if (attacker != null) {
				attacker.subtractStrength(attacker.getAntiair());
				textGenie.writeAboutRevokingAntiairFromUnit(attacker);
			}
			if (defender != null) {
				defender.subtractStrength(defender.getAntiair());
				textGenie.writeAboutRevokingAntiairFromUnit(defender);
			}
		}
	}

	private void activateNoWall() {
		defender.subtractStrength(defendingArmy.getEffectiveWallBonus());
		textGenie.writeAboutRevokingWallBonusFromUnit(defender);
	}

	private void deactivateNoWall() {
		defender.addStrength(defendingArmy.getEffectiveWallBonus());
		textGenie.writeAboutGrantingBackWallBonusToUnit(defender);
	}

	private void calculateRound() {
		if (roundsCounter == 0) {
			textGenie.writeInitialSummary(attackingArmy, defendingArmy, ordinal);
		}

		attacker = attackingArmy.getUnits().getFirst();
		defender = defendingArmy.getUnits().getFirst();

		calculateAmbush();
		if (attacker != null && defender != null) { //fight only if there was no successful ambush
			calculateFight();
		}

		roundsCounter++;

		textGenie.writeRoundSummary(attackingArmy, defendingArmy, roundsCounter, ordinal);
	}

	int[] resolve() {
		int attackerWon = 0;
		int defenderWon = 1;
		int[] battleResult = new int[2];

		do {
			calculateRound();
		} while (!attackingArmy.getUnits().isEmpty() && !defendingArmy.getUnits().isEmpty());

		if (attackingArmy.getUnits().isEmpty()) {
			battleResult[0] = defenderWon;
			return battleResult;
		} else {
			int numOfSurvivors = attackingArmy.getUnits().size();
			battleResult[0] = attackerWon;
			battleResult[1] = numOfSurvivors;
			return battleResult;
		}
	}
}
