package com.parapharma.analytics;


import java.util.Scanner;

import com.parapharma.modeles.ecrireFile;

public class AnalyticsCounter {
		
	public static void main(String args[]) throws Exception
	{
		
		
		
		
		Scanner choixUtilisateur = new Scanner(System.in);
		boolean choixOk = false;
		do 
		{
			System.out.println("\n***************************************************************\n                              MENU                                      \n***************************************************************\n");
			System.out.println("\nque voulez vous faire ?\n1- lire le fichier (symptoms.txt)\n2- voir les occurences du fichier (symptoms.txt)\n3- quitter");
			String choixTape = new String(choixUtilisateur.next()).toUpperCase();
			int choixUser = (int) choixTape.charAt(0);
			if(choixUser ==49 ||choixUser ==50 ||choixUser ==51 )
			{
				
				switch(choixUser) 
				{
				case 49:
					ReadSymptomDataFromFile.init();
					break;
				case 50:
					ecrireFile.init();
					break;
				case 51:
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
		choixUtilisateur.close();
		System.out.println("merci au revoir...");
		

	}
}