import java.lang.*;

//Laboonifies an integer array

public class Laboon {
	
	public int[] laboonify(int [] array){
		int tempval = 0;
		int [] temparray = new int [(array.length + 1)];
		for(int i = 0; i < array.length; i++){
			tempval += (int) Math.pow(array[i], 2);
			temparray[i] = array[i];
		}
		
		temparray[array.length] = tempval;
		
		return temparray;
	
	}

}
