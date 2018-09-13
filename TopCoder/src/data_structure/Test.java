package data_structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Iterator<Integer> li = list.iterator();
		while(li.hasNext()) {
			System.out.println(li.next());
		}
	}

}
