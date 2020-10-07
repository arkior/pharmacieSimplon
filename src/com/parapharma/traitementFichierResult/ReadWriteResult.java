package com.parapharma.traitementFichierResult;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.parapharma.interfaces.ISymptomReader;

public class ReadWriteResult implements ISymptomReader
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
				writer.write("symptome : "+i+ " "+this.listeSymptomesOccurences.get(i)+"\n");
			}
			writer.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
	
	
	@Override
	public List<String> GetSymptoms() {
			
			
		if (this.cheminFichierAEcrire != null)
		{
			try {
				BufferedReader reader = new BufferedReader (new FileReader(this.cheminFichierAEcrire));
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
	
	public void getResult() 
	{
		for(String i : this.GetSymptoms()) 
		{
			System.out.println("symptome : " +i);
		}
	}

}
