package com.chan.scanner;

import static org.junit.Assert.fail;
import java.io.File;
import junit.framework.TestCase;
import com.chan.scanner.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Chandra.Sharma
 *
 */
public class FileListingTest extends TestCase{

	/**
	 * @throws java.lang.Exception
	 */
	
	FileListing filelist =null;
	@Before
	public void setUp() throws Exception {
		super.setUp();
		filelist = new FileListing();
		FileListing.getFileListing(new File("C:\\webs"));
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.sapient.java.FileListing#getFileListing(java.io.File)}.
	 */
	@Test
	public void testGetFileListing() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.sapient.java.FileListing#matchingSearchCriteria(java.io.File)}.
	 */
	@Test
	public void testMatchingSearchCriteria() {
		fail("Not yet implemented");
	}
}
