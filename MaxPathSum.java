package BT;
import java.util.*;
class pairsum{
	long LTLpathsum=-1;    // max leaf to leaf path sum
	long NTLpathsum=-1; 	  // max node to leaf path sum	
 }
public class MaxPathSum {
	
	public static pairsum maxpathsum(BinaryTreeNode<Integer> root) {
		
		if(root==null) {
			pairsum x=new pairsum();
			return x;
		}	
		if(root.left==null && root.right==null) {
			pairsum y=new pairsum();
			y.NTLpathsum=root.data;
			return y;
		}
		pairsum lp=maxpathsum(root.left);
		pairsum rp=maxpathsum(root.right);
		pairsum ans=new pairsum();
		ans.LTLpathsum=(long)Math.max(lp.LTLpathsum, rp.LTLpathsum);
		if(root.left!=null && root.right!=null) {
			// LTL can be calculated only if parent has both child
			ans.LTLpathsum=(long)Math.max(ans.LTLpathsum, lp.NTLpathsum+root.data+rp.NTLpathsum);
		}
		
		ans.NTLpathsum=(long)Math.max(lp.NTLpathsum,rp.NTLpathsum) + root.data;
		
		return ans;
	}

	

	public static void main(String[] args) {
//		10 30 20 60 50 70 90 8 9 -1 -1 -1 -1 6 100 -1 1 -1 7 5 2 -1 -1 -1 4 -1 -1 -1 -1 -1 -1 -1 -1
		BinaryTreeNode<Integer> root=BTUse.takeinput();
		BTUse.print(root);
		System.out.println(maxpathsum(root).LTLpathsum);
		System.out.println(maxpathsum(root).NTLpathsum);
		
	}

}
