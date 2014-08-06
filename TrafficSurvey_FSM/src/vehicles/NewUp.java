package vehicles;

import fsm.Action;

public class NewUp implements Action {

	@Override
	public void do_it(Object model) {
		VF_Model m = (VF_Model) model;
		Vehicle v = m.carUp;
		v.setStart(m.day,m.timeStamp);
	}
	
	public static NewUp getInstance() { return INSTANCE; }
	
	public static final NewUp INSTANCE = new NewUp();
	
	private NewUp(){}

}
