// at each ith petrol pump u can fill petrol as petrol[i] and distance to next petrol pump is distance[i]
// find from which min index u can have circular path
public class gasStation {
	
	private static int solve(int[] petrol, int[] distance) {
		int startindex=0,currbalance=0,rembalance=0;
		for(int i=0;i<petrol.length;i++) {
			// can travel to next station if currbalce>=0
			currbalance+=petrol[i]-distance[i];
			if(currbalance<0) {
				// has to statrt form next index for circular loop
				startindex=i+1;
//				check if rembalance can compensate currbalance
				rembalance+=currbalance;
				currbalance=0;
			}
		}
		return currbalance + rembalance >=0 ? startindex:-1;
	}

	public static void main(String[] args) {
		int[] petrol= {1,2,3,4,5};
		int[] distance= {3,4,5,1,2};
		int ans=solve(petrol,distance);
		System.out.println( (ans+1) + "th petrol pump"); // index is ans
	}

	

}
