package Trees;
import java.util.*;

public class TreeUse {
	
	public static int numNodes(TreeNode<Integer> root) {
		if(root==null)  //  not a base case
			return 0;
		
		int count=1;
		for(int i=0;i<root.children.size();i++) {
			count+= numNodes(root.children.get(i));
		}
		return count;
	}
	
	public static TreeNode<Integer> takeInput(Scanner sc){
		
		int n,childcount;
		//asking for root
//		System.out.println("Enter root data:");
		n=sc.nextInt();  
		TreeNode<Integer> root= new TreeNode<Integer>(n);
		//asking for children
//		System.out.println("Enter number of children for:" + n);
		childcount=sc.nextInt();
		for(int i=0;i<childcount;i++) {
			TreeNode<Integer> child=takeInput(sc);
			root.children.add(child);
		}
		return root;	
	}
	
	public static TreeNode<Integer> takeInputLevelWise(){
		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter root data");
		int rootdata=sc.nextInt();
		TreeNode<Integer> root=new TreeNode<Integer>(rootdata);
		Queue<TreeNode<Integer>> q=new LinkedList<TreeNode<Integer>>();
		q.add(root);
		
		while(!q.isEmpty()) {
			TreeNode<Integer> frontnode=q.poll();
//			System.out.println("Enter number of children for:" +frontnode.data);
			int numchild=sc.nextInt();
			for(int i=0;i<numchild;i++) {
//				System.out.println("Enter " + (i+1) + "st child of " + frontnode.data);
				int child=sc.nextInt();
				TreeNode<Integer> childnode=new TreeNode<Integer>(child);
				frontnode.children.add(childnode);
				q.add(childnode);
			}
		}
		return root;
	}
	
	public static void print(TreeNode<Integer> root) {
		String ans =root.data + ":";
		for(int i=0;i<root.children.size();i++) {
			ans+=root.children.get(i).data + " ";
			}
		System.out.println(ans);
		for(int i=0;i<root.children.size();i++) {
			print(root.children.get(i));
			}
	}
	
	public static void printLevelWise(TreeNode<Integer> root) {
		if(root==null)
			return;
		
		Queue<TreeNode<Integer>> queue=new LinkedList<TreeNode<Integer>>();
		queue.add(root);
		System.out.println(root.data);
		
			while(!queue.isEmpty()) {
				int n=queue.size();   
				while(n>0) {
					TreeNode<Integer> frontnode=queue.poll();
					for(int i=0;i<frontnode.children.size();i++) {
						System.out.print(frontnode.children.get(i).data + " ");
						queue.add(frontnode.children.get(i));
					}
					n--;
				}
				System.out.println();
			}
	}
	
	public static void main(String[] args) {
		
		TreeNode<Integer> root= takeInputLevelWise();
		
		printLevelWise(root);
	}
}
