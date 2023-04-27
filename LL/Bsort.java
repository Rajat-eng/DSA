package LinkedList;

public class Bsort {
	
	public static Node<Integer> sort(Node<Integer> head) {
		
		if(head==null)
			return null;
		Node<Integer> curr=head;
		Node<Integer> prev=null;
	    int i=0,j=0;
	    boolean swapped=false;
	    int length=size(head);
	    for(i=0;i<length-1;i++) {
	    	prev=null;
	    	curr=head;
	    	for(j=0;j<length-i-1;j++) {
	    		if(curr.data<=curr.next.data) {
	    			prev=curr;
		    		curr=curr.next;	
	    		}else {
	    			if(prev==null) {
	    				Node<Integer> fwd=curr.next;
	    				head=head.next;  // head is at current
	    				curr.next=fwd.next;
	    				fwd.next=curr;
	    				prev=fwd;
	    				
	    			}else {
	    				Node<Integer> fwd=curr.next;
	    				prev.next=fwd;
	    				curr.next=fwd.next;
	    				fwd.next=curr;
	    				prev=fwd;
	    			}
	    			swapped=true;
	    		}	
	    	}
	    	if(swapped==false)
	    		break;
	    } 	 
	     return head;
	 }
   
    public static int size(Node<Integer> head) {
    	int count=0;
		while(head!=null) {
			head=head.next;
			count++;
		}
		return count;
    }
}
