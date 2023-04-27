
public class PrintSubstrings {
	
	private static void print(String s) {
		int n=s.length();
		for(int gap=0;gap<n;gap++) {
			for(int i=0,j=gap;j<n;j++,i++) {
				System.out.println(s.substring(i,j+1));
			}
		}
	}
	
	public static void main(String[] args) {
		String s="abcd";
		print(s);
	}

	
}
