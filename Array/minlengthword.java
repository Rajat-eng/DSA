
public class minlengthword {
	public static String minLengthWord(String input) {
	int currentwordstart=0,minstart=-1;
	int currentwordlength=0;
	int minlength=Integer.MAX_VALUE;
	int i=0,n=input.length();
	for(i=0;i<n;i++) {
		if(input.charAt(i)==' ') {
			currentwordlength=i-currentwordstart;         //  calculating length of each word
			if(currentwordlength<minlength) {
				minlength=currentwordlength; 			  //  storing length of min word in string
				minstart=currentwordstart;                //  storing starting character of min word in string
			}
			currentwordstart=i+1;                          
		}
		else
			continue;
	 }
	currentwordlength=i-currentwordstart;                  // for last word 
	if(currentwordlength<minlength) {
		minlength=currentwordlength;
		minstart=currentwordstart;
	 }
	
	  String ans=input.substring(minstart,minstart + minlength);
	  return ans;
	 }
	
	
	public static void main(String[] args) {
		String s="this iss test string zt";
		 System.out.println(minLengthWord(s));

	}

}
