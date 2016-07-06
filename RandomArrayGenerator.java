import java.util.*;

//Object generates 100 integer arrays randomly,
//returns those arrays in an arraylist

//The last generated array made in the object can also be printed

public class RandomArrayGenerator {
	
	ArrayList<int[]> arl = new ArrayList<int[]>();

	//method
	public ArrayList<int[]> generate(){
				
		for(int j = 0; j < 100; j++){
			Random random = new Random();
			int length = random.nextInt(99) + 1;
			int [] array = new int [length];
			int value;
			
			for(int i = 0; i <= length-1; i++){
				value = random.nextInt(99) + 1;
				array[i] = value;
				}
			
			arl.add(array);
		}
		
		return arl;
	}//end generate
	
	
	
	public int[] getArray(int i){
		return arl.get(i);
	}
	
	
	public void print(){
		System.out.print("Arrays: ");
		for(int i = 0; i < arl.size(); i++){
			System.out.println("\nArrays #" + i);
			for(int j = 0; j < arl.get(i).length; j++)
			System.out.print(arl.get(i)[j] + " , ");
		}
	}
	
}
