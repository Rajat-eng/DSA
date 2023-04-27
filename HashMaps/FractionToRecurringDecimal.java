package HashMap;
import java.util.*;

public class FractionToRecurringDecimal {
	
	private static String solve(int numerator, int denominator) {
												
		StringBuilder ans=new StringBuilder();
		 if(numerator<0 || denominator<0){
	            ans.append("-");
	     }
        if(numerator<0 && denominator<0){
          ans.delete(0,1);  
        }
        long num=Math.abs((long)numerator);
        long den=Math.abs((long)denominator);
		long q=num/den;
		long r=num%den;
		ans.append(q);
		if(r==0) {	
			return ans.toString();
		}else {
			ans.append(".");
			HashMap<Long,Integer> map=new HashMap<>();
			while(r!=0) {
				if(map.containsKey(r)) {
					int length=map.get(r);
					ans.insert(length, "(");
					ans.append(")");
					break;
				}else {
					map.put(r, ans.length());
					r=r*10;
					q=r/den;
					r=r%den;
					ans.append(q);
				}	
			}
		}
		return ans.toString();
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int den=sc.nextInt();
		String ans=solve(num,den);
		System.out.println(ans);
		sc.close();
	}

}
