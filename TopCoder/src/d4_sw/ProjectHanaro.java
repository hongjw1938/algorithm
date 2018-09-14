package d4_sw;

import java.util.Scanner;

public class ProjectHanaro {
	static class Island{
		int x;
		int y;
		long len;
	}
	
	private static int N;
	private static boolean[] visit;
	private static Island[] island;
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int case_n = scan.nextInt();
		
		for(int test=1; test <= case_n; test++) {
			N = scan.nextInt();
			island = new Island[N];
			visit = new boolean[N];
			for(int i=0; i < N; i++) {
				island[i] = new Island();
				island[i].x = scan.nextInt();
			}
			
			for(int i=0; i< N; i++) {
				island[i].y = scan.nextInt();
				island[i].len = Long.MAX_VALUE;
			}
			
			double tax_rate = scan.nextDouble();
			
			long result = 0;
			result = getMinimum(result);
			System.out.println("#" + test + " " + Math.round(tax_rate * result));
		}
		
		scan.close();
	}
	
	private static long getMinimum(long result) {
		island[0].len = 0;
		for(int i=0; i < N; i++) {
			long cost = Long.MAX_VALUE;
			int index = 0;
			for(int j=0; j < N; j++) {
				if(!visit[j] && island[j].len < cost) {
					cost = island[j].len;
					index = j;
				}
			}
			visit[index] = true;
			result += island[index].len;
			
			for(int j=0; j < N; j++) {
				if(!visit[j]) {
					cost = (long) Math.pow(island[index].x - island[j].x, 2) + (long) Math.pow(island[index].y - island[j].y, 2);
                    if (island[j].len > cost) {
                        island[j].len = cost;
                    }
				}
			}
		}
		return result;
	}
}
