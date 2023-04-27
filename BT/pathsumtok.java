package BT;

public class pathsumtok {
static final int mod=1000000007;
static long totalsum=0;
	public static void pathsum1(BinaryTreeNode<Integer> root,int sum,String input) {
		if(root==null)
			return;
		// all path from root to leaf
		if(root.left==null & root.right==null) {
			sum+=root.data;
			System.out.println(input + root.data);
			return;
		}
		
		pathsum1(root.left, sum+root.data,input+root.data + " ");
		pathsum1(root.right,sum+root.data,input+root.data + " ");
			
	}
	
	public static void pathsum2(BinaryTreeNode<Integer> root,int sum,int k,String input) {
		if(root==null)
			return;
		// all path from root to leaf
		if(root.left==null & root.right==null) {
			sum+=root.data;
			if(sum==k) {
			System.out.print(input + root.data);
			}
			System.out.println();
			return;
		}
		
		pathsum2(root.left, sum+root.data,k,input+root.data + " ");
		pathsum2(root.right,sum+root.data,k,input+root.data + " ");		
	}
	
	public static void pathsum3(BinaryTreeNode<Integer> root,long currsum) {
//		1
//	  2    3
//   12 + 13=25
		if(root==null)
			return;
		
		if(root.left==null && root.right==null) {
			currsum=(currsum*10 +root.data)%mod;
			totalsum+=currsum%mod;
			return;
		}
		
		currsum=(currsum*10 + root.data)%mod;
		
		pathsum3(root.left, currsum);
		pathsum3(root.right,currsum);
			
	}
	

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root=BTUse.takeinput();
		BTUse.print(root);
		pathsum3(root,0L);
		System.out.println((int)totalsum);

	}

}
