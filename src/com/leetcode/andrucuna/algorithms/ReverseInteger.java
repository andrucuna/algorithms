package com.leetcode.andrucuna.algorithms;
/**
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * Note:
 * The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 */
public class ReverseInteger {
	public static void main(String[] args) {
		ReverseInteger p = new ReverseInteger(); 
		Solution s = p.new Solution();
		System.out.println( s.reverse(-123) );
	}
	
	public class Solution {
	    public int reverse(int x) {
	    	//Avoiding stack overflow cases
	    	if( x == 0 || x == Integer.MIN_VALUE )
	    		return 0;
	    	//Negative numbers
    		if( x<0 )
    			return reverse( -x )*-1;	
	    	//If the last digit of the number is 0, the reverse number won't have it
	    	if( x%10 == 0 )
	        	return reverse( x/10 );
	    	else {	    		
	    		//Digits will be x as a power of 10
		        int digits = 1;
		    	int count = x/10;
		    	while( count > 0 ) {
		        	count /= 10;
		        	digits*=10;
		        }
		    	
		    	//Revert the number
		    	long reverse = 0;
		        while( x > 0 ) {
		        	reverse += (long)(x%10)*digits;
		        	digits /= 10;
		        	x /= 10;
		        }
		        //if reverse Overflow int 32-bit representation cases
		        if( reverse < Integer.MIN_VALUE || reverse > Integer.MAX_VALUE )
		        	return 0;
		        
		        return (int)reverse;
	    	}
	    }
	}
}
