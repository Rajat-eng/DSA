package BT;
import java.util.*;
public class Pairsum {
    public static void pairSum(BinaryTreeNode<Integer> root, int sum) {
		
        ArrayList<Integer> node=new ArrayList<>();
        x(root,node);
		Collections.sort(node);  // O(nlogn) to sort
        
        int si=0;
        int ei=node.size()-1; // O(n) to find pair 
        while(si<ei){
            int leftdata=node.get(si);
            int rightdata=node.get(ei);
            if(leftdata+rightdata<sum){
               si++; 
            }else if(leftdata+rightdata>sum){
                ei--;
            }else{
               System.out.println(leftdata + " " + rightdata);
                si++;
                ei--;
            }
        }
        
        // total time is O(n) + O(nlogn) + O(n) == O(nlogn)
	}
    
    public static void x(BinaryTreeNode<Integer> root,ArrayList<Integer> list){
        if(root==null)
            return;
        //order n to fill
        list.add(root.data);
        x(root.left,list);
        x(root.right,list);
    }

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root=BTUse.takeinput();
//		1 2 3 4 5 6 7 -1 8 -1 -1 -1 -1 -1 -1 -1 -1 
		pairSum(root, 9);
	}
 }
