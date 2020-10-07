package com.parapharma.symptom;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
			Scanner sc = new Scanner(System.in);
			try 
			{
			//FileWriter writer = new FileWriter (toto.cheminFichierAEcrire,true);
			PrintWriter pOut = new PrintWriter(new BufferedWriter(new FileWriter (toto.cheminFichierAEcrire,true)));
			boolean sortir = false;
			do 
			{
				System.out.println("veuillez saisir le symptome a rajouter");
				String symptom= sc.next();
				pOut.print(symptom+ "\n");
				
				System.out.println("voulez vous rajouter un symptome O/N ?");
				String choix = new String (sc.next().toUpperCase());
				int valueChoix = (int) choix.charAt(0);
				if (valueChoix== 79 || valueChoix== 78)
				{
					
					switch(valueChoix)
					{
					case 78 :
						sortir = true;
						break;
					case 79 : 
						sortir = false;
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

}
