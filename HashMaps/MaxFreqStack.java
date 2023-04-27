package HashMap;
import java.util.*;
public class MaxFreqStack {
	
	class FreqStack {
	    HashMap<Integer,Integer> fmap;
	    HashMap<Integer,Stack<Integer>> group;
	    int maxfreq;
	    
	    public FreqStack() {
	        fmap=new  HashMap<>();
	        group=new HashMap<>();
	        maxfreq=0;
	    }
	    
	    public void push(int val) {
	        int freq=fmap.getOrDefault(val,0)+1;
	        fmap.put(val,freq);
	        if(freq>maxfreq){
	            maxfreq=freq;
	        }
	        if(!group.containsKey(freq)){
	            group.put(freq,new Stack<Integer>());
	        }
	        group.get(freq).push(val);
	    }
	    
	    public int pop() {
	        int ans=group.get(maxfreq).pop();
	        
	        if(group.get(maxfreq).size()==0){
	            group.remove(maxfreq);
	            maxfreq--;
	        }
	        
	        int freq=fmap.get(ans);
	        freq--;
	        fmap.put(ans,freq);
	        
	        return ans;
	    }
	}

	public static void main(String[] args) {
		

	}

}
