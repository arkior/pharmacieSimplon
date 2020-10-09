package com.parapharma.traitementFichierResult;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.parapharma.interfaces.ISymptomReader;


/**
 * <b>class WriteResult</b>
 * WriteResult est une classe qui ecrit que les donnees dans le fichier result.out
 * @author gautherot christophe
 * @version version 3 
 */
public class WriteResult 
{

	private String cheminFichierAEcrire;
	private HashMap<String,Integer>listeSymptomesOccurences = new HashMap<>();
	
	/** 
     * <b>Constructeur WriteResult()</b> 
     * qui initialise directement le fichier dans lequel ecrire
     */
	public WriteResult ()
	{
	
		this.cheminFichierAEcrire= "src/result.out";
	}

	/**
	 * <b>methode getListeSymptomesOccurences()</b> 
     * gettter du la HashMap
     * @return retourne la HashMap de l'objet courant
     */
	public HashMap<String, Integer> getListeSymptomesOccurences()
	{
		return this.listeSymptomesOccurences;
	}

	
	/**
	 * <b>methode setEcriture()</b> 
     * methode qui lit la HashMap de l'objet courant et qui l'ecrit dans le fichier result.out
     * 
     */
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
			Scanner sc = new Scanner(System.in);
			System.out.println("votre dossier est introuvable veuillez specifier le chemin du fichier dans lequel vou voulez ecrire ?");
			this.cheminFichierAEcrire = sc.nextLine();
			this.setEcriture();
		}

	}

}
