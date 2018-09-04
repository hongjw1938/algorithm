package d4_sw;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Worm {
	int x;
	int y;
	Worm(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class WormMatching {
	
	private static List<Worm> worm;
	private static long Answer;
	private static int N;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int case_num = scan.nextInt();
		for(int i=1; i <= case_num; i++) {
			int worms = scan.nextInt();
			N = worms;
			worm = new ArrayList<>();
			for(int j=0; j < worms; j++) {
				int x_pos = scan.nextInt();
				int y_pos = scan.nextInt();
				worm.add(new Worm(x_pos, y_pos));
			}
			
			Answer = Long.MAX_VALUE;
			dfs(0, 0, 0, 0);
		
			System.out.println("#" + i + " " + Answer);
		}
		
		scan.close();
	}
	
    static void dfs(long wormA, long wormB, int idx, int count) {
    	System.out.println("wormA : " + wormA + " ," + " wormB : " + wormB);
    	System.out.println("idx : " + idx + ", " + "count : " + count);
        if(idx == N) {
 
            if(count == N/2)
                Answer = Math.min(Answer, (wormA * wormA) + (wormB * wormB));
            return;
        }
 
        dfs(wormA - worm.get(idx).x, wormB - worm.get(idx).y, idx + 1, count + 1);
        dfs(wormA + worm.get(idx).x, wormB + worm.get(idx).y, idx + 1, count);
    }
	
}
