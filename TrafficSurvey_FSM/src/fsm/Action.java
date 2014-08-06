package fsm;
/**
 * 
 * @author dels
 *
 *	The Action Interface enables the FSM designer to configure a State object
 *	so the FSM engine will execute a context-specific action for an (Event,State) combination.
 * 
 */
public interface Action {

	public void do_it(Object model);
	
}
	
/*	
 * to construct a singleton Object with this interface
 * create a class using the following template
 * 
package myApp;

import fsm.Action;

public class <Type> implements Action {

	@Override
	public void do_it() {
		// TODO Auto-generated method stub
		System.out.println("This is my Action Type");
	}
 
	public static <Type> getInstance() {return INSTANCE; }
	public static final <Type> INSTANCE = new <Type>();
	private <Type>() {};
*
* then instantiate it with 
*   static <Type>  myType = <Type>.getInstance();
*/
