package com.chan.util;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.Target;
import org.apache.tools.ant.taskdefs.Expand;
import java.io.File;

/**
 * Unzip a zip file into a given directory.
 *
 * @param zipFilepath A pathname representing a local zip file
 * @param destinationDir where to unzip the archive to
 */

public class UnZipFile {

	public static void main(String[] args) {
		UnZipFile unzip = new UnZipFile();
		unzip.unzip("C:\\Users\\asus\\Downloads\\GoogleChromeDownloads\\sakai-demo-10.5.zip", "C:\\Users\\asus\\Downloads\\GoogleChromeDownloads\\images");

	}

	static public void unzip(String zipFilepath, String destinationDir) {

	    final class Expander extends Expand {
	        public Expander() {
	 	    project = new Project();
		    project.init();
		    taskType = "unzip";
		    taskName = "unzip";
		    target = new Target();
		}	
	    }
	    Expander expander = new Expander();
	    expander.setSrc(new File(zipFilepath));
	    expander.setDest(new File(destinationDir));
	    expander.execute();
}
}
