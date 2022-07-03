package Stacks;

public class stackuse<T> {
	
	private Node<T> head;
	private int size;
	
	public stackuse() {
		head=null;
		size=0;
	}
	
	int size() {
		return size;
	}
	
	T top()    { 
		if(size()==0) {
			return null;
		}	
		return head.data;	
	}
	
	boolean isEmpty() {
		return size()==0;
	}
	
	void push(T element) {
		Node<T> newnode= new Node<T>(element);
		newnode.next=head;
		head=newnode;
		size++;
	}
	
	T pop()  {
		if(size()==0) {
			return null;
		} 	
		T tempdata=head.data; 
		head=head.next;
		size--;
		return tempdata;	
	}
	
}
