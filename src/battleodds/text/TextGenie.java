package battleodds.text;

import battleodds.main.Army;
import battleodds.main.Unit;

public class TextGenie {

	private StringBuilder battleText;
	private int blockWidth;

	private boolean shouldWrite;

	public static final int CHARCAPACITY_FOR_STANDARD_BATTLETEXT = 6500; //"standard" means 2 armies of 8 units apiece

	public TextGenie(int aCharCapacity, boolean aShouldWrite) {
		battleText = new StringBuilder(aCharCapacity);
		shouldWrite = aShouldWrite;
	}

	public void writeAnnouncement(String aAnnouncement) {
		if (shouldWrite) {
			battleText.append("\n*** " + aAnnouncement + " ***\n");
		}
	}

	public void writeAboutGrantingAntiairToUnit(Unit aUnit) {
		if (shouldWrite) {
			battleText.append(makeSpecialUnitAnnouncement(aUnit, "has been granted an antiair bonus"));
		}
	}

	public void writeAboutGrantingBackWallBonusToUnit(Unit aUnit) {
		if (shouldWrite) {
			battleText.append(makeSpecialUnitAnnouncement(aUnit, "has been granted its wall bonus back"));
		}
	}

	public void writeAboutRevokingAntiairFromUnit(Unit aUnit) {
		if (shouldWrite) {
			battleText.append(makeSpecialUnitAnnouncement(aUnit, "has had its antiair bonus revoked"));
		}
	}

	public void writeAboutRevokingWallBonusFromUnit(Unit aUnit) {
		if (shouldWrite) {
			battleText.append(makeSpecialUnitAnnouncement(aUnit, "has had its wall bonus revoked"));
		}
	}

	public void writeAboutUnitAmbushRoll(Unit aUnit, int aRoll) {
		if (shouldWrite) {
			battleText.append(aUnit.getRole().toString() + "[" + aUnit.getAmbush() + "] rolls: " + aRoll);
		}
	}

	public void writeAboutUnitDeath(Unit aUnit) {
		if (shouldWrite) {
			battleText.append(makeRegularUnitAnnouncement(aUnit, "has been killed"));
		}
	}

	public void writeAboutUnitDeathByAmbush(Unit aUnit) {
		if (shouldWrite) {
			battleText.append(makeRegularUnitAnnouncement(aUnit, "has been killed in ambush"));
		}
	}

	public void writeAboutUnitHit(Unit aUnit) {
		if (shouldWrite) {
			battleText.append(makeRegularUnitAnnouncement(aUnit, "has been hit"));
		}
	}

	public void writeAboutUnitRoll(Unit aUnit, int aRoll) {
		if (shouldWrite) {
			battleText.append("\n" + aUnit.getRole().toString() + " rolls: " + aRoll);
		}
	}

	public void makeSpace(int aRows) {
		if (shouldWrite) {
			for (int i = 0; i < aRows; i++) {
				battleText.append("\n");
			}
		}
	}

	//makes sth like this: "Attacker(Light Infantry) has been hit"
	private static String makeRegularUnitAnnouncement(Unit aUnit, String aText) {
		String announcement = "\n" + aUnit.getRole().toString() + "(" + aUnit.getName() + ") " + aText;
		return announcement;
	}

	//makes sth like this: "Attacker(Light Infantry[10,2]) has been granted its wall bonus back"
	private static String makeSpecialUnitAnnouncement(Unit aUnit, String aText) {
		String announcement = "\n" + aUnit.getRole().toString() + "(" + aUnit.getName() + "[" + aUnit.getStrength()
				+ "," + aUnit.getHitPoints() + "]) " + aText + "\n";
		return announcement;
	}

	public void writeInitialSummary(Army aAttackingArmy, Army aDefendingArmy, int aBattleOrdinal) {
		if (shouldWrite) {
			String armiesListing = constructArmiesListing(aAttackingArmy, aDefendingArmy); //we need first to construct a listing to know how long it is...
			battleText.append(constructInitialHeader(aBattleOrdinal)); //...then we know how to set length of a header
			battleText.append(armiesListing);
		}
	}

	public void writeRoundSummary(Army aAttackingArmy, Army aDefendingArmy, int aRoundsCounter, int aBattleOrdinal) {
		if (shouldWrite) {
			battleText.append(constructArmiesListing(aAttackingArmy, aDefendingArmy));
			battleText.append(constructBottomHeader(aRoundsCounter, aBattleOrdinal));
		}
	}

	//note: every call to this method provides blockWidth with a new value
	private String constructArmiesListing(Army aAttackingArmy, Army aDefendingArmy) {
		StringBuilder armiesListing = new StringBuilder();

		StringBuilder firstLine = new StringBuilder("Attacking army: ");
		for (Unit u : aAttackingArmy.getUnits()) {
			String s = u.getName() + "[" + u.getStrength() + "," + u.getHitPoints() + "] ";
			firstLine.append(s);
		}
		int firstLineLength = firstLine.length();

		StringBuilder secondLine = new StringBuilder("Defending army: ");
		for (Unit u : aDefendingArmy.getUnits()) {
			String s = u.getName() + "[" + u.getStrength() + "," + u.getHitPoints() + "] ";
			secondLine.append(s);
		}
		int secondLineLength = secondLine.length();

		if (firstLineLength > secondLineLength) {
			blockWidth = firstLineLength;
		} else {
			blockWidth = secondLineLength;
		}

		armiesListing.append("\n");
		armiesListing.append(Herald.constructBorderline(blockWidth, '-'));
		armiesListing.append("\n");
		armiesListing.append(firstLine);
		armiesListing.append("\n");
		armiesListing.append(secondLine);
		armiesListing.append("\n");
		armiesListing.append(Herald.constructBorderline(blockWidth, '-'));

		return armiesListing.toString();
	}

	private String constructBottomHeader(int aRoundsCounter, int aBattleOrdinal) {
		String bottomHeader;
		StringBuilder endOfRound = new StringBuilder(blockWidth + 16);
		if (blockWidth >= 31) {
			endOfRound.append(" BATTLE #" + aBattleOrdinal + " * END OF ROUND: " + aRoundsCounter + ' ');
		} else {
			endOfRound.append(" * END OF ROUND: " + aRoundsCounter + ' ');
		}
		bottomHeader = "\n" + Herald.centerText(endOfRound.toString(), '*', blockWidth);
		return bottomHeader;
	}

	private String constructInitialHeader(int aBattleOrdinal) {
		String battleBegins = " BATTLE #" + aBattleOrdinal + " BEGINS! ";
		String initialHeader = "\n\n\n".concat(Herald.centerText(battleBegins, '*', blockWidth));
		return initialHeader;
	}

	public int getBlockWidth() {
		return blockWidth;
	}

	public void setBlockWidth(int blockWidth) {
		this.blockWidth = blockWidth;
	}

	public String getBattleText() {
		return battleText.toString();
	}

	public void setShouldWrite(boolean shouldWrite) {
		this.shouldWrite = shouldWrite;
	}

}
