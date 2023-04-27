package Trees;

public class Height {
	
	public static int height(TreeNode<Integer> root) {
		if(root==null)
			return 0;
		int max=0;
		
		for(int i=0;i<root.children.size();i++) {
			int height=height(root.children.get(i));
			if(height>max)
				max=height;
		}
		return 1+max;
	}
	
	public static void printAtK(TreeNode<Integer> root,int k) {
		if(k<0) {
			return;
		}else if(k==0) {
			System.out.print(root.data +" ");
			return;
		}
		else {
			for(int i=0;i<root.children.size();i++) {
				printAtK(root.children.get(i), k-1);
			}
		}
	}
	
	public static int countLeafNodes(TreeNode<Integer> root) {
		
		if(root.children.size()==0) 
			return 1;
			
			int count=0;
			for(int i=0;i<root.children.size();i++) {
				int ifleaf=countLeafNodes(root.children.get(i));
				count+=ifleaf;
			}
		
			return count;
		}

	public static void main(String[] args) {
		TreeNode<Integer> root= TreeUse.takeInputLevelWise();
		printAtK(root,2);
		System.out.println(countLeafNodes(root));

	}

}
