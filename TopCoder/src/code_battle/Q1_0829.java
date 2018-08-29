package code_battle;

import java.util.Scanner;

public class Q1_0829 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int case_num = scan.nextInt();
		
		int[] students;
		for(int i=0; i < case_num; i++) {
			
			students = new int[scan.nextInt()];
			
			int submit_num = scan.nextInt();
			for(int j=0; j < submit_num; j++) {
				students[scan.nextInt() - 1 ] = 1;
			}
			
			System.out.printf("#%d", i+1);
			for(int j=0; j < students.length; j++) {
				if(students[j] == 0) System.out.printf(" %d", j+1);
			}
			System.out.println();
		}
		scan.close();
	}

}
