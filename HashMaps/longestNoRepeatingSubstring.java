package HashMap;
import java.util.HashMap;
public class longestNoRepeatingSubstring {
	private static int solve(String s) {
		HashMap<Character,Integer> map=new HashMap<>();
		int ans=0;
		int i=-1,j=-1;
		while(true) {
			boolean f1=false;
			boolean f2=false;
			while(i<s.length()-1) {
				f1=true;
//				acquire till you become invalid i.e freq of any char >1
				i++;
				char ch=s.charAt(i);
				map.put(ch,map.getOrDefault(ch, 0)+1);
				if(map.get(ch)==2) {
					break;
				}else { // all char freq is 1
					int length=i-j;
					if(length>ans) {
						ans=length;
					}
				}
			}
//			relaese till you become valid
			while(j<i) {
				f2=true;
				j++;
				char ch=s.charAt(j);
				map.put(ch, map.get(ch)-1);
				if(map.get(ch)==1) {
					break; //become valid again
				}
			}
			if(!f1&&!f2) {
				break;
			}
		}
		return ans;
	}
	
	   
	
	private static void count(String s) {
		HashMap<Character,Integer> map=new HashMap<>();
		int ans=0;
		int i=-1,j=-1;
		while(true) {
			boolean f1=false;
			boolean f2=false;
			while(i<s.length()-1) {
				f1=true;
//				acquire till you become invalid i.e freq of any char >1
				i++;
				char ch=s.charAt(i);
				map.put(ch,map.getOrDefault(ch, 0)+1);
				if(map.get(ch)==2) {
					break;
				}else { // al char freq is 1
					ans+=i-j;
				}
			}
//			relaese till you become valid
			while(j<i) {
				f2=true;
				j++;
				char ch=s.charAt(j);
				map.put(ch, map.get(ch)-1);
				if(map.get(ch)==1) {
					ans+=i-j;
					break; //become valid again
				}
			}
			
			if(!f1&&!f2) {
				break;
			}
		}
		System.out.println(ans);
		
	}

	public static void main(String[] args) {
		String s="abbac";
		System.out.println(lengthOfLongestSubstring(s));
		count(s);
	}



	



}
