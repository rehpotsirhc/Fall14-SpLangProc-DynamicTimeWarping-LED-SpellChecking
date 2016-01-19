package spellchecker;

import java.io.*;
import java.util.*;
import minEditAlgorithms.*;
import utilities.*;


public class Spellchecker
	{
		private ArrayList<String>	dictionary;
		private int					insCost;
		private int					delCost;
		private int					subsCost;
		private int					maxEditCost;

		public Spellchecker(String dictionaryFilePath) throws FileNotFoundException
			{
				this(dictionaryFilePath, 1, 1, 1, 7);
			}

		public Spellchecker(String dictionaryFilePath, int ins_cost, int del_cost, int subs_cost, int editCostThreshold) throws FileNotFoundException
			{
				this.maxEditCost = editCostThreshold;
				dictionary = new ArrayList<String>();
				for (String line : FileRWLines.ReadFileLines(dictionaryFilePath))
					{
						dictionary.add(line);
					}
				insCost = ins_cost;
				delCost = del_cost;
				subsCost = subs_cost;
			}

		public void spellCheckFileLED(String input_file_path, String output_file_path) throws IOException
			{
				StringTransformer stringTrans = new LED(insCost, delCost, subsCost);
				spellCheckFile(input_file_path, output_file_path, stringTrans);
			}

		public void spellCheckFileDTW(String input_file_path, String output_file_path) throws IOException
			{
				StringTransformer  stringTrans = new DTWStrings(insCost, delCost, subsCost);
				spellCheckFile(input_file_path, output_file_path, stringTrans);
			}

		public String spellCheckWordLED(String word)
			{
				StringTransformer stringTrans = new LED(insCost, delCost, subsCost);
				return spellCheckWord(word, stringTrans);
			}

		public String spellCheckWordDTW(String word)
			{
				StringTransformer stringTrans = new DTWStrings(insCost, delCost, subsCost);
				return spellCheckWord(word, stringTrans);
			}

		private void spellCheckFile(String input_file_path, String output_file_path, StringTransformer se) throws IOException
			{
				List<String> corrections = new LinkedList<String>();
				for (String line : FileRWLines.ReadFileLines(input_file_path))
					{
						corrections.add(spellCheckWord(line, se));
					}
				FileRWLines.WriteFileLines(output_file_path, corrections);
			}

		private String spellCheckWord(String word, StringTransformer se)
			{
				double min = Integer.MAX_VALUE;
				String closestWord = "NULL";
				for (String dictWord : dictionary)
					{
						double tmp = se.minTransformCost(word, dictWord);
						if (tmp < min && tmp <= maxEditCost)
							{
								min = tmp;
								closestWord = dictWord;
							}
					}
				
				return closestWord;
			}

		public String getEdits(String source, String target, StringTransformer se)
			{
				se.Transform(source, target);
				return se.toString();
			}

		public String getEditsLED(String source, String target)
			{
				return getEdits(source, target, new LED(insCost, delCost, subsCost));
			}

		public String getEditsDTW(String source, String target)
			{
				return getEdits(source, target, new DTWStrings(insCost, delCost, subsCost));
			}
	}
