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

import java.util.HashMap;


/**
 * Problem Description:
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 * 
 * @author andres.ruiz (andrucuna@gmail.com)
 * @version 1.0
 */
public class ClimbingStairs {
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//                 Attributes                  
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * Used for dynamic programming
	 */
	private HashMap<Integer, Integer> memory = new HashMap<Integer, Integer>();
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//                 Solution                  
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * Returns the number of possible combination climbing a stair of n-steps
	 * @param n
	 * @return int
	 */
	public int climbStairs( int n ) {
		//Base cases
		if( n == 1) {
			memory.put( 1, 1 );
			return 1;
		}
		if( n == 2 ) {
			memory.put( 2, 2 );
			return 2;
		}
		
		//Recursive cases with dynamic programming
		Integer a = memory.get( n-1 );
		Integer b = memory.get( n-2 );

		if( a == null ) {
			a = climbStairs( n-1 );
			memory.put( n-1, a );
		}
		if( b == null ) {
			b = climbStairs( n-2 );
			memory.put( n-2, b );
		}
		
		return a+b;
	}
}
