package HashMap;
import java.util.*;
public class GetRandom {
	
	class RandomizedCollection {
	    HashMap<Integer,HashSet<Integer>> map;
	    List<Integer> list;
	    Random r;
	    public RandomizedCollection() {
	        map=new HashMap<>();
	        list=new ArrayList<>();
	        r=new Random();
	    }
	    
	    public boolean insert(int val) {
	        boolean flag;
	        HashSet<Integer> set;
	        if(!map.containsKey(val)){
	            set=new HashSet<Integer>();
	            flag=true;
	        }else{
	            set=map.get(val);
	            flag=false;
	        }
	        set.add(list.size());
	        list.add(val);
	        map.put(val,set);
	        return flag;
	    }
	    
	    public boolean remove(int val) {
	        if(!map.containsKey(val)){
	            return false;
	        }
	        HashSet<Integer> set=map.get(val);
	        int remidx=-1;
	        for(int i:set){
	            remidx=i;
	            break;
	        }
	        set.remove(remidx);
	        map.put(val,set);
	        if(map.get(val).size()==0){
	            map.remove(val);
	        }
	        if(remidx==list.size()-1){
	            list.remove(list.size()-1); 
	        }else{
	            list.set(remidx,list.get(list.size()-1));
	            list.remove(list.size()-1);
	            int newval=list.get(remidx);
	            HashSet<Integer> temp=map.get(newval);
	            temp.remove(list.size());
	            temp.add(remidx);
	            map.put(newval,temp);
	        }
	        
	        return true;
	    }
	    
	    public int getRandom() {
	        int randomidx=r.nextInt(list.size());
	        return list.get(randomidx);
	    }
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
