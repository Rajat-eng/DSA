package LinkedList;

public class Oddeven {

	public static Node<Integer> oddeven(Node<Integer> head) {
		Node<Integer>oddhead=null;
		Node<Integer>oddtail=null;
		Node<Integer>evenhead=null;
		Node<Integer>eventail=null;
		
		while(head!=null) {
			if(head.data %2==0) {
				if(evenhead==null){
				    evenhead=head;
				    eventail=head;
				}else {
					eventail.next=head;
					eventail=eventail.next;
				}
			}
			else {
				if(oddhead==null){
				    oddhead=head;
				    oddtail=head;
				}else {
					oddtail.next=head;
					oddtail=oddtail.next;
				}
			}
			head=head.next;
		}
		
		if(oddhead==null)
			return evenhead;
		if(evenhead==null)
			return oddhead;
		
		eventail.next=null;
		oddtail.next=evenhead;
		return oddhead;
	}
	
}
