package com.parapharma.traitementFichierResult;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ReadWriteResult
{

	private String cheminFichierAEcrire;
	private HashMap<String,Integer>listeSymptomesOccurences = new HashMap<>();
	private ArrayList<String> result = new ArrayList<String>();
	
	public ReadWriteResult ()
	{
	
		this.cheminFichierAEcrire= "src/result.out";
	}
	
	
	public ReadWriteResult (String fichierEcriture)
	{
		
		this.cheminFichierAEcrire= fichierEcriture;
	}

	public HashMap<String, Integer> getListeSymptomesOccurencesVide()
	{
		return this.listeSymptomesOccurences;
	}

	public void setEcriture()
	{
		try
		{
			FileWriter writer = new FileWriter (this.cheminFichierAEcrire);
			for (String i :this.listeSymptomesOccurences.keySet() ) 
			{
				writer.write("symptomes : "+i+ " "+this.listeSymptomesOccurences.get(i)+"\n");
			}
			writer.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
	
	public  void getFichierResult()
	{
		if (this.cheminFichierAEcrire != null)
		{
			try {
				BufferedReader reader = new BufferedReader (new FileReader(this.cheminFichierAEcrire));
				String line = reader.readLine();
				
				while (line != null) {
					this.result.add(line);
					System.out.println(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}

}
