import static org.junit.Assert.*;
import java.lang.*;

import java.util.ArrayList;
import java.util.stream.IntStream;

import org.junit.*;


public class RandomArrayGeneratorTest {

	//RandomArrayGenerator returns an ArrayList of 100 int[], whose length is between 1 and 100.
	//each int[] contains integers between the values of 1 and 100
	public RandomArrayGenerator rando = new RandomArrayGenerator();
	
	//generated arrays
	public ArrayList<int[]> arl = rando.generate();
	
	
	
	//method will return a laboonified arraylist of integer arrays if given one
	//used in testing
	public ArrayList<int[]> laboonifyThis( ArrayList<int[]> array) {
		Laboon laboon = new Laboon();
		ArrayList<int[]> temp = array;
		
		for(int i = 0; i < temp.size(); i++){
			temp.set(i, laboon.laboonify(temp.get(i)));
		}
		
		return temp;
		
    }
	
	//assert the generated arraylist contains 100 integer arrays
	//The test should pass, as the Arraylist should have 100 integer arrays
	@Test
	public void testGenerate() {
		assertEquals(arl.size(), 100);
		
	}
	
	//Test every integer array in the arraylist has less than 100 elements and more than 0 elements
	//The test should pass
	@Test
	public void testLength() {
		
		for(int i = 0; i < 100; i++ ){
			assertEquals((arl.get(i).length < 100), true);
			assertEquals((arl.get(i).length > 0), true);
		}
		
		
	}
	
	//Test every integer array in the arraylist has a value between 1 and 99(inclusive)
	//The test should pass
	@Test
	public void testInts() {
		
		for(int i = 0; i < 100; i++ ){
			for(int j = 0; j < arl.get(i).length; j++ ){
				assertEquals((arl.get(i)[j] < 100), true);
				assertEquals((arl.get(i)[j] > 0), true);
			}
		}
			
			
	}
	
	//This test will test the first array condition:
	//The laboonified element of the array should be greater than or equal to the square of the largest element squared
	//The laboonified element should be the same if the array was only 1 element long
	//Other wise, since all integers in the array are greater than 0, it should be bigger
	//This test tests every one of the hundred arrays generated for this condition
	@Test
	public void testCondition1(){
		
		ArrayList<int[]> temp = arl;
		temp = laboonifyThis(temp);
		
		
		int max = 0;
		int length = 0;
		
		for(int i = 0; i < 100; i++ ){
			max = temp.get(i)[0];
			
			for(int j = 0; j < temp.get(i).length; j++){
				if(arl.get(i)[j] > max && j != (temp.get(i).length - 1)){
					max = temp.get(i)[j];
					}
				length = (temp.get(i).length - 1);
			}
			
		assertEquals(true, (Math.pow(max, 2) <= temp.get(i)[length]));
		}
		
		
	}
	
	//This test tests the second array condition:
	//the laboonified element must be lower than 980101, since the max amount a laboonifed array can be is 980101
	//and the max amount of element in our array is 99, and the maximum amount an element can be is 99
	//thus, the laboonfied element at max can be 100*(99)^2, or 980100
	//
	@Test
	public void testCondition2(){
		
		ArrayList<int[]> temp = arl;
		temp = laboonifyThis(temp);
		
		for(int i = 0; i < 100; i++ ){
			assertEquals(true, 980100 >= temp.get(i)[temp.get(i).length-1]);
		}
	}
	
	
	//This test tests the third array condition:
	//the laboonified element must be lower than the number of integers in an array multiplied by 99^2
	//maximum amount an element can be is 99, so that squared and multiplied by the number of elements in an array should always
	//give us a number greater than or equal to the laboonified element
	
	//
	@Test
	public void testCondition3(){
			
		ArrayList<int[]> temp = arl;
		temp = laboonifyThis(temp);
		
		for(int i = 0; i < 100; i++ ){
			assertEquals(true, (Math.pow(99, 2) * temp.get(i).length) >= temp.get(i)[temp.get(i).length-1]);
		}
			
	}
	
	
}
