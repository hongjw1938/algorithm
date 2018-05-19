package exhaustiveSearch;

public class CryptographyTest {

	public static void main(String[] args) {
		System.out.println(Cryptography.encrypt3(new int[] {1, 2, 3}));
		System.out.println(Cryptography.encrypt3(new int[] {1, 3, 2, 1, 1, 3}));
		System.out.println(Cryptography.encrypt3(new int[] {1000, 999, 998, 997, 996, 995}));
	}
}
