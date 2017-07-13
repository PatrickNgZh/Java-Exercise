package PAT.A1005SpellIiRight;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner c=new Scanner(System.in);
		while(c.hasNext()) {
			String src=c.nextLine();
			String[] broker=src.split(" ");
			List<String> target=Arrays.asList(broker);//why not to use the type of ArrayList
			Collections.reverse(target);      //because the ArrayList is the downCast which is illegal
			for (int i = 0; i < target.size(); i++) {
				if(i<target.size()-1) {
					System.out.print(target.get(i)+" ");
				}else {
					System.out.println(target.get(i));
				}
			}
		}
	}

}
