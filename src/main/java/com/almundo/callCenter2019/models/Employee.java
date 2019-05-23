package com.almundo.callCenter2019.models;

public class Employee implements Comparable<Employee>{
	String name;
	TypeEmployee typeEmployee;
	
	public Employee(String name, TypeEmployee typeEmployee) {
		super();
		this.name = name;
		this.typeEmployee = typeEmployee;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public TypeEmployee getTypeEmployee() {
		return typeEmployee;
	}
	
	public void setTypeEmployee(TypeEmployee typeEmployee) {
		this.typeEmployee = typeEmployee;
	}
	
	public void answerCall (Call call) {
		try {
			System.out.println(this.getTypeEmployee().getDescription() + ": "+
					this.getName() +" llamada atendida en " + call.getCallDuration() + " segundos.");
			Thread.sleep(call.getCallDuration() * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int compareTo(Employee employee) {
		return this.getTypeEmployee().getValue().compareTo(employee.getTypeEmployee().getValue());
	}

}
