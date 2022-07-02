package LinkedList;

public class segregate012 {
	
	public static Node<Integer> sort012(Node<Integer> head){
		Node<Integer> zero=new Node<>(-1);
		Node<Integer> pz=zero;
		
		Node<Integer> one=new Node<>(-1);
		Node<Integer> po=one;
		
		Node<Integer> two=new Node<>(-1);
		Node<Integer> pt=two;
		
		Node<Integer> curr=head;
		while(curr!=null) {
			if(curr.data==0) {
				pz.next=curr;
				pz=pz.next;
			}else if(curr.data==1) {
				po.next=curr;
				po=po.next;
			}else {
				pt.next=curr;
				pt=pt.next;
			}
			curr=curr.next;
		}
		po.next=two.next;
		pz.next=one.next;  
		// if reverse order the 2 2 2 -1 is null  
		pt.next=null;
		
		return zero.next;
	}
	
	
	public static Node<Integer> pivot (Node<Integer> head,int pivotindx){
		int index=0,info=0;
		Node<Integer> curr=head;
		Node<Integer> pivot=head;
		Node<Integer> small=new Node<>(-1);
		Node<Integer> ps=small;
		Node<Integer> large=new Node<>(-1);
		Node<Integer> pl=large;
		
		while(pivot!=null) {
			if(index==pivotindx) {
				info=pivot.data;
				break;
			}
			index++;
			pivot=pivot.next;
		}
		while(curr!=null) {
			if(curr==pivot){
				curr=curr.next;
				continue;
			}
		    else if(curr.data<=info) {
				ps.next=curr;
				ps=ps.next;
			}else {
				pl.next=curr;
				pl=pl.next;
			}
			curr=curr.next;
		}
		ps.next=pivot;
		pivot.next=large.next;
		pl.next=null;
		return small.next;
	}
	
}
