package LinkedList;

public class mid {
	
	public static Node<Integer> Mid(Node<Integer>head){
		if(head==null)
			return head;
   	    Node<Integer> fast=head;
        Node<Integer> slow=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
