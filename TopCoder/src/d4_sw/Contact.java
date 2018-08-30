package d4_sw;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Contact {
	
	private static int[][] contact;
	private static int[] onCall;
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		for(int i=0; i < 10; i++) {
			int con_num = scan.nextInt();
			int start_num = scan.nextInt();
			
			contact = new int[101][101];
			onCall = new int[101];
			for(int j=0; j < con_num / 2; j++) {
				int index = scan.nextInt();
				int val = scan.nextInt();
				
				int k=0;
				int temp = 0;
				while(contact[index][k] != 0) {
					if(contact[index][k] < val) {
						temp = contact[index][k];
						contact[index][k] = val;
						val = temp;
					}
					k++;
				}
				contact[index][k] = val;
			}
			System.out.printf("#%d", i+1);
			System.out.printf(" %d%n", get_highest(start_num));
		}
		scan.close();
	}
	
	private static int get_highest(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		Queue<Integer> subq = null;
		int ret_val = 0;
		while(!q.isEmpty()) {
			subq = new LinkedList<>();
			int length = q.size();
			
			for(int i=0; i < length; i++) {
				int current = q.poll();
				subq.add(current);
				onCall[current] = 1;
					
				int idx = 0;
				while(contact[current][idx] != 0) {
					int next = contact[current][idx];
					
					if(onCall[next] != 1) {
						onCall[next] = 1;
						q.add(next);
					}
					idx++;
				}
			}
			if (!q.isEmpty()) {
                subq.clear();
            } else {
                break;
            }
		}
		while(!subq.isEmpty()) {
			if(subq.peek() > ret_val) ret_val = subq.poll();
			else subq.poll();
		}		
		return ret_val;
	}
}
