package com.parapharma.traitementFichierSymptom;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.parapharma.interfaces.ISymptomReader;

/**
 * <b>class ReadSymptomDataFromFile</b>
 * ReadSymptomDataFromFile est une classe qui ne lit que les donnees dans le fichier symptoms.txt
 * @author gautherot christophe
 * @version version 3 
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	private ArrayList<String> result = new ArrayList<String>();
	

    /** 
     * <b>Constructeur ReadSymptomDataFromFile()</b> 
     * qui initialise directement le fichier a lire
     */
	public ReadSymptomDataFromFile ()
	{
		this.filepath = "src/symptoms.txt";
	}
	
	

	public String getFilepath()
	{
		return this.filepath;
	}



	/**
	 * <b>methode getSymptoms()</b> 
     * methode de l'interface redefinie qui lit le fichier symptoms.txt 
     * @return retourne une List des symptomes triés 
     */
	@Override
	public List<String> GetSymptoms()
	{
		
		
		if (this.filepath != null)
		{
			try {
				BufferedReader reader = new BufferedReader (new FileReader(this.filepath));
				String line = reader.readLine();
				
				while (line != null) 
				{
					this.result.add(line);
					line = reader.readLine();
				}
				reader.close();
			}
			catch (IOException e)
			{
				Scanner sc = new Scanner(System.in);
				System.out.println("votre dossier est introuvable...\nveuillez specifier le chemin du fichier que vous voulez lire ?");
				this.filepath = sc.nextLine();
				this.GetSymptoms();
				//e.printStackTrace();
			}
		}
		Collections.sort(this.result);
		return this.result;
	}

	 /** 
	  * <b>methode getListesSymptoms()</b>
     * methode qui lit la liste de symptomes du fichier symptoms.txt 
     */ 
	public void getListesSymptoms()
	{
		for(String s : this.GetSymptoms()) 
		{
			System.out.println("symptome : "+ s);
		}
		
	}
	
   /** 
    * <b>methode init()</b>
     * methode qui appelee dans le Main 
     */
	public static void init()
	{
		ReadSymptomDataFromFile toto = new ReadSymptomDataFromFile();
		toto.getListesSymptoms();
	
	}
		
		
		
		
		

}
