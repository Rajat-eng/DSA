package DP;

import java.util.HashSet;
import java.util.Scanner;

public class EchoString {
	
	public static int solve(String text) {
		
		HashSet<String> hs=new HashSet<>();
	    
	    for(int len=1;len<=(text.length()/2);len++)
	    {
	        int count=0;
	        for(int i=0,j=len;j<text.length();i++,j++)
	        {
	            if(text.charAt(i)==text.charAt(j))
	                count++;
	            else
	                count=0;
	            if(count==len)
	            {
	             String s=text.substring(i-len+1,i+1);
	             System.out.println("string:" + " " +s);
	                hs.add(s);
	                count--;
	            }
	        }
	    }
	    return hs.size();
	}

	    
		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			String s="abcabcab"; //cabcac  abcabc  bcabca  
			System.out.println(solve(s));
			sc.close();
			
    }
}
