package BST;

import BT.BTUse;
import BT.BinaryTreeNode;
import LinkedList.Node;
public class construct {

	public static BinaryTreeNode<Integer> construct(int[] arr, int n, int si, int ei){
        if(si>ei)
            return null;
        int mid=(si+ei)/2;
        int data=arr[mid];
        BinaryTreeNode<Integer> newnode=new BinaryTreeNode<>(data);
        newnode.left=construct(arr,n,si,mid-1);
        newnode.right=construct(arr,n,mid+1,ei);
        return newnode;
    }
	
	public static BinaryTreeNode<Integer> sortedListToBST(Node<Integer> head){
		 if(head==null) return null;
   	
        return toBST(head,null);
	}
   
   
	public static BinaryTreeNode<Integer> toBST(Node<Integer> head, Node<Integer> tail){
		Node<Integer> slow = head;
		Node<Integer> fast = head;
		if(head==tail) return null;
   
		while(fast!=tail&&fast.next!=tail){
			fast = fast.next.next;
			slow = slow.next;
		}
		BinaryTreeNode<Integer> thead = new BinaryTreeNode<Integer>(slow.data);
		thead.left = toBST(head,slow);
		thead.right = toBST(slow.next,tail);
		return thead;
	}
	
	
	public static void main(String[] args) {
		int [] arr= {2,3,5,9,10,15,18,29};
		BinaryTreeNode<Integer> root= construct(arr, arr.length, 0, arr.length-1);
		BTUse.print(root);


	}

}
