package LinkedList;

public class skipdelete {
	
	public static Node<Integer> skip(Node<Integer> head,int M,int N) {
		
		int i=0;
        int j=0;
        if(M==0)
            return null;  // Nothing to retain
        if(N==0)
        	return head;  // Nothing to delete
        
		Node<Integer> head1=head;
	    Node<Integer> head2=null;
		while(head1!=null) {
		
		while(i<M-1  && head1!=null){
			head1=head1.next;
			i++;
			}
		
        head2=head1.next;
		
		while(j<N && head2!=null) {
			head2=head2.next;
			j++;
			}
		head1.next=head2;
		head1=head2;
		i=j=0;
		}
		return head;
	}
	
	public static Node<Integer> pairSwap(Node<Integer> head) {
		if(head==null)
			return null;
		Node<Integer> t1=head;
		Node<Integer> t2=head.next;
		while(t1!=null && t2!=null) {
			int temp=t1.data;
			t1.data=t2.data;
			t2.data=temp;
			t1=t1.next.next;
			if(t2.next!=null)
			t2=t2.next.next;
		}
		return head;
	}

}
