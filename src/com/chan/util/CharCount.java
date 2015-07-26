
package com.chan.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


/**
 * @author asus
 *
 *Java Program To Count Occurrences Of Each Character In String
 */
public class CharCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CharCount cCount = new CharCount();
		System.out.println(cCount.printHashMap(cCount.charCountString("Java J2EE Program To Count Occurrences Of Each Character In String")));
		
		System.out.println(cCount.charCountInString("Java J2EE Program To Count Occurrences Of Each Character In String"));
		
	}

public HashMap charCountString(String source){
	
	Map<String, Integer> charMap = new HashMap<String, Integer>();
	
	
	char[] charList = source.toCharArray();
	for(char c: charList){
		if(null!=""+c){
			if(charMap.containsKey(""+c)){
				Integer count = charMap.get(""+c);
				charMap.remove(""+c);
				charMap.put(""+c, count+1);
			} else
				charMap.put(""+c, 1);
		}
	}
	return (HashMap) charMap;
}

public HashMap charCountInString(String source){
	
	Map<Character, Integer> charMap = new HashMap<Character, Integer>();
	
	
	char[] charList = source.toCharArray();
	for(char c: charList){
//		if(null!=c){
			if(charMap.containsKey(c)){
				Integer count = charMap.get(c);
				charMap.remove(c);
				charMap.put(c, count+1);
			} else
				charMap.put(c, 1);
		}
//	}
	return (HashMap) charMap;
}

public String printHashMap(Map<String, Integer> hashMap){
	StringBuilder sb = new StringBuilder();
	java.util.Iterator<Entry<String, Integer>> itr =  hashMap.entrySet().iterator();
	while(itr.hasNext()){
		Map.Entry<String, Integer> eEntry = itr.next();
		String key = eEntry.getKey();
		Integer value = eEntry.getValue();
		sb.append("[" + key).append("] = ").append(value).append("\n");
	}
	
	return sb.toString();
}
}
