package BACKTRACK;
// Each unique char has uniquw value form 0 to 9
// Given  3 strings find if sum of first 2string is equla to 3

import java.util.*;

public class CryptarithematicPuzzle {
	
	private static void solve(String unique, int i, HashMap<Character,Integer> map,boolean [] usedNumbers, String s1, String s2, String s3) {
//		O[10^unique.length()]
		if(i==unique.length()) {
			int num1=getSum(s1,map);
			int num2=getSum(s2,map);
			int num3=getSum(s3,map);
			if(num1 + num2 == num3) {
				for(int k=0;k<26;k++) {
					//printing char in alphabetical order
					char ch=(char)('a' + k);
					if(map.containsKey(ch)) {
						System.out.print(ch + "-->" + map.get(ch) + " ");
						
					}
				}
				System.out.println();
			}
			return;
		}
		
		char ch=unique.charAt(i);
		for(int val=0;val<=9;val++) {
			if(usedNumbers[val]==false) {
				usedNumbers[val]=true;
				map.put(ch, val);
				solve(unique, i+1, map, usedNumbers, s1, s2, s3);
				usedNumbers[val]=false;
				map.put(ch,-1);
			}
		}
	}

	private static int getSum(String s, HashMap<Character,Integer> map) {
		String num="";
		for(int i=0;i<s.length();i++) {
			int val=map.get(s.charAt(i));
			num+=val;
		}
		return Integer.parseInt(num);
	}

	public static void main(String[] args) {
		String s1="send";
		String s2="more";
		String s3="money";
		HashMap<Character,Integer> map=new HashMap<Character, Integer>();
		String unique="";
		for(int i=0;i<s1.length();i++) {
			char ch=s1.charAt(i);
			if(!map.containsKey(ch)) {
				unique+=ch;
				map.put(ch, -1);
			}
		}
		
		for(int i=0;i<s2.length();i++) {
			char ch=s2.charAt(i);
			if(!map.containsKey(ch)) {
				unique+=ch;
				map.put(ch, -1);
			}
		}
		
		for(int i=0;i<s3.length();i++) {
			char ch=s3.charAt(i);
			if(!map.containsKey(ch)) {
				unique+=ch;
				map.put(ch, -1);
			}
		}
		boolean [] usedNumbers=new boolean[10]; // numbers assigned t each char can vary from 0 to 9
		solve(unique,0,map,usedNumbers,s1,s2,s3);

	}
	
}
