package BST;
import BT.BinaryTreeNode;
import BT.BTUse;

 class pair {
	int max;
	int min;
	int height;
	boolean isBST;	
	BinaryTreeNode<Integer> node;
 } 

 public class largestBST {

	public static pair largest(BinaryTreeNode<Integer> root) {
		 if(root==null) {
			 pair output=new pair();
			 output.max=Integer.MIN_VALUE;
			 output.min=Integer.MAX_VALUE;
			 output.height=0;
			 output.isBST=true;
			 output.node=null;
			 return output;
		 }
		 
		 pair lans=largest(root.left);
		 pair rans=largest(root.right);
		 
		 pair ans=new pair();
		 ans.min=Math.min(root.data, Math.min(lans.min, rans.min));
		 ans.max=Math.max(root.data, Math.max(lans.max, rans.max)); 
		 ans.isBST=(root.data>lans.max && root.data<rans.min && lans.isBST && rans.isBST);
		
		 if(ans.isBST) {
			 ans.node=root;
			 ans.height= Math.max(lans.height, rans.height) + 1;
		 }else if(lans.height>rans.height) {
			 ans.node=lans.node;
			 ans.height=lans.height;
		 }else {
			 ans.node=rans.node;
			 ans.height=rans.height;
		 }
		 return ans;
	}
	
	public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
		return largest(root).height;
	}
	
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root=BTUse.takeinput();
		BTUse.print(root);
		
	}
}
