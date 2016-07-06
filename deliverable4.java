import java.util.ArrayList;

public class deliverable4 {
	
	public static void main(String args[]){
		RandomArrayGenerator rando = new RandomArrayGenerator();
		ArrayList<int[]> arl = new ArrayList<int[]>();
		arl = rando.generate();
		for(int i = 0; i < arl.size(); i++){
			System.out.print("Array " + i + " length " + arl.get(i).length + ": ");
			for(int j = 0; j < arl.get(i).length; j++){
				System.out.print(arl.get(i)[j] + " , ");
			}
			System.out.print("\n");
		}
			
	}
	
}
