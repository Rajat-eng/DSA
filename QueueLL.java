package Queue;

public class QueueLL<T> {
    private Node<T> front;
    private Node<T> rear;
    int size;
    
    public QueueLL(){
    	front=rear=null;
    	size=0;
    }
    
    int size() {
		return size;
	}
	
	boolean isEmpty() {
		return size()==0;
	}

	T front() {
		if(size()==0) {
			return null;
		}
		return front.data;
	}
	
	void enqueue(T element) {
		Node<T> newnode=new Node<T>(element);
		if(rear==null) {
			front=newnode;
			rear=newnode;
		}else {
			rear.next=newnode;
			rear=newnode;
		}
		size++;
	}
	
	T dequeue() {
		if(size()==0) {
		   return null;	
		}
		T temp=front.data;
		front=front.next;
		if(size()==1) {
			rear=null;
		}
		size--;
		return temp;
	}

}

