package simulation;

public class KiwiJuiceEasy {
	// capacities는 최대 용량, bottles는 현재 용량, fromId는 비워낼 병의 index, toId는 채울 병의 index
	public static int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
		// fromId와 toId에 있는 순서에 따라 반복
		int f = 0;
		int t = 0;
		
		int capacity = 0;
		for(int i = 0; i < fromId.length; i++) {
			// from과 to의 i번째 index에 있는 병으로 용량을 이동시킴 
			f = fromId[i];
			t = toId[i];
			
			//현재 to의 i번째 index의 병에 채울 수 있는 최대한의 양을 계산
			capacity = capacities[t] - bottles[t];
			
			//현재 채울 수 있는 용량보다 이전의 양이 더 많으면 최대로 채우고 그만한다.
			//다 채웠고 from쪽 병에서 넘길 양이 더 이상 없다면 그만한다.
			if(capacity >= bottles[f]) {
				int pour = bottles[f];
				bottles[f] -= pour;
				bottles[t] += pour;
			} else {
				bottles[f] -= capacity;
				bottles[t] += capacity;
			}
		}
		return bottles;
	}
	
	public static int[] thePouring2(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
		
		int f = 0;
		int t = 0;
		
		int vol = 0;
		for(int i = 0; i < fromId.length; i++) {
			f = fromId[i];
			t = toId[i];
			
			vol = Math.min(capacities[t] - bottles[t], bottles[f]);
			
			bottles[f] -= vol;
			bottles[t] += vol;
			
		}
		return bottles;
	}
	
	public static int[] thePouring3(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
		
		int sum = 0;
		for(int i = 0; i < fromId.length; i++) {
			
			sum = bottles[fromId[i]] + bottles[toId[i]];
			
			bottles[toId[i]] = Math.min(sum, capacities[toId[i]]);
			bottles[fromId[i]] = sum - bottles[toId[i]];
			
		}
		return bottles;
	}
}
