package DP;
// find min attempts to find critical floor which can be any floor or it does not exist
public class EggDropping {
	
	private static int solution(int eggs, int floor) {
		int [][] dp=new int[1+eggs][1+floor];
		for(int i=1;i<=eggs;i++) {
			for(int j=1;j<=floor;j++) {
				if(i==1) {
//					 eggs is 1 then min attempts is no. of floor
					dp[i][j]=j;
				}else if(j==1) {
//					 only 1 floor then 1 attempt only
					dp[i][j]=j;
				}else {
//   2 eggs 2 floor
//	 visit each floor(1,2-- floor) -->  if egg breaks then check egg-1|floor-1 else egg|floor-k 				
					int min=Integer.MAX_VALUE;
					for(int mj=j-1,pj=0; mj>=0; mj--,pj++) {
						int v1=dp[i][mj]; // egg survives
						int v2=dp[i-1][pj]; // egg breaks
						int val=Math.max(v1, v2);
						min=Math.min(val,min);
					}
					dp[i][j]=1+min;
				}
			}
		}
		return dp[eggs][floor];
	}

	public static void main(String[] args) {
		int eggs=3;
		int floor=7;
		int ans=solution(eggs,floor);
		System.out.println(ans);
	}

	

}
