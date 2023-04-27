package HashMap;
import java.util.*;
public class LongestSubsWithExactlyKDistinctChars {
	
	private static void solve(String s, int k) {
//		O[n]
		HashMap<Character,Integer> map=new HashMap<>();
		Set<String> result=new HashSet<>();
		int ans=0;
		int i=-1,j=-1;
		while(true) {
			boolean f1=false;
			boolean f2=false;
			while(i<s.length()-1) {
//				acquire
				f1=true;
				i++;
				char ch=s.charAt(i);
				map.put(ch, map.getOrDefault(ch, 0)+1);
				if(map.size()<k) {
//					keep acquiring
					continue;
				}else if(map.size()==k) {
					int length=i-j;
						
					   result.add(s.substring(j+1,i+1));
						
					if(length>ans) {
						ans=length;
					}
				}else {
//					gretaer than 2 distinct chars
					break;
				}
			}
			while(j<i) {
				f2=true;
				j++;
				char ch=s.charAt(j);
				if(map.get(ch)==1) {
					map.remove(ch);
				}else {
					map.put(ch, map.get(ch)-1);
				}
				if(map.size()>k) {
//					Invalid Keep releasing
					continue;
				}else if(map.size()==k) {
//					valid string
					int length=i-j;
					result.add(s.substring(j+1,i+1));
					if(length>ans) {
						ans=length;
					}
					break;
				}
//				else not required bcoz previouslt we break for >k
			}
			if(!f1&!f2) {
				break;
			}
		}
		System.out.println(ans);
		System.out.println(result);
	}
	
	



	public static void main(String[] args) {
		String s="aabcbcdbca";
//		bcbc has exactly 2 diff chars and is longest string
		int k=2;
		solve(s,k);
	}



	
}
