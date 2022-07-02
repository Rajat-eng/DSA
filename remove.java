package LinkedList;

import java.util.HashMap;
import java.util.Scanner;

public class remove {
	
	public static Node<Integer> removeduplicate(Node<Integer> head){

	 if(head==null || head.next==null)
		return head;
	 
		Node<Integer> current=head;
		
		while(current.next!=null){
			if(current.data==current.next.data) {
				current.next=current.next.next;
			}
			else {
				current=current.next;
			}
		}
		 return head;
	}
	
	public static Node<Integer> removeduplicatefromunsorted(Node<Integer> head){
		if(head==null)
			return null;
		
		HashMap<Integer,Integer> map=new HashMap<>();
		Node<Integer> curr=head;
		Node<Integer> prev=null;
		while(curr!=null) {
			if(map.containsKey(curr.data)) {
				map.put(curr.data, 1+map.get(curr.data));
				prev.next=curr.next;
			}else {
				map.put(curr.data,1);
				prev=curr;
			}
			curr=curr.next;
		}
		return head;
	}
	
	public static Node<Integer> removeallduplicate(Node<Integer> head){
		Node<Integer> dummy=new Node<>(-1);
		Node<Integer> itr=dummy;
		itr.next=head;
		Node<Integer> curr=head.next;
		while(curr!=null) {
			boolean islooprun=false;
			while(curr!=null && itr.next.data==curr.data) {
				islooprun=true;
				curr=curr.next;
			}if(islooprun)
				itr.next=curr;  // potential unique element but if while loop is executed it updates to other unique potential element
			else
				itr=itr.next;  // unique element found
			if(curr!=null)
				curr=curr.next;
		}
		return dummy.next;
	}
}
