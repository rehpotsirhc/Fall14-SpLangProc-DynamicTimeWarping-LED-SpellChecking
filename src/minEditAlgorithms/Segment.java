package minEditAlgorithms;

import java.util.*;


public class Segment
	{
		private String		stringRep;
		private char[]		charsRep;
		private int[]		intsRep;
		private double[]	doublesRep;
		private int			length;

		public Segment(String segment)
			{
				stringRep = segment;
				length = stringRep.length();
			}

		public Segment(double[] doubles)
			{
				doublesRep = doubles;
				length = doublesRep.length;
			}

		public Segment(char[] characters)
			{
				charsRep = characters;
				length = charsRep.length;
			}

		public Segment(int[] integers)
			{
				intsRep = integers;
				length = intsRep.length;
			}

		public String getString()
			{
				if (stringRep != null)
					return stringRep;
				else if (charsRep != null)
					return new String(charsRep);
				else if (intsRep != null) return intsToString(BoxInts(intsRep));
				return "";
			}

		public char[] getCharacters()
			{
				if (charsRep != null)
					return charsRep;
				else if (stringRep != null)
					return stringRep.toCharArray();
				else if (intsRep != null) return UnBoxChars(intsToChars(BoxInts(intsRep)));
				return new char[] {};
			}

		public int[] getIntegers()
			{
				if (intsRep != null)
					return intsRep;
				else if (charsRep != null)
					return UnBoxInts(charsToInts(BoxChars(charsRep)));
				else if (stringRep != null) return UnBoxInts(charsToInts(BoxChars(stringRep.toCharArray())));
				return new int[] {};
			}

		public double[] getDoubles()
			{
				if (doublesRep != null)
					return doublesRep;
				else if (intsRep != null)
					return intsToDoubles(intsRep);
				else if (charsRep != null)
					return intsToDoubles(UnBoxInts(charsToInts(BoxChars(charsRep))));
				else if (stringRep != null) return intsToDoubles(UnBoxInts(charsToInts(BoxChars(stringRep.toCharArray()))));
				return new double[] {};
			}

		public boolean EqualAt(Segment other, int thisIndex, int otherIndex)
			{
				doublesRep = getDoubles();
				
				return (doublesRep[thisIndex] == other.getDoubles()[otherIndex]);
			}

		public int getLength()
			{
				return length;
			}

		private static double[] intsToDoubles(int[] ints)
			{
				double[] dbls = new double[ints.length];
				for (int c = 0; c < ints.length; c++)
					{
						dbls[c] = ints[c];
					}
				return dbls;
			}

		private static String intsToString(Integer[] integers)
			{
				if (integers == null) return null;
				if (integers.length == 0) return "";
				String s = "";
				Character[] cs = intsToChars(integers);
				for (char c : cs)
					{
						s += c;
					}
				return s;
			}

		private static Character[] intsToChars(Integer[] integers)
			{
				if (integers == null) return null;
				if (integers.length == 0) return new Character[] {};
				List<Character> characters = new ArrayList<Character>();
				for (Integer i : integers)
					{
						char[] cs = Character.toChars(i);
						List<Character> chars = new ArrayList<Character>();
						for (char c : cs)
							{
								chars.add(c);
							}
						characters.addAll(chars);
					}
				return characters.toArray(new Character[characters.size()]);
			}

		private static Integer[] charsToInts(Character[] characters)
			{
				if (characters == null) return null;
				if (characters.length == 0) return new Integer[] {};
				Integer[] ints = new Integer[characters.length];
				for (int c = 0; c < ints.length; c++)
					{
						ints[c] = (int) characters[c];
					}
				return ints;
			}

		private static Integer[] BoxInts(int[] ints)
			{
				Integer[] integers = new Integer[ints.length];
				for (int c = 0; c < integers.length; c++)
					{
						integers[c] = ints[c];
					}
				return integers;
			}

		private static Character[] BoxChars(char[] chars)
			{
				Character[] characters = new Character[chars.length];
				for (int c = 0; c < characters.length; c++)
					{
						characters[c] = chars[c];
					}
				return characters;
			}

		private static int[] UnBoxInts(Integer[] integers)
			{
				int[] ints = new int[integers.length];
				for (int c = 0; c < integers.length; c++)
					{
						ints[c] = integers[c];
					}
				return ints;
			}

		private static char[] UnBoxChars(Character[] characters)
			{
				char[] chars = new char[characters.length];
				for (int c = 0; c < characters.length; c++)
					{
						chars[c] = characters[c];
					}
				return chars;
			}
	}
