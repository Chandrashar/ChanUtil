/**
 * 
 */
package com.chan.scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
* matching File name according to following pattern
*  
* @author chandra.sharma
*/

public class MatchingCriteria {
	
	private static String patternFormate= ".MFile.*.tx[a-zA-Z]";
	private static Pattern filePattern = Pattern.compile(patternFormate);
	public boolean compile(String patternSearch) {
	    try {
	      Matcher matcher = filePattern.matcher(patternSearch);
	      if (matcher.find()){
	    	  return true;
	        }else 
	        	return false;
	    } catch (PatternSyntaxException ex) {
	      System.err.println(ex.getMessage());
	    }
		return false;
	  }
}