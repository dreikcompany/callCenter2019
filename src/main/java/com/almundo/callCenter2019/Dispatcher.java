package com.almundo.callCenter2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

import com.almundo.callCenter2019.models.Answer;
import com.almundo.callCenter2019.models.Call;
import com.almundo.callCenter2019.models.Employee;
import com.almundo.callCenter2019.models.TypeEmployee;

public class Dispatcher {
	
	private int processedCalls;
	private int callWaiting;
	private int hungCalls;
	private int callsToMake;
	private ExecutorService executorService;
	private PriorityBlockingQueue<Employee> employees;
	private int callDemand;
	
	public Dispatcher(int callDemand) {
		this.processedCalls = 0;
		this.callWaiting = 0;
		this.hungCalls = 0;
		this.callsToMake = 0;
		this.executorService = Executors.newFixedThreadPool(callDemand);
		this.employees = generateEmployees();
		this.callDemand = callDemand;
	}
	
	public void dispatchCall() {
		try {
			List<Call> calls = generateCallforDemand();
			if (!calls.isEmpty()) {
				for (Call call : calls) {
					if (!employees.isEmpty()) {
						Employee employee = employees.poll();
						executorService.submit(task(call, employee));
					} else {
						StringBuilder menu = new StringBuilder();
						menu.append("**************************************** \n")
							.append("Nuestros asesores se encuentran ocupados \n")
							.append("Mantenerse en espera Oprima: 0 \n")
							.append("Dejar numero de contacto Oprima: 1 \n")
							.append("Finalizar llamada Oprima: 2 \n")
							.append("**************************************** \n");
						Random random = new Random();
						int answer = random.nextInt(3);
						
						switch (answer) {
							case 0:
								System.out.println(menu.append(Answer.ESPERAR.getDescription()).toString());
								Employee employee = employees.take();
								callWaiting++;
								executorService.submit(task(call, employee));
								break;
							case 1:
								System.out.println(menu.append(Answer.DEJAR_NUMERO.getDescription()).toString());
								callsToMake++;
								break;
							case 2:
								System.out.println(menu.append(Answer.FINALIZAR.getDescription()).toString());
								hungCalls++;
								break;
						}
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} 
	
	private Runnable task(Call call, Employee employee) {
		processedCalls++;
		Runnable runnable = () -> {
			employee.answerCall(call);
			employees.add(employee);
		};
		
		return runnable;
	}
	
	public void report() {
		executorService.shutdown();
		while (!executorService.isTerminated()) {
        	// esperamos que todas las tareas terminen
        }
		
		System.out.println("****************************************");
		System.out.println("Cantidad de llamadas procesadas: " + processedCalls);
		System.out.println("Cantidad de llamadas en espera: " + callWaiting);
		System.out.println("Cantidad de llamadas por hacer: " + callsToMake);
		System.out.println("Cantidad de llamadas perdidas: " + hungCalls);
		System.out.println("****************************************");
	}
	
	private PriorityBlockingQueue<Employee> generateEmployees() {
    	PriorityBlockingQueue<Employee> employees = new PriorityBlockingQueue<Employee>();
    	employees.add(new Employee("Jose Ramos", TypeEmployee.OPERADOR));
    	employees.add(new Employee("Laura Gil", TypeEmployee.OPERADOR));
    	employees.add(new Employee("Juan Marin", TypeEmployee.OPERADOR));
    	employees.add(new Employee("Danny Camacaro", TypeEmployee.OPERADOR));
    	employees.add(new Employee("Ericka Montero", TypeEmployee.OPERADOR));
    	employees.add(new Employee("Kisbel Caldera", TypeEmployee.OPERADOR));
    	employees.add(new Employee("Ray Gonzalez", TypeEmployee.SUPERVISOR));
    	employees.add(new Employee("Claudio Castillo", TypeEmployee.SUPERVISOR));
    	employees.add(new Employee("Leopoldo Ruan", TypeEmployee.SUPERVISOR));
    	employees.add(new Employee("Mariela Louis", TypeEmployee.DIRECTOR));
    	return employees;
    }
	
	private List<Call> generateCallforDemand() {
		List<Call> calls = new ArrayList<Call>();
		if (callDemand > 0) {
			for (int i = 0; i < callDemand; i++) {
				Call call = new Call();
				calls.add(call);
			}
		}
		return calls;
	}

	public int getProcessedCalls() {
		return processedCalls;
	}

	public int getCallWaiting() {
		return callWaiting;
	}

	public int getHungCalls() {
		return hungCalls;
	}

	public int getCallsToMake() {
		return callsToMake;
	}

	public int getCallDemand() {
		return callDemand;
	}

}
