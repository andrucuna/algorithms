package com.leetcode.andrucuna.algorithms;
/**
 * Problem: Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {
	
	public static void main(String[] args) {
		PalindromeNumber p = new PalindromeNumber(); 
		Solution s = p.new Solution();
		System.out.println( s.isPalindrome(-2147447412) );
	}
	
	public class Solution {
	    public boolean isPalindrome(int x) {
	    	//As we might have representation issues for int border numbers... we need to check that
	    	if( x == Integer.MIN_VALUE || x == Integer.MAX_VALUE )
	    		return false;
	    	
	    	//If x is negative, it's not a palindrome
	    	if( x < 0 )
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
}

