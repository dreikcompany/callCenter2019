package com.almundo.callCenter2019;

public class App {
    public static void main( String[] args ) {
        System.out.println( "******************** CALL CENTER ALMUNDO 2019 ********************" );
        int callDemand = 10;
        Dispatcher dispatcher = new Dispatcher(callDemand);
        dispatcher.dispatchCall();
        dispatcher.report();
    }
   
}
