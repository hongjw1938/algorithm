package d4_sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class TreeNodeInorder {
	
	private static String[] word;
	private static Map<Integer, List<Integer>> map;
	private static StringBuffer sb;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i < 10; i++) {
			int node_num = Integer.parseInt(br.readLine());
			
			word = new String[node_num];
			map = new HashMap<>();
			
			for(int j=0; j < node_num; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				while(st.hasMoreTokens()) {
					word[Integer.parseInt(st.nextToken()) -1] = st.nextToken();
					map.put(j+1, new ArrayList<>());
					while(st.hasMoreTokens()) {
						map.get(j+1).add(Integer.parseInt(st.nextToken()));
					}
				}
				
			}
			
			
			sb = new StringBuffer(); 
			getInOrder(1);
			
			System.out.printf("#%d", i+1);
			System.out.printf(" %s%n", sb.toString());
			
		}
		
		br.close();

	}
	
	private static void getInOrder(int key) {
		if(map.get(key).isEmpty()) {
			sb.append(word[key-1]);
			return;
		}
		
		int count = 0;
		for(int next : map.get(key)) {
			getInOrder(next);
			count++;
			if(count == 1) sb.append(word[key-1]);
		}
	}

}
