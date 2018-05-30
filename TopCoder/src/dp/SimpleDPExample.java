package dp;

public class SimpleDPExample {

	final int h = 5, w = 4; 
	int[][] dp = new int[h+1][w+1];
	
	
	public static void main(String[] args) {
		SimpleDPExample ans = new SimpleDPExample();
		System.out.println(ans.dfs(0, 0));
		
		SimpleDPExample ans2 = new SimpleDPExample();
		System.out.println(ans2.dfs2(0, 0));
		
		SimpleDPExample ans3 = new SimpleDPExample();
		System.out.println(ans3.dp());
	}
	
	public int dfs(int nowh, int noww) {
		
		//한계 거리 이상 이동시도시 반환
		if(nowh > h || noww > w) return 0;
		
		//만약 최종점에 도달시 return
		if(nowh == h && noww == w) return 1;
		
		return dfs(nowh + 1, noww) + dfs(nowh, noww + 1);
	}
	
	//메모화 재귀로 만드는 경우
	public int dfs2(int nowh, int noww) {
		if(nowh > h || noww > w) return 0;
		if(nowh == h && noww == w) return 1;
		
		if(dp[nowh][noww] != 0) return dp[nowh][noww];
		
		return dp[nowh][noww] = dfs(nowh + 1, noww) + dfs(nowh, noww + 1);
	}
	
	//일반적인 동적 계획법을 사용하는 경우
	public int dp() {
		int i, j;
		
		//최초의 점은 1로 초기화
		dp[0][0] = 1;
		
		for(i = 0; i < h; i++) {
			for(j = 0; j < w; j++) {
				if(i != 0) dp[i][j] += dp[i-1][j];
				if(j != 0) dp[i][j] += dp[i][j-1];
			}
		}
		
		return dp[h][w];
	}
}
