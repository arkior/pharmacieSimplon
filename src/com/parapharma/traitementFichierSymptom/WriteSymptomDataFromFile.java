package com.parapharma.traitementFichierSymptom;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class WriteSymptomDataFromFile
{
	private String cheminFichierAEcrire;
	
	public WriteSymptomDataFromFile(String unChemin)
	{
		this.cheminFichierAEcrire= unChemin;
	}
	
	
	
	public static  void setSymptoms() 
	{
			WriteSymptomDataFromFile toto = new WriteSymptomDataFromFile("src/symptoms.txt");
			
			try 
			{
			//FileWriter writer = new FileWriter (toto.cheminFichierAEcrire,true);
			PrintWriter pOut = new PrintWriter(new BufferedWriter(new FileWriter (toto.cheminFichierAEcrire,true)));
			boolean sortir = false;
			do 
			{
				Scanner sc = new Scanner(System.in);
				System.out.println("veuillez saisir le symptome a rajouter");
				String symptom= sc.nextLine();
				
				
				System.out.println("voulez vous rajouter un symptome O/N ?");
				String choix = new String (sc.next().toUpperCase());
				int valueChoix = (int) choix.charAt(0);
				if (valueChoix== 79 || valueChoix== 78)
				{
					pOut.print(symptom+ "\n");
					switch(valueChoix)
					{
					case 78 :
						sortir = true;
						break;
					case 79 : 
						break;
					}
					
					
				}
				else
				{
					System.out.println("choix invalide...");
				}
				
				
			}while(!sortir);
			
			pOut.close();
			}catch(IOException e) 
			{
				e.printStackTrace();
			}
			
	}
	
	public boolean supprimerValeur(String nom)
	{
		boolean resultat = false; ;
		String valeurParametre = new String(nom);
		ReadSymptomDataFromFile toto = new ReadSymptomDataFromFile("src/symptoms.txt");
		List<String> listeProvisoire = toto.GetSymptoms();
		resultat =  listeProvisoire.remove(valeurParametre);
			
		try 
		{
			//FileWriter writer = new FileWriter (toto.cheminFichierAEcrire,true);
			PrintWriter pOut = new PrintWriter(new BufferedWriter(new FileWriter (this.cheminFichierAEcrire)));
			
			for(String symptom : listeProvisoire)
			{
				
				  pOut.print(symptom+ "\n");
			}
			
			pOut.close();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		return resultat;
		
	}
	
	public static void supprimerSymptome() 
	{
		WriteSymptomDataFromFile toto = new WriteSymptomDataFromFile("src/symptoms.txt");
		Scanner choixValeur = new Scanner(System.in);
		System.out.println("quelle symptome voulez vous supprimer du fichier symptome.txt ?");
		String symptomeChoisi = choixValeur.nextLine();
		boolean resultat = toto.supprimerValeur(symptomeChoisi);
		String message = (resultat)?"suppression reussi":"le symptome n'existe pas dans votre fichier";		
		System.out.println(message);
	}

}
