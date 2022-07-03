package Trees;
import java.util.*;

public class Traversal {
	static TreeNode<Integer> predecessor=null;
	static TreeNode<Integer> successor=null;
	static int state=0;
	
	public static void postorder(TreeNode<Integer> root) {
		// leaves first then root
		if(root==null)
			return;
		for(int i=0;i<root.children.size();i++) {
			postorder(root.children.get(i));
		}
		System.out.print(root.data + " ");
	}
	
	public static void preorder(TreeNode<Integer> root) {
		if(root==null)
			return;
		System.out.print(root.data + " ");
		for(int i=0;i<root.children.size();i++) {
			postorder(root.children.get(i));
		}
	}
	
	public static TreeNode<Integer> removeleaves(TreeNode<Integer> root) {	
        for(int i=0;i<root.children.size();i++) {
        	TreeNode<Integer> Nodechild=root.children.get(i);
        	if(Nodechild.children.size()==0) {
        		for(int j=i;j<root.children.size()-1;j++) {
        			root.children.set(j, root.children.get(j+1));
        		}
        		root.children.remove(root.children.size()-1);
        		i--;
        	}	
        }
        
        for(int i=0;i<root.children.size();i++) {
			removeleaves(root.children.get(i));
		} 
        
        return root;
	}
	
	public static ArrayList<Integer> nodetorootpath(TreeNode<Integer> root,int x ){
		if(root.data==x) {
			ArrayList<Integer> list=new ArrayList<Integer>();
			list.add(root.data);
			return list;
		}
		
		for(int i=0;i<root.children.size();i++) {
			ArrayList<Integer> path=nodetorootpath(root.children.get(i), x);
			if(path.size()>0) {
				path.add(root.data);
				return path;
			}
		}
		
		return new ArrayList<Integer>();
	}
	
	public static int lca(TreeNode<Integer> root,int d1,int d2) {
		ArrayList<Integer> p1=nodetorootpath(root, d1);
		ArrayList<Integer> p2=nodetorootpath(root, d2);
		int i=p1.size()-1;
		int j=p2.size()-1;
		while(i>=0 && j>=0  && p1.get(i)==p2.get(i) ) {
			i--;
			j--;
		}
		i++; j++;
		return p1.get(i);
	}
	
	public static int DistancebwNodes(TreeNode<Integer> root, int d1,int d2) {
		// find lca and then traverse path for both nodes
		ArrayList<Integer> p1=nodetorootpath(root, d1);
		ArrayList<Integer> p2=nodetorootpath(root, d2);
		int i=p1.size()-1;
		int j=p2.size()-1;
		while(i>=0 && j>=0  && p1.get(i)==p2.get(i) ) {
			i--;
			j--;
		}
		i++; j++;
		return i+j;
	}
	
	public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){

        if(root1.children.size()!=root2.children.size() && root1.data!=root2.data)
               return false;
        
        for(int i=0;i<root1.children.size();i++){
            TreeNode<Integer> c1=root1.children.get(i);
            TreeNode<Integer> c2=root2.children.get(i);
            if(checkIdentical(c1,c2)==false)
                return false;
        }
        return true;
	}

	public static void predecessorandsuccessor(TreeNode<Integer> root, int x) {
		if(state==0) {
			if(root.data==x)
				state=1;
			else 
				predecessor=root;	
		}
		else if(state==1) {
			successor=root;
			state=2;
		}
		for(int i=0;i<root.children.size();i++) {
			 predecessorandsuccessor(root.children.get(i), x);
		}	
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> root= TreeUse.takeInputLevelWise();
		TreeUse.printLevelWise(root);
		ArrayList<Integer> ans=nodetorootpath(root, 5);
		for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i) + " ");
        }
	}
}
