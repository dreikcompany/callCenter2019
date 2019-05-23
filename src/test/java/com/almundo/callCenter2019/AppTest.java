package com.almundo.callCenter2019;


import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class AppTest{
	
	@Test
	public void process10Calls()  {
		System.out.println( "******************** CALL CENTER ALMUNDO 2019 ********************" );
        int callDemand = 10;
        Dispatcher dispatcher = new Dispatcher(callDemand);
        dispatcher.dispatchCall();
        dispatcher.report();
        assertEquals("No se pudieron atender las 10 llamadas solicitadas", 10, dispatcher.getProcessedCalls());
	}
	
	@Test
	public void process30Calls()  {
		System.out.println( "******************** CALL CENTER ALMUNDO 2019 ********************" );
        int callDemand = 30;
        Dispatcher dispatcher = new Dispatcher(callDemand);
        dispatcher.dispatchCall();
        dispatcher.report();
        int calls = dispatcher.getProcessedCalls() + dispatcher.getCallsToMake() + dispatcher.getHungCalls();
        assertEquals("No se pudieron atender las 30 llamadas solicitadas", 30, calls);
	}
}
