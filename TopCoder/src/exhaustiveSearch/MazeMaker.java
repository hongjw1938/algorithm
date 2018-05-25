package exhaustiveSearch;

public class MazeMaker {
	private int colLength;
	public int[][] moved;
	private boolean[][] check;
	private int dfsCalled = 0;
	public int longestPath(String[] maze, int startRow, int startCol, 
							int[] moveRow, int[] moveCol) {
		//아이디어 : 출발점에서 가능한 방식으로 계속 움직여
		//각각의 점까지 최단거리로 이동시킨다.
		//각 위치에 도착했을 때, 이동거리 중 minimum값을 배열에 저장
		//dfs가 끝났을 때는, 이동거리를 저장한 배열을 조사하여
		//-1이 있는지 찾고 없으면 최장거리를 반환함.
		
		colLength = maze[0].length();
		moved = new int[maze.length][colLength];
		check = new boolean[maze.length][colLength];
	
		dfs(maze, 0, startRow, startCol, moveRow, moveCol);
		
		int retVal = 0;
		for(int i=0; i < moved.length; i++) {
			for(int j=0; j < moved[i].length; j++) {
				if(i == startRow && j == startCol || maze[i].charAt(j) == 'X') { 
					continue;
				} else if(moved[i][j] == 0){
					return -1;
				} else {
					retVal = Math.max(retVal, moved[i][j]);
				}
			}
		}
		
		System.out.println(dfsCalled);
		return retVal;
	}
	
	private void dfs(String[] maze, int n, int x, int y,
					int[] moveRow, int[] moveCol) {
		dfsCalled++;
		//이미 이동한 장소이거나 ArrayIndex를 벗어나는 경우 되돌아감.
		int rowLeng = maze.length;
		int colLeng = maze[0].length();
		if(x < 0 || x >= rowLeng || y < 0 || y >= colLeng || check[x][y] == true) {
			return;
		}
		
		//X표시가 있는 장소인 경우 돌아감
		if(maze[x].charAt(y) == 'X') return;
		
		//이동 가능한 장소인 경우 이동했다는 표시를 함. true
		check[x][y] = true;
		
		//n값을 이동 거리로 계산하므로 해당 값을 대입
		if(moved[x][y] == 0) {
			moved[x][y] = n;
		} else {
			moved[x][y] = Math.min(moved[x][y], n);
		}
		
		
		//이동시킴
		for(int i=0; i < moveRow.length; i++) {
			dfs(maze, n+1, x + moveRow[i], y + moveCol[i], moveRow, moveCol);
		}
		
		check[x][y] = false;
	}
}
