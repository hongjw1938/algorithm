package exhaustiveSearch;

import java.util.*;
public class FriendScore {
	//friends는 1~50개의 요소를 갖는 배열
	public static int highestScore(String[] friends) {
		
		//최대값 초기화. 해당 값을 리턴할 것.
		int maxVal = 0;
		
		Map<Integer, List<Integer>> friend = new HashMap<Integer, List<Integer>>();
		//반복문을 통해 직접 친구를 찾음.
		for(int i=0; i < friends.length; i++) {
			friend.put(i, new ArrayList<Integer>());
			
			// n*n크기의 배열임을 활용
			int count = 0;
			for(int j=0; j < friends[i].length(); j++) {
				// 직접 친구 index를 저장하고 Y이면 친구의 수를 세는 count변수를 늘림
				if(friends[i].charAt(j) == 'Y') {
					friend.get(i).add(j);
					count++;
					
				}
			}
			//System.out.println(i + "의 직접 친구 수 : " + count);
			//System.out.println(friend.get(5));
			//간접 친구의 수를 구한다.
			boolean indirect;
			for(int k=0; k < friends[i].length(); k++) {
				indirect = false;
				if(k == i) {
					continue;
				}
				
				for(int check : friend.get(i)) {
					if(check == k) {
						indirect = false;
						break;
					}
					//System.out.print("k번째 : " + k + ", " + "check : " + check + "friends[check].charAt(k)" + friends[check].charAt(k));
					
					if(check != k && friends[check].charAt(k) == 'Y') {
						indirect = true;
						
					}
					//System.out.println(" " + indirect);
				}
				
				if(indirect == true) {
					count++;
					//System.out.println("count : " + count);
				}
			}
			
			//System.out.println(i + "의 친구 수 : " + count);
			maxVal = Math.max(maxVal, count);
		}
		
		return maxVal;
	}
	
	//간결한 방식
	public static int highestScore2(String[] friends) {
		int ans = 0;
		int n = friends[0].length();
		
		for(int i=0; i < n; i++) {
			int cnt = 0;
			
			for(int j=0; j < n; j++) {
				//자기 자신이면 넘어감
				if(i==j) continue;
				
				//직접친구인 경우
				if(friends[i].charAt(j) == 'Y') {
					cnt++;
				} else {
					for(int k=0; k < n; k++) {
						//i의 직접친구가 아니면서 j와 i가 서로 간접 친구인 경우 
						if(friends[j].charAt(k) == 'Y' && friends[k].charAt(i) == 'Y') {
							cnt++;
							break;
						}
					}
				}
			}
			ans = Math.max(ans, cnt);
		}
		return ans;
		
	}
}
