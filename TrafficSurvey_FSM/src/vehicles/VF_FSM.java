package vehicles;


import fsm.FSM;
import fsm.State;

public class VF_FSM extends FSM {
	
	// TODO: may need a finalise() method to clean up if used in a non-stop application
	
	// Build the state table
	public VF_FSM( VF_Model model ) {

		// Instantiate Actions
		NewDn NewDN = NewDn.getInstance();
		NewUp NewUP = NewUp.getInstance();    
		SaveDn SaveDN = SaveDn.getInstance(); 
		SaveUp SaveUP = SaveUp.getInstance(); 
		Resync ReSync = Resync.getInstance();
		
		// Instantiate States
		State RST = new State("Reset",null,ReSync);
		State DN1 = new State("Down1",RST,ReSync); 
		State DN2 = new State("Down2",RST,ReSync); 
		State UP1 = new State("Up1",RST,ReSync);   
		State UP2 = new State("Up2",RST,ReSync);   
		State CC1 = new State("Cc1",RST,ReSync);   
		State CC2 = new State("Cc2",RST,ReSync);   
		State CC3 = new State("Cc3",RST,ReSync);   
		State OL1 = new State("Ol1",RST,ReSync);   
		State OL2 = new State("Ol1",RST,ReSync);   
		State OL3 = new State("Ol3",RST,ReSync);   
		State OL4 = new State("Ol4",RST,ReSync);   
		State OL5 = new State("Ol5",RST,ReSync);   
		State OL6 = new State("Ol6",RST,ReSync);   
		State OL7 = new State("Ol7",RST,ReSync);   
		State IDLE = new State("Idle",RST,ReSync);
		
		// Add Event handlers to States
		IDLE.addEvent("A1",DN1,NewDN);
		IDLE.addEvent("A2",DN1,NewDN);
		IDLE.addEvent("A3",DN1,NewDN);
		IDLE.addEvent("A4",DN1,NewDN);
	
		DN1.addEvent("A1",CC1,NewUP);
		DN1.addEvent("A2",OL1,NewUP);
		DN1.addEvent("A3",IDLE,SaveDN);
		DN1.addEvent("B1",UP1,NewUP);
		
		DN2.addEvent("A1",IDLE,SaveDN);
		DN2.addEvent("A2",IDLE,SaveDN);
		DN2.addEvent("A3",IDLE,SaveDN);
		DN2.addEvent("A4",IDLE,SaveDN);
		
		UP1.addEvent("A1",CC2,null);
		UP1.addEvent("A2",OL2,null);
		UP1.addEvent("A3",UP2,null);
		
		UP2.addEvent("B1",IDLE,SaveUP);
		
		CC1.addEvent("B1",CC2,null);
		
		CC2.addEvent("A2",CC3,null);
		
		CC3.addEvent("B1",DN2,SaveUP);
		
		OL1.addEvent("B1",OL4,null);
		
		OL2.addEvent("A1",OL3,null);
		OL2.addEvent("A2",OL3,null);
		OL2.addEvent("A3",OL3,null);
		OL2.addEvent("A4",OL3,null);
		
		OL3.addEvent("B1",DN2,SaveUP);
		
		OL4.addEvent("A2",OL5,null);
		OL4.addEvent("A3",OL6,null);
		
		OL5.addEvent("A2",UP1,null);
		
		OL6.addEvent("A1",UP2,SaveDN);
		OL6.addEvent("B1",OL7,SaveUP);
		
		OL7.addEvent("A1",IDLE,SaveDN);
		
		RST.addEvent("A1",DN1,NewDN);
		RST.addEvent("A2",DN1,NewDN);
		RST.addEvent("A3",DN1,NewDN);
		RST.addEvent("A4",DN1,NewDN);
		RST.addEvent("B1",RST,NewDN);
		
		// set the initial State and save the data model
		this.configure( IDLE, model );
	}

}