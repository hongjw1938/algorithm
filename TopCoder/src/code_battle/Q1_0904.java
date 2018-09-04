package code_battle;

import java.util.Scanner;

public class Q1_0904 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int case_num = scan.nextInt();
		
		for(int i=1; i <= case_num; i++) {
			int m = scan.nextInt();
			int n = scan.nextInt();
			
			int date = 0;
			if(m == 1) date += n;
			else {
				int month = 1;
				while(month < m) {
					if( month < 8 && month % 2 == 1) date += 31;
					else if( month < 8 && month % 2 == 0) {
						if(month == 2) date += 29;
						else date += 30;
					} else if(month >= 8 && month % 2 == 1) date += 30;
					else date += 31;
					
					month++;
				}
				
				date += n; 
			}
			
			
			int result = date % 7 + 3;
			if(result < 7) System.out.println("#" + i + " " + result);
			else System.out.println("#" + i + " " + (result - 7));
			
			
		}

	}

}
