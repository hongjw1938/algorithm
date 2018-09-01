package d4_sw;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ProjectHanaro {
	private static int[][] island;
	private static double[][] distance;
	private static double TAX_RATE;
	private static boolean[] visited;

	public static void main(String[] args) {
		// ������ ������� �Ÿ��� ���� ���ؼ� �����Ѵ�.
		// 0�� ������ ������ ���� ����� �Ÿ��� �ִ� ���� �����Ѵ�. ����� ��� visited�� true�� �ٲ۴�.
		// ���� �������� ���� ���� ���� ���� �ִٸ� �� ���� ���� ����� ���� �����Ѵ�.
		
		Scanner scan = new Scanner(System.in);
		int case_num = scan.nextInt();
		for(int i=1; i <= case_num; i++) {
			int islands = scan.nextInt();
			
			island = new int[islands][2];
			distance = new double[islands][islands];
			visited = new boolean[islands];
			for(int j=0; j < 2; j++) {
				for(int k=0; k < islands; k++) {
					island[k][j] = scan.nextInt();
				}
			}
			TAX_RATE = scan.nextDouble();
			
			for(int j=0; j < islands; j++) {
				for(int k=0; k < islands; k++) {
					if(j==k) continue;
					else {
						distance[j][k] = Math.pow((island[j][0] - island[k][0]), 2) + Math.pow((island[j][1] - island[k][1]), 2);
					}
				}
			}
			
//			for(int j=0; j < islands; j++) {
//				System.out.print("distance : ");
//				for(int k=0; k < islands; k++) {
//					System.out.print(distance[j][k] + " ");
//				}
//				System.out.println();
//			}
			
			Queue<Integer> q = new LinkedList<>();
			q.add(0);
			visited[0] = true;
			
			List<Double> list = null;
			Queue<Double> subq = null;
			while(!q.isEmpty()) {
				list = new ArrayList<>();
				subq = new LinkedList<>();
				
				int from = q.poll();
				for(int j=0; j < islands; j++) {
					subq.add(distance[from][j]);
				}
				
				int t = 0;
				for(int f=0; f < islands; f++) {
					if(distance[f][t] == 0.0) continue;
					if(f==t) {
						t++;
						f = 0;
					}
					distance[f][t]
				}
			}
			
//			System.out.printf("#%d", i);
//			System.out.printf(" %d%n", Math.round(TAX_RATE * result));
			
		}
		scan.close();
	}
}
