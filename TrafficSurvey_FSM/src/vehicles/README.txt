/**
 * FSM model
 *		the client process 
 *			generates an Event
 *			activates the FSM with the Event
 *		the FSM
 *			retrieves a 'Transition' for (Event,State)
 *			if Transition is null,
 *				executes Resync.handler <which will change State>
 *				retrieves Transition for (Event,State)
 *			executes Transiton.handler
 *     the handler
 *			executes 'onExit' method
 *			updates the State
 */



		/*
		 * I would expect the following code to return the same thing for temp and temp2
		 * but it generates different Hashes so only the original tag Object finds a match
		 * 
				VF_tag tTag = new VF_tag(VF_ev.NA,VF_st.RESYNC);
				FsmMap.put( tTag, new VF_trans(VF_act.NONE,VF_st.RESYNC));
				VF_trans temp = FsmMap.get( tTag);
				VF_tag tTag2 = new VF_tag(VF_ev.NA,VF_st.RESYNC);
				VF_trans temp2 = FsmMap.get( tTag2);
		 */

