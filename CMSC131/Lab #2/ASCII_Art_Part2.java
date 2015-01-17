import java.util.Scanner;

public class ASCII_Art_Part2 {
	
	//NOTE: You can add static helper methods here if you want to.
	

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Shape? ");
		String shape = s.next();
		System.out.print("Size? ");
		int size = s.nextInt();
		
		String output = "*";
		if (shape.equals("l-triangle")) {
			for( int row = 0; row < size; row++ ){
				System.out.println(output);
				output = output + "*";
			}
		} else if (shape.equals("r-triangle")) {
			int var1 = 1;
			int var2 = size - 1;
			int counter = 0;
			while (counter != size){
				output = "";
				for (int i = 0; i < var1; i++){
					output = output + "*";
				}
				for(int j = 0; j < var2; j++){
					output = " " + output;
				}
				System.out.println(output);
				var1++;
				var2--;
				counter++;
			}
		} else {  // stripes
			//YOUR CODE HERE
			String prefix;
			String full;
			for( int i = 1; i <= size; i++ ){
				// 1 -> size of lines
				full = "";
				if ( i % 4 == 1 ){
					prefix = "$$$";
					full = prefix;
				}else if ( i % 4 == 2 ){
					prefix = "$$*";
					full = prefix;
				}else if ( i % 4 == 3 ){
					prefix = "$*$";
					full = prefix;
				}else{
					prefix = "*$$";
					full = prefix;
				}
				for( int j = (size - 3); j > 0; j--){
					// run this as many times as we need characters
					if ( prefix == "$$$"){
						full = full + "*";
						prefix = "$$*";
					}else if( prefix == "$$*" ){
						full = full + "$";
						prefix = "$*$";
					}else if ( prefix == "$*$" ){
						full = full + "$";
						prefix = "*$$";
					}else if ( prefix == "*$$"){
						full = full + "$";
						prefix = "$$$";
					}
				}
				System.out.println(full);
			}
		}
		
		s.close();
	}

}
