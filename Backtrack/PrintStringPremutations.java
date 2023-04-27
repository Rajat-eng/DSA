package BACKTRACK;

import java.util.*;


public class PrintStringPremutations {
	    
	    public static void generate1(String s,String ans){
//	    	include repititons
	        if(s.length()==0){
	            System.out.println(ans);
	            return;
	        }
	        for(int i=0;i<s.length();i++){
	            char ch=s.charAt(i);
	            String left=s.substring(0,i);
	            String right=s.substring(i+1);
	            String rest=left+right;
	            generate1(rest,ans+ch);
	        }
	    }
	    
	    private static void generate2(int i, String s, Character[] spots, HashMap<Character, Integer> lastoccurence) {
//	    	no repitition
			if(i>=spots.length) {
				for(int pos=0;pos<spots.length;pos++) {
					System.out.print(spots[pos]);
				}
				System.out.println();
				return;
			}
			char ch=s.charAt(i);
			int lo=lastoccurence.get(ch);
			for(int pos=lo+1;pos<spots.length;pos++) {
				if(spots[pos]==null) {
					spots[pos]=ch;
					lastoccurence.put(ch, pos);
					generate2(i+1, s, spots, lastoccurence);
					lastoccurence.put(ch,lo);
					spots[pos]=null;
				}
			}
		}

	public static void main(String[] args) {
		String s="aabb";
		Character spots[]=new Character[s.length()];
		HashMap<Character,Integer> lastoccurence=new HashMap<>();
		for(char ch:s.toCharArray()) {
			lastoccurence.put(ch, -1);
		}
//		generate1(s,"");
//		System.out.println();
		generate2(0,s,spots,lastoccurence);
	}



	

}
