package vehicles;

import fsm.Action;

public class SaveUp implements Action {
	
	@Override
	public void do_it(Object model) {
		/* -----------------------------------------------------
		 *  finish off a vehicle (trip) and put it on a List
		 */
		VF_Model m = (VF_Model) model;
		Vehicle v = m.carUp;
		v.setEnd(m.timeStamp,v.getEnd());
		Vehicle save = v.copy();
		m.upList.addLast(save);
	}

	public static SaveUp getInstance() { return INSTANCE; }
	
	public static final SaveUp INSTANCE = new SaveUp();
	
	private SaveUp(){}
}
