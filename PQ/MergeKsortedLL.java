package PQ;
import java.util.PriorityQueue;
import java.util.ArrayList;
import LinkedList.Node;
import LinkedList.LinkedListUse;
public class MergeKsortedLL {
	
	public static Node<Integer> MergeKLists(ArrayList<Node<Integer>> lists) {
		PriorityQueue<Node<Integer>> pq=new PriorityQueue<Node<Integer>>((a,b)->{return a.data-b.data;});
		Node<Integer> dummy= new Node<Integer>(-1);
		Node<Integer> prev=dummy;
		for(Node<Integer> curr: lists) {
			if(curr!=null)
			pq.add(curr);
		}
		while(pq.isEmpty()) {
			Node<Integer> x=pq.remove();
			prev.next=x;
			prev=prev.next;
			x=x.next;
			if(x!=null)
			pq.add(x);	
		}	
		return dummy.next;
	}

	public static void main(String[] args) {
		Node<Integer> head1=LinkedListUse.takeinput();
		Node<Integer> head2=LinkedListUse.takeinput();
		Node<Integer> head3=LinkedListUse.takeinput();
		ArrayList<Node<Integer>> a=new ArrayList<Node<Integer>>();
		a.add(head1);
		a.add(head2);
		a.add(head3);
		Node<Integer> result=MergeKLists(a);
		LinkedListUse.print(result);
	}
}
