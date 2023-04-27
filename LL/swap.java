package LinkedList;

public class swap {
	
	public static Node<Integer> exchange(Node<Integer> head, int i,int j){
		
		if(head==null || (i==0 && j==0))
			return null;
		
		if(i==j && i!=0)
			return head;
		
		if(i<j)
			return helper(head,i,j);
		
		else
			return helper(head, j, i);
		
	}
		
		public static Node<Integer> helper(Node<Integer> head,int i,int j){
			Node<Integer> p1=null,p2=null;
			Node<Integer> c1=head,c2=head;
			Node<Integer> temp= null;
			int count=0;

			if(i==0) {
				if(j==1) {  // i=0 j=1
					c1=head.next;
					c2=c1.next;
					c1.next=head;
					head.next=c2;
					return c1;
				}else {     // i=0  j=3
					while(count<j) {
						count++;
						p1=c1;
						c1=c1.next;
					}
					c2=c1.next;
				    c1.next=head.next; 
				    p1.next=head;
				    head.next=c2;
					return c1;
				}
			} else {
				if(j==1+i) {  //  i=2 j=3
					while(count<i) {
						p1=c1;
						c1=c1.next;
						count++;
					}
					c2=c1.next;
					temp=c2.next;
					p1.next=c2;
					c2.next=c1;
					c1.next=temp;
					return head;
				}else {       //  i=2 j=5
					while(count<i) {
						p1=c1;
						c1=p1.next;
						count++;
					}
					count=0;
					while(count<j) {
						p2=c2;
						c2=p2.next;
						count++;
					}
					temp=c2.next;
					p1.next=c2;
					c2.next=c1.next;
					p2.next=c1;
					c1.next=temp;
					
					return head;
				 }	
			}
		}

 }
		
		
		  
	   
	
			
	


