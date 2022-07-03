package BACKTRACK;
import java.util.*;
public class KLengthWord {
	
	private static void generate1(int i, String uniqstr, int charselect, int k, Character[] spots) {
		if(i==uniqstr.length()) {
			if(charselect==k) {
				for(int pos=0;pos<spots.length;pos++) {
					System.out.print(spots[pos]);
				}
				System.out.println();
			}
			return;
		} 
		char ch=uniqstr.charAt(i);
		for(int pos=0;pos<spots.length;pos++) {
			if(spots[pos]==null) { 
//				 at each level char is put in spots
				spots[pos]=ch;
				generate1(i+1, uniqstr, charselect+1, k,spots);// a-- -a- --a -->{ ab-,a-b,ba-,-ab,b-a,-ba } --> { abc,acb,bac,cab,bca,cba }
				spots[pos]=null;
			}
		}
		generate1(i+1, uniqstr, charselect, k,spots);
	}
	
	private static void generate2(int spot, int k, String uniqstr, HashSet<Character> used, String asf) {
		
		if(spot>k) {
			System.out.println(asf);
			return;
		}
		
		for(int i=0;i<uniqstr.length();i++) {
//			 at each level all char are filled in spots
//			 {a--,b--,c--} --> {ab-,ac-,ba-,bc-,ca-,cb-} --> {abc,acb,bac,bca,cab,cba}
			char ch=uniqstr.charAt(i);
			if(used.contains(ch)==false) {
				used.add(ch);
				generate2(spot+1,k,uniqstr,used,asf +ch);
				used.remove(ch);
			}
		}
	}
	
	private static void generate3(String uniqstr, HashMap<Character, Integer> fmap, int currspot, int k, String ans) {
	// repitition allowed
		if(currspot==k) {
			System.out.println(ans);
			return;
		}
		
		for(int i=0;i<uniqstr.length();i++) {
			char ch=uniqstr.charAt(i);
			if(fmap.get(ch)>0) {
				fmap.put(ch, fmap.get(ch)-1);
				generate3(uniqstr,fmap,currspot+1,k,ans+ch);
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
		Character[] spots=new Character[k];
		generate1(0,uniqstr,0,k,spots);
		System.out.println();
//		generate2(1,k,uniqstr,new HashSet<>(),"");
		
		HashMap<Character,Integer> fmap=new HashMap<Character,Integer>();
		for(char ch:s.toCharArray()) {
			if( fmap.containsKey(ch) ) {
				fmap.put(ch,fmap.get(ch)+1);
			}else {
				fmap.put(ch,1);
			}
		}
		generate3(uniqstr,fmap,0,k,"");
	}

	

	
}
