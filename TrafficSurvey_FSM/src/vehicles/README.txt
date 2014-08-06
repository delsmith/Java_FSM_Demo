/**
 * FSM model
 *		the client process 
 *			generates an Event
 *			passes Event to FSM handler
 *		the FSM 
 *			passes the Event to the active State object
 *		the State object
 *			retrieves a 'Transition' for (Event,State)
 *			if Transition is null,
 *				executes default Action
 *				enters default State
 *			else
 *				executes Action
 *				enters next State
 *
 */
