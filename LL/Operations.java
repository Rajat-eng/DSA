package LinkedList;

public class Operations {
	
	public static Node<Integer> addition(Node<Integer> head1,Node<Integer>head2){
		if(head1==null || head2==null ) 
			return head1!=null ? head1:head2;
		
		Node<Integer> c1= Reverse.reverseiterative(head1);
		Node<Integer> c2= Reverse.reverseiterative(head2);
		Node<Integer> itr=new Node<>(-1);
		Node<Integer> ans=itr;
		int carry=0;
		
		while(c1!=null||c2!=null||carry!=0) {
			
			int sum=carry + (c1!=null ? c1.data:0) +  (c2!=null ? c2.data:0);
		
		int lastdigit=sum%10;
		carry=sum/10;
		Node<Integer> ld= new Node<>(lastdigit);
		itr.next=ld; 
		itr=itr.next;
		if(c1!=null)
			c1=c1.next;
		if(c2!=null)
			c2=c2.next;
		}
		return Reverse.reverseiterative(ans.next);
    }

	public static Node<Integer> subtract(Node<Integer> head1,Node<Integer>head2){
		if(head1==null) {
			head2.data=-head2.data;
			return head2;
		}
		if(head2==null) {
			return head1;
		}
		
		Node<Integer> c1= Reverse.reverseiterative(head1);
		Node<Integer> c2= Reverse.reverseiterative(head2);
		Node<Integer> itr=new Node<>(-1);
		Node<Integer> ans=itr;
		int borrow=0;
		while(c1!=null) {
			int diff=borrow + (c1!=null ? c1.data:0) - (c2!=null ? c2.data:0);
			if(diff<0) {
				borrow=-1;
				diff+=10;
			}
			else {
				borrow=0;
			}
			itr.next=new Node<>(diff);
			itr=itr.next;
			c1=c1.next;
			if(c2!=null)
				c2=c2.next;
		}
		return Reverse.reverseiterative(ans.next);
	}

}
