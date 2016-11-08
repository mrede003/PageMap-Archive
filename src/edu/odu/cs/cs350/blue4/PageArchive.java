package edu.odu.cs.cs350.blue4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.google.gson.*;

/**
 
 * This class is the collection of all pages.
 * All pages will be added in this class by user defined array 
 * This class will also give the output in Json and text file
 * @author mredeniu
 *
 */

public class PageArchive {
	private ArrayList<Page> pages;
	
	/**
	 * To initialize the constructor by an array of Page
	 */	
	
	public PageArchive()
	{
		pages = new ArrayList<Page>();
	}
	
	/**
	 * To return the size of the array
	 * @return size of pages
	 */
	
	public int length()
	{		
		
		return pages.size();
	}
	
	/**
	 * To add the pages in the array
	 * @param complete
	 */
	
	public void addPage(Page complete)
	{
		pages.add(complete);
	}
	
	/**
	 * This function update the references and first finds the page existence
	 * If a page  does not exists, it will adds the page using addToReferenceBy function	
	 * @param name
	 * @param other
	 */
	
	public void updatePageReferences(String name, String other)
	{
		boolean found = false;
		for (Page temp : pages)
		{
			if (temp.getPageLink() == name)
			{
				temp.addToReferencedBy(other);
				found = true;
			}
		}
		if (found == false)
		{
			Page newPage = new Page(name);
			newPage.addToReferencedBy(other);
			addPage(newPage);
		}
	}
	
	/**
	 * Sort the pages according the length of the directory by using Comparing two pages
	 * and using java.util.Collections utilities 
	 * @return page links 
	 * 
	 */
	
	public void sortPageArchive()
	{
		Collections.sort(pages, new Comparator<Page>() {
		    public int compare(Page p1, Page p2) {
		    	return p1.getPageLink().lastIndexOf("\\") - p2.getPageLink().lastIndexOf("\\");
		        
		    }
		});
	}
	
	
	/**
	 * Giving the output by showing the directory relative to the site root 
	 */
	
		public void simpleOutputToScreen()
	{
		for (Page temp : pages)
		{
			System.out.println(temp.getPageLink());
		}
	}
		
		/**
		 * Function to give the output in a text file
		 * @param siteroot
		 */
		
	public void simpleOutputToFile(String siteroot)
	{
		File outputFile = new File(siteroot + "\\Text Output File.txt");
		try {
			FileWriter fw = new FileWriter(outputFile);
			if(!outputFile.exists())
			{
				outputFile.createNewFile();
			}
			for (Page temp : pages)
			{
				fw.write(temp.getPageLink() + "\n");
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Function to give the output to the JSON file 
	 * @param siteroot
	 */
	
	public void jsonOutput(String siteroot)
	{
		File outputFile = new File(siteroot + "\\JSON Output File.txt");
		try {
			FileWriter fw = new FileWriter(outputFile);
			if(!outputFile.exists())
			{
				outputFile.createNewFile();
			}
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(pages);
			fw.write(json.toString().replaceAll("\\\\+", "\\\\"));
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
