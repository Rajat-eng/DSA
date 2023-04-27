package BT;
import java.util.*;
public class distancenode {
	
    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        
        //finding node and storing its path
	   ArrayList<BinaryTreeNode<Integer>> ans= getpath(root,node);
        // for every node in path find nodes at k-i
        
       for(int i=0;i<ans.size();i++){
           printkleveldown(ans.get(i),k-i,i==0?null:ans.get(i-1));  
       } 
	}
    
    public static void printkleveldown(BinaryTreeNode<Integer> root, int k,BinaryTreeNode<Integer> blocker){
        if(root==null || k<0 || root==blocker){
           return;
       }
        if(k==0){
            System.out.println(root.data);
        }
        
        printkleveldown(root.left,k-1,blocker);
        printkleveldown(root.right,k-1,blocker);
    }
   
    public static ArrayList<BinaryTreeNode<Integer>> getpath(BinaryTreeNode<Integer> root, int x){
        if(root==null){
            return null;
        }
        
        if(root.data==x) {
        	ArrayList<BinaryTreeNode<Integer>> output=new ArrayList<BinaryTreeNode<Integer>>();
        	output.add(root);
        	return output;
        }
        
        ArrayList<BinaryTreeNode<Integer>> lo=getpath(root.left,x);
        if(lo!=null){
            lo.add(root);
            return lo;
        }
        ArrayList<BinaryTreeNode<Integer>> ro=getpath(root.right,x);
        if(ro!=null){
            ro.add(root);
            return ro;
        }
        
        return null;
    }

	public static void main(String[] args) {
//		10 30 20 60 50 70 90 8 9 -1 -1 -1 -1 6 100 -1 1 -1 7 5 2 -1 -1 -1 4 -1 -1 -1 -1 -1 -1 -1 -1
		BinaryTreeNode<Integer> root=BTUse.takeinput();
		BTUse.print(root);
		nodesAtDistanceK(root, 60, 2);
	}

}
