package exhaustiveSearch;

public class FriendsScoreTest {

	public static void main(String[] args) {
		String[] friends = new String[] {
				"NNN", "NNN", "NNN"
		};
		
		String[] friends2 = new String[] {
				"NYY", "YNY", "YYN"
		};
		
		String[] friends3 = new String[] {
				"NYNNN", "YNYNN", "NYNYN", "NNYNY", "NNNYN"
		};
		
		String[] friends4 = new String[] {
				"NNNNYNNNNN", "NNNNYNYYNN", "NNNYYYNNNN", "NNYNNNNNNN", "YYYNNNNNNY",
				"NNYNNNNNYN", "NYNNNNNYNN", "NYNNNNYNNN", "NNNNNYNNNN", "NNNNYNNNNN"
		};
		System.out.println(FriendScore.highestScore(friends));
		System.out.println(FriendScore.highestScore(friends2));
		System.out.println(FriendScore.highestScore(friends3));
		System.out.println(FriendScore.highestScore(friends4));

		System.out.println(FriendScore.highestScore2(friends));
		System.out.println(FriendScore.highestScore2(friends2));
		System.out.println(FriendScore.highestScore2(friends3));
		System.out.println(FriendScore.highestScore2(friends4));

	}

}
