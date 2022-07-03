package BT;
import java.util.*;
public class path {
	
	public static boolean find(BinaryTreeNode<Integer> root, int x){
   	    if(root==null) {
		  return false;
		}
		if(root.data==x) {
			return true;
		}
		boolean lans=find(root.left, x);
		if(lans) {
			return true;
		}
		boolean rans=find(root.right, x);
		if(rans) {
			return true;
		}
		return false;
	}
		
    public static ArrayList<Integer> nodetorootpath(BinaryTreeNode<Integer> root, int data) {
		if(root==null) {
			return null;
          }
	     
        if(root.data==data){
            ArrayList<Integer> output=new ArrayList<>();
            output.add(root.data);
            return output;
         }
        
            ArrayList<Integer> lo=nodetorootpath(root.left,data);
            if(lo!=null){
                lo.add(root.data);
                return lo;
            }
        
            ArrayList<Integer> ro=nodetorootpath(root.right,data);
            if(ro!=null){
                ro.add(root.data);
                return ro;
            }
  
            return null;
            
	}
    
    public static ArrayList<Integer> nodetoleafpath(BinaryTreeNode<Integer> root) {
		 if(root==null) {
//			 ArrayList<Integer> output=new ArrayList<>();
//			 return output;
			 return null;
		 }	 
         if(root.left==null && root.right==null){
            ArrayList<Integer> output=new ArrayList<>();
            output.add(root.data);
            return output;
         }
        
            ArrayList<Integer> lo=nodetoleafpath(root.left);
            if(lo!=null){
                lo.add(root.data);
                return lo;
            }
        
            ArrayList<Integer> ro=nodetoleafpath(root.right);
            if(ro!=null){
                ro.add(root.data);
                return ro;
            }
            
            return new ArrayList<Integer>();        
	}
       
    public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root){
		if(root==null) {
	       ArrayList<Integer> output=new ArrayList<>();
           return output;}
        
        if(root.left==null && root.right==null){
            ArrayList<Integer> output=new ArrayList<>();
            output.add(root.data);
            return output;
        }
		
        ArrayList<Integer> left=longestRootToLeafPath(root.left);
        ArrayList<Integer> right=longestRootToLeafPath(root.right);
        
        if(left.size()>right.size()){
            left.add(root.data); 
        }
           
        else{
           right.add(root.data); 
        }
        
        return left.size()>right.size()?left:right;
	}
		
    public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
        
        if(root==null)
            return -1;
        
        ArrayList<Integer> path1=nodetorootpath(root,a);  // O[n]
        ArrayList<Integer> path2=nodetorootpath(root,b);  // O[n]
       
       if(path1!=null && path2!=null){
           int i=path1.size()-1;
           int j=path2.size()-1;
        
	   while(i>=0 && j>=0 && path1.get(i)==path2.get(j)){
        i--;
        j--;
       }
        i++;
        j++;
       return path1.get(i);
        }      
        else if(path1!=null){
            return path1.get(0);
        }else if(path2!=null){
            return path2.get(0);
        }else{
           return -1;
        }        
	}
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root=BTUse.takeinput();
		BTUse.print(root);
		ArrayList<Integer> ans=nodetoleafpath(root);
		for(int i:ans) {
			System.out.print(i+ " ");
		}
	}

	
}
