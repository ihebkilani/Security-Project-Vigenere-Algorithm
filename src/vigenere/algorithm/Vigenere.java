/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vigenere.algorithm;

import java.io.*;       
/**
 *
 * @author iheb_
 */
public class Vigenere {
    
    public static int caesar_findGap(String filename) throws IOException
	{
		// Tableau des fréquences (Code ASCII, Fréquence)
		int frequences[] = new int[26];
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String message = in.readLine();
						
		// Calcul des fréquences des lettres
		for(int i = 97; i <= 122; i++)
		{
			for(int j = 0; j < message.length(); j++)
			{
				if(message.charAt(j) == (char)i)
					frequences[i - 97]++;
			}
		}
				
		int highestIndex = 0;
		for(int i = 0; i < 26; i++)
		{
			if(frequences[i] > frequences[highestIndex])
				highestIndex = i;
		}
				
		System.out.println("\nLettre la plus fréquente : '" + (char)(highestIndex + 97) + "', correspond donc au 'e'");
		
		// On récupère la valeur du décalage
		int decalage = ((int)'z' - (int)'a') - ((((int)'z' - (int)'a') - highestIndex) + ((int)'e' - (int)'a'));
		if(decalage < 0)
			decalage += 26;
		System.out.println("Décalage trouvé : " + decalage);
		
		return decalage + 97;
	}
	
	public static String crypt(String text, String key)
	{
		String res = "";
                text = text.toUpperCase();
                for (int i = 0, j = 0; i < text.length(); i++)
        {
                char c = text.charAt(i);
                if (c < 'A' || c > 'Z')
                continue;
                res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
                j = ++j % key.length();
        }
                return res;
	}
	
        
	public static String decrypt(String text, String key)
	{
		String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
                char c = text.charAt(i);
                if (c < 'A' || c > 'Z')
                continue;
                res += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
                j = ++j % key.length();
        }
                return res;
	}
        
        public static void sauvegarde_mot(File fichier,String texte) throws FileNotFoundException, IOException{
        
                try (FileOutputStream outputStream = new FileOutputStream(fichier)) {
                byte[] strToBytes = texte.getBytes();
                outputStream.write(strToBytes);
                    }
        }
    
}
