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
package com.leetcode.andrucuna.algorithms.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Test;
import com.leetcode.andrucuna.algorithms.ClimbingStairs;


/**
 * Test algorithm "ClimbingStairs.java"
 * 
 * @author andres.ruiz (andrucuna@gmail.com)
 * @version 1.0
 */
public class ClimbingStairsTest {
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//           Configuration Variables                  
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * File with test cases, inputs and expected results
	 */
	private static final String TEST_CASES_FILE_PATH = "./test/test-cases/ClimbingStairsTC";
	
	/**
	 * Algorithm time tolerance in ms
	 */
	private static final long TIME_TOLERANCE = 32;
	
	/**
	 * List of inputs to test
	 */
	private int[] inputs;
	
	/**
	 * List of expected results
	 */
	private int[] outputs; 
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//                 Load Test Cases                  
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * Load test cases from file
	 */
	private void loadTestCases() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader( TEST_CASES_FILE_PATH ));
		    //Read file header
			String line = br.readLine();
			
			//Number of test cases
			line = br.readLine();
			int testCases = Integer.parseInt( (line.split("=")[1]).trim() );
			inputs = new int[testCases];
			outputs = new int[testCases];
			
			//Load inputs and outputs
		    for ( int i = 0; i<testCases; i++ ) {
		        line = br.readLine();
		        if( line != null ) {
		        	inputs[i] = Integer.parseInt( (line.split(" ")[0]).trim() );
		        	outputs[i] = Integer.parseInt( (line.split(" ")[1]).trim() );
		        }
		    }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if( br != null )
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//                 Tests                  
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * Test if the algorithm test cases succeed, during the established time limit  
	 */
	@Test
	public void testIsPalindromeAlgorithm() {
		ClimbingStairs c = new ClimbingStairs(); 
		loadTestCases();
		
		try {
			for (int i = 0; i < inputs.length; i++) {
				// Get solution and total time
				long startTime = System.currentTimeMillis();
				int result = c.climbStairs( inputs[i] );
				long endTime   = System.currentTimeMillis();
				long totalTime = endTime - startTime;
				
				//Verify if the algorithm exceed time limit 
				if( totalTime > TIME_TOLERANCE ) {
					System.err.println( "Time Limit Exceed. Total time: "+totalTime+" ms" );
					fail( "Time Limit Exceed. Total time: "+totalTime+" ms" );
				}
				
				//Verify output vs expected result
				boolean tcSucceed = (result == outputs[i]);
				if( !tcSucceed )
					System.err.println( "Test case failed. Input: "+inputs[i]+". Result: "+result+". Expected: "+outputs[i] );
				assertEquals( "Test case failed. Input: "+inputs[i]+". Result: "+result+". Expected: "+outputs[i], result, outputs[i] );
			}
			
			System.out.println( "Test cases succeed!!!" );
		} catch ( Exception e ) {
			System.err.println( e.getMessage() );
			fail( "Runtime error: "+e.getMessage() );
		}
	}
}
