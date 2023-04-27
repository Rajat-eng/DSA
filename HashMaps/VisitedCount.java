package HashMap;
import java.util.*;
public class VisitedCount {
	
	private static ArrayList<String> solve(String[] domains) {
		HashMap<String,Integer> map=new HashMap<String, Integer>();
		for(String domain:domains) {
			String num[]=domain.split(" ");
			int visitCount=Integer.parseInt(num[0]);
			String words[]=num[1].split("\\.");
			StringBuilder sb=new StringBuilder();
			for(int idx=words.length-1;idx>=0;idx--) {
				if(idx==words.length-1) {
					sb.append(words[idx]);
				}else {
					sb.insert(0,".");
					sb.insert(0, words[idx]);
				}
				
				String subDomain=sb.toString();
				if(map.containsKey(subDomain)) {
					int freq=map.get(subDomain);
					map.put(subDomain, freq+visitCount);
				}else {
					map.put(subDomain, visitCount);
				}
			}
		}
		
		ArrayList<String> list=new ArrayList<String>();
		for(String subDomains:map.keySet()) {
			StringBuilder sb=new StringBuilder();
			sb.append(map.get(subDomains));
			sb.append(" ");
			sb.append(subDomains);
			list.add(sb.toString());
		}
		
		return list;
	}

	public static void main(String[] args) {
		String[] domains= {"150 google.com","200 pepcoding.com","130 contest.pepcoding.com"};
		ArrayList<String> ans=solve(domains);
		System.out.println(ans);
	}
}
