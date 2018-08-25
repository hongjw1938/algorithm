package dp;

public class HandShake {

	public static void main(String[] args) {
		HandShake obj = new HandShake();
		System.out.println(obj.countPerfect(2));
		System.out.println(obj.countPerfect(4));
		System.out.println(obj.countPerfect(6));
		System.out.println(obj.countPerfect(8));
		System.out.println(obj.countPerfect(10));
	}
	
	public long countPerfect(int n) {
		long dp[] = new long[n/2+1];
		dp[0] = 1;
		
		for(int i=1; i <= n/2; i++) {
			dp[i] = 0;
			for(int j=0; j<i; j++) {
				dp[i] += dp[j] * dp[i-j-1];
			}
		}
		
		return dp[n/2];
	}

}
