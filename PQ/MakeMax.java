package PQ;
import java.util.*;
import LinkedList.*;
public class MakeMax {
	//O[logn] && O[n]
	public static Node<Integer> findLargestNum(Node<Integer> head) 
    {
        PriorityQueue<Node<Integer>> pq=new PriorityQueue<Node<Integer>>((a,b)-> {return b.data-a.data;});
        while(head!=null) {
        	pq.add(head);
        	head=head.next;
        }
        Node<Integer> dummy=new Node<Integer>(-1);
        Node<Integer> itr=dummy;
        while(!pq.isEmpty()) {
        	Node<Integer> temp=pq.remove();
        	itr.next=temp;
        	itr=itr.next;
        }
        itr.next=null;
        itr=dummy.next;
        dummy.next=null;
        return itr;
    }

	public static void main(String[] args) {
		
		Node<Integer> head=LinkedListUse.takeinput();
		Node<Integer> ans=findLargestNum(head);
		LinkedListUse.print(ans);		
	}

}
