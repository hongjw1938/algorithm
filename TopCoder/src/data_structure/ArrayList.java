package data_structure;

//ArrayList의 본질적인 구현
public class ArrayList {
	
	//Object타입의 배열을 생성. 최대 element 100개
	private Object[] elementData = new Object[100];
	
	//몇 개의 데이터가 리스트에 들어있는지 체크하는 것.
	private int size = 0;
	
	//addLast method. list의 마지막에 값을 추가하는 것.
	public boolean addLast(Object element) {	
		// 현재 데이터가 들어있는 숫자만큼의 index에 새로 추가하고 element개수를 의미하는 size를 증가시킴
		elementData[size] = element;
		size++;
		return true;
	}
	
	//addFirst method. list의 처음에 추가하는 경우
	public boolean addFist(Object element) {
		//이미 제작한 add메소드를 이용해서 추가한다.
		return add(0, element);
	}
	
	
	//add method. list의 중간에 값을 추가하는 경우
	//중간 index이상의 index에 위치한 모든 값을 하나씩 뒤로 미뤄야한다.
	public boolean add(int index, Object element) {
		//모든 값을 하나씩 뒤로 미룬다
		for(int i = size - 1; i >= index; i--) {
			elementData[i+1] = elementData[i];
		}
		
		// 새로 추가한 값을 추가함.
		elementData[index] = element;
		
		// 엘리먼트의 숫자를 1 증가
		size++;
		return true;
	}
	
	//toString method. 데이터 출력
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
	
	//remove method. 데이터를 삭제하는 방법
	public Object remove(int index) {
		//삭제 전에 삭제할 데이터를 removed 변수에 저장
		Object removed = elementData[index];
		
		//삭제된 부분 다음부터 하나씩 앞으로 옮김
		for(int i=index+1; i <= size - 1; i++) {
			elementData[i-1] = elementData[i];
		}
		//크기를 줄임
		size--;
		
		//마지막 위치의 element를 명시적으로 삭제
		elementData[size] = null;
		
		//삭제한 element에 저장되어있었던 값을 리턴
		return removed;
	}
	
	//removeFirst method. 가장 첫 element를 삭제
	public Object removeFirst() {
		return remove(0);
	}
	
	//removeLast method. 가장 마지막 element를 삭제
	public Object removeLast() {
		return remove(size-1);
	}
	
	//get method. 특정 index의 element를 가져오는 메소드
	public Object get(int index) {
		return elementData[index];
	}
	
	//size method. 현재 list가 몇 개의 element를 가졌는지 확인
	public int size() {
		return size;
	}
	
	//indexOf method. 검색하는 것. 특정 element의 index를 알아낸다.
	public int indexOf(Object element) {
		
		//list를 뒤져서 찾은 다음. 있으면 index값 반환
		for(int i=0; i < size; i++) {
			if(element.equals(elementData[i])) {
				return i;
			}
		}
		
		//없으면 -1반환
		return -1;
	}
	
	
	//ListIterator, 즉 iterator객체를 반환하는 메소드
	public ListIterator listIterator() {
		return new ListIterator();
	}
	
	//inner class. Iterator객체를 가짐
	public class ListIterator{
		private int nextIndex = 0;
		
		//현재 pointer의 값
		public Object next() {
			return elementData[nextIndex++];
		}
		
		//순차적으로 확인시 next메소드를 호출 가능한지 확인
		public boolean hasNext() {
			return nextIndex < size();
		}
		
		//next에 반대되는, previous
		public boolean hasPrevious() {
			return nextIndex > 0;
		}
		
		//previous는 우선 index를 감소시키고 return한다는 것에 주의
		public Object previous() {
			return elementData[--nextIndex];
		}
		
		//iterator를 이용해 값을 추가하고 제거하는 method
		public void add(Object element) {
			//상위 클래스의 메소드와 충돌나지 않게 하도록. 확실히 표현
			ArrayList.this.add(nextIndex++, element);
		}
		
		//remove는 현재의 element를 삭제하는 것이다.
		//next를 한번도 호출하지 않은 상태에서 remove를 호출하는 것은 
		//아직 존재하지 않는 상태에서 실행하는 것이므로 next를 무조건 1회 이상 불러야하낟.
		public void remove() {
			ArrayList.this.remove(nextIndex-1);
			nextIndex--;
		}
	}
	
	//main method. Test용 
	public static void main(String[] args) {
		ArrayList array_list = new ArrayList();
		array_list.addLast(10);
		array_list.addLast(20);
		array_list.addLast(30);
		array_list.addLast(40);
		array_list.addLast(50);
		
		ArrayList.ListIterator li = numbers.listIterator();
	}
	
	
	
}
