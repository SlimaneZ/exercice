package com.caci.util;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public  class Constante {
	
	//Répertoire contenant les fichiers paniers
	public static final String ORDER_FOLDER = "src/main/resources/order/";
	
	//Les produits alimentaires
	public static final String[] FOOD_PRODUCTS = new String[] {"CHOCOLAT"};
	
	//Liste contenant des mots clés represantant des médicaments
	public static final String[] MEDICAL_PRODUCTS = new String[] {"PILULE"};
	
	public static final String[] BOOK_PRODUCTS = new String[] {"LIVRE"};
	public static final Set<String> FOOD_PRODUCTS_SET = new HashSet<>(Arrays.asList(FOOD_PRODUCTS));
	public static final Set<String> MEDICAL_PRODUCTS_SET = new HashSet<>(Arrays.asList(MEDICAL_PRODUCTS));
	public static final Set<String> BOOK_PRODUCTS_SET = new HashSet<>(Arrays.asList(BOOK_PRODUCTS));
	public static final String IMPORT = "IMPORT";
	public static final String SPACE = " ";
	
	

	
	private Constante(){
		
	}

}
