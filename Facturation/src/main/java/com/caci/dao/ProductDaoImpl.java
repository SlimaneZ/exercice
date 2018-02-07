package com.caci.dao;

import static com.caci.util.Constante.ORDER_FOLDER;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.caci.exception.ResourceNotFoundException;


/**
 * Classe DAO lecture des fichiers input.
 * 
 * @author Slimane.
 *
 */
@Component
public class ProductDaoImpl implements ProductDao {

	

	private static final Logger logger = LogManager.getLogger(ProductDaoImpl.class);

	/**
	 * Lire le contenu du fichier
	 * 
	 * @param fileName: nom de fichier          
	 */
	@Override
	public List<String> readProducts(String fileName) {
		List<String> productRows = new ArrayList<>();
		String url = ORDER_FOLDER + fileName;
		Path path = Paths.get(url);
		try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
			String currentLine = null;
			while ((currentLine = reader.readLine()) != null) {
				productRows.add(currentLine);
			}
		} catch(NoSuchFileException ex){
			logger.error("Le fichier demandé est introuvable ", ex);
			throw new ResourceNotFoundException(null, "fichier "+fileName+"  non trouvé");
		}catch (IOException ex) {
			logger.error("erreur dans la lecture du fichier ", ex);
		}

		return productRows;
	}



	
}
