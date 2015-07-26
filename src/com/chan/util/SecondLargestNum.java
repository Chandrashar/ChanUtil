/**
 * 
 */
package com.chan.util;

import java.util.Scanner;

/**
 * @author asus
 *
 *	How To Find Largest Number Less Than Given Number And Without Given Digit?
 *
 *	Write a java program to find the largest number ‘L’ less than a given number ‘N’ which should
 *	not contain a given digit ‘D’. For example, If 145 is the given number and 4 is the given digit,
 *	then you should find the largest number less than 145 such that it should not contain 4 in it.
 *  In this case, 139 will be the answer.
 */
public class SecondLargestNum {

	public static void main(String args[]){
		
		Scanner scn = new Scanner(System.in);
		int number = scn.nextInt();
		int digit = scn.nextInt();
		SecondLargestNum sLN = new SecondLargestNum();
		System.out.println(sLN.getLargestExcludingDigit(number, digit));
	
		System.out.println(sLN.getLargestExcludingDigit(123, 2));
		System.out.println(sLN.getLargestExcludingDigit(4582, 5));
		System.out.println(sLN.getLargestExcludingDigit(98512, 5));
		System.out.println(sLN.getLargestExcludingDigit(548624, 8));
			
	}

	private int getLargestExcludingDigit(int number, int digit) {
		
		int sLargest = 0;

		while(number>0){
			String str = Integer.toString(number);
			if(str.indexOf(Integer.toString(digit).charAt(0)) == -1){
				sLargest = number;
				return number;				
			} else{
				number--;
			}
		}
		return sLargest;
}
	
}
