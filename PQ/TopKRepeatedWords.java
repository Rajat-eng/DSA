package PQ;

import java.util.*;


class A implements Comparable<A>{
	String word;
	int times;
	public A(String word,int times) {
		this.times=times;
		this.word=word;
	}
	@Override
	public int compareTo(A o) {
		return o.times-this.times;
	}
}

public class TopKRepeatedWords {
	
	private static String[] solve(String para, int k) {
		String ans[]=new String[k];
		HashMap<String,Integer> map=new HashMap<String, Integer>();
		String words[]=para.split(" ");
		for(String word:words) {
			map.put(word, map.getOrDefault(word, 0)+1);
		}
		PriorityQueue<A> pq=new PriorityQueue<A>();
		for(String key:map.keySet()) {
			A p=new A(key,map.get(key));
			pq.add(p);
		}
		int idx=0;
		while(k-->0) {
			if(!pq.isEmpty()) {
				ans[idx++]=pq.remove().word;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String para=sc.nextLine();
		int k=sc.nextInt();
		para=para.toLowerCase();
		String ans[]=solve(para,k);
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
		sc.close();
	}
}
