
public class checkAB {
	
	public static boolean check(String input) {
		int i=0;
		int n=input.length();
		int loa=-1;
		int fob=-1;
		if(input.charAt(0)=='b')
			return false;
		for(i=0;i<n;i++) {
			if(input.charAt(i)=='a')
				loa=i;
		}
	
		for(i=n-1;i>=0;i--) {
			if(input.charAt(i)=='b')
				fob=i;			
		}
		
		if(fob==-1)
			return true;
		
		if(loa>fob)
			return false;
		
		return true;
		
	}

	public static void main(String[] args) {
		String s="aaaabbb";
		System.out.println(check(s));

	}

}
