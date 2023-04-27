package BST;

import BT.*;
import LinkedList.*;
import java.util.*;
import java.util.LinkedList;

 class Nodepair{
	Node<Integer> head;
	Node<Integer> tail;
 }
 
public class flatten {
	
	public static Node<Integer> construct1(BinaryTreeNode<Integer> root){
		ArrayList<Integer> element=new ArrayList<>();
		order(root,element);  // O[n]
//		Collections.sort(element); //  O[nlogn]
		Node<Integer> head=null;
		for(int i=element.size()-1;i>=0;i--) {
			head=insert(head,element.get(i));
		}
		return head;
	}
	
	public static Node<Integer> insert(Node<Integer> head,int element) {
		Node<Integer> temp = new Node<>(-1);
		temp.data=element;
		temp.next=head;
		head=temp;
		return head;
	}
	
	public static void order(BinaryTreeNode<Integer> root, ArrayList<Integer> list) {
		if(root==null)
			return;
		order(root.left,list);
		list.add(root.data);
		order(root.right,list);			
	}
	
	public static Nodepair get(BinaryTreeNode<Integer> root) {
//		suitable for BST --> Linked list in sorted way
		if(root==null) {
			Nodepair nodepair=new Nodepair();
			return nodepair;
		}
		Node<Integer> newnode=new Node<>(root.data);
		Nodepair lans= get(root.left);		
		Nodepair rans= get(root.right);
		
		Nodepair ans= new Nodepair();
		if(lans.tail!=null) {
			lans.tail.next=newnode;
		}
		newnode.next=rans.head;
		if(lans.head!=null) {
			ans.head=lans.head;
		}else {
			ans.head=newnode;
		}
		if(rans.tail!=null) {
			ans.tail=rans.tail;
		}else {
			ans.tail=newnode;
		}	
		
		return ans;
	}
	
	public static Node<Integer> construct2(BinaryTreeNode<Integer> root){
		return get(root).head;
	}
	

	public static void main(String[] args) {
//	    5 4 8 -1 -1 7 10 -1 -1 9 -1 -1 -1 
		BinaryTreeNode<Integer> root=BTUse.takeinput();
		BTUse.print(root);
		Node<Integer> head=construct2(root);
		LinkedListUse.print(head);
	}

}
