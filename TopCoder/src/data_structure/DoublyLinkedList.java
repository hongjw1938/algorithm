package data_structure;

public class DoublyLinkedList {
	
	// ù ��° ��忡 ���� ����, ������ ��忡 ���� ����, �� ���� ������� size
	private Node head;
	private Node tail;
	private int size = 0;
	
	// ��� ��ü class
	private class Node{
		
		// ������ ��尡 ������ ����
		private Object data;
		
		// ���� ��忡 ���� ����
		private Node next;
		// ���� ��忡 ���� ����
		private Node prev;
		
		// ��� ������ �ʱ�ȭ
		public Node(Object input) {
			this.data = input;
			this.next = null;
			this.prev = null;
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
		
		// ���� ��尡 �̹� �־��ٸ�
		if(head != null) {
			// ���� head�� ����Ű�� ����� ���� ��尡 ���� ������� ����̴�.
			head.prev = newNode;	
		}
		
		
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
			
			// ���� ������ ��尡 ���� �߰��� ����� prev ���
			newNode.prev = tail;
			
			// ���簡 last�̹Ƿ� tail����
			tail = newNode;
			size++;
		}
		
	}
	
	// Ư�� ��ġ�� ��带 ã�Ƴ��� ���
	Node node(int index) {
		
		Node x = null;
		// ã���� �ϴ� ����� ��ġ�� size�� ������ ������ ���� ��ġ�� ���� �� ���� ������ Ž��
		if(index < size / 2) {
			// ���� ù ��带 ����
			x = head;
			
			// index�� ���޵� ������ ���� ���ȿ� next�� node�� �̵���Ų��. 
			for(int i=0; i < index; i++) {
				x = x.next;
			}
		} else {
			x = tail;
			
			for(int i=size-1; i < index; i--) {
				x = x.prev;
			}
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
			
			// ���� ��忡 ���� ���� ����
			if(temp2 != null) {
				temp2.prev = newNode;
			}
			newNode.prev = temp1;
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
		
		// ������ ����� ���� ��尡 null�� �ƴ϶�� ���� ��带 null�� ����
		if(head != null) {
			head.prev = null;
		}
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
			
			// ������ ����� ���� ��带 next�� �����ؾ� �Ѵ�.
			temp.next = temp.next.next;
			
			if(temp.next != null) {
				// ���� ����� ������带 temp�� ����
				temp.next.prev = temp;
			}
			
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
	
	// iterator ��ü ��ȯ
	public ListIterator listIterator() {
		return new ListIterator();
	}
	
	// iterator inner class
	class ListIterator {
		private Node next;
		private Node lastReturned;
		private int nextIndex;
		
		ListIterator(){
			next = head;
		}
		
		// next��
		public Object next() {
			// ������ next�� ����� Node ��ȯ
			lastReturned = next;
			
			// ��ȯ�Ͽ�����, ���� ��ġ�� pointer�̵�
			next = next.next;
			
			nextIndex++;
			
			return lastReturned.data;
		}
		
		// previous��
		public Object previous() {
			if(next == null) {
				lastReturned = next = tail;
			} else {
				lastReturned = next = next.prev;
			}
			nextIndex--;
			return lastReturned.data;
		}
		
		public boolean hasPrevious() {
			return nextIndex > 0;
		}
		
		// ���� ���� �ִ°�?
		public boolean hasNext() {
			return nextIndex < size();
		}
		
		// iterator�� �߰��� ���� �ִ� ���
		public void add(Object input) {
			// ��� ����
			Node newNode = new Node(input);
			
			// ó���� �߰��ϴ� ���
			if(lastReturned == null) {
				head = newNode;	
				// ���ο� ����� ���� ���� next
				newNode.next = next;
			} else {
				// ������ next, prev����
				lastReturned.next = newNode;
				newNode.prev = lastReturned;
				
				// ���� next�� null�� �ƴ϶�� tail�� �ƴ϶�� �ǹ�
				if(next != null) {
					newNode.next = next;
					next.prev = newNode;
				} else {
					tail = newNode;
				}
				// �߰��� �߰��ϴ� ���
				// ��� ��ȯ�ߴ� Node�� next��  ���θ��� Node�� ����
				lastReturned.next = newNode;	
			}
		
			// lastReturned�� ���� �߰��� ���� �߰�.
			lastReturned = newNode;
			nextIndex++;
			size++;
		}
		
		// lastReturned�� ����Ű�� Node�� �����ϰ� �ʹ�.
		public void remove() {
			// next�� �ѹ��� ȣ������ �ʾҴٸ�
			if(nextIndex == 0) {
				throw new IllegalStateException();
			}
			
			Node n = lastReturned.next;
			Node p = lastReturned.prev;
			
			// ���� ���� ��尡 �������� ������.. ��, remove��Ű���� �ϴ� ��尡 �� ù �����
			if(p==null) {
				head = n;
				head.prev = null;
				lastReturned = null;
			} else {
				p.next = next;
				lastReturned.prev = null;
			}
			
			// ���� ������ ��尡 ���ٸ�
			if( n == null) {
				tail = p;
				tail.next = null;
			} else {
				n.prev = p;
			}
			
			// ���� ���� ��尡 null�̸�
			if(next == null) {
				lastReturned = tail;
			} else {
				lastReturned = next.prev;	
			}
			
			
			size--;
			nextIndex--;
		}
	}
	
	public static void main(String[] args) {
		LinkedList numbers = new LinkedList();
		numbers.addFirst(30);
		numbers.addLast(20);
		
		LinkedList.ListIterator i = numbers.listIterator();
		i.add(5);
	}

}
