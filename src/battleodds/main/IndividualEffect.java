package battleodds.main;

public class IndividualEffect extends NumericalEffect {

	public IndividualEffect(int aID, String aName, int aValue) {
		super(aID, aName, aValue);
	}

	public IndividualEffect(int aID, String aName) {
		super(aID, aName);
	}

	public void apply(Unit aOwner) {
		aOwner.addStrength(getValue());
	}
}
