package data_structure;

public class LinkedList {
	
	// ù ��° ��忡 ���� ����, ������ ��忡 ���� ����, �� ���� ������� size
	private Node head;
	private Node tail;
	private int size = 0;
	
	private class Node{
		
		// ������ ��尡 ������ ����
		private Object data;
		
		// ���� ��忡 ���� ����
		private Node next;
		
		// ��� ������ �ʱ�ȭ
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
		
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	// ù ���� �߰�
	public void addFirst(Object input) {
		// ��� ����
		Node newNode = new Node(input);
		
		// ���ο� ����� ���� ���� ��� ����
		// ���簡 First�̹Ƿ� ������ head�� �����Ǿ� �ִ� ��带 next�� �����Ѵ�.
		newNode.next = head;
		
		// ���� ���ο� ��带 �����Ѵ�.
		head = newNode;
		size++;
		if(head.next == null) {
			// ���� ��� null�̸�, ���� ��尡 ������ ��� 
			tail = head;
		}
	}
	
	// ������ ���� �߰�
	public void addLast(Object input) {
		//��� ����
		Node newNode = new Node(input);
		
		// ���� ������Ʈ�� ���ٸ�
		if(size == 0) {
			addFirst(input);
		} else {
			// ���� �߰����� ��, ���� ��尡 ���� �߰��� ��带 ����Ű���� �ؾ� �Ѵ�.
			tail.next = newNode;
			// ���簡 last�̹Ƿ� tail����
			tail = newNode;
			size++;
		}
		
	}
	
	// Ư�� ��ġ�� ��带 ã�Ƴ��� ���
	Node node(int index) {
		// ���� ù ��带 ����
		Node x = head;
		
		// index�� ���޵� ������ ���� ���ȿ� next�� node�� �̵���Ų��. 
		for(int i=0; i < index; i++) {
			x = x.next;
		}
		return x;
	}
	
	// Ư�� ��ġ�� Node�� �߰��ϴ� ���
	public void add(int k, Object input) {
		// ���� 0�̸� ó���� �߰��ϴϱ� addFirst���
		if(k == 0) {
			addFirst(input);
		} else {
			// ���� k-1��°�� ��ġ�� ��带 �˾Ƴ��� �Ѵ�.
			// �ֳ��ϸ� �ش� ����� next���� �ٲپ��־�� �ϱ� ����.
			Node temp1 = node(k-1);
			
			// k��° ���
			Node temp2 = temp1.next;
			
			// ���ο� ���
			Node newNode = new Node(input);
			
			// ������ next�� ����
			temp1.next = newNode;
			newNode.next = temp2;
			size++;
			
			// ���� ���ο� ��尡 �������� �߰��ȴٸ�?, ���ο� ��尡 �ٷ� tail
			if(newNode.next == null) {
				tail = newNode;
			}
			
		}
	}
	
	// Node�� Ȯ���� �� �ִ�.
	public String toString() {
		if(head == null) {
			return "[]";
		}
		
		Node temp = head;
		String str = "[";
		
		while(temp.next != null) {
			str += temp.data + ", ";
			temp = temp.next;
		}
		
		str += temp.data;
		
		return str + "]";
	}
	
	// ���� ù ��带 ����
	public Object removeFirst() {
		Node temp = head;
		head = head.next;
		
		Object returnData = temp.data;
		temp = null;
		size--;
		
		return returnData;
	}
	
	// �߰� ��� ����
	public Object remove(int k) {
		if(k == 0) {
			return removeFirst();
		} else {
			// �߰��� ��带 �����ÿ���, ���� �����ϰ��� �ϴ� Node�� ���� Node�� ã�ƾ� �Ѵ�.
			Node temp = node(k-1);
			
			// ������ ������ ���
			Node tobeDeleted = temp.next;
			
			// ������ ����� ���� ����� head�� �ٲ��־�� �Ѵ�.
			temp.next = tobeDeleted.next;
			
			Object returnData = tobeDeleted.data;
			
			// ���� ������ ��带 �����Ѵٸ�, ������尡 tail�� �ȴ�.
			if(tobeDeleted.next == null) {
				tail = temp;
			}
			tobeDeleted = null;
			size--;
			return returnData;
		}
	}
	
	// element�� ũ�� �˾Ƴ���
	public int size() {
		return size;
	}
	
	// ������ ��� ����
	public Object removeLast() {
		return remove(size - 1);
	}
	
	// Ư�� ��� data ��������
	public Object get(int k) {
		Node temp = node(k);
		return temp.data;
	}
	
	// Ư�� data�� �� ��° Node�� �����ϴ��� ��ȯ
	public int indexOf(Object data) {
		// head���� ����
		Node temp = head;
		
		// ��ȯ�ϱ� ���� �� �ʱ�ȭ
		int index = 0;
		
		while(temp.data != data) {
			temp = temp.next;
			index++;
			
			// ���� ���� ������ ���
			if(temp == null) {
				return -1;
			}
		}
		
		return index;
	}
	
	public static void main(String[] args) {
		LinkedList numbers = new LinkedList();
		numbers.addFirst(30);
		numbers.addLast(20);
		

	}

}