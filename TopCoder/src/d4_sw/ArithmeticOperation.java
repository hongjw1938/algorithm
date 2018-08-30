package d4_sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArithmeticOperation {
	private static String[] operator = {"+", "-", "*", "/"};
	private static String[] nodes;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i < 10; i++) {
			int node_num = Integer.parseInt(br.readLine());
			nodes = new String[node_num];
			
			for(int j=0; j < node_num; j++) {
				String node = br.readLine();
				nodes[j] = node;
			}
			
			String[] root_splited = nodes[0].split(" ");
			int result = 0;
			if(which_operator(root_splited[1]) == 0) result = operate(root_splited[2]) + operate(root_splited[3]);
			else if(which_operator(root_splited[1]) == 1) result = operate(root_splited[2]) - operate(root_splited[3]);
			else if(which_operator(root_splited[1]) == 2) result = operate(root_splited[2]) * operate(root_splited[3]);
			else result = operate(root_splited[2]) / operate(root_splited[3]);
			
			System.out.printf("#%d", i+1);
			System.out.printf(" %d%n", result);
		}
		br.close();
	}
	
	private static int operate(String next_node) {
		int index = Integer.parseInt(next_node) - 1;
		
		String[] node_split = nodes[index].split(" ");
		if(node_split.length != 2) {
			int ret_val = 0;
			switch (which_operator(node_split[1])) {
			case 0:
				ret_val = operate(node_split[2]) + operate(node_split[3]);
				break;
			case 1:
				ret_val = operate(node_split[2]) - operate(node_split[3]);
				break;
			case 2:
				ret_val = operate(node_split[2]) * operate(node_split[3]);
				break;
			case 3:
				ret_val = operate(node_split[2]) / operate(node_split[3]);
				break;
			}
			
			return ret_val;
		} else {
			return Integer.parseInt(node_split[1]); 
		}
	}
	
	private static int which_operator(String oper) {
		int ret_val = 0;
		if(oper.equals(operator[0])) {
			ret_val = 0;
		} else if(oper.equals(operator[1])) {
			ret_val = 1;
		} else if(oper.equals(operator[2])) {
			ret_val = 2;
		} else {
			ret_val = 3;
		}
		
		return ret_val;
	}
}
