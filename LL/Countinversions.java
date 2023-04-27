package LinkedList;

class Number{
	long num;
	Number(long num){
		this.num=num;
	}
}

public class Countinversions {
	
	public static Node<Integer> mid(Node<Integer> head,Number countinleft){
		if(head==null)
			return head;
		
		countinleft.num=1;
   	    Node<Integer> fast=head;
        Node<Integer> slow=head;
        while(fast.next!=null && fast.next.next!=null){
        	countinleft.num++; // counting elements till mid
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
	}
	
	public static Node<Integer> merge(Node<Integer> head1,Node<Integer> head2,Number countinleft,Number countinversions) {
		
		if(head1==null || head2==null)
			return head1!=null ? head1:head2;
		
		Node<Integer> dummy= new Node<>(-1);
		Node<Integer> result=dummy;
		System.out.println(head1.data +"*" +head2.data + " "+ countinleft.num);
		int currentposinleft=0;
		while(head1!=null && head2!=null) {
			if(head1.data<=head2.data) {
				currentposinleft++;
				result.next=head1;
				result=result.next;
				head1=head1.next;
			}else {
				countinversions.num += countinleft.num - currentposinleft;
				result.next=head2;
				result=result.next;
				head2=head2.next;
			}
		}
		if(head1!=null)
			result.next=head1;
		if(head2!=null)
			result.next=head2;
		
		result=dummy.next;
		dummy.next=null;
		
		return result;
	}
		
	public static Node<Integer> mergesort(Node<Integer> head,Number countinversions){
		if(head.next==null || head==null )
			return head;
		Number countinleft=new Number(0);
		Node <Integer> middle=mid(head,countinleft);
		Node<Integer> head1=head;
		Node <Integer> head2= middle.next;
		middle.next=null;
		Node<Integer> left = mergesort(head1,countinversions);
		
		Node<Integer> right= mergesort(head2,countinversions);
	
		head=merge(left, right,countinleft,countinversions);
		
		return head;
	}
	
	public static long count(Node<Integer> head) {
		
		if(head==null|| head.next==null)
			return 0;
		
		Number countinversions=new Number(0L);
		head=mergesort(head,countinversions);
		LinkedListUse.print(head);
		return countinversions.num;
	}

	public static void main(String[] args) {
		Node<Integer> head=LinkedListUse.takeinput();
		long ans= count(head);
		System.out.println();
		System.out.println(ans);
	}

}
