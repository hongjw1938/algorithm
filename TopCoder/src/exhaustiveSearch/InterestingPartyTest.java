package exhaustiveSearch;

public class InterestingPartyTest {

	public static void main(String[] args) {
		//각 친구는 first, second배열의 i번째에 흥미가 있음.
		String[] first = {"fishing", "gardening", "swimming", "fishing"};
		String[] second = {"hunting", "fishing", "fishing", "biting"};
		
		System.out.println(InterestingParty.bestInvitation3(first, second));
	}

}
