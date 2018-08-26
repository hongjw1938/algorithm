package d4_sw;

import java.util.Scanner;

public class PairWay {
	private static int pair1[];
	private static int pair2[];
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		
		
		for(int i=0; i < 10; i++) {
			int case_num = scan.nextInt();
			int pair_num = scan.nextInt();
			
			pair1 = new int[100];
			pair2 = new int[100];
			
			int key = 0;
			for(int j=0; j < pair_num; j++) {
				key = scan.nextInt();
				
				if(pair1[key] != 0) pair2[key] = scan.nextInt();
				else pair1[key] = scan.nextInt();
			}
			
			System.out.printf("#%d", case_num);
			System.out.printf(" %d%n", isWayExist(new int[] {pair1[0], pair2[0]}));
		}
		scan.close();
	}
	
	private static int isWayExist(int[] way) {
		
		int ret_val = 0;
		for(int go : way) {
			if(ret_val==1) break;
			
			if(go == 99) return ret_val=1;
			else if(go == 0) continue;
			else  ret_val = isWayExist(new int[] {pair1[go], pair2[go]});
		}
		return ret_val;
	}

}
