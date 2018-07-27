package exhaustiveSearch;

public class BadNeighbors {
	
	private boolean[] donated;
	
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
		int retVal = 0;
		
		donated = new boolean[donations.length];
		for(int i=0; i < 2; i++) {
			retVal = Math.max(retVal, dp(i, donations));
		}
		
		return retVal;
	}
	
	public int dp(int i, int[] donations) {
		
		int lastIdx = donations.length-1;

		//우선 0혹은 1번째의 donation을 더해준다.
		int[] maxVal = {donations[i], donations[i]};
		
		donated[i] = true;
	
		//case 1
		for(int j=i+2; j < donations.length; j+=2) {
			//마지막 index보다 큰 경우 break
			if( j > lastIdx) break;
			if(donated[0] && j == lastIdx) break;
			
			maxVal[0] = Math.max(maxVal[0], maxVal[0]+dp(i+2, donations));
			//System.out.println("maxVal[0] = " + maxVal[0]);
		}
		
		
		//case 2
		for(int j=i+3; j < donations.length; j+=2) {
			//마지막 index보다 큰 경우 break
			if( j > lastIdx) break;
			if(donated[0] && j == lastIdx) break;
			
			maxVal[1] = Math.max(maxVal[1], maxVal[1]+dp(i+3, donations));
			//System.out.println("maxVal[1] = " + maxVal[1]);
		}
		
		
		return Math.max(maxVal[0], maxVal[1]);
	}


}
