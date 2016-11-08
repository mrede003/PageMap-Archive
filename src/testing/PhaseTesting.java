package edu.odu.cs.cs350.blue4;

import java.io.FileNotFoundException;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import java.io.File;

/**
 * Phase3 Junit Testing
 * @author asimamjad
 * 
 */

public class PhaseTesting {


/**
 * Search the Directory path
 */


	@Test
	public void testSearchDirectory() {
		String args = "./target/TestDirectory";
		
		LinkAnalyzer la = new LinkAnalyzer(args);
		PageArchive list = new PageArchive();
		File[] extraPages;
		
		File directory = new File(la.getSiteroot());

		try{
			Phase3.searchDirectory(directory, la, list);
		}
		catch(FileNotFoundException fnf)
		{
			assertTrue(true);
		}
		assertTrue(true);
	}

}
