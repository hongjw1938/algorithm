package exhaustiveSearch;

public class CrazyBot3 {
	//3에서는 조금 다른 방식으로 구현해보도록 함.
	private boolean grid[][];
	private double success;
	private double overall;
	
	private int n;
	private int east;
	private int south;
	private int west;
	private int north;
	CrazyBot3(int n, int east, int south, int west, int north) {
		grid = new boolean[100][100];
		success = 0.0;
		overall = 0.0;
		
		this.n = n;
		this.east = east;
		this.south = south;
		this.west = west;
		this.north = north;
	}
	
	public double getAnswer() {
		dfs(n, 50, 50);
		return success / overall;
	}
	
	private void dfs(int n, int x, int y) {
		
		//실패한 경우
		if(grid[x][y]) {
			
			overall++;
			//System.out.println("x : " + x + ", y : " + y + ":" + success + ", " + overall);
			return;
		}
				
		//성공한 경우
		if(n==0) {
			
			overall++; success++;
			//System.out.println("x : " + x + ", y : " + y + ":" + success + ", " + overall);
			return;
		}
		
		
		//최초 true변환 및 이동 자리 true변환
		grid[x][y] = true;
		
		for(int i = n; i > 0; i--) {
			if(east != 0) dfs(i-1, x+1, y);
			if(south != 0) dfs(i-1, x, y+1);
			if(west != 0) dfs(i-1, x-1, y);
			if(north != 0) dfs(i-1, x, y-1);
			
			//i가 값이 줄어서 최상위에서 다시 시작하는 것을 방지.
			if(i == n) break;
			
		}
		grid[x][y] = false;
	}
	
}
