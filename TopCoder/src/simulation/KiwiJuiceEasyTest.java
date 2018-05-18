package simulation;

public class KiwiJuiceEasyTest {

	public static void main(String[] args) {
		int[] capacities = {14, 35, 86, 58, 25, 62};
		int[] bottles = {6, 34, 27, 38, 9, 60};
		int[] fromId = {1, 2, 4, 5, 3, 3, 1, 0};
		int[] toId = {0, 1, 2, 4, 2, 5, 3, 1};
		int[] result = KiwiJuiceEasy.thePouring3(capacities, bottles, fromId, toId);
		
		
		//출력
		System.out.print("[");
		for(int i=0; i < result.length; i++) {
			if( i != 0) {
				System.out.print(", " + result[i]);
			} else {
				System.out.print(result[i]);
			}
		}
		System.out.print("]");
	}

}

