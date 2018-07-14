package dp;

public class ChessMetic2 {
		int[] dx = {1, 1, 1, 0, -1, -1, -1, 0, 2, 1, -1, -2, -2, -1, 1, 2};
		int[] dy = {1, 0, -1, -1, -1, 0 ,1, 1, -1, -2, -2, -1, 1, 2, 2, 1};
		
		long[][][] ways = new long[100][100][55];
		
		public static void main(String[] args) {
			
			ChessMetric object = new ChessMetric();
			ChessMetric object2 = new ChessMetric();
			ChessMetric object3 = new ChessMetric();
			ChessMetric object4 = new ChessMetric();
			ChessMetric object5 = new ChessMetric();
	        
	        //System.out.println(object.howMany(3, new int[] {0, 0}, new int[] {1, 0}, 1));
	        //System.out.println(object2.howMany(3, new int[] {0, 0}, new int[] {1, 2}, 1));
	        //System.out.println(object3.howMany(3, new int[] {0, 0}, new int[] {2, 2}, 1));
	        System.out.println(object4.howMany(3, new int[] {0, 0}, new int[] {0, 0}, 2));
	        System.out.println(object.howMany(100, new int[] {0, 0}, new int[] {0, 99}, 50));
		}
		
		public long howMany(int size, int[] start, int[] end, int numMoves) {
			int startX = start[1];
			int startY = start[0];
			int endX = end[1];
			int endY = end[0];
			
			ways[startY][startX][0] = 1;
			
			int nx=0, ny=0;
			// 이동가능 횟수 설정
			for(int i=1; i <= numMoves; i++) {
				// 모든 x좌표에서 이동시킴
				for(int x=0; x < size; x++) {
					// 모든 y좌표에서 이동시킴
					for(int y=0; y < size; y++) {
						// 모든 x축 방향으로 이동 시킴
						for(int j=0; j < 16; j++) {
						
								nx = x + dx[j];
								ny = y + dy[j];
								
								if(nx < 0 || ny < 0 || nx >= size || ny >= size) continue;
								
								ways[ny][nx][i] += ways[y][x][i-1];
							}
						}
					}
				}
			
			
			return ways[numMoves][endY][endX];
		}

}

