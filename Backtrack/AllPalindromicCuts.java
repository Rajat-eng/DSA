package BACKTRACK;
import java.util.*;
public class AllPalindromicCuts {
	
	 public static List<List<String>> partition(String s){
		 List<List<String>> answer = new ArrayList<>();
		 List<String> currlist=new ArrayList<String>();
		 partitionhelper(s,currlist,answer);  // O[2^n] if all substring are palindrome
		 return answer;
	 }

	private static void partitionhelper(String s, List<String> currlist, List<List<String>> answer) {
		if(s.length()==0) {
//			System.out.println(currlist);
			answer.add(new ArrayList<String>(currlist));
			return;
		}
		
		for(int i=0;i<s.length();i++) {
			String prefix=s.substring(0,i+1);
			String left=s.substring(i+1);
			if(ispalindrome(prefix)) {
				currlist.add(prefix);
				partitionhelper(left, currlist, answer);
				currlist.remove(currlist.size()-1);
			}
		}
	}

	private static boolean ispalindrome(String prefix) {
		int i=0,j=prefix.length()-1;
		while(i<j) {
			if(prefix.charAt(i)!=prefix.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		String s="abccb";
		List<List<String>> ans=partition(s);
		for(int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}
	}

}
