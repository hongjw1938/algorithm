package d4_sw;

import java.util.Scanner;

public class ParenthesisMatching {
	
	private static char[] left_par = {'[', '{', '(', '<'};
	private static char[] right_par = {']', '}', ')', '>'};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int case_length = 0;
	
		for(int i=0; i < 10; i++) {
			StringBuffer parenthesis = new StringBuffer();
			
			case_length = scan.nextInt();
			parenthesis.append(scan.next());
			
			System.out.printf("#%d", i+1);
			System.out.printf(" %d", isMatch(case_length, parenthesis));
			System.out.println();
		}
		scan.close();
	}
	
	private static int isMatch(int length, StringBuffer parenthesis) {
		StringBuffer left_var = new StringBuffer();
		StringBuffer right_var = new StringBuffer();
		
		int ret_val = 0;
		for(int i=0; i < length; i++) {
			for(int j=0; j < left_par.length; j++) {
				if(parenthesis.charAt(i) == left_par[j]) {
					left_var.append(j);
					break;
					
				} else if(parenthesis.charAt(i) == right_par[j]){
					right_var.append(j);
					
					if(left_var.substring(left_var.length()-1).equals(right_var.toString())) {
						ret_val = 1;
						left_var.deleteCharAt(left_var.length()-1);
						right_var.deleteCharAt(right_var.length()-1);
						
						break;
					} else {
						return 0; 
					}
				}
			}		
		}
		return ret_val;
	}

}
