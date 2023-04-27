package BACKTRACK;
// maximize score of words such that freq of selected words does not surpass freq in char array
public class maxScoreOfWords {
	
	private static int max(String[] words, char[] letters, int[] score) {
		int[] freq=new int[26];
		for(char c:letters) {
			freq[c-'a']++;
		}
		return maxhelper(words,freq,score,0);
	}

	private static int maxhelper(String[] words, int[] freq, int[] score, int i) {
//		O[2^words]
		if(i==words.length) {
			return 0;	
		}
		int scoreexcluded=0+maxhelper(words,freq,score,1+i); 
		String word=words[i];
		boolean iswordjustified=true;
		int currscore=0;
		for(int j=0;j<word.length();j++) {
			char ch=word.charAt(j);
			if(freq[ch-'a']==0) {
				iswordjustified=false;
			}
			freq[ch-'a']--;
			currscore+=score[ch-'a'];
		}
		int scoreincluded=0;
		if(iswordjustified) {
			scoreincluded=currscore+maxhelper(words, freq, score,i+1);
		}
		//  freq of words discarded or to be used elsewhere
		for(int j=0;j<word.length();j++) {
			char ch=word.charAt(j);
			freq[ch-'a']++;
		}
		
		return Math.max(scoreexcluded,scoreincluded );
	}

	public static void main(String[] args) {
		 String words[] = { "dog", "cat", "dad", "good" };
	     char letters[] = { 'a', 'a', 'c', 'd', 'd','d', 'g', 'o', 'o' };
	     int  score[]= { 1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	     int ans=max(words,letters,score);
	     System.out.println(ans);
	}

	

}
