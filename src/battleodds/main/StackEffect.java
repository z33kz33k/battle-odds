package battleodds.main;

public class StackEffect extends NumericalEffect {

	public StackEffect(int aID, String aName, int aValue) {
		super(aID, aName, aValue);
	}

	public void apply(Army aOwnerArmy) {
		for (Unit u : aOwnerArmy.getUnits()) {
			u.addStrength(getValue());
		}
	}
}
