package DP;
//Whis and Beerus are playing a new game today. 
//They form a tower of N coins and make a move in alternate turns
// Beerus plays first. 
//In one step, the player can remove either 1, X, or Y coins from the tower.
//The person to make the last move wins the game. Can you find out who wins the game?
public class CoinTowerGame {
	
	public static String findWinner(int n, int x, int y) {
		boolean [] dp=new boolean[1+n];
        
        dp[0]=false;
        dp[1]=true;
        dp[x]=true;
        dp[y]=true;
        
        for(int i=2;i<=n;i++){
        if(i-1>=0 && dp[i-1]==false)
            dp[i]=true;
        else if(i-x>=0 && dp[i-x]==false)
            dp[i]=true;
        else if(i-y>=0 && dp[i-y]==false)
            dp[i]=true;     
        else
            dp[i]=false;
        }
        
        if(dp[n]){
            String win1="Beerus";
        	return win1;
        }
            
        else{
            String win2="Whis";
            return win2;
        }   	
	}

	public static void main(String[] args) {
		System.out.println(findWinner(5, 3, 4));
	}

}
