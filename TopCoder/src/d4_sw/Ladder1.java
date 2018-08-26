package d4_sw;

import java.util.Scanner;

public class Ladder1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int case_num =0;
		int[][] ladder = new int[100][100];

		for(int i=0; i < 10; i++){
			int arrive_point=0;
			
			case_num = scan.nextInt();
			System.out.printf("#%d", case_num);
			
			for(int k=0; k < ladder.length; k++) {
				for(int j=0; j < ladder[k].length; j++) {
					ladder[k][j] = scan.nextInt();
					if(ladder[k][j]==2) {
						arrive_point = j;
					}
				}
			}
		
			int answer = findway(ladder, arrive_point);
			System.out.printf(" %d", answer);
			System.out.println();
		}
		scan.close();
	}
	
	public static int findway(int[][] ladder, int arrive_point) {
		
		int x_pos = arrive_point;
		
		for(int y_pos=99; y_pos >= 0; y_pos--) {
			if(x_pos >=1 && ladder[y_pos][x_pos-1] == 1) {
				x_pos--;
				while(ladder[y_pos-1][x_pos] != 1) {
					x_pos--;
				}
			} else if(x_pos <= 98 && ladder[y_pos][x_pos+1] == 1) {
				x_pos++;
				while(ladder[y_pos-1][x_pos] != 1) {
					x_pos++;
				}
			} else {
				continue;
			}
		}
		
		return x_pos;
	}

}
