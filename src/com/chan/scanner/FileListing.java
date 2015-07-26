package com.chan.scanner;

import java.util.*;
import java.io.*;
import com.chan.scanner.Constatnt;

/**
* Recursive file listing under a specified directory.
*  
* @author chandra.sharma
*/
public final class FileListing {

	
  public static void main(String args[]) throws FileNotFoundException {
	long startTime = System.currentTimeMillis();
	String matchingFile="";
    File startingDirectory= new File(args[0]);
    List<File> files = FileListing.getFileListing(startingDirectory);
    if((System.currentTimeMillis() - startTime )/1000 < Constatnt.TIMEOUT  ){
    for(File file : files ){
      matchingFile = matchingSearchCriteria(file);
      //System.out.println(matchingFile);
      if(null!=matchingFile && matchingFile.length()>0){
    	  System.out.println("Match Found: " +  matchingFile.toString());
      }
    }  // 
    } else {
    	System.out.println(Constatnt.FAILURE_TO_SEARCH);
    }
  }
  
  /**
  * Recursively walk a directory tree and return a List of all
  * Files found
  * 
  * @param aStartingDir must be a valid directory, which can be read.
  */
  static public List<File> getFileListing(
    File aStartingDir
  ) throws FileNotFoundException {
    validateDirectory(aStartingDir);
    List<File> result = getFileListingMatching(aStartingDir);
    Collections.sort(result);
    return result;
  }

  /*
   * gathering files.
   */
 static private List<File> getFileListingMatching(
    File aStartingDir
  ) throws FileNotFoundException {
    List<File> result = new ArrayList<File>();
    File[] filesAndDirs = aStartingDir.listFiles();
    List<File> filesDirs = Arrays.asList(filesAndDirs);
    for(File file : filesDirs) {
      result.add(file); //adding, even if directory
      System.out.println(file.getName() + "\t == Size in MB: \t" + file.length()/1024 * 1024 + " \t -->File URL: \t" + file.getAbsolutePath());
      if ( ! file.isFile() ) {
         //recursive call!
        List<File> deeperList = getFileListingMatching(file);
        result.addAll(deeperList);
      }
    }
    return result;
  }

  /**
  * Directory is valid if it exists, does not represent a file, and can be read.
  */
  static private void validateDirectory (
    File aDirectory
  ) throws FileNotFoundException {
    if (aDirectory == null) {
      throw new IllegalArgumentException("Directory should not be null.");
    }
    if (!aDirectory.exists()) {
      throw new FileNotFoundException("Directory does not exist: " + aDirectory);
    }
    if (!aDirectory.isDirectory()) {
      throw new IllegalArgumentException("Is not a directory: " + aDirectory);
    }
    if (!aDirectory.canRead()) {
      throw new IllegalArgumentException("Directory cannot be read: " + aDirectory);
    }
  }
  
  public static String matchingSearchCriteria(File name){
	  MatchingCriteria mCriteria = new MatchingCriteria();
	  String fileName = name.toString().substring(name.toString().lastIndexOf('\\'), name.toString().length());
	  //System.out.println("New File Name " + fileName);
	  if(mCriteria.compile(fileName)){
		  System.out.println("Match Found: " + name.toString());
		  return name.toString();
	  }else{
		  return null;
	  }
  }
	
  public static void checkTimeout(){
	  
  }
  } 