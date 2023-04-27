package Trie;

import java.util.*;

public class Trie {

	private TrieNode root;
	private int numWords;
	
	public Trie() {
		root=new TrieNode('\0');
		numWords=0;
	}
	
	private void add(TrieNode root,String word) {
		if(word.length()==0) {
			if(root.isTerminating) {
				root.prefixCount++;
				root.endFrequency++;
				return;
			}else {
				root.prefixCount++;
				root.endFrequency++;
				root.isTerminating=true;
				return;
			}		
		}
		root.prefixCount++;
		int childindex=word.charAt(0)-'a';
		TrieNode child=root.children[childindex];
		if(child==null) {
			child=new TrieNode(word.charAt(0));
			root.children[childindex]=child;
			root.childCount++;
		}
		add(child,word.substring(1));	
	}
	
	public void add(String word) {
		add(this.root,word);
			numWords++;	
	}
	
	private boolean search(TrieNode root,String word) {
		if(word.length()==0)
			return root.isTerminating;
		int childindex=word.charAt(0)-'a';
		TrieNode child=root.children[childindex];
		if(child==null) {
			return false;
		}
		return search(child, word.substring(1));
	}
	
    public boolean search(String word) {
		return search(root,word);
	}
	
    private boolean startsWith(TrieNode root,String word) {
		if(word.length()==0)
			return true;
		
		int childindex=word.charAt(0)-'a';
		TrieNode child=root.children[childindex];
		if(child==null) {
			return false;
		}
		boolean ans=startsWith(child, word.substring(1));
		return ans;
	}
    
    public boolean startsWith(String word) {
    	return startsWith(root, word);
    }
	
	private void remove(TrieNode root,String word) {
		if(word.length()==0){
			if(root.endFrequency==1) {
				root.endFrequency--;
				root.prefixCount--;
				root.isTerminating=false;
				return;
			}
			else {
				root.endFrequency--;
				root.prefixCount--;
				return;
			}
		}
		int childindex=word.charAt(0)-'a';
		TrieNode child=root.children[childindex];
		if(child!=null) {
			root.prefixCount--;
		}else {
			return;
		}
		remove(child,word.substring(1));
		if(!child.isTerminating && child.childCount==0) {
			root.children[childindex]=null;
			child=null;
			root.childCount--;
		}
	}
	
	public void remove(String word) {
		remove(root,word); 
			numWords--;
		
	}
	
    public int countWords() {
		return numWords; 	
	}
    
    public int countWordsEqualTo(TrieNode root,String word) {
    	if(word.length()==0) {
    		return root.endFrequency;
    	}
    	int childindex=word.charAt(0)-'a';
		TrieNode child=root.children[childindex];
		if(child==null) {
			return 0;
		}
		return countWordsEqualTo(child,word.substring(1));
    }
    
    public int countWordsEqualTo(String word) {
    	return countWordsEqualTo(root, word);
     }
	    
    private int countWordsStartingWith(TrieNode root,String word) {
    	
    	if(word.length()==0) {
    		return root.prefixCount;
    	}
    	int childindex=word.charAt(0)-'a';
    	TrieNode child=root.children[childindex];
    	if(child==null)
    		return 0;
    	
    	return countWordsStartingWith(child,word.substring(1));
    }
    
    public int countWordsStartingWith(String word) {
    	return countWordsStartingWith(root, word);
    }
    
    public String longestCommonPrefix(String[] arr) {
    	
    	root= new TrieNode('\0');
    	for(int i=0;i<arr.length;i++) {
    		String word=arr[i];
    		add(root,word);
    	}
    	
    	String answer="";
    	for(int idx=0;idx<arr[0].length();idx++) {
    		
    		if(root.childCount==1) {
    			answer+=arr[0].charAt(idx);
    			int diff=arr[0].charAt(idx)-'a';
    			root=root.children[diff];
    		}else {
    			break;
    		}
    		if(root.isTerminating)
    			break;
    	}
    	return answer;
    }
    
    private void print(TrieNode root, String word) {
		if (root == null) {
			return;
		}
		
		if (root.isTerminating) {
			System.out.println(word);
		}
		
		for (TrieNode child : root.children) {
			if (child == null) {
				continue;
			}
			String fwd = word + child.data;
			print(child, fwd);
		}
	}
	
	public void printstartingwith(String word) {
		for(int i=0;i<word.length();i++) {
			int idx=word.charAt(i)-'a';
			TrieNode child=root.children[idx];
			root=child;
		}
		print(root,word);
	}
    
	public int countPalindromicPair(ArrayList<String> words) {
		for(String word: words) {
			StringBuilder input=new StringBuilder();
			input.append(word);
			input.reverse();
			add(root,input.toString());
		}
		
		return isPalindromepair(root,words);
	}
	
	private int isPalindromepair(TrieNode root,ArrayList<String> words) {
		int count=0;
		if(words.size()==0 || words==null) {
			return 0;
		}
		for(String word: words) {
			if(doespairexist(root, word, 0)) {
				count++;
			}
		}
		return count;
	}
	
	private boolean doespairexist(TrieNode root,String word,int startindex) {
		
		if(startindex==word.length()) {
			if(root.isTerminating)
				return true;
			
			return checkremaininTrie(root,"");
		}
		int childindex=word.charAt(startindex)-'a';
		TrieNode child= root.children[childindex];
		if(child==null) {
			if(root.isTerminating)
				return ispalindrome(word.substring(startindex)); // {abcm.cba}
				
			return false;
		}
		return doespairexist(child, word, 1+startindex);
	}
	
	private boolean checkremaininTrie(TrieNode root,String word) {
		
		if(root.isTerminating) {
			return ispalindrome(word);
		}
		for(TrieNode child: root.children) {
			if(child==null)
				continue;
			String fwd=word+child.data;
			if(checkremaininTrie(child,fwd)) {
				return true;
			}		
		}	
		return false;
	}
	
	private boolean ispalindrome(String input) {
		int si=0;
		int ei=input.length()-1;
		while(si<ei) {
			if(input.charAt(si)!=input.charAt(ei))
				return false;
		}
		return true;
	}
 }
