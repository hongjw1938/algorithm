package d4_sw;

import java.util.Scanner;

public class Ladder2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[][] ladder = new int[100][100];
		int answer = 0;
		for(int i=0; i < 10; i++) {
			System.out.printf("#%d", scan.nextInt());
			
			for(int j=0; j < 100; j++) {
				for(int k=0; k < 100; k++) {
					ladder[j][k] = scan.nextInt();
				}
			}
			
			int way = 10000;
			for(int j=0; j < 100; j++) {
				if(ladder[0][j] == 1) {
					int n = checkWay(ladder, 0, j, 0, "down");
					if(way >= n) {
						way = n;
//						System.out.println("way :" +n);
						
						answer = j;
					}
				}
			}
			System.out.printf(" %d", answer);
			System.out.println();
		}
		scan.close();
	}
	
	private static int checkWay(int[][] ladder, int y_pos, int x_pos, int n, String direction) {
//		System.out.println("n :" + n);
		if(y_pos == 99) return n;
		
		if(x_pos > 0 && ladder[y_pos+1][x_pos-1] == 1 && (direction.equals("down") || direction.equals("right"))) {
			x_pos--;
			return checkWay(ladder, y_pos, x_pos, n+1, "right");
		} else if(x_pos < 99 && ladder[y_pos+1][x_pos+1] == 1 && ( direction.equals("down") || direction.equals("left"))) {
			x_pos++;
			return checkWay(ladder, y_pos, x_pos, n+1, "left");
		} else {
			y_pos++;
			return checkWay(ladder, y_pos, x_pos, n+1, "down");
		}
		
	}
}
