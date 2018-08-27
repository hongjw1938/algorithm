package d4_sw;

import java.util.Scanner;
import java.util.Stack;

public class ToPostfix {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		for(int i=0; i < 10; i++) {
			int length = scan.nextInt();
			String equation = scan.next();
			
			String postfix_equation = makePostfix(length, equation);
//			System.out.println(postfix_equation);
			
			System.out.printf("#%d", i+1);
			System.out.printf(" %d%n", calculate(postfix_equation));
			
		}
		scan.close();
	}
	
	private static String makePostfix(int length, String equation) {
		Stack<Character> stack = new Stack<>();
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i < length; i++) {
			char ch = equation.charAt(i);
			if("+-/*()".contains(ch + "")) {
				if(stack.isEmpty()) stack.push(ch);
				else if(ch == '(') stack.push(ch);
				else if(ch == ')') {
					while(true) {
						if(stack.peek() == '(') {
							stack.pop();
							break;
						} else {
							sb.append(stack.pop());
						}
					}
				} else {
					while(!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(ch)) {
						sb.append(stack.pop());
					}
					stack.push(ch);
				}
			} else if(ch >= '0' && ch <= '9'){
				sb.append(ch);
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
			
		}
		return sb.toString();
	}
	
	private static int getPriority(char op) {
		int ret = 0;
		switch (op) {
		case '+':
		case '-':
			ret = 1;
			break;
		
		case '*':
		case '/':
			ret = 2;
			break;

		default:
			break;
		}
		
		return ret;
	}
	
	private static int calculate(String postfix_equation) {
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i < postfix_equation.length(); i++) {
			char ch = postfix_equation.charAt(i);
			
			if(ch >= '0' && ch <= '9') stack.push(Integer.parseInt(ch+""));
			else {
				int first = stack.pop();
				int second = stack.pop();
				if(ch == '+') stack.push(first+second);
				else if(ch == '-') stack.push(second-first);
				else if(ch == '/') stack.push(second / first);
				else if(ch == '*') stack.push(second * first);
			}
//			System.out.println(stack.peek());
		}
		return stack.pop();
	}
}
