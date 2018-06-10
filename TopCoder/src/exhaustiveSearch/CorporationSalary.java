package exhaustiveSearch;

public class CorporationSalary {
	
	long[] sals;
	
	public static void main(String[] args) {
		String[] relations = {"NNYN", "NNYN", "NNNN", "NYYN"};
		String[] relations2 = {
				"NNNNNN",
				"YNYNNY",
				"YNNNNY",
				"NNNNNN",
				"YNYNNN",
				"YNNYNN"
		};
		CorporationSalary sal = new CorporationSalary();
		System.out.println(sal.totalSalary(relations2));
	}
	
	//급여의 합계를 구하는 메소드
	//깊이 우선 탐색으로 진행하는 경우
	public long totalSalary(String[] relations) {
		
		sals = new long[relations.length]; 
		
		getSalary(0, relations);
		
		long hap = 0;
		for(int i=0; i < sals.length; i++) {
			System.out.println("sals[" + i + "] = " + sals[i] );
			hap += sals[i];
		}
		
		return hap;
	}
	
	public void getSalary(int i, String[] relations) {
		System.out.println("i = " + i);
		if(i >= relations.length) return;
		if(sals[i] != 0) return;
		
		
		int count = 0;
		for(int j=0; j < relations[i].length(); j++) {
			
			
			if(relations[i].charAt(j) == 'Y') {
				getSalary(j, relations);
				sals[i] += sals[j];
			} else {
				count++;
			}
			
			if(count == relations.length && i != 0) {
				sals[i] = 1L;
				return;
			} else if(count == relations.length && i == 0) {
				sals[i] = 1L;
				break;
			}
			
		}
		
		while(i < relations.length) {
			i++;
			getSalary(i, relations);
		}
		
		
	}
	
	//다른 코드 해석
	public long totalS(String[] relations) {
		sals = new long[relations.length];
		
		
		//반환하기 위한 최종값
		long total = 0;
		
		for(int i=0; i < relations.length; i++) {
			total += getSal(i, relations);
		}
		
		return total;
	}
	
	private long getSal(int i, String[] relations) {
		
		//초기화된 상태라면
		if(sals[i] == 0) {
			//해당 사원의 월급
			long sal = 0;
			
			//해당 사원의 관계도
			String relation = relations[i];
			
			for(int j=0; j < relations.length; j++) {
				
				//각 관계를 조사하여 해당 관계가 Y인 경우
				if(relation.charAt(i) == 'Y') {
					//재귀호출하고 NNNN까지 찾아 해당 값들을 리턴받아 계속 더함
					sal += getSal(j, relations);
				}
			}
			
			//재귀호출로 넘어가지 않은 경우 NNNN과 같이 모두 N이므로 가장 아래 직급. 월급은 1
			if(sal == 0) sal = 1;
				
			sals[i] = sal;
		}
		return sals[i];
	}

}
