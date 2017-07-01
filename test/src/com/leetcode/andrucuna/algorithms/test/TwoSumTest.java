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
import com.leetcode.andrucuna.algorithms.TwoSum;


/**
 * Test algorithm "TwoSum.java"
 * 
 * @author andres.ruiz (andrucuna@gmail.com)
 * @version 1.0
 */
public class TwoSumTest {
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//           Configuration Variables                  
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * File with test cases, inputs and expected results
	 */
	private static final String TEST_CASES_FILE_PATH = "./test/test-cases/TwoSumTC";
	
	/**
	 * Algorithm time tolerance in ms
	 */
	private static final long TIME_TOLERANCE = 32;
	
	/**
	 * List of inputs to test
	 */
	private int[] inputsN;
	
	/**
	 * List of inputs to test
	 */
	private int inputT;
	
	/**
	 * List of expected results
	 */
	private int[] output; 
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//                 Load Test Cases                  
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * Load test cases from file
	 */
	@Test
	public void testAllCases() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader( TEST_CASES_FILE_PATH ));
		    //Read file header
			String line = br.readLine();
	
			//Number of test cases
			line = br.readLine();
			int testCases = Integer.parseInt( (line.split("=")[1]).trim() );
			
			//Load inputs and outputs
		    for ( int i = 0; i<testCases; i++ ) {
		        line = br.readLine();
		        if( line != null ) {
		        	String numsS = line.split(" ")[0].trim();
		        	//Build array input
		        	inputsN = new int[numsS.split(",").length];
		        	for (int j = 0; j < inputsN.length; j++) {
		        		inputsN[j] = Integer.parseInt(numsS.split(",")[j]);
					}
		        	//Get target input and output
		        	inputT = Integer.parseInt( line.split(" ")[1].trim() );
		        	String outputS = line.split(" ")[2].trim();
		        	output = new int[2];
		        	for (int k = 0; k < output.length; k++) {
		        		output[k] = Integer.parseInt(outputS.split(",")[k]);
					}
		        	
		        	//Test this case
		        	testTwoSumAlgorithm(inputsN, inputT, output);
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
	public void testTwoSumAlgorithm(int[] nums, int target, int[] output) {
		TwoSum ts = new TwoSum(); 
		
		try {
			// Get solution and total time
			long startTime = System.currentTimeMillis();
			int[] result = ts.twoSum( nums, target );
			long endTime   = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			
			//Verify if the algorithm exceed time limit 
			if( totalTime > TIME_TOLERANCE ) {
				System.err.println( "Time Limit Exceed. Total time: "+totalTime+" ms" );
				fail( "Time Limit Exceed. Total time: "+totalTime+" ms" );
			}
			
			//Verify output vs expected result
			boolean tcSucceed = (result[0] == output[0]) && (result[1] == output[1]);
			if( !tcSucceed )
				System.err.println( "Test case failed. Input: "+nums.toString()+". Result: "+result.toString()+". Expected: "+output.toString() );
			assertEquals( "Test case failed. Input: "+nums.toString()+". Result: "+result.toString()+". Expected: "+output.toString(), tcSucceed, true );
		
			System.out.println( "Test case succeed!!!" );
		} catch ( Exception e ) {
			System.err.println( e.getMessage() );
			fail( "Runtime error: "+e.getMessage() );
		}
	}
}
