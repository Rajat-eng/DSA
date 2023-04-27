package DP;
import java.util.Scanner;
public class countbalancedtrees {
	
static int mod=(int)(Math.pow(10,9)+7);
    
	public static int balancedBTs(int height){
		int []dp=new int[height+1];
        dp[0]=1;
        dp[1]=1;
        if(height==0||height==1)
            return dp[height];
        
        for(int i=2;i<=height;i++) {
        	int x=dp[i-1];
            int y=dp[i-2];
            long res1=(long)x*x;
            long res2=(long)x*y*2;
            int val1=(int)(res1%mod);
            int val2=(int)(res2%mod);
            int result=(val1+val2)%mod;
            dp[i]=result;
        }
		return dp[height];
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int h=sc.nextInt();
		System.out.println(balancedBTs(h));
		sc.close();
	}

}
