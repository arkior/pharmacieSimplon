package com.parapharma.analytics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.parapharma.traitementFichierResult.WriteResult;
import com.parapharma.traitementFichierSymptom.ReadSymptomDataFromFile;
/**
 * <b>class AnalyticsCounter</b>
 * AnalyticsCounter est une classe qui analyse le fichier de la classe ReadSymptomDataFromFile et qui affche les occurences.
 * @author gautherot christophe
 * @version version 3 
 */

public class AnalyticsCounter 
{
	private ReadSymptomDataFromFile readSymptom;
	private WriteResult writeResult;


	
	/**
	 * <b>methode setSymptomesOccurence()</b> 
     * methode qui analyse les occurences et demande a la classe WriteResult d'ecrire le resultat des occurences
     * sur le fichier result.out
     * @return une HashMap 
     */
	private HashMap<String,Integer> setSymptomesOccurence()
	{
		this.readSymptom = new ReadSymptomDataFromFile();
		this.writeResult = new WriteResult();
		
			for(String symptome : this.readSymptom.GetSymptoms())
			{
				   Integer count = this.writeResult.getListeSymptomesOccurences().get(symptome);
				   this.writeResult.getListeSymptomesOccurences().put(symptome, (count == null) ? 1 : count + 1);  
			}
			this.writeResult.setEcriture();
				

		return this.writeResult.getListeSymptomesOccurences();
	}
	
	//methode qui renvoie le resultat de la HashMap de la Classe WriteResult avec tri
	
	/**
	 * <b>methode triHashMap()</b> 
     * methode qui tri en ordre croissant la hashmap des occurences  
     */
	public void triHashMap()
	{
		Map<String,Integer> sorteMap = new TreeMap<>(this.writeResult.getListeSymptomesOccurences());
		Set<Entry<String, Integer>> set = sorteMap.entrySet();
		Iterator<Entry<String, Integer>> iterator = set.iterator();
		
		while(iterator.hasNext())
		{
			Map.Entry<String, Integer> me = (Map.Entry<String, Integer>)iterator.next();
			System.out.println("symptome : "+me.getKey()+ " : "+me.getValue());
			
		}
		
		
	}
	
	
	/**
	 * <b>methode getResult()</b> 
     * methode qui affiche dans la console la HashMap de la classe WriteResult sans tri
     */
	public void getResult()
	{
		for(String i : this.writeResult.getListeSymptomesOccurences().keySet()) 
		{
			System.out.println("symptome : "+i + " : "+this.writeResult.getListeSymptomesOccurences().get(i));
		}
		System.out.println("\n");
	}
	
	
	 /** 
	  *<b>methode init()</b>
     * methode qui est appelee dans le Main 
     */
	public static void init()
	{
		AnalyticsCounter toto = new AnalyticsCounter();
		toto.setSymptomesOccurence();
		toto.triHashMap();;
		
	}
	
	
	
	
	
	
}