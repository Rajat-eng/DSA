package LinkedList;

public class Intersection {
	
	public static Node<Integer> find(Node<Integer> head1,Node<Integer> head2){
		Node<Integer> t1=head1;
		Node<Integer> t2=head2;
		int l1=LinkedListUse.length(t1);
		int l2=LinkedListUse.length(t2);
		int delta=Math.abs(l1-l2);
		if(l1>l2) {
			for(int i=0;i<delta;i++) {
				t1=t1.next;
			}
		}else {
			for(int i=0;i<delta;i++) {
				t2=t2.next;
			}
		}
		while(t1!=t2) {
			t1=t1.next;
			t2=t2.next;
		}
		return t1;
	}

	public static void main(String[] args) {
		Node<Integer> head1=LinkedListUse.takeinput();
		Node<Integer> head2=LinkedListUse.takeinput();
		Node<Integer> ans=find(head1, head2);
		System.out.println(ans.data);
	}

}
