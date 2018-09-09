package data_structure;

//ArrayList�� �������� ����
public class ArrayList {
	
	//ObjectŸ���� �迭�� ����. �ִ� element 100��
	private Object[] elementData = new Object[100];
	
	//�� ���� �����Ͱ� ����Ʈ�� ����ִ��� üũ�ϴ� ��.
	private int size = 0;
	
	//addLast method. list�� �������� ���� �߰��ϴ� ��.
	public boolean addLast(Object element) {	
		// ���� �����Ͱ� ����ִ� ���ڸ�ŭ�� index�� ���� �߰��ϰ� element������ �ǹ��ϴ� size�� ������Ŵ
		elementData[size] = element;
		size++;
		return true;
	}
	
	//addFirst method. list�� ó���� �߰��ϴ� ���
	public boolean addFist(Object element) {
		//�̹� ������ add�޼ҵ带 �̿��ؼ� �߰��Ѵ�.
		return add(0, element);
	}
	
	
	//add method. list�� �߰��� ���� �߰��ϴ� ���
	//�߰� index�̻��� index�� ��ġ�� ��� ���� �ϳ��� �ڷ� �̷���Ѵ�.
	public boolean add(int index, Object element) {
		//��� ���� �ϳ��� �ڷ� �̷��
		for(int i = size - 1; i >= index; i--) {
			elementData[i+1] = elementData[i];
		}
		
		// ���� �߰��� ���� �߰���.
		elementData[index] = element;
		
		// ������Ʈ�� ���ڸ� 1 ����
		size++;
		return true;
	}
	
	//toString method. ������ ���
	public String toString() {
		String str = "[";
		
		for(int i=0; i < size; i++) {
			str += elementData[i];
			if(i < size-1) {
				str += ",";
			}
		}
		return str + "]";
	}
	
	//remove method. �����͸� �����ϴ� ���
	public Object remove(int index) {
		//���� ���� ������ �����͸� removed ������ ����
		Object removed = elementData[index];
		
		//������ �κ� �������� �ϳ��� ������ �ű�
		for(int i=index+1; i <= size - 1; i++) {
			elementData[i-1] = elementData[i];
		}
		//ũ�⸦ ����
		size--;
		
		//������ ��ġ�� element�� ��������� ����
		elementData[size] = null;
		
		//������ element�� ����Ǿ��־��� ���� ����
		return removed;
	}
	
	//removeFirst method. ���� ù element�� ����
	public Object removeFirst() {
		return remove(0);
	}
	
	//removeLast method. ���� ������ element�� ����
	public Object removeLast() {
		return remove(size-1);
	}
	
	//get method. Ư�� index�� element�� �������� �޼ҵ�
	public Object get(int index) {
		return elementData[index];
	}
	
	//size method. ���� list�� �� ���� element�� �������� Ȯ��
	public int size() {
		return size;
	}
	
	//indexOf method. �˻��ϴ� ��. Ư�� element�� index�� �˾Ƴ���.
	public int indexOf(Object element) {
		
		//list�� ������ ã�� ����. ������ index�� ��ȯ
		for(int i=0; i < size; i++) {
			if(element.equals(elementData[i])) {
				return i;
			}
		}
		
		//������ -1��ȯ
		return -1;
	}
	
	
	//ListIterator, �� iterator��ü�� ��ȯ�ϴ� �޼ҵ�
	public ListIterator listIterator() {
		return new ListIterator();
	}
	
	//inner class. Iterator��ü�� ����
	public class ListIterator{
		private int nextIndex = 0;
		
		//���� pointer�� ��
		public Object next() {
			return elementData[nextIndex++];
		}
		
		//���������� Ȯ�ν� next�޼ҵ带 ȣ�� �������� Ȯ��
		public boolean hasNext() {
			return nextIndex < size();
		}
		
		//next�� �ݴ�Ǵ�, previous
		public boolean hasPrevious() {
			return nextIndex > 0;
		}
		
		//previous�� �켱 index�� ���ҽ�Ű�� return�Ѵٴ� �Ϳ� ����
		public Object previous() {
			return elementData[--nextIndex];
		}
		
		//iterator�� �̿��� ���� �߰��ϰ� �����ϴ� method
		public void add(Object element) {
			//���� Ŭ������ �޼ҵ�� �浹���� �ʰ� �ϵ���. Ȯ���� ǥ��
			ArrayList.this.add(nextIndex++, element);
		}
		
		//remove�� ������ element�� �����ϴ� ���̴�.
		//next�� �ѹ��� ȣ������ ���� ���¿��� remove�� ȣ���ϴ� ���� 
		//���� �������� �ʴ� ���¿��� �����ϴ� ���̹Ƿ� next�� ������ 1ȸ �̻� �ҷ����ϳ�.
		public void remove() {
			ArrayList.this.remove(nextIndex-1);
			nextIndex--;
		}
	}
	
	//main method. Test�� 
	public static void main(String[] args) {
		ArrayList array_list = new ArrayList();
		array_list.addLast(10);
		array_list.addLast(20);
		array_list.addLast(30);
		array_list.addLast(40);
		array_list.addLast(50);
		
		ArrayList.ListIterator li = array_list.listIterator();
	}
	
	
	
}
