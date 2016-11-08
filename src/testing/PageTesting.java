package edu.odu.cs.cs350.blue4;


import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

/**
 * 
 * 
 * This is JUNIT to check the Page.java class
 * @author asimamjad 
 *
 */
public class PageTesting {
	
	/**
	 * Test case for testPage method
	 */

	@Test
	public void testPage() {
		String S="new Page";
		Page P= new Page(S);
		P.setPageLink(S);
		assertEquals("new Page",S);
		P.setIntrapage(1);
		assertEquals(1,P.getIntrapage());		
		P.setIntrasite(4);
		assertEquals(4,P.getIntrasite());
		P.setExtSite(5);
		assertEquals(5,P.getExtSite());
		P.setIntResource(23);
		assertEquals(23, P.getIntResource());
		P.setBroken(2);
		assertEquals(2,P.getBroken());
		P.setExtPage(2);	
		assertEquals(2,P.getExtPage());
	}

	/**
	 * Test case for TestGetReferences method
	 */
	
	@Test
	public void TestGetReferences(){
		
		String S="new Page";
		String S2= "second page";
		Page P= new Page(S);
		Page P2= new Page(S2);
		ArrayList<String> ref=new ArrayList<>();
		ref.add(S);
		ref.add(S2);
		P.addToReferences(S);
		P.addToReferences(S2);
		assertEquals(ref.size(),P.getReferences().size());
		for(int i=0; i<ref.size(); i++ )
		{
			assertEquals(ref.get(i), P.getReferences().get(i));
		}
	}
	
	/**
	 * Test case for testSetReferences method
	 */
	
	

	@Test
	public void testSetReferences() {
		String S="one two three";
		Page P= new Page(S);	
		ArrayList<String> ref2=new ArrayList<>();
		assertTrue(ref2.size()==0); 
		ref2.add(S);
		assertTrue(ref2.size()==1);
		P.addToReferences(S);
		assertEquals(ref2.size(),P.getReferences().size());
		for(int i=0; i<ref2.size(); i++ )
		{
			assertEquals(ref2.get(i), P.getReferences().get(i));
		}
	}
	
	
	/**
	 * Test case for testGetReferenceBy
	 */
	

	@Test
	public void testGetReferencedBy() {
		String S="new Page";
		Page P= new Page(S);		
		ArrayList<String> ref3=new ArrayList<>();
		ref3.add(S);	
		P.addToReferencedBy(S);		
		assertEquals(ref3.size(),P.getReferencedBy().size());
		for(int i=0; i<ref3.size(); i++ )
		{
			assertEquals(ref3.get(i), P.getReferencedBy().get(i));
		}
	}
	
	/**
	 * Test case for testSetReferenceBy
	 */

	@Test
	public void testSetReferencedBy() {
		String S="one two three";
		Page P= new Page(S);	
		ArrayList<String> ref4=new ArrayList<>();
		assertTrue(ref4.size()==0); 
		ref4.add(S);
		assertTrue(ref4.size()==1);
		P.addToReferencedBy(S);
		assertEquals(ref4.size(),P.getReferencedBy().size());
		for(int i=0; i<ref4.size(); i++ )
		{
			assertEquals(ref4.get(i), P.getReferencedBy().get(i));
		}
	}
	
	


}
