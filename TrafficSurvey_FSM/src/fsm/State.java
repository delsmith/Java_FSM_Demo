package fsm;

import java.util.HashMap;
import java.util.Map;

public class State implements Action {
	// define a Transiton class
	private class Transition {
		
		private State next;
		private Action action;
		
		private Transition( State next, Action action){ this.next = next; this.action = action;}
	}
	
	// State attributes
	private String name;						// the name of this state
	private Map<String,Transition> options;		// defines state transitions for valid events
	private State dfltState;					// default next state for invalid events
	private Action dfltAction;					// default Action for invalid events
	
	/*
	 * method to handle 'event' and perform state transition
	 */
	public State onEvent(String event, Object model){
		// get Transition
		Transition t = options.get(event);
		
		// Transition valid: execute the Action then change State 
		if ( t != null ) {
			System.out.println(event+":"+this.name+" > "+t.next.name);
			if( t.action != null )
				t.action.do_it(model);
			return t.next;
		}
		// Transition invalid: use defaults
		else {
			dfltAction.do_it(model);
			return dfltState;
		} 
	}
	
	@Override
	/* 
	 *  method executed if this State cannot handle 'event' and has no default Action
	 */
	public void do_it(Object model) {
		System.out.println("Unhandled FSM condition");
	}
	
	/*
	 * define Transition for an Event in this State
	 */
	public void addEvent(String event, State nextState, Action action){
		options.put( event, new Transition(nextState, action) );
	}

	/*
	 * create State with : name String, default State, default Action
	 */
	public State(String t ) {
		this(t,null,null);
		dfltState = this;
		dfltAction = this;
	}
	
	public State (String name, State dfltState, Action dfltAction ) {
		this.name = name;
		this.dfltState = (dfltState == null)? this : dfltState;
		this.dfltAction = (dfltAction == null)? this : dfltAction;
		options = new HashMap<String,Transition>();
	}
}
