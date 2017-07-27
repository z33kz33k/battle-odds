package battleodds.main;

public abstract class Effect {

	private final int id;
	private final String name;

	public Effect(int aID, String aName) {
		id = aID;
		name = aName;
	}

	public String getName() {
		return name;
	}

	public int getID() {
		return id;
	}
}
