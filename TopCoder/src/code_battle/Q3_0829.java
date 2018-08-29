package code_battle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class Q3_0829 {
	private static StringBuffer[] sb;

	public static void main(String[] args) throws IOException, InputMismatchException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int case_num = Integer.parseInt(br.readLine());
		
		String sentence = br.readLine();
		int length = sentence.length();
		
		StringTokenizer m_val = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(m_val.nextToken());
		int end = Integer.parseInt(m_val.nextToken());
		
		int mfm = 0;
		for(int i = start; i <= end; i++) {
			mfm += getFm(sentence, length / i +2, i);
		}
		
		System.out.printf("#%d", case_num);
		System.out.printf(" %d%n", mfm);
	}
	
	private static int getFm(String sentence, int length, int m) {
		
		StringTokenizer st = new StringTokenizer(sentence);
		int ret_val = 0;
		sb = new StringBuffer[length];
		
		for(int j=0; j < length; j++) {
			sb[j] = new StringBuffer();
		}
		
		int index = 0;
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			if(sb[index].length() + token.length() > m) {
				index++;
				sb[index].append(token);
				if(st.hasMoreTokens()) sb[index].append(" ");
			} else {
				sb[index].append(token);
				if(st.hasMoreTokens()) sb[index].append(" ");
			}
		}
			System.out.println();
			for(int j=0; j < length; j++) {
				System.out.println(sb[j].toString());
			}
		
		int fm = 0;
		for(int j=0; j < length; j++) {
			
			if(j < length - 1) fm += sb[j].toString().split(" ")[0].length() + 1;
			else if(sb[j].toString().length() == 0) fm -= 1;
			else fm += sb[j].toString().split(" ")[0].length();
		}
//		System.out.print("i : " + m);
//		System.out.println("fm : " + fm);
		ret_val += m * fm;
	
		return ret_val;
	}
}
