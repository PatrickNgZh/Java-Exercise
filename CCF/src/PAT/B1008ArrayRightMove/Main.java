package PAT.B1008ArrayRightMove;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner c=new Scanner(System.in);
		while (c.hasNext()) {
			int num=c.nextInt();
			int mov=c.nextInt();
			Deque<Integer> queue=new LinkedList<Integer>();
			for (int i = num; i >=1 ; i--) {
				queue.add(c.nextInt());    //the order is backward
			}
			for (int i = 0; i < mov; i++) {
				int temp=queue.pollLast();
				queue.addFirst(temp);
			}
			for (int i = 0; i < num; i++) {
				if (i!=num-1) {
					System.out.print(queue.pollFirst()+" ");
				} else {
					System.out.print(queue.pollFirst());
				}
			}
			System.out.println();
		}
	}

}
