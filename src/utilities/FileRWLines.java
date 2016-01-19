package utilities;

import java.io.*;
import java.util.*;

public class FileRWLines
	{
		
		/*
		 * Reads each line from the file
		 */
		public static List<String> ReadFileLines(String filePath) throws FileNotFoundException
			{
				Scanner s = new Scanner(new FileReader(filePath));
				List<String> lines = new LinkedList<String>();
				while (s.hasNextLine())
					{
						lines.add(s.nextLine().trim());
					}
				s.close();
				return lines;
			}

		/*
		 * Writes each string within lines to a separate line of the file
		 * filepath
		 */
		public static void WriteFileLines(String filePath, List<String> lines) throws IOException
			{
				Writer w = new FileWriter(filePath);
				String newLine = System.getProperty("line.separator");
				for (String line : lines)
					{
						w.write(line + newLine);
					}
				w.close();
			}
	}
