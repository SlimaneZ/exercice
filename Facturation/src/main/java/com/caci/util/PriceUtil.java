package com.caci.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Classe utilitaire pour manipuler les prix
 *
 */
public class PriceUtil {
	
	private PriceUtil(){
		
	}
	
	/**
	 * Arrondir une valeur 
	 * 
	 * @param value: la valeur à arrondir 
	 * @param increment: l'incrément
	 * @param roundingMode: le mode de l'arrondi 
	 * @return la valeur arrondie
	 */
	public static BigDecimal round(BigDecimal value, BigDecimal increment, RoundingMode roundingMode) {
		if (increment.signum() == 0) {
			// Si increment = 0  la valeur arrondie est la même que la valeur en entrée
			return value;
		} else {
			BigDecimal divided = value.divide(increment, 0, roundingMode);
			return divided.multiply(increment);
		}
	}
	
	

	
}
