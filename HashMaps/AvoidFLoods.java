package HashMap;
import java.util.HashMap;
import java.util.TreeSet;
public class AvoidFLoods {

	  public int[] avoidFlood(int[] rains) {
	        HashMap<Integer,Integer> lastRain=new HashMap<>();
	        TreeSet<Integer> dry=new TreeSet<>();
	        int n=rains.length;
	        int[] ans=new int[n];
	        for(int i=0;i<n;i++){
	            int x=rains[i];
	            if(x==0){
	                dry.add(i);
	                ans[i]=1;
	            }else{
	                Integer id=lastRain.get(x);
	                if(id==null){
	                  lastRain.put(x,i);  
	                }else{
	                    Integer dryThisDay=dry.higher(id);
	                    if(dryThisDay==null){
	                        return new int[0];
	                    }   
	                    ans[dryThisDay]=x;
	                    dry.remove(dryThisDay);
	                    lastRain.put(x,i);           
	                }
	                ans[i]=-1;
	            }
	        }
	        return ans;
	    }
	  
	public static void main(String[] args) {
		int[] rains = {1,2,0,0,2,1};
//		0 means lake can be dried
//		1,2 meqans this lekae is filled. protect them from flooding in futire when again found

	}

}
