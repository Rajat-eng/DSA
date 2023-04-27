import java.util.Scanner;
public class reverseeachword {
	public static String reverseEachWord(String str) {
		int i=0,j=0; 
        String ans="";
        String reversed="";
        int start=0;
        int end;
        for(i=0;i<str.length();i++) {
             reversed="";
            if(str.charAt(i)==' '){
                end=i-1;
            for(j=start;j<=end;j++){
                reversed=str.charAt(j)+reversed;
            }
            start=i+1;
            ans+=reversed+ " " ;  // reversed
            }     
        }   
       for(j=start;j<str.length();j++)
        {
            reversed=str.charAt(j)+reversed;
        }
        ans+= reversed + " ";
        return ans;
	}

	public static void main(String[] args) {
	String str=" abc def ghi jkl mno";
	String ans=reverseEachWord(str);
	System.out.println(ans);
	}

}
