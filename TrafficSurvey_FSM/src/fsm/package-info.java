/**
 * @author dels
 *
 */
package fsm;
/*
 * The FSM package is a framework for building a Finite State Machine
 * 
 * The FSM has two fields
 *    state    - a State object which represents the current machine state
 *    model    - an Object containing the implementation-specific data
 * 
 * The implementer creates a sub-class of FSM
 * This implementation is responsible for building
 * 		a model class containing the implementation-specific data
 * 		some actions, implementing the Action interface, which operate on the model during state transitions
 * 		State objects representing the solution states, 
 * 		a set of Transitions, added to each State for its valid events
 * 
 * A Transition specifies the next State plus an Action, executed before entering the next state
 * 
 * The FSM must be configured with its 'model' Object and the initial State
 * 
 * Thereafter the FSM client invokes the 'handleEvent()' method each time an event fires
 * 
 * The Action interface has a method  "do_it( Object )", which is executed during a state transition
 * 
 * The State class 
 * 		implements Action, with a default, do-nothing 'do_it()' method
 * 		has a Map containing a Transition for each valid event
 * 		has an onEvent() method that may perform an Action and will return the next State
 */
