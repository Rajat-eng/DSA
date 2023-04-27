package BACKTRACK;

import java.util.*;

public class KSelectLetter {
	
	private static void select1(int i, String uniqstr, int ssf, int k, String ans) {
		
		if(i==uniqstr.length()) {
			if(ssf==k) {
				System.out.println(ans);
			}
			return;
		}
		char ch=uniqstr.charAt(i);
		select1(i+1, uniqstr, ssf+1, k, ans+ch);
		select1(i+1, uniqstr, ssf, k, ans);
		
	}
	
	
	private static void select2(String uniqstr, int currspot, int k, int lastOccurence, String ans) {
		
		if(currspot>k) {
			System.out.println(ans);
			return;
		}
		for(int i=lastOccurence+1;i<uniqstr.length();i++) {
			char ch=uniqstr.charAt(i);
			select2(uniqstr,currspot+1,k,i,ans+ch);
		}
	}
	
	private static void select3(String uniqstr, HashMap<Character, Integer> fmap, int totalspot, int k, String ans, int lastoccurence) {
		// with repitition
		if(totalspot==k) {
			System.out.println(ans);
			return;
		}
		for(int i=lastoccurence;i<uniqstr.length();i++) {
			char ch=uniqstr.charAt(i);
			if(fmap.get(ch)>0) {
				fmap.put(ch, fmap.get(ch)-1);
				select3(uniqstr,fmap,totalspot+1,k,ans+ch,i);
				fmap.put(ch, fmap.get(ch)+1);
			}
		}
	}
	

	public static void main(String[] args) {
		String s="abcabc";
		int k=2;
		HashSet<Character> map=new HashSet<>();
		String uniqstr="";
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(!map.contains(ch)) {
				uniqstr+=ch;
				map.add(ch);
			}
		}
		select1(0,uniqstr,0,k,"");
		System.out.println();
		select2(uniqstr,1,k,-1,"");
		HashMap<Character,Integer> fmap=new HashMap<Character,Integer>();
		for(char ch:s.toCharArray()) {
			if( fmap.containsKey(ch) ) {
				fmap.put(ch,fmap.get(ch)+1);
			}else {
				fmap.put(ch,1);
			}
		}
		System.out.println();
		select3(uniqstr,fmap,0,k,"",0);
	}


	



	

	

}
