package LinkedList;

public class append {
	 public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) {
			if(n==0|| head==null)
				return head;
			Node<Integer> fast=head;
			Node<Integer> slow=head;
			Node<Integer> initialhead=head;
			for(int i=0;i<n;i++) {
				fast=fast.next;
			}
			while(fast.next!=null) {
			slow=slow.next;
			fast=fast.next;
			}
			Node<Integer> temp=slow.next;
			slow.next=null;
			fast.next=initialhead;
			return temp;

	 }

}
