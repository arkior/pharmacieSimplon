package com.parapharma.testPharma;

import java.util.HashMap;
import java.util.Scanner;

import com.parapharma.analytics.AnalyticsCounter;
import com.parapharma.traitementFichierSymptom.ReadSymptomDataFromFile;
import com.parapharma.traitementFichierSymptom.WriteSymptomDataFromFile;
/**
 * <b>class test_pharmacie</b>
 * test_pharmacie est une classe qui traite l'affichage des donnees 
 * @author gautherot christophe
 * @version version 3 
 */

public class test_pharmacie {

	public static void main(String[] args)
	{
		Scanner choixUtilisateur= new Scanner(System.in);
		boolean choixOk = false;
		do 
		{
			
			System.out.println("\n***************************************************************\n                              MENU                                      \n***************************************************************\n");
			System.out.println("\nque voulez vous faire ?\n\n"
								+ "1- lire le fichier (symptoms.txt)\n"
								+ "2- voir les occurences du fichier (symptoms.txt)\n"
								+ "3- ajouter un symptome au fichier (symptoms.txt)\n"
								+ "4- supprimer un symptome du fichier (symptoms.txt)\n"
								+ "5- quitter");
			
			String choixTape = new String(choixUtilisateur.next()).toUpperCase();
			int choixUser = (int) choixTape.charAt(0);
			if(choixUser ==49 ||choixUser ==50 ||choixUser ==51 || choixUser ==52  || choixUser ==53 )
			{
				
				switch(choixUser) 
				{
				case 49:
					ReadSymptomDataFromFile.init();
					break;
				case 50:
					AnalyticsCounter.init();
					break;
				case 51:
					WriteSymptomDataFromFile.setSymptoms();
					break;
				case 52:
					WriteSymptomDataFromFile.supprimerSymptome();
					break;
				case 53:
					choixOk = true;
					break;
				
				}
			}
			else
			{
				System.out.println("ce choix n'est pas dans la liste\nveuillez recommencer");
				choixOk = false;
				
			}
		}
		while(!choixOk);
		
		System.out.println("merci au revoir...");
	
		
	}

}
