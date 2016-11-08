package edu.odu.cs.cs350.blue4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.comparator.NameFileComparator;

/**
 * 
 * 
 * It is a main class of the project which will takes an command line arguments
 * @author mredeniu
 *
 */
public class Phase3 {

	public static void main(String[] args) throws FileNotFoundException {
		LinkAnalyzer la = null;
		PageArchive list = new PageArchive();
		File[] extraPages;
		if (args[0] == null)
		{
			System.out.println("Error: Site root argument missing from command line.");
			System.exit(0);
		}
		else
		{
			la = new LinkAnalyzer(args[0]);
		}
				
		/**
		 * Gives the site root information and recursively searches for sub-directories
		 */
		
		File directory = new File(la.getSiteroot());
		searchDirectory(directory, la, list);
		
		if (args.length > 1)
		{
			extraPages = new File[args.length - 1];
			for (int i = 1; i < args.length; i++)
			{
				extraPages[i - 1] = new File(args[i].toString());
			}
			for (File current : extraPages)
			{
				searchDirectory(current, la, list);
			}
		}
		
		list.sortPageArchive();
		list.simpleOutputToScreen();
		list.simpleOutputToFile(la.getSiteroot());
		list.jsonOutput(la.getSiteroot());
		
	}
	
	

	/**
	 * Checks the existence of the directory otherwise give an exception 
	 */
	
	public static void searchDirectory(File directory, LinkAnalyzer la, PageArchive list) throws FileNotFoundException
	{
		
		if(!directory.exists())
		{
			System.out.println("Error: Directory " + la.getSiteroot() + " does not exist."); 
			System.exit(0);
		}
		else
		{
			
			File[] filesInDir = directory.listFiles();
			for (int i = 0; i < filesInDir.length; i++)
			{
				
				if (filesInDir[i].isFile())
				{
					
					Page newPage = new Page(filesInDir[i].getAbsolutePath().substring(la.getSiteroot().length() + 1));
					try {
						la.determineResources(filesInDir[i], newPage, list);
					} catch (IOException e) {
					
						e.printStackTrace();
					}
					list.addPage(newPage);
					
				}
				
				else if (filesInDir[i].isDirectory())
				{
					searchDirectory(filesInDir[i], la, list);
				}
			}
		}
	}
}
