package Trie;
import java.util.*;
public class TrieUse {

	public static void main(String[] args) {
		Trie t=new Trie();
		t.add("not");
		t.add("no");
		t.add("note");
		t.add("notes");	
		t.printstartingwith("no");
	}
}
