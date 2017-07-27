package battleodds.effects;

import battleodds.main.IndividualEffect;

public class Blessing extends IndividualEffect {

	private final int value;

	public Blessing() {
		super(0, "Blessing");
		value = 5;
	}

	@Override
	public int getValue() {
		return value;
	}

}
