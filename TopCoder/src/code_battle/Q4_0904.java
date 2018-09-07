package code_battle;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q4_0904 {
	
	private static String[] icyRoad;
	private static boolean[][] stayed;
	private static int[] moveRow = {0, 1, 0, -1};
	private static int[] moveCol = {1, 0, -1, 0};
//	private static int MAX;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int test_num = scan.nextInt();
		for(int i=1; i <= test_num; i++) {
			int row = scan.nextInt();
			int col = scan.nextInt();
		
			icyRoad = new String[row];
			stayed = new boolean[row][col];
			
//			MAX = row + col;
			//icyRoad길 확인
			for(int j=0; j < row; j++) {
				icyRoad[j] = scan.next();
			}
			// boolean배열 초기화
			for(int j=0; j < stayed.length; j++) {
				for(int k=0; k < stayed[j].length; k++) {
					if(icyRoad[j].charAt(k) == '#') stayed[j][k] = true;
				}
			}
			
//			for(int j=0; j < row; j++) {
//				for(int k=0; k < row; k++) {
//					System.out.print(icyRoad[j].charAt(k));
//				}
//				System.out.println();
//			}
//			
//			if(icyRoad[0].charAt(0) == '#') {
//				System.out.println("it is right");
//			} else {
//				System.out.println("no it is not");
//			}
			
			int start_row = scan.nextInt() - 1;
			int start_col = scan.nextInt() - 1;
			
			int end_row = scan.nextInt() - 1;
			int end_col = scan.nextInt() - 1;
			
			int moved = 0;
			stayed[start_row][start_col] = true;
			
//			moved = dfs(start_row, start_col, end_row, end_col, 0);
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {start_row, start_col, 0});
			while(!q.isEmpty()) {
				int[] current_pos = q.poll();
				int current_y = current_pos[0];
				int current_x = current_pos[1];
				int move = current_pos[2];
				
				stayed[current_y][current_x] = true;
				
				Queue<int[]> subq = new LinkedList<>();
				for(int k=0; k < moveRow.length; k++) {
					int next_y = current_y;
					int next_x = current_x;
					while(true) {
						next_y += moveRow[k];
						next_x += moveCol[k];
						if(icyRoad[next_y].charAt(next_x) == '#' || stayed[next_y][next_x]) {
							next_y -= moveRow[k];
							next_x -= moveCol[k];
							
							if(next_y == current_y && next_x == current_x) {
								break;
							} else {
								int m = move+1;
								subq.add(new int[] {next_y, next_x, m});
								break;
							}
						}
					}
					
					if(!subq.isEmpty()) {
						int[] after_moved = subq.poll();
						int after_y = after_moved[0];
						int after_x = after_moved[1];
						
//						System.out.println("y : " + after_y + ", x : " + after_x + ", move :" + after_moved[2] );
						
						if(after_y == end_row && after_x == end_col) {
							q.clear();
							moved = after_moved[2];
							break;
						} else {
							q.add(after_moved);
						}
					} else {
						if(next_y == end_row && next_x == end_col) break;
						else {
							moved = -1;
						}
					}
				}
			}
//			if(moved == Integer.MAX_VALUE) {
//				System.out.println("#" + i + " " + "-1");
//			} else {
				System.out.println("#" + i + " " + moved);
		}
		scan.close();
	}
	
//	private static int dfs(int start_y, int start_x, int end_y, int end_x, int move) {
//		if(start_y == end_y && start_x == end_x) return move;
//		if(stayed[start_y][start_x]) return -1;
//		if(move > MAX) return Integer.MAX_VALUE;
//		
//		stayed[start_y][start_x] = true;
//		int ret_val = Integer.MAX_VALUE;
//		for(int i=0; i < 4; i++) {
//			int next_y = start_y;
//			int next_x = start_x;
////			System.out.println("next_y : " + next_y + ", next_x : " + next_x);
//			while(icyRoad[next_y+moveRow[i]].charAt(next_x+moveCol[i]) == '.' && !stayed[next_y+moveRow[i]][next_x+moveCol[i]]) {
//				next_y += moveRow[i];
//				next_x += moveCol[i];
//			}
//			
//			if(next_y == end_y && next_x == end_x) {
//				ret_val = move+1;
//				break;
//			} else {
//				if(next_x == start_x && next_y == start_y) {
//					continue;
//				} else {
//					ret_val = Math.min(dfs(next_y, next_x, end_y, end_x, move+1), ret_val);
//				}
//			}
//		}
//		
//		stayed[start_y][start_x] = false;
//		return ret_val;
//	}
}
