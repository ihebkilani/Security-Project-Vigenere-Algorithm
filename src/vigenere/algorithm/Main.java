/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vigenere.algorithm;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.*;   
import java.util.Scanner;
import static vigenere.algorithm.Vigenere.crypt;
import static vigenere.algorithm.Vigenere.decrypt;
import static vigenere.algorithm.Vigenere.sauvegarde_mot;

/**
 *
 * @author iheb
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
                System.out.println("//////////////////////////////////////////////////////////");
		System.out.println("//              CHIFFREMENT DE VIGENERE                 //");
		System.out.println("//             (Chiffrement, Déchiffrement)            //");
		System.out.println("//////////////////////////////////////////////////////////\n");
		
		Scanner sc = new Scanner(System.in);
		int option;
		
		String key;
		
                
                FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
                dialog.setMode(FileDialog.LOAD);
                dialog.setVisible(true);
                String file = dialog.getFile(); 
                String path = dialog.getDirectory() + dialog.getFile();
                System.out.println("le path est "+path);
                System.out.println(file + " chosen.");
                        
                String text="";
                FileReader fr = new FileReader(path); 
                int i; 
                while ((i=fr.read()) != -1){ 
                System.out.print((char) i); 
                text+= (char)i;
                        }
          
		String result = "";
                System.out.println(text);
		System.out.println("Entrez le numéro correspondant à l'action que vous voulez exécuter\n1 : Crypter\n2 : Décrypter\n");
		option = sc.nextInt();
		
		switch(option) 
		{
			case 1: 
				System.out.println("Entrez la clé de chiffrement :\n");
				key = sc.next();
				result = crypt(text, key);
				break;
				
			case 2:	
				System.out.println("Entrez la clé de chiffrement :\n");
				key = sc.next();
				result = decrypt(text, key);
				break;
				
				
			default:
				System.out.println("Vous n'avez pas entré de valeur valide.\n");
				System.exit(0);
		}
		
                dialog = new FileDialog((Frame)null, "Selectionnez le fichier où vous allez sauvegarder");
                dialog.setMode(FileDialog.LOAD);
                dialog.setVisible(true);
                File[] fichier = dialog.getFiles(); 
                        
                sauvegarde_mot(fichier[0],result);
                        
                System.out.println(result); 
                        
                System.exit(0);
	}
}
