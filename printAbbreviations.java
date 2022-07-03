package BACKTRACK;

//Input : ABC 
//Output : 
//ABC 000
//AB1 001
//A1C 010
//A2  011
//1BC 100
//1B1 101
//2C  110
//3   111
public class printAbbreviations {
	
	public static void solve(String s) {
		solvehelper(s,"",0,0);
	}
	
	private static void solvehelper(String s, String asf, int count, int pos) {
		if(pos==s.length()) {
			if(count==0)
			System.out.println(asf);
			else
			System.out.println(asf+count);
			return;
		}
		if(count>0) {
			solvehelper(s, asf + count + s.charAt(pos) ,0, pos+1); // yes 
		}
		else {
			solvehelper(s, asf + s.charAt(pos) , 0, pos+1); // yes
		}
		solvehelper(s, asf  , count+1, pos+1); //no
	}


	public static void main(String[] args) {
		String s="abc";
		solve(s);
	}

}
