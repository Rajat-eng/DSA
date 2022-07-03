package BACKTRACK;

public class coinChange {
	
	private static void solve(int i, int[] coins, int amtcol, int amount, String ans) {
		
		if(i==coins.length) {
			if(amtcol==amount) {
				System.out.println(ans);
			}
			return;
		}
		for(int j=amount/coins[i];j>=1;j--) {
			solve(i+1, coins, amtcol+coins[i]*j, amount, ans + coins[i] + "(" + j + ")" + " ");
		}
		solve(i+1, coins, amtcol, amount, ans );
	}

	public static void main(String[] args) {
		int [] coins= {2,3,5};
		int amount=12;
		solve(0,coins,0,amount,"");
	}
}
