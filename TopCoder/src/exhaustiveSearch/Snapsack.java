package exhaustiveSearch;

public class Snapsack {
	
	int[] weightSnap = {3, 4, 1, 2, 3};
	int[] valueSnap = {2, 3, 2, 3, 6};

	int ans = 0;
	
	public static void main(String[] args) {
		Snapsack ans = new Snapsack();
		System.out.println(ans.getMaxValue());

	}
	
	public int getMaxValue() {
		
		dfs(0, 0, 0);
		return ans;
	}
	
	public void dfs(int n, int w, int v) {
		
		//만약 weight가 10 초과이면 return
		if(w > 10) return;
		
		ans = Math.max(ans, v);
		if(n >= weightSnap.length) return; 
		
		System.out.println("dfs(" + (n+1) + ", " + (w+weightSnap[n]) + ", " + (v+valueSnap[n]) + ")");
		dfs(n+1, w, v);
		System.out.println("dfs(" + (n+1) + ", " + (w+weightSnap[n]) + ", " + (v+valueSnap[n]) + ")");
		dfs(n+1, w + weightSnap[n], v + valueSnap[n]);
		
	}
}
