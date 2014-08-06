package vehicles;

import fsm.Action;

public class SaveDn implements Action {

	@Override
	public void do_it(Object model) {
		/* -----------------------------------------------------
		 *  finish off a vehicle (trip) and put it on a List
		 */
		VF_Model m = (VF_Model) model;
		Vehicle v = m.carDn;
		v.setEnd(m.timeStamp,v.getEnd());
		Vehicle save = v.copy();
		m.downList.addLast(save);
	}

	public static SaveDn getInstance() { return INSTANCE; }
	
	public static final SaveDn INSTANCE = new SaveDn();
	
	private SaveDn(){}
}
