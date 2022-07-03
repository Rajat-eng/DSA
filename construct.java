package BST;

import BT.BTUse;
import BT.BinaryTreeNode;

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
	
	
	public static void main(String[] args) {
		int [] arr= {2,3,5,9,10,15,18,29};
		BinaryTreeNode<Integer> root= construct(arr, arr.length, 0, arr.length-1);
		BTUse.print(root);


	}

}
