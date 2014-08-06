package vehicles;

import fsm.Action;

public class Resync implements Action {

	@Override
	public void do_it(Object model) {
		System.out.println("Action: Invalid event - ReSync");

	}

	public static Resync getInstance() { return INSTANCE; }
	
	public static final Resync INSTANCE = new Resync();
	
	private Resync(){}
}
