package BT;

public class Constructtree {
	
	public static BinaryTreeNode<Integer> construct1(int[] pre,int psi,int pei,int[] ino, int isi,int iei){	
		
		if(isi>iei)
			return null;
		
		int index=0;
		while(ino[index]!=pre[psi]) {  
			// Preorder    root + count is left subtree
			// Inorder     left subtree <--x--> right subtree
			index++;
		}
		int count= index-isi;
		BinaryTreeNode<Integer> root= new BinaryTreeNode<Integer>(pre[psi]);
		root.left=construct1(pre, psi+1, psi+count, ino, isi, index-1); 
		root.right=construct1(pre, psi+count+1, pei, ino, index+1, iei); 
		
		return root;
	}
	
  public static BinaryTreeNode<Integer> construct2(int[] post,int psi,int pei,int[] ino, int isi,int iei){	
		
		if(isi>iei)
			return null;
		
		int index=0;
		while(ino[index]!=post[pei]) {
			index++;
		}
		int count= index-isi;
		BinaryTreeNode<Integer> root= new BinaryTreeNode<Integer>(post[pei]);
		root.left=construct2(post, psi, psi+count-1, ino, isi, index-1);
		root.right=construct2(post, psi+count, pei-1, ino, index+1, iei);
		
		return root;
  }

	public static void main(String[] args) {
		int[] preorder= {0,1,3,7,8,4,9,10,2,5,11,6};
		int[] inorder = {7,3,8,1,9,4,10,0,11,5,2,6};
		int[] postorder={7,8,3,9,10,4,1,11,5,6,2,0};
		
		int n=preorder.length;
		BinaryTreeNode<Integer> root=construct1(preorder,0,n-1,inorder,0,n-1);
		BTUse.printlevelwise(root);
	}

}
