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
 **/
public class TwoSum {
	
	public class Solution {
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
}