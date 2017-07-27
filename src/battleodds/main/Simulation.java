package battleodds.main;

import battleodds.text.Herald;
import battleodds.text.TextGenie;
import battleodds.units.LightInfantry;
import battleodds.units.Scout;

import java.math.BigDecimal;

class Simulation {

	private final int numberOfIterations;
	private final int textCoverage; //percentage of text to be shown
	private final Terrain terrain;

	private int timesAttackerWins;
	private int[] survivorsBreakdown; //this array stores information about how many attacking units survives each battle

	private Herald herald;

	Simulation(int aNumberOfIterations, int aTextCoverage) {
		numberOfIterations = aNumberOfIterations;
		textCoverage = aTextCoverage;
		terrain = Terrain.CITY10;

		survivorsBreakdown = new int[numberOfIterations];
	}

	void simulate() {
		int closingBlockWidth = doBattles();
		doPercentages(closingBlockWidth);
	}

	private int doBattles() {
		int numberOfBattlesToBeShown = numberOfIterations * textCoverage / 100;
		int charCapacity = (int) (TextGenie.CHARCAPACITY_FOR_STANDARD_BATTLETEXT * calculateCharCapacityFactor());
		herald = new Herald(numberOfBattlesToBeShown * charCapacity);
		herald.printWelcomingStatement(numberOfIterations, textCoverage);

		int closingBlockWidth = 0; //this value is needed to adjust width of the closing block of text (showing survivors percentages) so it is the same as width of a last battle text

		int shownBattlesCount = 0;
		boolean shouldBattleBeShown = false;

		//let's do battles!
		for (int i = 0; i < numberOfIterations; i++) { //THIS IS THE MAIN LOOP OF THE PROGRAM!
			if (shownBattlesCount < numberOfBattlesToBeShown) {
				shouldBattleBeShown = shouldBattleBeShown();
				if (i == numberOfIterations - 1) { //if it's the final iteration and there haven't yet been enough battles shown, make sure that the last battle is shown
					shouldBattleBeShown = true;
				}
			}
			TextGenie tg = new TextGenie(charCapacity, shouldBattleBeShown);

			Battle battle = new Battle(concoctArmies(terrain), i + 1, tg);
			int[] battleOutcome = battle.resolve();
			if (battleOutcome[0] == 0) {
				timesAttackerWins++;
				survivorsBreakdown[i] = battleOutcome[1];
			}

			if (shouldBattleBeShown) {
				shownBattlesCount++;
				herald.addBattleText(tg.getBattleText());
				closingBlockWidth = tg.getBlockWidth();
				if (shownBattlesCount == numberOfBattlesToBeShown) { //if this was the last battle to be shown...
					shouldBattleBeShown = false; //...don't show anything else
				}
			}
		}

		return closingBlockWidth;
	}

	private void doPercentages(int aClosingBlockWidth) {
		//let's calculate percentages from the results...
		BigDecimal winsPercentage = new BigDecimal((double) timesAttackerWins * 100 / numberOfIterations);
		BigDecimal[] survivorsPercentages = new BigDecimal[8];

		//no array was used here - for readability
		if (timesAttackerWins > 0) {
			int eightSurvivorsCount = 0;
			int sevenSurvivorsCount = 0;
			int sixSurvivorsCount = 0;
			int fiveSurvivorsCount = 0;
			int fourSurvivorsCount = 0;
			int threeSurvivorsCount = 0;
			int twoSurvivorsCount = 0;
			int oneSurvivorCount = 0;

			for (int s : survivorsBreakdown) {
				switch (s) {
					case 8:
						eightSurvivorsCount++;
						break;
					case 7:
						sevenSurvivorsCount++;
						break;
					case 6:
						sixSurvivorsCount++;
						break;
					case 5:
						fiveSurvivorsCount++;
						break;
					case 4:
						fourSurvivorsCount++;
						break;
					case 3:
						threeSurvivorsCount++;
						break;
					case 2:
						twoSurvivorsCount++;
						break;
					case 1:
						oneSurvivorCount++;
						break;
				}
			}

			survivorsPercentages[0] = new BigDecimal((double) eightSurvivorsCount * 100 / timesAttackerWins);
			survivorsPercentages[1] = new BigDecimal((double) sevenSurvivorsCount * 100 / timesAttackerWins);
			survivorsPercentages[2] = new BigDecimal((double) sixSurvivorsCount * 100 / timesAttackerWins);
			survivorsPercentages[3] = new BigDecimal((double) fiveSurvivorsCount * 100 / timesAttackerWins);
			survivorsPercentages[4] = new BigDecimal((double) fourSurvivorsCount * 100 / timesAttackerWins);
			survivorsPercentages[5] = new BigDecimal((double) threeSurvivorsCount * 100 / timesAttackerWins);
			survivorsPercentages[6] = new BigDecimal((double) twoSurvivorsCount * 100 / timesAttackerWins);
			survivorsPercentages[7] = new BigDecimal((double) oneSurvivorCount * 100 / timesAttackerWins);
		}

		//...and print'em
		herald.printClosingBlock(winsPercentage, survivorsPercentages, aClosingBlockWidth);
		herald.announceAll();
	}

	private Army[] concoctArmies(Terrain aTerrain) {
		Army[] armies = new Army[2];
		armies[0] = new Army(); //attacker
		armies[1] = new Army(); //defender

		armies[0].addUnit(new LightInfantry());
		armies[0].addUnit(new LightInfantry());

		armies[1].addUnit(new Scout());

		armies[0].changeRoleToAttacker();

		armies[1].distributeWallBonus(aTerrain, armies[0]);

		return armies;
	}

	private boolean shouldBattleBeShown() {
		boolean should = false;
		int roll = (int) (numberOfIterations * Math.random() + 1);

		if (roll <= numberOfIterations * textCoverage / 100) {
			should = true;
		}
		return should;
	}

	private double calculateCharCapacityFactor() {
		double charCapacityFactor = 1.0;

		Army[] armies = concoctArmies(terrain);
		int numberOfUnits = armies[0].getUnits().size() + armies[1].getUnits().size();

		if (numberOfUnits > 16) {
			charCapacityFactor = numberOfUnits / 16.0;
		}

		return charCapacityFactor;
	}

	/*private int[] determineBattlesToBeShown() {
		int capacity = numberOfIterations * textCoverage / 100;
		int[] battlesToBeShown = new int[capacity];

		int roll = 0;
		for (int i = 0; i < capacity; i++) {
			roll = (int) (numberOfIterations * Math.random() + 1);
			for (int x : battlesToBeShown) {
				if (roll != x) {

				}
			}
		}

		return battlesToBeShown;
	}*/
}
