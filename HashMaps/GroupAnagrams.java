package HashMap;
import java.util.*;
public class GroupAnagrams {
	
	private static ArrayList<ArrayList<String>> solve(String[] s) {
		ArrayList<ArrayList<String>> res=new ArrayList<>();
		HashMap< HashMap<Character,Integer>,ArrayList<String> > bmap=new HashMap<HashMap<Character,Integer>, ArrayList<String>>();
		for(String str:s) {
			HashMap<Character,Integer> fmap=new HashMap<Character, Integer>();
			for(int i=0;i<str.length();i++) {
				char ch=str.charAt(i);
				fmap.put(ch,fmap.getOrDefault(ch, 0)+1);
			}
			if(bmap.containsKey(fmap)) {
				ArrayList<String> list=bmap.get(fmap);
				list.add(str);
			}else {
				ArrayList<String> list=new ArrayList<String>();
				list.add(str);
				bmap.put(fmap, list);
			}
		}
		for(ArrayList<String> val:bmap.values()) {
			res.add(val);
		}
		return res;
	}

	public static void main(String[] args) {
		String[] s= {"abcc","acbc","badc","abcd","dabb","babd","dbca","cabc"};
		ArrayList<ArrayList<String>> ans=solve(s);
		for(ArrayList<String> str: ans) {
			System.out.println(str);
		}
	}
	
}
