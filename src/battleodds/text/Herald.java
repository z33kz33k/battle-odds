package battleodds.text;

import java.math.BigDecimal;

public class Herald {

	private StringBuilder theText;

	public Herald(int aCharCapacity) {
		theText = new StringBuilder(aCharCapacity);
	}

	public static String constructBorderline(int aLength, char aChar) {
		StringBuilder borderline = new StringBuilder(aLength + 16);
		for (int i = 1; i < aLength; i++) {
			borderline.append(aChar);
		}
		return borderline.toString();
	}

	public static String centerText(String aText, char aChar, int aBlockWidth) {
		StringBuilder outerString = new StringBuilder(aBlockWidth + 16);

		int numberOfChars = 0;
		int difference = aBlockWidth - aText.length();

		if (difference > 0) {
			if (difference % 2 == 0) {
				numberOfChars = difference / 2;
				for (int i = 0; i < numberOfChars; i++) {
					outerString.append(aChar);
				}
				outerString.append(aText);
				for (int i = 1; i < numberOfChars; i++) {
					outerString.append(aChar);
				}
			} else {
				numberOfChars = difference / 2;
				for (int i = 0; i < numberOfChars; i++) {
					outerString.append(aChar);
				}
				outerString.append(aText);
				for (int i = 0; i < numberOfChars; i++) {
					outerString.append(aChar);
				}
			}
		} else {
			outerString.append(aText);
		}

		return outerString.toString();
	}

	public void printWelcomingStatement(int aIterations, int aTextCoverage) {
		theText.append("Simulation is set to run over " + aIterations + " iterations");
		theText.append("\n" + "Random selection of ~" + aTextCoverage + "% of them will be displayed");
	}

	public void printClosingBlock(BigDecimal aWinsPercentage, BigDecimal[] aSurvivorsPercentages, int aBlockWidth) {
		StringBuilder closingBlock = new StringBuilder(aBlockWidth * 13 + 16);
		closingBlock.append(constructAttackerWinsHeader(aWinsPercentage, aBlockWidth));
		if (aWinsPercentage.intValue() != 0) {
			closingBlock.append(constructSurvivorsPercentagesListing(aSurvivorsPercentages, aBlockWidth));
		}
		theText.append(closingBlock.toString());
	}

	public void addBattleText(String aBattleText) {
		theText.append(aBattleText);
	}

	public void announceAll() {
		System.out.println(theText.toString());
	}

	private String constructAttackerWinsHeader(BigDecimal aWinsPercentage, int aBlockWidth) {
		if (aBlockWidth < 39) {
			aBlockWidth = 39;
		}
		StringBuilder attackerWins = new StringBuilder(aBlockWidth * 3 + 16);

		String innerString = " Attacker wins " + aWinsPercentage.setScale(2, BigDecimal.ROUND_HALF_UP).toString()
				+ "% of times ";

		attackerWins.append("\n\n");
		attackerWins.append(constructBorderline(aBlockWidth, '-'));
		attackerWins.append("\n");
		attackerWins.append(centerText(innerString, '#', aBlockWidth));
		attackerWins.append("\n");
		attackerWins.append(constructBorderline(aBlockWidth, '-'));

		return attackerWins.toString();
	}

	private String constructSurvivorsPercentagesListing(BigDecimal[] aSurvivorsPercentages, int aBlockWidth) {
		if (aBlockWidth < 39) {
			aBlockWidth = 39;
		}
		StringBuilder spl = new StringBuilder("\n" + centerText("(of that:", ' ', aBlockWidth));

		String text = "";
		for (int i = 0; i < 8; i++) {
			if (i < 7) {
				text = "% with " + (8 - i) + " units surviving,";
			} else {
				text = "% with " + (8 - i) + " unit surviving";
			}
			spl.append("\n"
					+ centerText(aSurvivorsPercentages[i].setScale(2, BigDecimal.ROUND_HALF_UP).toString() + text, ' ',
							aBlockWidth));
		}
		spl.append("\n" + constructBorderline(aBlockWidth, '-'));

		return spl.toString();
	}

}
