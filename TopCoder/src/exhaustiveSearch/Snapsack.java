package exhaustiveSearch;

public class Snapsack {
	
	int[] weightSnap = {3, 4, 1, 2, 3};
	int[] valueSnap = {2, 3, 2, 3, 6};

	
	int[][] dp = new int[6][11];
	int ans = 0;
	
	public static void main(String[] args) {
		Snapsack ans = new Snapsack();
		
		for(int i=0; i < ans.dp.length; i++) {
			for(int j=0; j < ans.dp[i].length; j++) {
				ans.dp[i][j] = -1;
			}
		}
		System.out.println(ans.knapsack2(0, 0));
		System.out.println("-----------------------");
		for(int i=0; i < ans.dp.length; i++) {
			for(int j=0; j < ans.dp[i].length; j++) {
				System.out.print("dp[" + i + "][" + j + "] = " + ans.dp[i][j] + "\t" );
			}
			System.out.println();
		}

	}
	
	public int getMaxValue() {
		
		dfs(0, 0, 0);
		return ans;
	}
	
	public void dfs(int n, int w, int v) {
		
		//留뚯빟 weight媛� 10 珥덇낵�씠硫� return
		if(w > 10) return;
		
		ans = Math.max(ans, v);
		if(n >= weightSnap.length) return; 
		
		System.out.println("dfs(" + (n+1) + ", " + (w+weightSnap[n]) + ", " + (v+valueSnap[n]) + ")");
		dfs(n+1, w, v);
		System.out.println("dfs(" + (n+1) + ", " + (w+weightSnap[n]) + ", " + (v+valueSnap[n]) + ")");
		dfs(n+1, w + weightSnap[n], v + valueSnap[n]);
		
	}
	
	//다른 방식
	public int knapsack(int n, int w) {
		
		if(w > 10) return -1;
		if(n > weightSnap.length) return 0;
		return Math.max(knapsack(n + 1, w), knapsack(n + 1, w + weightSnap[n]) + valueSnap[n]);
	}
	
	//used memorization
	public int knapsack2(int n, int w) {
		if(w > 10) return -1;
		if(n >= weightSnap.length) return 0;
		if(dp[n][w] >= 0) return dp[n][w];
		System.out.println("dp"+n+w );
		return dp[n][w] = Math.max(knapsack2(n+1, w), knapsack2(n+1, w + weightSnap[n]) + valueSnap[n]);
	}
}
