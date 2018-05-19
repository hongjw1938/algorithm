package exhaustiveSearch;

public class InterestingDigitsTest {

	public static void main(String[] args) {
		int[] game = InterestingDigits.digits3(30);
		for(int num : game) {
			System.out.println(num);
		}
	}

}
