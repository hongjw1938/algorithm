package dp;


public class BadNeighbors {

	public static void main(String[] args) {
BadNeighbors ans = new BadNeighbors();
		
		int[] donations = {10, 3, 2, 5, 7, 8};
		int[] donations2 = {11, 15};
		int[] donations3 = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
 		System.out.println(ans.maxDonations(donations));
 		System.out.println(ans.maxDonations(donations2));
 		System.out.println(ans.maxDonations(donations3));

	}
	
	public int maxDonations(int[] donations) {
		int i = 0;
		int ans = 0;
		
		int N = donations.length;
		int[] dp = new int[N];
		
		for(i = 0; i < N-1; i++) {
			dp[i] = donations[i];
			if( i>0 ) dp[i] = Math.max(dp[i], dp[i-1]);
			if( i>1 ) dp[i] = Math.max(dp[i], dp[i-2] + donations[i]);
			
			ans = Math.max(ans, dp[i]);
		}
		
		for( i = 0; i < N-1; i++) {
			dp[i] = donations[i+1];
			if( i>0 ) dp[i] = Math.max(dp[i], dp[i-1]);
			if( i>1 ) dp[i] = Math.max(dp[i], dp[i-2] + donations[i+1]);
			
			ans = Math.max(ans, dp[i]);
		}
		
		return ans;
		
	}
}
