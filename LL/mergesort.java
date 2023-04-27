package LinkedList;

public class mergesort {
	
	public static Node<Integer> mergeSort(Node<Integer> head){
		if(head.next==null || head==null )
			return head;
		Node <Integer> middle=mid.Mid(head);
		Node<Integer> head1=head;
		Node <Integer> head2= middle.next;
		middle.next=null;
		Node<Integer> left=mergeSort(head1);
		Node<Integer> right=mergeSort(head2);
		head=mergeLL.mergeTwoSortedLinkedLists(left, right);
		return head;
	}

}
