package com.parapharma.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	private ArrayList<String> result = new ArrayList<String>();
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> GetSymptoms() {
		
		
		if (this.filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(this.filepath));
				String line = reader.readLine();
				
				while (line != null) {
					this.result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public static void init()
	{
		//Scanner choixUtilisateur = new Scanner(System.in);
		//System.out.println("\nVeuiller me donner le chemin du fichier a lire ?\n");
		String path ="src/symptoms.txt" ;                                    //choixUtilisateur.next() ;
		ReadSymptomDataFromFile toto = new ReadSymptomDataFromFile(path);
		;
		int i = 1;
		for (String symptone : toto.GetSymptoms()) 
		{
			System.out.println(i+": "+symptone);
			i++;
		}
		
	}
	

		
		
		
		
		

}
