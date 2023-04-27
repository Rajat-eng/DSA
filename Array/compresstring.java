

public class compresstring {
	
	public static String compress(String str) {
		int startindex=0;
		int endindex=0;
		String ans="";
		int count=0;
		while(startindex<str.length()) {
		while(endindex<str.length() && str.charAt(startindex)==str.charAt(endindex)) {
			endindex++;	
		}
		count=endindex-startindex;
		if(count==1)
		ans+=str.charAt(startindex);
		else
			ans+=str.charAt(startindex) + "" +count;
		startindex=endindex;
		}
		return ans;
	}
	

	public static void main(String[] args) {
		String s="aaabbbccddaae";
		compress(s);
	}
	
}
