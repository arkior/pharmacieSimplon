package com.parapharma.analytics;

import java.util.HashMap;

import com.parapharma.traitementFichierResult.ReadWriteResult;
import com.parapharma.traitementFichierSymptom.ReadSymptomDataFromFile;


public class AnalyticsCounter 
{
	private ReadSymptomDataFromFile readSymptom;
	private ReadWriteResult readWriteResult;
	private String fichierAnalyser;
	
	public AnalyticsCounter() 
	{
		this.fichierAnalyser = "src/symptoms.txt";
	}
	
	
	private HashMap<String,Integer> setSymptomesOccurence()
	{
		this.readSymptom = new ReadSymptomDataFromFile(this.fichierAnalyser);
		this.readWriteResult = new ReadWriteResult();
		
			for(String symptome : this.readSymptom.GetSymptoms())
			{
				   Integer count = this.readWriteResult.getListeSymptomesOccurencesVide().get(symptome);
				   this.readWriteResult.getListeSymptomesOccurencesVide().put(symptome, (count == null) ? 1 : count + 1);  
			}
			this.readWriteResult.setEcriture();
				

		return this.readWriteResult.getListeSymptomesOccurencesVide();
	}
	
	/*
	public void getResult()
	{
		for(String i : this.readWriteResult.getListeSymptomesOccurencesVide().keySet()) 
		{
			System.out.println("symptome : "+i + " : "+this.readWriteResult.getListeSymptomesOccurencesVide().get(i)+"\n");
		}
		System.out.println("\n");
	}
	
	*/
	
	public static void init()
	{
		//Scanner choixUtilisateur = new Scanner(System.in);
		//System.out.println("\nVeuiller me donner le chemin du fichier a lire ?\n");
		//String pathLire = choixUtilisateur.next() ;
		//System.out.println("\nVeuiller me donner le chemin du fichier dans lequel vous voulez ecrire ?\n");
		//String pathEcrire = choixUtilisateur.next() ;
		AnalyticsCounter toto = new AnalyticsCounter();
		toto.setSymptomesOccurence();
		ReadWriteResult toto2 = new ReadWriteResult();
		toto2.getResult();
		
	}
	
	
	
	
	
	
}