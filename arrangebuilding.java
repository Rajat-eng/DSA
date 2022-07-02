package DP;
//  arrange building on two sides such that no two buildings are adjacent
public class arrangebuilding {
	
	public static long arrange(int[] building) {
		long n=building.length;
		int oldb=1; // for i=1  --> ways to arrange building given 1 length
		int olds=1; // for i=1	--> ways to arrange spaces given 1 length
		for(int i=2;i<=n;i++) {
			int newb=olds;
			int news=olds+oldb;
			olds=news;
			oldb=newb;		
		}
		long ans= oldb+olds;
		return ans*ans;
	}

	public static void main(String[] args) {
		int[] arr= {1,2,3,4};
		System.out.println(arrange(arr));
	}

}
