package com.caci.model;

/**
 * enum décrivant le type de la taxe.
 * 
 * @author slimane
 *
 */
public enum TaxType {
	NONE(0),
	BOOK(10),
	OTHERS(20),
	IMPORTED(5);
	
	
	private double tax;
	
	private TaxType(double tax){
		this.tax = tax;
	}
	
	public double getTax(){
		return tax / 100;
	}

}
