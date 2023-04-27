package Trie;

public class TrieNode {

	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;
	int prefixCount;
	int endFrequency;
	
	TrieNode(char data){
		this.data=data;
		this.isTerminating=false;
		children=new TrieNode[26];
		childCount=0;;
	}
}
