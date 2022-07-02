package HashMap;
import java.util.*;
public class LongestSubsWithExactlyKDistinctChars {
	
	private static void solve(String s, int k) {
//		O[n]
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
				if(map.size()<k) {
//					keep acquiring
					continue;
				}else if(map.size()==k) {
					int length=i-j;
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
	}
	
	
	private static Set<String> count(String s, int k) {
//		O[n^2]
		Set<String> result=new HashSet<>();
		// base case
        if (s == null) {
            return result;
        }
 
        // in each iteration of the loop, consider substring starting with `str[i]`
        for (int i = 0; i < s.length() - k + 1; i++)
        {
            // create a set to store distinct characters in the current substring
            Set<Character> chars = new HashSet<>();
 
            // process substring starting with `str[i]`
            for (int j = i; j < s.length() && chars.size() <= k; j++)
            {
                // insert current character `str[j]` into the hash set
                chars.add(s.charAt(j));
 
                /*
                    If current character `str[j]` is seen before in the
                    substring `str[i…j-1]`, the count remains the same since
                    the hash set only allows unique values
                */
 
                // if the count of distinct characters becomes `k`
                if (chars.size() == k)
                {
                    // add the current substring to the result
                    result.add(s.substring(i, j + 1));
                    // to reduce the iterations of j
                    continue;  
                }
            }
        }
 
        return result;
	}


	public static void main(String[] args) {
		String s="aabcbcdbca";
//		bcbc has exactly 2 diff chars and is longest string
		int k=2;
		solve(s,k);
		System.out.println(count(s,k));
	}



	
}
