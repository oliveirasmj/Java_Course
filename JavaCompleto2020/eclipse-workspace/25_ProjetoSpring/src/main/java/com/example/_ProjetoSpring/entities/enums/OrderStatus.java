package com.example._ProjetoSpring.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENTS(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueof(int code) { //devolver o nome correspontente a cada estado de order
		for(OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus Code");
	}
}
