package exhaustiveSearch;

public class CrazyBot2 {
	
	CrazyBot2(){
		
	}
	
	//로봇이 이동할 경로를 체크하는 배열
	private static boolean[][] grid = new boolean[100][100];
	
	//이동 순서를 미리 정해놓는 배열. 동 남 서 북 방향으로 이동
	private static int[] moveX = {1, 0, -1, 0};
	private static int[] moveY = {0, -1, 0, 1};
	
	//확률의 경우, 각 이동방향이 나올 확률로 계산한다. 따라서
	//각 이동방향에 대한 확률을 지정할 배율을 생성
	private static double[] prob = new double[4];
	
	public static double getAnswer(int n, int east, int south, int west, int north) {
		//각 확률을 계산해 배열에 저장
		prob[0] = east / 100.0;
		prob[1] = south / 100.0;
		prob[2] = west / 100.0;
		prob[3] = north / 100.0;
		
		//정답은 dfs메서드를 통해 리턴할 것.
		//최초 위치는 50,50
		double ans = CrazyBot2.dfs(n, 50, 50);
		
		return ans;
		
	}
	
	private static double dfs(int n, int x, int y) {
		//만약 0회 남은 경우, 1을 반환
		if(n == 0) return 1;
		
		//만약 이동한 방향에 있는 위치가 이미 다녀온 곳이라면 0반환
		if(grid[x][y]) return 0;
		
		//최초 위치는 이미 다녀간 곳이므로 true로 변환
		grid[x][y] = true;
		double ret = 0;
		
		//각 방향으로 이동시키고 해당 확률을 리턴받아 모두 더한다.
		for(int i=0; i < 4; i++) {
			ret += dfs(n-1, x + moveX[i], y + moveY[i]) * prob[i];
		}
		
		//이 코드까지 내려오는 경우, 체크가 끝났으므로 모두 false로 재변환
		grid[x][y] = false;
		
		return ret;
	}
}
