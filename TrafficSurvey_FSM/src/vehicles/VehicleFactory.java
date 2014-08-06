/**
 * 
 */
package vehicles;

/**
 * @author dels
 *
 */

import java.util.LinkedList;

import util.*;
import sensor.*;
import fsm.FSM;

public class VehicleFactory {
	
	// constants  (assumes 2.5m axle separation)
	static int DT1 = 25;      // Maximum ms. delay between AB pair  (~10 kmh)
	static int DT2 = 75;      // Minimum ms. delay between axles    (~120 kmh)
	static int DT3 = 750;     // Maximum ms. delay between axles    (~12 kmh)
	static int SENSOR_A = 0, SENSOR_B = 1;
	
	// data model
	private static VF_Model model;
	
	// state machine handle
	private static FSM engine;

	/* -----------------------------------------------------
	 * accessor for the Vehicle Lists
	 * 
	 */
	public LinkedList<Vehicle> getList( String which ) { return (which.toUpperCase().equals("UP")? model.upList: model.downList); }
	
	/* -----------------------------------------------------
	 * decode traffic sensor Events 
	 */
	private String getEvent(int sensor, long deltaT) {
		if (sensor == SENSOR_A) {
			if      ( deltaT < DT1 ) return "A1";
			else if ( deltaT < DT2 ) return "A2";
			else if ( deltaT < DT3 ) return "A3";
			else                     return "A4";
		} else if   ( deltaT < DT1 ) return "B1";		
		return "NA";
	}
	
	/* -----------------------------------------------------
	*  Vehicle factory logic - analyse the sequence of Crossing events
	*	and build lists of vehicles travelling UP or DOWN
	*/
	public void analyse( Crossing next ) {

		int sensor = next.getSensor();
		model.timeStamp = next.getTime();
		if (model.timeStamp < model.prevTime) model.day++;
		
		long deltaT = TimeDiff.timeDiff(model.timeStamp, model.prevTime);
		
		// fire event into the FSM
		engine.handleEvent( getEvent(sensor, deltaT) );
		model.prevTime = model.timeStamp;
	}

	/* -----------------------------------------------------
	* implement a singleton VehicleFactory instance
	*/
	public static VehicleFactory getInstance() { return INSTANCE; }
	
	public static final VehicleFactory INSTANCE = new VehicleFactory();
	
	private VehicleFactory(){
		
		model = new VF_Model();
		engine = new VF_FSM( model );
	}
	
	
}
