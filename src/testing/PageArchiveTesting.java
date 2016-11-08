package edu.odu.cs.cs350.blue4;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * 
 * 
 * JUNIT for PageArchive.java class
 * @author asimamjad 
 *
 */

public class PageArchiveTesting {
	
	/**
	 * Test case for PageArchive constructor 
	 */

	@Test
	public void testPageArchive() {
		PageArchive PA= new PageArchive();
		String S1="First Page";
		Page PT= new Page(S1);
		PA.addPage(PT);
		assertTrue(PA.length() == 1);
		assertEquals(1,PA.length());		
	
		
			}
	
	/**
	 * Test case for addPage method
	 */

	@Test
	public void TestAddPage() {
		PageArchive PA= new PageArchive();
		String S1="First Page";
		Page PT= new Page(S1);
		PA.addPage(PT);
		assertTrue(PA.length() == 1);
		assertEquals(1,PA.length());
		String S2="Second Page";
		Page PT2= new Page(S2);
		PA.addPage(PT2);
		assertTrue(PA.length() == 2);
		assertEquals(2,PA.length());
		
	}
	
	/**
	 * Test case for updatePageReferences method
	 */

	@Test
	public void testUpdatePageReferences() {
		PageArchive PA= new PageArchive();
		String S1="First Page";
		Page PT= new Page(S1);
		PA.addPage(PT);
		assertTrue(PA.length() == 1);
		assertEquals(1,PA.length());
		assertFalse(PT.equals(PA.length()));
		String S2="Second Page";
		Page PT2= new Page(S2);
		PA.addPage(PT2);
		assertTrue(PA.length() == 2);
		assertEquals(2,PA.length());
		assertSame(PA.length(),2);
	}
	
	/**
	 * Test case for sortPageArchive method
	 */

	@Test
	public void testSortPageArchive() {
		PageArchive PA= new PageArchive();
		String S1="First Page";
		Page PT= new Page(S1);
		PA.addPage(PT);
		String S2="Second Page//";
		Page PT2= new Page(S2);
		PA.addPage(PT2);
		assertNotSame(PT.getReferences(), PT2.getReferences());
	}
	
	/**
	 * Testing Simpleout put file
	 */

	public void testSimpleOutputToFile()
	{
		
		PageArchive PA= new PageArchive();
		 
		String siteroot = "www.google.com";
		
		  PA.simpleOutputToFile(siteroot);
		  assertEquals(PA.length(),1); 
		
		
	}
	
	/**
	 * Testing the JsonOutput File
	 */
	
	public void testJsonOutput()
	{
		
		PageArchive PA= new PageArchive();
		String siteroot = "www.gmail.com";
		PA.jsonOutput(siteroot);
		
		String S1="First Page";
		Page PT= new Page(S1);
		PA.addPage(PT);
		String S2="Second Page//";
		Page PT2= new Page(S2);
		PA.addPage(PT2);
		assertNotSame(PT.getReferences(), PT2.getReferences());
		
		
	}
	

}
