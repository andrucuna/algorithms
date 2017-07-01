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
 *  Problem: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *  You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * @author andres.ruiz (andrucuna@gmail.com)
 * @version 1.0
 */
public class TwoSum {	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//                 Solution                  
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * Returns the index of the number in an array "nums", that sums up to "target"
	 * @param nums
	 * @param target
	 * @return int[]
	 */
	public int[] twoSum(int[] nums, int target) {
       int[] solution = new int[2]; 
       
       if( nums.length>0 ){
	       //I will use a HashMap in order to store <value, index>
    	   HashMap<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
	       numsMap.put( nums[0], 0 );
	       for( int i=1; i<nums.length; i++ ){
	    	   //I verify if the current value has a pair that adds to target
	    	   Integer substractionIndex = numsMap.get( target - nums[i] ); 
	    	   if( substractionIndex != null ) {
	    		   solution[0] = substractionIndex;
	    		   solution[1] = i;
	    		   
	    		   return solution;
	    	   }
	    	   
	    	   numsMap.put( nums[i], i );
	       }
       }
       
       return solution;
    }
}