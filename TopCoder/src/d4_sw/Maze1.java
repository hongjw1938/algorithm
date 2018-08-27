package d4_sw;

import java.util.Scanner;

public class Maze1 {
	
	private static int[] dy = {1, 0, -1, 0};
	private static int[] dx = {0, 1, 0, -1};
	private static String[] maze;
	private static int[][] board;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		for(int i=0; i < 10; i++) {
			int case_num = scan.nextInt();
			maze = new String[16];
			board = new int[16][16];
			
			for(int j=0; j < maze.length; j++) {
				maze[j] = scan.next();
				for(int k=0; k < maze[j].length(); k++) {
					board[j][k] = maze[j].charAt(k) - '0';
				}
			}
			System.out.printf("#%d", case_num);
			System.out.printf(" %d%n", findWay(maze, 1, 1));
			
		}
		
		scan.close();
	}
	
	private static int findWay(String[] maze, int y_pos, int x_pos) {
		if(maze[y_pos].charAt(x_pos) - '0' == 3) return 1;
		if(board[y_pos][x_pos] == 1) return 0;
		board[y_pos][x_pos] = 1;
		
		int ret_val = 0;
		for(int i=0; i < dy.length; i++) {
			int nextY = y_pos + dy[i];
			int nextX = x_pos + dx[i];
			
			if(nextY < 16 && nextY >= 0 && nextX < 16 && nextX > 0) {
				ret_val = findWay(maze, nextY, nextX);
				if(ret_val == 1) break;
			} else {
				continue;
			}
		}
		return ret_val;
	}
}
