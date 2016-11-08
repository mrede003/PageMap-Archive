package edu.odu.cs.cs350.blue4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;

/**
 * 
 * 
 * This class analyze all directories and 
 * also differentiate the difference between htm and html 
 * @author mredeniu 
 *
 */

public class LinkAnalyzer {
	private String siteroot;
	
	/**
	 * Constructor initialization 
	 * @param SR
	 */
	
	public LinkAnalyzer(String SR)
	{
		siteroot = SR;
	}
	
	/**
	 * Function to determine the resources,
	 * finds the href from resources and then trim it,
	 * checks the links are internal or external 
	 * and each page will analyzed once only
	 * Checks the relative path against boundary of the site 
	 * @param scanFile the files  to be scanned
	 * @param page 
	 * @param list
	 * @throws IOException
	 */
	
	public void determineResources(File scanFile, Page page, PageArchive list) throws IOException
	{
		Scanner fileScan = new Scanner(scanFile);
		
		while (fileScan.hasNextLine())
		{
			String line = fileScan.nextLine(); 
			if (line.contains("href")) 
			{
				int indexStart = line.indexOf("href") + 6;
				int indexEnd = line.indexOf('"', indexStart);
				String link = line.substring(indexStart, indexEnd);
				File testLink = new File(link);
				
				
				if (link.contains(getSiteroot()))
				{
					
					if (!testLink.exists())
						page.setBroken(page.getBroken() + 1);
					else if (link.contains("#"))
						page.setIntrapage(page.getIntrapage() + 1);
					else if (link.contains(".html") || link.contains(".htm") || link.charAt(link.length()) == '\\')
					{
						page.setIntrasite(page.getIntrasite() + 1);
						
						page.addToReferences(findLocalFile(testLink.getCanonicalPath()));
						
						if (checkBoundary(testLink.getCanonicalPath()))
						{
							list.updatePageReferences(findLocalFile(testLink.getCanonicalPath()), page.getPageLink());
						}
					}
					else 
						page.setIntResource(page.getIntResource() + 1);
				}
				else if (!link.contains(getSiteroot()))
				{
					if (link.contains("#"))
						page.setExtPage(page.getExtPage() + 1);
					else if (link.contains(".html") || link.contains(".htm") || link.charAt(link.length() - 1) == '\\')
						page.setExtSite(page.getExtSite() + 1);
					else 
						page.setExtResource(page.getExtResource() + 1);
				}
				else 
					System.out.println("Error: no resource detected");
			}
		}
		
		fileScan.close();
	}
	
	/**
	 * Compares the files, otherwise throws and exception 
	 * @param file1
	 * @param file2
	 * @return boolean value
	 * @throws IOException
	 */
	
	public boolean compareFiles(File file1, File file2) throws IOException
	{
		if (file1.getFreeSpace() == file2.getFreeSpace())
		{
			if(FileUtils.contentEquals(file1, file2))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks the siteroot of the link
	 * @param link
	 * @return
	 */
	
	public String findLocalFile(String link)
	{
		int index = 0;
		if(link.contains(getSiteroot()))
		{
			index = link.indexOf(getSiteroot());
			link=link.substring(index);
			return link;
		}
		else
			return "NULL";
	}
	
	/**
	 * Checks paths against the site boundary
	 * @param filepath
	 * @return
	 */
	
	
	public boolean checkBoundary(String filepath)
	{
		if (filepath.contains(getSiteroot()))
			return true;
		else
			return false;
	}

	/** To get the siteroot 
	 * @return the siteroot
	 */
	public String getSiteroot() {
		
		return siteroot;
	}

}


