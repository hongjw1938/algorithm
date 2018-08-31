package d4_sw;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int y;
	int x;
	Point(int y, int x){
		this.y = y;
		this.x = x;
	}
}
public class SupplyRoute {
	private static int[][] routes;
	private static int[][] board;
	private static int[] dy = {1, 0, -1, 0};
	private static int[] dx = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int test_case = scan.nextInt();
		for(int i=1; i <= test_case; i++) {
			int length = scan.nextInt();
			
			routes = new int[length][length];
			board = new int[length][length];
			for(int j=0; j < length; j++) {
				String s = scan.next();
				for(int k=0; k < length; k++) {
					routes[j][k] = s.charAt(k) - '0';
					board[j][k] = Integer.MAX_VALUE; 
				}
			}
			
			Queue<Point> point = new LinkedList<>();
			point.add(new Point(0, 0));
			board[0][0] = routes[0][0];
			
			while(!point.isEmpty()) {
				Point p = point.remove();
				for(int j=0; j < 4; j++) {
					int ny = p.y + dy[j];
					int nx = p.x + dx[j];
					
					if(ny < 0 || ny >= length || nx < 0 || nx >= length) continue;
					if(board[ny][nx] > board[p.y][p.x] + routes[ny][nx]) {
						board[ny][nx] = board[p.y][p.x] + routes[ny][nx];
						point.add(new Point(ny, nx));
					}
				}
			}
			System.out.printf("#%d", i);
			System.out.printf(" %d%n", board[length-1][length-1]);
		}
		
		scan.close();
	}
}
