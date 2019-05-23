package com.almundo.callCenter2019.models;

public enum Answer {
	ESPERAR(0, "Mantenerse en espera"), DEJAR_NUMERO(1, "Dejar numero de contacto"), FINALIZAR(2, "Finalizar llamada");
	
	private Integer value;
	private String description;
	
	private Answer(Integer value, String description) {
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
