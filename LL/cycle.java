package LinkedList;

public class cycle {
	
	public static boolean iscyclepresent(Node<Integer> head) {
		if(head==null||head.next==null) 
			return false;
		Node<Integer> fast=head;
		Node<Integer> slow=head;
		while(fast!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow)
				return true;
		}
		return false;	
	}
	
	public static Node<Integer> findpointsincycle(Node<Integer> head) {
		if(head==null||head.next==null) 
			return null;
		
		Node<Integer> fast=head;
		Node<Integer> slow=head;
		while(fast!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow)
				return fast;
		}
		if(slow!=fast) return null;
		
		Node<Integer> meeting=fast;
		slow=head;
		while(slow!=fast) {
			slow=slow.next;
			fast=fast.next;
		}
		return slow; //or fast is starting point of loop
	}

	public static void main(String[] args) {
		Node<Integer> head=LinkedListUse.takeinput();
	}

}
