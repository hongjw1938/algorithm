package code_battle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Doll_Comparator implements Comparator<long[]>{
	@Override
	public int compare(long[] o1, long[] o2) {
		if(o1[0] == o2[0]) {
			return (int)(o1[1] - o2[1]);
		} else {
			return (int)(o1[0] - o2[0]);
		}
	}
	
}

public class Q4_0829 {
	private static List<long[]> matryoshka;
	private static long radius;
	private static long height;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int case_num = scan.nextInt();
		
		int case_N = scan.nextInt();
		int case_Q = scan.nextInt();
		
		matryoshka = new ArrayList<>();
		for(int i=0; i < case_N; i++) {
			long radius = scan.nextLong();
			long height = scan.nextLong();
			matryoshka.add(new long[] { radius, height });
		}
		
		//sort
		Collections.sort(matryoshka, new Doll_Comparator());
		
		
//		for(int i=0; i < matryoshka.size(); i++) {
//			for(int j=0; j < 2; j++) {
//				System.out.print(matryoshka.get(i)[j]);
//			}
//			System.out.println();
//		}
		
		int minimum = 0;
		for(int i=0; i < case_Q; i++) {
			
			radius = scan.nextLong();
			height = scan.nextLong();
				
			Stack<long[]> stack = new Stack<>();
			for(int j=0; j < matryoshka.size(); j++) {
				long[] current_doll = matryoshka.get(j);
				
				if(current_doll[0] >= radius && current_doll[1] <= height) {
					stack.push(current_doll);
				}
			}
			if(stack.size() == 0) minimum += 0;
			else minimum += i * store_doll(stack, stack.pop()[0], stack.pop()[1]);
		}
		
		System.out.printf("#%d", case_num);
		System.out.printf(" %d%n", minimum);
		scan.close();
	}
	
	private static int store_doll(Stack<long[]> stack, long current_radius, long current_height) {
		long[] next_doll = stack.peek();
		
		int ret_val = stack.size();
		for(int i=0; i <= stack.size(); i++) {
			if(next_doll[0] < current_radius && next_doll[1] < current_height) {
				ret_val = store_doll(stack, stack.pop()[0], stack.pop()[1]);
			} else {
				
			}
		}
		
		return ret_val;
	}
}
