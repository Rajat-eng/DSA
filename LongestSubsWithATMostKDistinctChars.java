package HashMap;

import java.util.HashMap;

public class LongestSubsWithATMostKDistinctChars {
	
	private static void solve(String s, int k) {
		HashMap<Character,Integer> map=new HashMap<>();
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
				if(map.size()<=k) {
//					keep acquiring till chars<=k
					int length=i-j;
					if(length>ans) {
						ans=length;
					}
				}else {
//					gretaer than 3 distinct chars
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
				}else {
//					valid string
					int length=i-j;
					if(length>ans) {
						ans=length;
					}
					break;
				}
			}
			 								   
			if(!f1&!f2) {
				break;
			}
			
		}
		System.out.println(ans);
	}
	
	
	private static void count(String s, int k) {
		HashMap<Character,Integer> map=new HashMap<>();
		int ans=0;
		int max=-1;
		int i=-1,j=-1;
		while(true) {
			while(i<s.length()-1) {
//				acquire
				i++;
				char ch=s.charAt(i);
				map.put(ch, map.getOrDefault(ch, 0)+1);
				if(map.size()<=k) {
//					keep acquiring till chars<=k
					ans+=i-j;
					if(ans>max) {
						max=ans;
						
					}
				}else {
//					greater than 3 distinct chars
					break;
				}
			}
			if(i==s.length()-1 && map.size()==k) {
//				we dont want last string to be added twice
				break;
			}	
			while(j<i) {
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
				}else {
//					valid string
					ans+=i-j;
					if(ans>max) {
						max=ans;
					}
					break;
				}
			}
		}		
		System.out.println(ans);	
	}
	
	public static void main(String[] args) {
		String s="ddacbbaccdedacebb";
		int k=3;
		solve(s,k);
//		s="aabcbcdbca";
//		k=2;
		count(s,k);
	}



	
}
