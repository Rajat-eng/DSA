package LinkedList;

public class palindrome {
	
	public static boolean ispalindrome(Node<Integer> head) {
		
		Node<Integer> middle=mid.Mid(head);
		Node<Integer> newhead=middle.next;
		middle.next=null;
		
		newhead=Reverse.reverseiterative(newhead);
		while(head!=null && newhead!=null) {
			if(newhead.data!=head.data)
				return false;
			head=head.next;
			newhead=newhead.next;
		}
		return true;
	   }
    }

