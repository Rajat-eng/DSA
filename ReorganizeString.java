package HashMap;
import java.util.*;

public class ReorganizeString {
	
	  class Pair{
		    char c;
		    int f;
		    
		    public Pair(char c, int f){
		        this.c=c;
		        this.f=f;
		    }
		}

	 public static String reorganizeString(String s) {
	       HashMap<Character,Integer> map=new HashMap<>();
	        for(int i=0;i<s.length();i++){
	            char ch=s.charAt(i);
	            map.put(ch,map.getOrDefault(ch,0)+1);
	        }
	          PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.f-a.f);
	        
	        for(char key:map.keySet()){
	            pq.add(new Pair(key,map.get(key)));
	        }
	        
	        StringBuilder sb=new StringBuilder();
	        Pair block=pq.poll();
	        sb.append(block.c);
	        block.f--;
	        while(pq.size()>0){
	            Pair temp=pq.poll();
	            sb.append(temp.c);
	            temp.f--;
	            if(block.f>0){
	                pq.add(block);
	            }
	            block=temp;
	        }
	        if(block.f>0){
	            return "";
	        }
	        return sb.toString();
	 }
	 
	 
	public static void main(String[] args) {
//		Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
		String s="aab";
		System.out.println(reorganizeString(s));
	}
}
