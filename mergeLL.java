package LinkedList;

public class mergeLL {
	
	public static Node<Integer> mergeTwoSortedLinkedLists(Node<Integer> head1, Node<Integer> head2) {

        if(head1==null || head2==null)
    	return head1!=null ? head1:head2;
        
        
        if(head1.data<head2.data) {
        	head1.next=mergeTwoSortedLinkedLists(head1.next, head2);
        	return head1;
        } 
        else {
        	head2.next=mergeTwoSortedLinkedLists(head1, head2.next);
        	return head2;
        }
    }
	
	
}
