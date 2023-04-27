import java.util.*;
public class MeetingRooms {

	private static int minRooms(int[][] intervals) {
		// O[nlogn]
		// O[n]
		Arrays.sort(intervals,(a,b)->{ 
			return Integer.compare(a[0], b[0]);
		});
		
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
		
		for(int interval[]:intervals) {
			int start=interval[0];
			int end=interval[1];
			if(pq.size()==0) {
				pq.add(end);
			}else {
				if(start>=pq.peek()) {
					pq.remove();
					pq.add(end);
				}else {
					// new room
					pq.add(end);
				}
			}
		}
		
		return pq.size();
	}


	public static void main(String[] args) {
		int [][] intervals= {
								{1,4},
								{4,6},
								{3,5},
							};
		
		int rooms=minRooms(intervals);
		System.out.println(rooms);
	}

	

}
