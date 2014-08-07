package fsm;
/**
 * @author dels
 *	a Finite State Machine is a collection of State objects
 *	a State has a set of event Transitions
 *	a Transition will assign the next State, and may first perform an Action
 *
 *  the FSM handles events by 
 *  	invoking the current State object and 
 *  	saving the next State
 */
import fsm.State;

public class FSM {

	private State state;	// current State
	private Object model;	// data model
	
	/*
	 * pass the event to the current State object
	 */
	public void handleEvent( String event ) {
		try {
			state = state.onEvent(event, model);
		}
		catch (Exception e) {
			System.out.println("ERROR: FSM not configured!");
		}
		finally {}
	}

	// TODO: may need a finalise() method to clean up if used in a non-stop application
	
	/*
	 * configure FSM with the initial State and data model
	 */
	public void configure( State state, Object model ) { this.state = state; this.model = model; }
	
	/*
	 * default constructor
	 */
	public FSM() { state = null; model = null; }
}
