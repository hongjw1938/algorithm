package d4_sw;

import java.util.Scanner;

public class Maze2 {
	
	private static int board[][];
	private static String maze[];
	
	private static int moveX[] = {0, 1, 0, -1};
	private static int moveY[] = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		for(int i=0; i < 10; i++) {
			int case_num = scan.nextInt();
			
			board = new int[100][100];
			maze = new String[100];
			
			int start_y = 0;
			int start_x = 0;
			for(int j=0; j < maze.length; j++) {
				maze[j] = scan.next();
				
				
				for(int k=0; k < maze[j].length(); k++) {
					board[j][k] = maze[j].charAt(k) - '0';
					if(board[j][k] == 2) {
						start_y=j; start_x=k;
					}
				}

			}
			
			System.out.printf("#%d", case_num);
			System.out.printf(" %d%n", findWay(start_y, start_x));
		}
		
		scan.close();
	}
	
	private static int findWay(int start_y, int start_x) {
		if(board[start_y][start_x] == 1) return 0;
		if(board[start_y][start_x] == 3) return 1;
		board[start_y][start_x] = 1;
		
		int next_y = 0;
		int next_x = 0;
		for(int i=0; i < moveY.length; i++) {
			next_y = start_y + moveY[i];
			next_x = start_x + moveX[i];
			if(next_x < 0 || next_x > 100 || next_y < 0 || next_y > 100) continue;
			if(findWay(next_y, next_x) == 1) return 1;
			else continue;
		}
		return 0;
	}

}
