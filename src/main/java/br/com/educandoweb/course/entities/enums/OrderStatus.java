package br.com.educandoweb.course.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	// CRIAR UM CONSTRUTOR PARA RETORNAR O STATUS
	private OrderStatus(int code) {
		this.code = code;
	}
	
	// METODO PUBLICO RECEBENDO O VALOR
	public int getCode() {
		return code;
	}

	// UM FOR PARA TRADUZIR O NUMERO QUE O USUARIO DIGITOU EM UM ENUM
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
	

	
	
}
