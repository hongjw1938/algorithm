package code_battle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q2_0829 {
	
	private static List<Integer> lazer_pos;
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int case_num = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i < case_num; i++) {
			String iron_bar = br.readLine();
			
			int cut = 0;
			lazer_pos = new ArrayList<>();
			for(int j=0; j < iron_bar.length(); j++) {
				if(iron_bar.charAt(j) == '(' && iron_bar.charAt(j+1) == ')') {
					lazer_pos.add(j);
					j++;
				}
				else if(iron_bar.charAt(j) == '(' && iron_bar.charAt(j+1) == '(') stack.push(j);
				else {
					cut += isCut(stack.pop(), j);
				}
			}
			System.out.printf("#%d", i+1);
			System.out.printf(" %d%n", cut);
		}		
		br.close();
	}
	
	private static int isCut(int start, int end) {
		int ret_val = 1;
		
		for(int i=0; i < lazer_pos.size(); i++) {
			if(start < lazer_pos.get(i) && lazer_pos.get(i) < end) ret_val++;
		}
		
		return ret_val;
	}

}
