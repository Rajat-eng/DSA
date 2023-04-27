package BACKTRACK;
import java.util.*;

public class PalindromicPermutations {
	
	private static void generatepermutations(int i, int len, HashMap<Character, Integer> map, Character oddch,String ans) {
//		O[]
		if(i>=len) {
			String rev="";
			for(int k=0;k<ans.length();k++) {
				rev=ans.charAt(k)+rev;
			}
			if(oddch!=null) {
				ans+=oddch;
			}
			ans+=rev;
			System.out.println(ans);
			return;
		}
		
		for(char ch:map.keySet()){
		   int freq=map.get(ch);
		   if(freq>0) {
				 map.put(ch, freq-1);
				   generatepermutations(i+1, len, map, oddch, ans+ch);
				   map.put(ch, freq);
			}
		  
		}
		
	}

	public static void main(String[] args) {
		String s="malayalam";
//		logic aabbc --> abcba || bacab   orignal/2 +odd char + reverse of original/2
		HashMap<Character,Integer> map=new HashMap<>();
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch)+1);
			}else {
				map.put(ch, 1);
			}
		}
		Character oddch=null;
		int odds=0;
		int len=0;
		for(char ch:map.keySet()) {
			int freq=map.get(ch);
			if(freq%2==1) {
				oddch=ch;
				odds++;
			}
			map.put(ch, freq/2);
			len+=freq/2;  // length of half string aabbccc is abc
		}
		if(odds>1) { // number of odd charactrs is >1 
			System.out.println("Palindrome not possible");
			return;
		}
			generatepermutations(0,len,map,oddch,"");
		
	}
}
