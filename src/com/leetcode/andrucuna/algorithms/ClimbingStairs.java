package com.leetcode.andrucuna.algorithms;
import java.util.HashMap;

/**
 * Problem Description:
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 */
public class ClimbingStairs {
	HashMap<Integer, Integer> memory = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) {
		
		ClimbingStairs f =  new ClimbingStairs();
		System.out.println( f.fibonacci(777) );
	}
	
	public int fibonacci( int n ) {
		//Base cases
		if( n == 1) {
			memory.put( 1, 1 );
			return 1;
		}
		if( n == 2 ) {
			memory.put( 2, 2 );
			return 2;
		}
		
		//Recursive case 
		Integer a = memory.get( n-1 );
		Integer b = memory.get( n-2 );
		//Dynamic programming
		if( a == null ) {
			a = fibonacci( n-1 );
			memory.put( n-1, a );
		}
		if( b == null ) {
			b = fibonacci( n-2 );
			memory.put( n-2, b );
		}
		
		return a+b;
	}
}
