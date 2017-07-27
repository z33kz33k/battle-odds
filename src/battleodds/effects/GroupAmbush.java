package battleodds.effects;

import battleodds.main.Army;
import battleodds.main.StackEffect;
import battleodds.main.Unit;

public class GroupAmbush extends StackEffect {

	public GroupAmbush(int aValue) {
		super(50, "Group Ambush", aValue);
	}

	@Override
	public void apply(Army aOwnerArmy) {
		for (Unit u : aOwnerArmy.getUnits()) {
			u.addAmbush(getValue());
		}
	}

}
