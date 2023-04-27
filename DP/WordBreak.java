package DP;
import java.util.*;
public class WordBreak {
	
	private static int solution(String sentence, HashSet<String> dictionary) {
		int n=sentence.length();
		int [] dp=new int[sentence.length()];
		for(int i=0;i<n;i++){
			for(int j=0;j<=i;j++) {
				String wordcheck=sentence.substring(j,i+1);
				if(dictionary.contains(wordcheck)) {
					dp[i]+= (i==0?1:dp[j-1]);
				}
			}
		}
		return dp[n-1];
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		HashSet<String> dictionary=new HashSet<String>();
		for(int i=0;i<n;i++) {
			dictionary.add(sc.next());			
		}
		String sentence=sc.next();
		int ans=solution(sentence,dictionary);
		System.out.println(ans);
	}
}
