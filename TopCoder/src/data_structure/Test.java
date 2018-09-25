package data_structure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Array_comparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1 - o2;
	}
	
}



public class Test {
	
	
	public static void main(String[] args) {
		ImplementArrayList<Integer> list = new ImplementArrayList<>();
		list.addFirst(1);
		list.add(3, 1);
		list.add(2, 2);
	
		list.add(-1);
		System.out.println(list);
		
		Array_comparator c = new Array_comparator();
		list.sort(c);
		System.out.println(list);
		
		ImplementLinkedList<Integer> list2 = new ImplementLinkedList<>();
		list2.addFirst(1);
		list2.addFirst(10);
		list2.addFirst(-4);
		list2.addFirst(2);
		
		list2.sort(c);
		System.out.println(list2);

	}
}
