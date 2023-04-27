package LinkedList;

public class Reverse {
	
	 public static Node<Integer> reverserecursive(Node<Integer> head){
		 if(head==null||head.next==null)
			 return head;
		
		 Node<Integer> newtail=head.next;
		 Node<Integer> newhead=reverserecursive(head.next);
		 newtail.next=head;
		 head.next=null;
		 return newhead;			 
	 }
	 
	 public static Node<Integer> reverseiterative(Node<Integer> head) {
		    Node<Integer> prev=null;
	        Node<Integer> curr=head;
	        Node<Integer> fwd=null;
	        
	        while(curr!=null){
	            fwd=curr.next;
	            curr.next=prev;
	            prev=curr;
	            curr=fwd;
	        } 
	        return prev;
	 }
	 
	 public static Node<Integer> kreverse(Node<Integer> head, int k) {
		 
		 Node<Integer> prev=null;
	     Node<Integer> curr=head;
	     Node<Integer> next=null;
	     
		 int count=0;
		 while(count<k && curr!=null) {
			 next=curr.next;
	         curr.next=prev;
	         prev=curr;
	         curr=next;
	         count++;
		 }
		
		 if(next!=null)
		   head.next= kreverse(curr,k);
		
		 return prev;
	  
	 }
	 
	 public static Node<Integer> kaltreverse(Node<Integer> head, int k,boolean b) {
		 Node<Integer> prev=null;
	     Node<Integer> curr=head;
	     Node<Integer> next=null;
	     
	     if(head==null)
	    	 return null;
	     
		 int count=1;	 
		 while(count<=k && curr!=null) {
			 next=curr.next;
			 
			 if(b==true)
	         curr.next=prev;
			 
	         prev=curr;
	         curr=next;
	         count++;
		 }  
			 if(b==true) { // reverse done
				 head.next=kaltreverse(curr, k, false);
				 return prev;
			 }	 
			 else {  // no reverse done 
				 prev.next=kaltreverse(curr, k, true);
				 return head;
			 } 	 
	     } 
  }

