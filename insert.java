package LinkedList;

public class insert {

    public static Node<Integer> insert(Node<Integer> head, int element,int pos) {
    	
    	int i=0;
    	Node<Integer> newnode= new Node<>(element);
    	if(pos==0) {
    		newnode.next=head;
    		return newnode;
    	}		
    	Node<Integer>temp=head;
    	while(i<pos-1) {
    		temp=temp.next;
    		i++;
    	}
    	newnode.next=temp.next;
    	temp.next=newnode;
    	return head;
    }
    
    public static Node<Integer> insertrecursive(Node<Integer> head, int element,int pos){
    	if(pos==0) {
    		Node<Integer> newnode=new Node<>(element);
    		newnode.next=head;
    		return newnode;
    	}
    	if(head.next==null && pos!=0)
			return head;
    	
    	head.next=insertrecursive(head.next, element, pos-1);
    	return head;
    }

}
