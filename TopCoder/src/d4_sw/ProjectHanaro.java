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
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int case_num = scan.nextInt();
		for(int i=1; i <= case_num; i++) {
			int islands = scan.nextInt();
			
			island = new int[islands][2];
			distance = new double[islands][islands];
			
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
//					
//				}
//				System.out.println();
//			}
//			System.out.println("TAX : " + TAX_RATE);
		
			Queue<Double> q = new LinkedList<>();
			for(int j=0; j < distance.length; j++) {
				if(distance[0][j] == 0.0) continue;
				q.add(distance[0][j]);
			}
			
			int current = 0;
			while(current != islands) {
				for(int k=0; k < islands; k++) {
					if(current == k) continue;
					double val = q.poll();
					if(distance[current][k] >= val) {
						q.add(val);
					} else {
						q.add(distance[current][k]);
					}
				}
				current++;
			}
			
			int length = q.size();
			double result = 0;
			for(int j=0; j < length; j++) {
				result += TAX_RATE * q.poll();
			}
			System.out.printf("#%d", i);
			System.out.printf(" %d%n", Math.round(result));
		}
		scan.close();
	}
}
