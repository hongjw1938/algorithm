package data_structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ExpressionTreeImpl {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("������ �Է����ֽʽÿ�");
		System.out.println("�� ���ڴ� 10�� ���� �ʾƾ� �մϴ�. q�� �Է� �� enter�� ������ ����˴ϴ�.");
		
		char[] exp;
		while(true) {
			String next = scan.nextLine();
			if(next.equals("q")) {
				System.out.println("����Ǿ����ϴ�.");
				break;
			}
			
			exp = next.toCharArray();
			exp = ConvToRPNExp(exp);
			for(int i=0; i < exp.length; i++) {
				
				System.out.print(exp[i]);
			}
			System.out.println("length : " + exp.length);
			System.out.println();
			
			System.out.println("�ش� ������ ����մϴ�.");
			ImplementArrayList<Node<Character>> list = toExpressionTree(exp);
			System.out.println("���� ��� ��� : " + evaluateTree(list.get(0)));
		}
		
		scan.close();
	}
	
	public static int evaluateTree(Node<Character> node) {
		int op1;
		int op2;
		
		if(node.getLeftSub()==null && node.getRightSub() == null) {
			return node.getData() - '0';
		}
		op1 = evaluateTree(node.getLeftSub());
		op2 = evaluateTree(node.getRightSub());
		
		switch (node.getData().toString()) {
		case "+":
			return op1+op2;
		case "-":
			return op1-op2;
		case "*":
			return op1*op2;
		case "/":
			return op1/op2;
		default:
			break;
		}
		return 0;
	}
	
	// ����� �������� ����Ʈ�� ���·� ǥ���ϴ� �޼�Ʈ
	public static ImplementArrayList<Node<Character>> toExpressionTree(char exp[]) {
		ImplementArrayList<Node<Character>> list = new ImplementArrayList<>();
		Node<Character> btreeNode;
		
		int expLen = exp.length;
		int i;
		
		for(i=0; i < expLen; i++) {
			char data = exp[i];
			btreeNode = new Node<Character>(data);
			if(data >= '0' && data <= '9') {
				btreeNode.setData(data);
			} else {
				if(data == '\u0000') break;
				btreeNode.setLeftSub(list.removeLast());
				btreeNode.setRightSub(list.removeLast());
				btreeNode.setData(data);
			}
			
			list.add(btreeNode);
		}
		return list;
	}
	
	// ���������� �����ϴ� �޼ҵ�
	public static char[] ConvToRPNExp(char exp[]) {
//		Stack<Character> stack = new Stack<>();
		ImplementArrayList<Character> list = new ImplementArrayList<>();
		int expLen = exp.length;
	
		char token;
		
		int idx = 0;
		char[] postExp = new char[expLen];
		
		for(int i = 0; i < expLen; i++) {
			token = exp[i];
			
			if(token >= '0' && token <= '9') {
				postExp[idx++] = token;
			} else {
				switch (token) {
				case '(':
					list.add(token);
					break;
				case ')':
					while(true) {
						char op = list.removeLast();
						if(op == '(') {
							break;
						}
						postExp[idx++] = op;
					}
					break;
				case '+': case'-':
				case '*': case'/':
					while(!list.isEmpty() && compareOper(list.get(list.sizeOf()-1), token) >= 0) {
						postExp[idx++] = list.removeLast();
					}
					list.add(token);
					break;
				case ' ':
					break;
				default:
					throw new IllegalStateException();
				}
			}
		}
		
		while(!list.isEmpty()) {
			postExp[idx++] = list.removeLast();
		}
		
		return postExp;
	}
	
	
	// �������� �켱������ �����ϴ� �޼ҵ�
	public static int operationPrec(char op) {
		switch (op) {
		case '*':
		case '/':
			return 5;
		case '+':
		case '-':
			return 3;
		case '(':
			return 1;
		}
		
		// �̵�� ��������
		return -1;
	}
	
	// ������ ��
	public static int compareOper(char op1, char op2) {
		int op1Level = operationPrec(op1);
		int op2Level = operationPrec(op2);
		
		if(op1Level > op2Level) return 1;
		else if(op1Level < op2Level) return -1;
		else return 0;
	}

}
