package com.almundo.callCenter2019.models;

public enum TypeEmployee {
	OPERADOR(0, "Operador"), SUPERVISOR(1, "Supervisor"), DIRECTOR(2, "Director");

	private Integer value;
	private String description;
	
	private TypeEmployee(Integer value, String description) {
		this.value = value;
		this.description = description;
	}

	public Integer getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}
	
}
