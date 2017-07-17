package PAT.B1006ChangeTheFormatInput;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		while (s.hasNext()) {
			String res=s.nextLine();
			res=new StringBuffer(res).reverse().toString();
			char[] array=res.toCharArray();
			for (int i = array.length-1; i >= 0; i--) {
				if(i==2) {
					for (int j = 0; j < Character.getNumericValue(array[i]); j++) {
						System.out.print("B");
					}
				}else if(i==1) {
					for (int j = 0; j < Character.getNumericValue(array[i]); j++) {
						System.out.print("S");
					}
				}else {
					for (int j = 1; j <= Character.getNumericValue(array[i]); j++) {
						System.out.print(j);
					}
				}
			}
//			System.out.println((int)array[0]);    //the answer is the ASCII Caution!
			System.out.println();
		}

	}

}
