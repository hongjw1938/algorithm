package d4_sw;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Bottles_Comparator implements Comparator<int[]>{

	@Override
	public int compare(int[] o1, int[] o2) {
		if(o2[2] != o1[2]) {
			return o2[2] - o1[2];
		} else {
			return o2[1] - o1[1];
		}
		
	}
	
}
public class ChemicalBottleMatrix {

	private static int[][] matrix;
	private static List<int[]> bottles;
	private static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int case_num = scan.nextInt();
		
		for(int i=1; i <= case_num; i++) {
			int length = scan.nextInt();
			matrix = new int[length][length];
			bottles = new ArrayList<>();
			visited = new boolean[length][length];
			
			for(int j=0; j < length; j++) {
				for(int k=0; k < length; k++) {
					matrix[j][k] = scan.nextInt();
				}
			}
			
			Queue<Integer> q = new LinkedList<>();
			for(int j=0; j < length; j++) {
				for(int k=0; k < length; k++) {
					if(visited[j][k]) continue;
					
					visited[j][k] = true;
					if(matrix[j][k] != 0 && q.isEmpty()) q.add(k);
					else if(matrix[j][k] == 0 && !q.isEmpty()) {
						int width = k - q.poll();
						int height = 0;
						q.add(j);
						int start = q.peek();
						while(true) {
							start++;
							if(matrix[start][k-1] != 0 && start < length) {
								visited[start][k-1] = true;
							} else if(matrix[start][k-1] == 0 || start >= length) {
								height = start - q.poll();
								break;
							}
						}
						
						bottles.add(new int[] {height, width, height * width});
						for(int m=j; m < j+height-1; m++) {
							for(int n=k; n < k+width-1; k++) {
								visited[m][n] = true;
							}
						}
					}
				}
			}
			
			int size = bottles.size();
			System.out.printf("#%d", i);
			System.out.printf(" %d", size);
			for(int j=0; j < size; j++) {
				System.out.print(" " + bottles.get(j)[0] + " " + bottles.get(j)[1]);
			}
			System.out.println();
		}
		
		scan.close();

	}

}
