package com.parapharma.modeles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;




public class ecrireFile
{
	private String cheminFichierALire;
	private String cheminFichierAEcrire;
	private HashMap<String,Integer>listeSymptomesOccurences = new HashMap<>();
	
	
	
	public ecrireFile (String fichierLu,String fichierEcriture)
	{
		this.cheminFichierALire = fichierLu;
		this.cheminFichierAEcrire= fichierEcriture;
	}
	
	//methode qui lit un fichier et initialise la hashMap hashMap avec cle=symptones valeur=occurences de l'objet coutrant 
	private HashMap<String,Integer> getSymptomesOccurence()
	{
		
		
		ArrayList<String> result = new ArrayList<>();
		if (this.cheminFichierALire != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(this.cheminFichierALire));
				String line = reader.readLine();
	
				result.add(line);
				while (line != null)
				{
				
					result.add(line);
					line = reader.readLine();
				
					
				}
				for(String symptome : result)
				{
					
					String key = symptome;
					Integer count = this.listeSymptomesOccurences.get(key);
		               this.listeSymptomesOccurences.put(key, (count == null) ? 1 : count + 1);  
				}
				this.setEcriture();
				
				
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return this.listeSymptomesOccurences;
	}
	
	//methode pour ecrire dans un fichier qui sera indique lors de sa construction
	public void setEcriture()
	{
			try
			{
				FileWriter writer = new FileWriter (this.cheminFichierAEcrire);
				for (String i :listeSymptomesOccurences.keySet() ) 
				{
					writer.write(i+ "  : "+listeSymptomesOccurences.get(i)+" Occurences\n");
				}
				writer.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}

	}
	
	
	public void getOccurences()
	{
		for(String i : this.listeSymptomesOccurences.keySet()) 
		{
			System.out.println("symptomes : "+i + " : "+this.listeSymptomesOccurences.get(i));
		}
		System.out.println("\n");
	}
	
	public static void init()
	{
		//Scanner choixUtilisateur = new Scanner(System.in);
		//System.out.println("\nVeuiller me donner le chemin du fichier a lire ?\n");
		//String pathLire = choixUtilisateur.next() ;
		//System.out.println("\nVeuiller me donner le chemin du fichier dans lequel vous voulez ecrire ?\n");
		//String pathEcrire = choixUtilisateur.next() ;
		ecrireFile toto = new ecrireFile("src/symptoms.txt","src/result.out");
		toto.getSymptomesOccurence();
		toto.setEcriture();
		toto.getOccurences();
		
		
	}

	



	
	/*
	FileWriter writer = new FileWriter ("src/result.out");
	writer.write("headache: " + headacheCount + "\n");
	writer.write("rash: " + rashCount + "\n");
	writer.write("dialated pupils: " + pupilCount + "\n");
	writer.close();
	*/
}
