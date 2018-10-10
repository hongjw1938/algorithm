package data_structure;

public class SimpleHashTable<T> {
	@SuppressWarnings("hiding")
	class SHTable<T>{
		private int tableSize;
		private T data[];
		
		private SHTable() {
			this.tableSize = 16;
		}
		
		@SuppressWarnings("unchecked")
		private SHTable(int tableSize){
			this.tableSize = tableSize;
			data = (T[])new Object[tableSize];
		}
	}
	
	SHTable<T> table;
	
	public SHTable<T> createSHTable() {
		this.table = new SHTable<>();
		
		return table;
	}
	
	// 해시테이블을 만드는 메소드
	public SHTable<T> createSHTable(int size) {
		this.table = new SHTable<>(size);
		
		return table;
	}
	
	// 해싱을 진행하는 메소드
	public int hash(int key) {
		return key % table.tableSize;
	}
	
	// 데이터를 넣는 메소드
	public void SHT_set(int key, T value) {
		int address = hash(key);
		table.data[address] = value;
		
	}
	
	// 데이터를 반환하는 메소드
	public T SHT_get(int key) {
		int address = hash(key);
		return table.data[address];
	}
	
	
	public static void main(String[] args) {
		SimpleHashTable<Integer> sht = new SimpleHashTable<>();
		sht.createSHTable(193);
		sht.SHT_set(418, 32114);
		sht.SHT_set(9, 514);
		sht.SHT_set(27, 8917);
		sht.SHT_set(1031, 286);
		
		System.out.printf("Key:%d,	 	Value:%d%n", 418, sht.SHT_get(418));
		System.out.printf("Key:%d, 			Value:%d%n", 9, sht.SHT_get(9));
		System.out.printf("Key:%d, 		Value:%d%n", 27, sht.SHT_get(27));
		System.out.printf("Key:%d, 		Value:%d%n", 1031, sht.SHT_get(1031));
		
		
		
	}

}
