package DLL;

public class LinkedList {
	
	private Node head=null;
	private Node tail=null;
	private int size=0;
	
	public LinkedList() {
		this.head=null;
		this.tail=null;
		this.size=0;
				
	}
	
	public boolean isEmpty() {
		return getSize()==0;
	}
	
	public int getSize() {
		return size;
	}
	
	private void addFirst(Node x) {
		
		if(this.size==0) {
			head=x;
			tail=x;
		}else {
			x.next=this.head;
			this.head.prev=x;
			this.head=x;
		}
		this.size++;
	}
	
	public void addFirst(int data) {
		Node newnode=new Node(data);
		addFirst(newnode);
	}
	
	private Node removeFirstNode() {
		Node temp=head;
		if(this.size==1) {
			head=null;
			tail=null;
		}
		else {
			Node fwd=temp.next;
			head.next=null;
			fwd.prev=null;
			this.head=fwd;
		}
		this.size--;
		return temp;
	}
	
	public Node removeFirst() {
		if(this.size==0) {
			System.out.println("Lis is empty");
			return null;
		}
		return removeFirstNode();
	}

	private void addLast(Node newnode) {
		if(this.size==0) {
			addFirst(newnode);
		}
		else {
			tail.next=newnode;
			newnode.prev=tail;
			tail=newnode;
			this.size++;
		}
	}
	
	public void addLast(int data) {
		Node n=new Node(data);
		addLast(n);
	}
	
    private Node removeLastNode() {
		Node temp=this.tail;
		if(this.size==1) {
	         head=null;
			tail=null;
		}
		else {
			Node previous=temp.prev;
			temp.prev=null;
			previous.next=null;
			this.tail=previous;
		}
		this.size--;
		return temp;
	}
	
	public Node removeLast() {
		if(this.size==0) {
			System.out.println("Lis is empty");
			return null;
		}
		return removeLastNode();
	}
	
	private Node getNodeAt(int index) {
		if(index<0 || index>getSize()) {
			System.out.println("Invalid index");
			return null;
		}
		Node curr=this.head;
		while(index-->0) {
			curr=curr.next;
		}
		return curr;
	}
	
	private void addNodeAt(int index,Node newnode) {
		if(index==getSize()) {
			addLast(newnode);
		}else if(index==0) {
			addFirst(newnode);
		}else {
			Node fwd= getNodeAt(index);
			Node prev=fwd.prev;
			prev.next=newnode;
			newnode.prev=prev;
			newnode.next=fwd;
			fwd.prev=newnode;
			this.size++;
		}	
	}
	
	public void addAt(int index,int data) {
		if(index<0 || index>getSize()) {
			System.out.println("Invalid index");
			return;
		}
		Node n=new Node(data);	
		addNodeAt(index, n);
	}
	
	public Node removeAt(int index) {
		if(index<0 || index>getSize()) {
			System.out.println("Invalid index");
			return null;
		}
		if(index==0) {
			return removeFirstNode();
		}else if(index==this.size-1) {
			return removeLastNode();
		}else {
			Node curr=getNodeAt(index);
			Node prev=curr.prev;
			Node fwd=curr.next;
			prev.next=fwd;
			fwd.prev=curr;
			curr.next=null;
			curr.prev=null;
			this.size--;
			return curr;
		}	
	}
	
	public void addBefore(Node ref,int data) {
		Node newnode=new Node(data);
		Node prev=ref.prev;
		if(prev==null) {
			newnode.next=ref;
			ref.prev=newnode;
			this.head=newnode;
		}else {
			prev.next=newnode;
			newnode.prev=prev;
			ref.prev=newnode;
			newnode.next=ref;
		}
		this.size++;
	}
	
	public Node removeAfter(Node ref) {
		Node forw=ref.next;
		if(forw==null) {// tailNode
			ref.next=null;
			tail.prev=null;
			this.tail=ref;
		}else {
			Node temp=forw.next;
			ref.next=temp;
			temp.prev=ref;
			forw.prev=forw.next=null;
		}
		return forw;
	}

}


