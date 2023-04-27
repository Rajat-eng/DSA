package BT;

import java.util.ArrayList;
import java.util.List;

public class maxsumtoleaves {
	

    public static List<Integer> maxSum(BinaryTreeNode<Integer> root) {
//    	 path which is max from root to leaf
//    	 O[n+height^2]
    	if(root==null) {
    		List<Integer> ans=new ArrayList<Integer>();
    		return ans;
    	}
    	List<Integer> leftpath=maxSum(root.left);
    	List<Integer> rightpath=maxSum(root.right);
    	
    	leftpath.add(root.data);
    	rightpath.add(root.data);
    	int leftsum=0;
    	int rightsum=0;
    	
    	for(int i=0;i<leftpath.size();i++) {
    		leftsum+=leftpath.get(i);
    	}
    	for(int i=0;i<rightpath.size();i++) {
    		rightsum+=leftpath.get(i);
    	}
    	
    	if((leftsum>=rightsum && root.left!=null) || root.right==null )
    		return leftpath;
    	
    	return rightpath;
    }
    
//  Method 2
    
    public static List<Integer> maxSum2(BinaryTreeNode<Integer> root){
    	int s=getsum(root);
    	System.out.println("sum is:" + s );
    	List<Integer> path=new ArrayList<Integer>();
    	getpath(root,s,0,path);
    	return path;
    }
    
    public static int getsum(BinaryTreeNode<Integer> root) {
    	
    	int sum=Integer.MIN_VALUE;
    	if(root.left!=null) {
    		sum=Math.max(sum, getsum(root.left));
    	}
    	if(root.right!=null) {
    		sum=Math.max(sum, getsum(root.right));
    	}
    	if(sum==Integer.MIN_VALUE)
    		sum=0;
    	
    	return sum+root.data;
    }
    
    public static boolean getpath(BinaryTreeNode<Integer> root, int max,int sum,List<Integer> path) {
//    	 path from root to leaf
    	if(root==null) {
    		if(max==sum)
    			return true;	
    		return false;
    	}
    	sum+=root.data;
    	path.add(root.data);
    	boolean lans=getpath(root.left, max, sum,path);
    	if(lans) {
    		return true;
    	}
    	boolean rans=getpath(root.right, max, sum, path);
    	if(rans) {
    		return true;
    	}
    	path.remove(path.size()-1);
    	sum-=root.data;
    	return false;	
    }

	public static void main(String[] args) {
//		1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
		BinaryTreeNode<Integer> root=BTUse.takeinput();
		BTUse.print(root);
		List<Integer> ans=maxSum2(root);
		for(int i=0;i<ans.size();i++) {
			System.out.print(ans.get(i) + " ");
		}
	}
}
