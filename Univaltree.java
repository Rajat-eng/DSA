package BT;


  class xxx {
	int count;
	boolean isunival;
	
	xxx(int count,boolean isunival){
		this.count=count;
		this.isunival=isunival;
	}
}

public class Univaltree {
	
	public static xxx countunival(BinaryTreeNode<Integer> root) {
		
		if(root==null)  
		{
			return new xxx(0,true);
		}
		
		 xxx left=countunival(root.left);
		 xxx right=countunival(root.right);
			
		int totalcount=left.count+right.count;
		boolean isunival=false;
		xxx ans=new xxx(totalcount,isunival); 
				
		if(left.isunival && right.isunival) {
			if( root.left!=null && !root.left.data.equals(root.data) )
				return ans;
			if( root.right!=null && !root.right.data.equals(root.data) )
				return ans;
			
			ans.count++;
			ans.isunival=true;
			return ans;
		}
		return ans;	
	}
	
	public static void main(String[] args) {
//		 0 1 0 -1 -1 1 0 1 1 -1 -1 -1 -1 -1 -1 
		BinaryTreeNode<Integer> root=BTUse.takeinput();
		BTUse.print(root);
		System.out.println(countunival(root).count);
	}

}
