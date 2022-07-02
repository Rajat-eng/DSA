package LinkedList;

public class printithnode {
	public static void printIthNode(Node<Integer> head, int i){
    	int count=0;
        Node<Integer>temp=head;  
        while(temp!=null && count<i){
            count++;
            temp=temp.next;
        }
        if(temp==null)
        	return;
        System.out.println(temp.data);    
	}

}
