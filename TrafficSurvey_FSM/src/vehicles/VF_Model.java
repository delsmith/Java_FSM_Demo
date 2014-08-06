package vehicles;

import java.util.LinkedList;

public class VF_Model {
	
	public Vehicle carUp;
	public Vehicle carDn;
	public LinkedList<Vehicle> upList;
	public LinkedList<Vehicle> downList;
	public long day;
	public long prevTime;
	public long timeStamp;
	
	public VF_Model() {
		day = 1;
		prevTime = 0;
		timeStamp = 0;
		carUp = new Vehicle(day,0,0,true);
		carDn = new Vehicle(day,0,0,false);
		upList = new LinkedList<Vehicle>();
		downList = new LinkedList<Vehicle>();
	}
}
