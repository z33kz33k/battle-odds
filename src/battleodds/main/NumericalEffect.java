package battleodds.main;

public abstract class NumericalEffect extends Effect {

	private int value;

	public NumericalEffect(int aID, String aName, int aValue) {
		super(aID, aName);
		value = aValue;
	}

	public NumericalEffect(int aID, String aName) {
		super(aID, aName);
	}

	public int getValue() {
		return value;
	}
}
