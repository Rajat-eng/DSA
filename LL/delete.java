package LinkedList;

public class delete {

	    public static Node<Integer> deletenode(Node<Integer> head,int pos){

		    	int i=0;
		    	if(head==null)
		    		return null;
		    	Node<Integer> temp=head;
		    	
		    	if(pos==0)
		    		return temp.next;
		    	
		    	while(i<pos-1 && temp.next!=null) {
		    		temp=temp.next;
		    		i++;
		    	}
		    	if(temp.next!=null)
		    		temp.next=temp.next.next;
		    
		    	return head;
		    }
	    
	    public static Node<Integer> deleteNodes(Node<Integer> head) {  
	        if(head==null|| head.next==null)
	            return head;
	        Node<Integer> nextnode=deleteNodes(head.next);
	        
	        if(nextnode.data>head.data)
	    	   return nextnode;
	       
	        head.next=nextnode;
	       
	        return head;   
	    }

	    public static Node<Integer> deleterecursive(Node<Integer> head,int pos){
	    	
	    if(pos==0) {
	    	return head.next;	
	    }
		if(head.next==null && pos!=0)
			return head;
		
	    head.next=deleterecursive(head.next, pos-1);
	    return head;
	   
	  }
	    
	    public static void main(String args[]) {
	    	
	    	Node<Integer> head=LinkedListUse.takeinput();
	    	Node <Integer> ans=deleteNodes(head);
	    	LinkedListUse.print(ans);
	    	
	    }
  
 }


