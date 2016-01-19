package spellchecker;

import java.io.IOException;
import java.util.Arrays;
import minEditAlgorithms.Segment;


public class Driver
	{
		public static void main(String[] args) throws IOException
			{
				//chars
				Segment charSeg = new Segment(new char[] { 'a', 'b', 'c', '*', '@', '%', '1', '5' });
				System.out.println(charSeg.getString());
				
				System.out.println(Arrays.toString(charSeg.getCharacters()));
				
				System.out.println(Arrays.toString(charSeg.getIntegers()));
				System.out.println(Arrays.toString(charSeg.getDoubles()));
				
				System.out.println("\n\n");
				
				
				//ints
				Segment intSeg = new Segment(new int[] {  97, 98, 99, 42, 64, 37, 49, 53 });
				System.out.println(intSeg.getString());
				System.out.println(Arrays.toString(intSeg.getCharacters()));
				System.out.println(Arrays.toString(intSeg.getIntegers()));
				System.out.println(Arrays.toString(intSeg.getDoubles()));
				
				System.out.println("\n\n");
				
				
				//string
				Segment stringSeg = new Segment("abc*@%15");
				
				System.out.println(stringSeg.getString());
				System.out.println(Arrays.toString(stringSeg.getCharacters()));
				System.out.println(Arrays.toString(stringSeg.getIntegers()));
				System.out.println(Arrays.toString(stringSeg.getDoubles()));
				
				
				System.out.println("\n\n");
				
				//doubles
				
				Segment doubleSeg = new Segment( new double[] {97.0, 98.0, 99.0, 42.0, 64.0, 37.0, 49.0, 53.0});
				
				System.out.println(doubleSeg.getString());
				System.out.println(Arrays.toString(doubleSeg.getCharacters()));
				System.out.println(Arrays.toString(doubleSeg.getIntegers()));
				System.out.println(Arrays.toString(doubleSeg.getDoubles()));
				
				
				
				
				Spellchecker sc = new Spellchecker("dictionary.txt",  1, 1, 1, 7);
				
				sc.spellCheckFileLED("misspellings.txt", "correctionsLED1.txt");
				
				sc.spellCheckFileDTW("misspellings.txt", "correctionsDTW1.txt");

				
				
				Spellchecker sc2 = new Spellchecker("dictionary.txt", 1, 1, 2, 12);
				
				sc2.spellCheckFileLED("misspellings.txt", "correctionsLED2.txt");
				
				sc2.spellCheckFileDTW("misspellings.txt", "correctionsDTW2.txt");
				
				
				System.out.println(sc.getEditsLED("chris", "kris"));
				System.out.println(sc.getEditsDTW("chris", "kris"));
				
				System.out.println(sc.getEditsLED("christopher", "chris"));
				System.out.println(sc.getEditsDTW("christopher", "chris"));
				
				System.out.println(sc.getEditsLED("intention", "execution"));
				System.out.println(sc.getEditsDTW("intention", "execution"));

				System.out.println(sc.getEditsLED("gdasvwsa23412", "89725jkodfs"));
				System.out.println(sc.getEditsDTW("gdasvwsa23412", "89725jkodfs"));
				
				System.out.println(sc.getEditsLED("execution", "intention"));
				System.out.println(sc.getEditsDTW("execution", "intention"));
			
				System.out.println(sc.getEditsLED("melanie", "melony"));
				System.out.println(sc.getEditsDTW("melanie", "melony"));
				
				System.out.println(sc.getEditsLED("telephonecaul", "telefoncall"));
				System.out.println(sc.getEditsDTW("telephonecaul", "telefoncall"));
				
				
				System.out.println(sc.getEditsLED("gbbc", "gbc"));
				System.out.println(sc.getEditsDTW("gbbc", "gbc"));
				
				System.out.println(sc.getEditsLED("gbba", "abg"));
				System.out.println(sc.getEditsDTW("gbba", "abg"));
				
				System.out.println(sc.getEditsLED("abg", "gbba"));
				System.out.println(sc.getEditsDTW("abg", "gbba"));
				
				System.out.println(sc.getEditsLED("abbg", "gba"));
				System.out.println(sc.getEditsDTW("abbg", "gba"));
	
				
				
				
			}
	}
