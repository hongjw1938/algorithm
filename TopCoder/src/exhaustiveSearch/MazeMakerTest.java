package exhaustiveSearch;

public class MazeMakerTest {

	public static void main(String[] args) {
		MazeMakerBFS ans = new MazeMakerBFS();
		String[] maze = {".......",
						 "X.X.X..",
						 "XXX...X",
						 "....X..",
						 "X....X.",
						 "......."};
		int startRow = 5;
		int startCol = 0;
		int[] moveRow = {1, 0, -1, 0, -2, 1};
		int[] moveCol = {0, -1, 0, 1, 3, 0};
		
		long startTime = System.currentTimeMillis();
		
		System.out.println(ans.longestPath(maze, startRow, startCol, moveRow, moveCol));
		System.out.println("This algorithm took about  : " + (System.currentTimeMillis() - startTime));
		
		System.out.println("--------------------");
		for(int i = 0; i < maze.length; i++) {
			for(int j = 0; j < maze[i].length(); j++) {
				System.out.print(ans.board[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
