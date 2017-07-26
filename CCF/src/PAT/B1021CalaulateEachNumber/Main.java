package PAT.B1021CalaulateEachNumber;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			String res=s.nextLine();
			char[] array=res.toCharArray();
			int[] cal=new int[10];
			for (int i = 0; i < array.length; i++) {
				++cal[Character.getNumericValue(array[i])];
			}
			for (int i = 0; i < cal.length; i++) {
				if(cal[i]!=0) {
					System.out.println(i+":"+cal[i]);
				}
			}
			System.out.println();
		}
	}

}
