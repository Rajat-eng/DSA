package BST;

import java.util.ArrayList;

import BT.BTUse;
import BT.BinaryTreeNode;

public class getPath {
	
	
	
   public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
     
     if(root==null)
         return -1;
     
     ArrayList<Integer> path1=BT.path.nodetorootpath(root,a);
     ArrayList<Integer> path2=BT.path.nodetorootpath(root,b);
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
   
   public static int lcaof3nodes(BinaryTreeNode<Integer> root, int node1, int node2,int node3) {
	   ArrayList<Integer> path1=BT.path.nodetorootpath(root,node1);
       ArrayList<Integer> path2=BT.path.nodetorootpath(root,node2);
       ArrayList<Integer> path3=BT.path.nodetorootpath(root,node3);
       int i=path1.size()-1;
       int j=path2.size()-1;
       int k=path3.size()-1;
      while(i>=0 && j>=0 && k>=0) {
    	  if (path1.get(i).equals(path2.get(j)) && path1.get(i).equals(path3.get(k))  && path2.get(j).equals(path3.get(k))) {
              i--;
              j--;
              k--;
          }
    	  
      }
      i++;
	  j++;
	  k++;
      
       return  path1.get(i);
   }

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root=BTUse.takeinput();
		BTUse.print(root);
	}

}
