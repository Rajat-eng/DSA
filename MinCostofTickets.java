package DP;

public class MinCostofTickets {
	
	private static int findMinCost(int[] days, int[] cost) {
		Integer[] dp=new Integer[400]; 
		return helper(days[0],days,cost,dp);
	}

	private static int helper(int currday, int[] days, int[] cost,Integer[] dp) {
		if(currday>days[days.length-1]) {
			return 0;
		}
		if(dp[currday]!=null) {
			return dp[currday];
		}
		int ans=Integer.MAX_VALUE;
		if(travel(currday,days)) {
		   ans=Math.min( cost[0] + helper(currday+1,days,cost,dp), ans); // buy pass for 1 day
		   ans=Math.min( cost[1] + helper(currday+7,days,cost,dp), ans); // buy pass for week
		   ans=Math.min( cost[2] + helper(currday+30,days,cost,dp), ans); // but pass for month
		}else {
			ans=helper(currday+1, days, cost,dp);
		}
		dp[currday]=ans;
		return ans;
	}

	private static boolean travel(int currday, int[] days) {
		for(int i:days) {
			if(i==currday) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] days= {2,3,8,9,10,11,12,14,27};  // days on which you travel
		int [] cost={1,5,25}; // perday  oneweek month
		// max 365 days in days array
		int ans=findMinCost(days,cost);
		System.out.println(ans);
	}
}
