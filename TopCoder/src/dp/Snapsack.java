package dp;

public class Snapsack {
	
	int[] weightSnap = {3, 4, 1, 2, 3};
	int[] valueSnap = {2, 3, 2, 3, 6};

	int[][] dp = new int[6][11];
	
	public static void main(String[] args) {
		Snapsack ans = new Snapsack();
		System.out.println(ans.getValue(0, 0));
		
		
		
	}
	
	public int getValue(int n, int w) {
		
		int ret = 0;
		
		for(int i=0; i < weightSnap.length; i++) {
			for(int j=0; j < 10; j++) {
				
				if(j + weightSnap[i] > 10) continue;
				//���Ը� ���Ͽ� ����
				dp[i+1][j + weightSnap[i]] = Math.max(dp[i][j] + valueSnap[i], dp[i+1][j + weightSnap[i]]);
				ret = Math.max(dp[i+1][j + weightSnap[i]], ret);
			}
		}
		
		return ret;
	}

}
