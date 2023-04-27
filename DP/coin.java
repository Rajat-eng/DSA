package DP;

public class coin {
	
	public static int countWaysToMakeChange(int denominations[], int value){
		int [][] dp=new int[1+denominations.length][1+value];
		
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				dp[i][j]=-1;
			}
		}
      return countMemo(denominations,value,0,dp);
	}
	
	private static int countMemo(int[] denominations, int value, int i, int[][] dp) {
		
		if(value==0){ // do not submit any denomination --> return 1
			dp[i][value]=1;
			return 1;
		}
		if(i==denominations.length) {  // all denominations over
			dp[i][value]=0;
			return 0;
		}		
		if(dp[i][value]!=-1)
			return dp[i][value];
		
		if(denominations[i]<=value) {
//			denomination cannot be used or can be used
			dp[i][value]=countMemo(denominations, value, i+1, dp) + countMemo(denominations, value-denominations[i], i, dp); 
			return dp[i][value];
		}else {
//			denomination value higher than target
			dp[i][value]=countMemo(denominations, value, i+1, dp);
			return dp[i][value];
		}
	}
	
	private static int countDP(int denominations[],int value) {
     int [][] dp=new int[1+denominations.length][1+value];
		
		for(int i=0;i<=denominations.length;i++) {
			dp[i][0]=1;
		}
		for(int j=1;j<=value;j++) {
			dp[0][j]=0;
		}
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(j-denominations[i-1]>=0)
					dp[i][j] = dp[i-1][j]+dp[i][j-denominations[i-1]];
				else
					dp[i][j]=dp[i-1][j];
			}
		}
		
		return dp[denominations.length][value];
	}
	
	private static int permutations(int coins[],int target) {
		int [] dp=new int[1+target];
		dp[0]=1;
		for(int amt=1;amt<=target;amt++) {
			for(int coin:coins) {
				if(coin<=amt) {
					int remamt=amt-coin;
					dp[amt]+=dp[remamt];
				}
			}
		}
		return dp[target];
	}

	public static void main(String[] args) {
	int []arr= {2,3,5};
//	System.out.println(countWaysToMakeChange( arr, 7));
	System.out.println(countDP(arr,7));
	System.out.println(permutations(arr, 7));
	}

}
