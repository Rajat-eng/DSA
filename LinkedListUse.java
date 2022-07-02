package LinkedList;
import java.util.Scanner;

public class LinkedListUse {
	
	public static Node<Integer> takeinput() {
		Node<Integer>head=null;
		Node<Integer>tail=null;
		Scanner sc=new Scanner(System.in);
		int data=sc.nextInt();
		while(data!=-1) {
		Node<Integer> newnode=new Node<>(data);
		if(tail==null) {
			head=newnode;
			tail=newnode;
		}
		else {
			tail.next=newnode;
			tail=newnode;   //tail=tail.next
		}
		data=sc.nextInt();
		}
		return head;
	}
	
	public static void print(Node<Integer> head) {
		
		while(head!=null) {
			System.out.print(head.data + " ");
			head=head.next;
		}
	}
	
	public static int length(Node<Integer> head) {
		int count=0;
		while(head!=null) {
			head=head.next;
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {  
		Node<Integer> head=takeinput();
		Node<Integer> ans=mergesort.mergeSort(head);
		print(ans);
		
	
	}

}
