package vehicles;

import fsm.Action;

public class NewDn implements Action {

	@Override
	public void do_it(Object model) {
		VF_Model m = (VF_Model) model;
		Vehicle v = m.carDn;
		v.setStart(m.day,m.timeStamp);
	}
	
	public static NewDn getInstance() { return INSTANCE; }
	
	public static final NewDn INSTANCE = new NewDn();
	
	private NewDn(){}
}
