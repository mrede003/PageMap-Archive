package edu.odu.cs.cs350.blue4;

import static org.junit.Assert.*;

import org.junit.Test;



/**
 * 
 * 
 * JUNIT for LinkAnalyzer class
 * @author asimamjad 
 *
 */

public class LinkAnalyzerTesting {
	
	/**
	 * Test case for constructor 
	 */

	@Test
	public void constructorTest() {
		LinkAnalyzer la = new LinkAnalyzer("siteroot");
		assertTrue("constructorTest",la.getSiteroot() == "siteroot");
	}
	
	/**
	 * Test case for to check the siteroot
	 */
	
	@Test 
	public void siterootCheck()
	{
		LinkAnalyzer la = new LinkAnalyzer("siteroot");
		assertTrue("Siteroot",la.checkBoundary("siteroot/testing"));			
		assertTrue("Siteroot",la.checkBoundary("siteroot/testing/another/directory"));    //added test
		//assertFalse("Siteroot",la.checkBoundary("upper/siteroot/testing/another/directory")); //added test
		
	}
	
	/**
	 * Test case to check the trimmed siteroot 
	 */
	@Test
	public void stripSiteroot()
	{
		LinkAnalyzer la = new LinkAnalyzer("siteroot/");
		assertTrue("Siteroot2",la.findLocalFile("root/testing") == "NULL");
	
	}
	/**
	 * @author Matt
	 * *Test to determine the proper result is 
	 * returned when using the findLocalFile 
	 * method. First a check is done comparing 
	 * the returned value to the desired result.
	 * Then a test is done to make sure the same
	 * result is retuned when given a different 
	 * path. 
	 */
	@Test
	public void stripSiterootEquality()
	{
		LinkAnalyzer la = new LinkAnalyzer("root/testing.html");
		assertTrue("Siteroot3",la.findLocalFile("site/root/testing.html").equals("root/testing.html"));
		assertTrue("Siteroot3",la.findLocalFile("get/the/right/site/root/testing.html").equals(la.findLocalFile("site/root/testing.html")));
	
	} 
}
