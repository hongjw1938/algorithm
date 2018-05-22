package exhaustiveSearch;

public class CrazyBot {
	
	private static boolean grid[][] = new boolean[100][100];
	private static double prob[] = new double[4];
	private static int vx[] = {1, -1, 0, 0};
	private static int vy[] = {0, 0, 1, -1};
	
	public static double getProbability(int n, int east, int west, int south, int north) {
		
		//°¢°¢ÀÇ È®·ü
		prob[0] = east/100.0;
		prob[1] = west/100.0;
		prob[2] = south/100.0;
		prob[3] = north/100.0;
		
		return dfs(50, 50, n);
	}
	
	private static double dfs(int x, int y, int n) {
		if(grid[x][y]) return 0;
		if(n == 0) return 1;
		
		grid[x][y] = true;
		double ret = 0;
		for(int i=0; i < 4; i++) {
			ret += dfs(x + vx[i], y + vy[i], n-1) * prob[i];
		}
		
		grid[x][y] = false;
		return ret;
	}
}
