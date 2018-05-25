package exhaustiveSearch;

import java.util.LinkedList;
import java.util.Queue;


public class MazeMakerBFS {
	//DFS로 푸는 방식은 계산량이 너무 많음.
	//이런 경우 BFS방식으로 고쳐본다.
	public int board[][];
	
	public int longestPath(String[] maze, int startRow, int startCol, 
							int[] moveRow, int[] moveCol) {
		
		//반환할 값을 미리 지정
		int longest = 0;
		
		//해당 값으로 이동했을 때, 각 위치마다 이동 값을 지정하기 위한 board배열 생성
		int width = maze[0].length();
		int height = maze.length;

		board = new int[height][width]; //처음엔 0값이 지정되어 있다.
		
		//각 값을 -1로 지정
		for(int i=0; i < board.length; i++) {
			for(int j=0; j < board[i].length; j++) {
				board[i][j] = -1;
			}
		}
		
		//처음 시작점을 0으로 지정
		board[startRow][startCol] = 0;
		
		//bfs를 진행하기 위해서 FIFO방식의 Queue를 생성
		Queue<Integer> queueX = new LinkedList<Integer>();
		Queue<Integer> queueY = new LinkedList<Integer>();
		
		queueX.add(startCol);
		queueY.add(startRow);
		
		//이동시키기 위한 반복문
		while(!queueX.isEmpty()) {
			int x = queueX.poll();
			int y = queueY.poll();
			
			for(int i = 0; i < moveRow.length; i++) {
				int nextX = x + moveCol[i];
				int nextY = y + moveRow[i];
				
				
				//index가 벗어나지 않고 최초 값이며 해당 값으로 이동 가능시
				if( 0 <= nextX && nextX < width
						&& 0 <= nextY && nextY < height 
						&& board[nextY][nextX] == -1
						&& maze[nextY].charAt(nextX) == '.') {
		
					//이전에 이동했던 위치에서 이동값을 ++
					board[nextY][nextX] = board[y][x] + 1;
					
					queueX.offer(nextX);
					queueY.offer(nextY);
				}
			}
			
		}
		for(int i=0; i < height; i++) {
			for(int j=0; j < width; j++) {
				if(maze[i].charAt(j) == '.' && board[i][j] == -1) {
					return -1;
				}
				longest = Math.max(longest,  board[i][j]);
			}
		}
		
		return longest;
	}
}
