package d4_sw;

import java.util.Scanner;
import java.util.StringTokenizer;

public class ArithmeticOperation2 {
	
	private String[][] nodes;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		ArithmeticOperation2 object = new ArithmeticOperation2();
		
		for(int i=0; i < 10; i++) {
			int node_num = Integer.parseInt(scan.nextLine());
			
			object.nodes = new String[node_num][3];
			StringTokenizer token;
			for(int j=0; j < node_num; j++) {
				token = new StringTokenizer(scan.nextLine());
				
				int index = Integer.parseInt(token.nextToken())-1;
				int k = 0;
				while(token.hasMoreTokens()) {
					object.nodes[index][k] = token.nextToken();
					k++;
				}
			}
			System.out.printf("#%d", i+1);
			System.out.printf(" %d%n", object.dfs(object.nodes, 1));
		}
		scan.close();
	}
	
	private int dfs(String[][] nodes, int n) {
		String[] current_node = nodes[n-1];

		int result = 0;
		if(current_node[0].equals("+") || current_node[0].equals("-") || current_node[0].equals("*") || current_node[0].equals("/")) {
			if(current_node[1] == null || current_node[2] == null) {
				result = 0;
			} else {
				if(dfs(nodes, Integer.parseInt(current_node[1])) == 0 || dfs(nodes, Integer.parseInt(current_node[2])) == 0) {
					return 0;
				} else {
					result = 1;
				}
			}
		} else if(current_node[0] == null) {
			result = 0;
		} else {
			if(current_node[1] != null || current_node[2] != null) {
				result = 0;
			} else {
				result = 1;
			}
		}
		return result;
	}

}
