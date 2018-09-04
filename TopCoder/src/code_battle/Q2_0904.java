package code_battle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Q2_0904 {

	private static Map<Integer, List<Integer>> friends;
	private static boolean[] invited;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int case_num = scan.nextInt();
		for(int i=1; i <= case_num; i++) {
			int friend_num = scan.nextInt();
			
			friends = new HashMap<>();
			for(int j=1; j <= friend_num; j++) {
				friends.put(j, new ArrayList<>());
			}
			
			int relation_num = scan.nextInt();
			invited = new boolean[friend_num];
			
			for(int j=0; j < relation_num; j++) {
				int a = scan.nextInt();
				int b = scan.nextInt();
				
				friends.get(a).add(b);
			}

			int invitation_num = 0;
			
			// 模茄 模备甸阑 Queue俊 历厘
			Queue<Integer> q = new LinkedList<>();
			invited[0] = true;
			
			for(int j=1; j <= friend_num; j++) {
				for(int friend : friends.get(j)) {
					if(j == 1) {
						invited[friend-1] = true;
						q.add(friend);
					} else if(friend == 1) {
						invited[j-1] = true;
						q.add(j);
					}
				}
			}
			
			// 模茄 模备狼 模茄 模备
			for(int j=1; j <= friend_num; j++) {
				if(!invited[j-1]) {
					for(int friend : friends.get(j)) {
						if(invited[friend-1]) invited[j-1] = true;
					}
				}
			}
			
			while(!q.isEmpty()) {
				int next = q.poll();
				for(int friend : friends.get(next)) {
					if(invited[friend-1]) continue;
					invited[friend-1] = true;
				}
			}
			
			for(int j=1; j < friend_num; j++) {
				if(invited[j]) {
					invitation_num++;
				}
			}
			
			System.out.println("#" + i + " " + (invitation_num));
		}

		scan.close();
	}

}
