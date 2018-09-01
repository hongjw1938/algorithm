package d4_sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		
		String[] split = new String[3];
		
		int j=0;
		while(st.hasMoreTokens()) {
			split[j] = st.nextToken();
		}
		
		for(int i=0; i < 3; i++) {
			if(split[i] == null) {
				System.out.println("1");
			} else {
				System.out.println(i + " split : " + split[i]);
			}
		}
	}

}
