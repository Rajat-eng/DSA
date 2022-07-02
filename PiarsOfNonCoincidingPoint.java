package HashMap;
import java.util.HashMap;
public class PiarsOfNonCoincidingPoint {
	
	private static int solve(int[] x, int[] y) {
		int sum=0;
		HashMap<Integer,Integer> xmap=new HashMap<Integer, Integer>();
		HashMap<Integer,Integer> ymap=new HashMap<Integer, Integer>();
		HashMap<String,Integer> xymap=new HashMap<String, Integer>();
		for(int i=0;i<x.length;i++) {
			int xco=x[i];
			int yco=y[i];
			String xy=xco+"*"+yco;
			sum+=xmap.getOrDefault(xco,0)+ymap.getOrDefault(yco,0)-2*xymap.getOrDefault(xy,0);
			xmap.put(xco, xmap.getOrDefault(xco, 0)+1);
			ymap.put(yco, ymap.getOrDefault(yco, 0)+1);
			xymap.put(xy, xymap.getOrDefault(xy, 0)+1);
		}
		return sum;
	}

	public static void main(String[] args) {
		
		int[]x= {3,3,1,3,2,1};
		int[]y= {2,4,2,5,4,1};
		int ans=solve(x,y);
		System.out.println(ans);
	}
}
