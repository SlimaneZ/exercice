package com.caci.util;

import static com.caci.util.Constante.ORDER_FOLDER;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * Classe utilitaire 
 *
 */
public class ProductUtil {
	

	private static final Logger logger = LogManager.getLogger(ProductUtil.class);
	
	private ProductUtil(){
		
	}
	
	/**
	 * Suuprimer les derniers caractères d'une chaine.
	 * 
	 * @param string: la chaine de caractère
	 * @param n: le nombre de cacactères à supprimer
	 * @return la chaine de caractère coupée
	 */
	public static String cutOffEnd(String string, int n) {
	    if (n > string.length())
	        throw new IllegalArgumentException("n ne doit pas etre supérieur à la longueur de la chaine");
	    return string.substring(0, string.length() - n);
	}
	/**
	 * Retourne la liste de tous les fichiers dans le répertoire order
	 * 
	 * @return liste des fichiers
	 */
	public static List<String> getAllFileNames(){				
		List<String> fileNames = new ArrayList<>();
		Path gitReposFolderPath = Paths.get(ORDER_FOLDER);
		try (Stream<Path> forderStream = Files.list(gitReposFolderPath)){
			              forderStream.filter(p -> p.toFile().isFile())
			                          .forEach(p -> fileNames.add(p.toFile().getName())); 
		}catch (IOException ioe){
			logger.error("erreur dans la lecture "+ORDER_FOLDER, ioe);
		}
		
		return fileNames;
	}


}
