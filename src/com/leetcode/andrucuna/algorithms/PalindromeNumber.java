/**
 * Copyright (c) 2017 All Right Reserved.
 * 
 * This file is part of algorithms solutions as free software: 
 * you can redistribute it and/or modify it under the terms of the 
 * GNU General Public License as published by the Free Software Foundation, 
 * either version 3 of the License, or any later version.
 * 
 * This code is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * For further reference, see <http://www.gnu.org/licenses>.
 */
package com.leetcode.andrucuna.algorithms;


/**
 * Problem: Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author andres.ruiz (andrucuna@gmail.com)
 * @version 1.0
 */
public class PalindromeNumber {
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//                 Solution                  
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * Returns true if x is palindrome, false otherwise
	 * @param x
	 * @return boolean
	 */
	public boolean isPalindrome(int x) {
    	//If x is negative, it's not a palindrome
    	if( x < 0 )
    		return false;

    	//As we might have representation issues for int border numbers... we need to check that
    	if( x == Integer.MIN_VALUE || x == Integer.MAX_VALUE )
    		return false;

    	//Digits will be x as a power of 10
        int digits = 1;
    	int count = x/10;
    	while( count > 0 ) {
        	count /= 10;
        	digits*=10;
        }

    	//Here I compare the first and last digit of x, and then remove them from x
        while( x > 0 ) {
        	//If the first and last digit are not equal, then x is not a palindrome
        	if( (x/digits) != (x%10)) {
        		 return false;
        	 }
        	 x -= ( (x/digits)*digits );
        	 x /= 10;
        	 digits /= 100;
        }
    	
        //If all the compared digits were equal, then x was palindrome
    	return true;
    }
}

