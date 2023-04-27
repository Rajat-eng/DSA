package Trees;

public class Sum {
	
	static int maxSum=0;
    static TreeNode<Integer> ans=null;
	
	static TreeNode<Integer> larger=null;
	static TreeNode<Integer> smaller=null;
	static int ceil=Integer.MAX_VALUE;
	static int floor=Integer.MIN_VALUE;
	
	public static int sumOfAllNode(TreeNode<Integer> root) {
		if(root==null)
			return -1;
		
		int sum=root.data;
		for(int i=0;i<root.children.size();i++) {
			sum+=sumOfAllNode(root.children.get(i));	
		}
		return sum;		
	}
	
	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
		  
			int sum = root.data;
			for (int i = 0; i < root.children.size(); i++) {
				sum += root.children.get(i).data;
			}
//			if (sum > maxSum) {
//				maxSum = sum;
//				ans = root;
//			}
			for (int i = 0; i < root.children.size(); i++) {
				maxSumNode(root.children.get(i));
			}
			if (sum > maxSum) {
				maxSum = sum;
				ans = root;
			}
	       return ans;
	}

	public static  TreeNode<Integer> largest(TreeNode<Integer> root) {
		if(root==null)
		return null;
		
		int max=root.data;
		for(int i=0;i<root.children.size();i++) {
		     TreeNode<Integer> childnode=largest(root.children.get(i));
		     if(childnode.data>max) {
		    	 max=childnode.data;
		    	 ans=childnode;
		     } 
		}
		return root;	
	}
	
    public static int numNodeGreater(TreeNode<Integer> root,int x) {
		if(root==null)
		return Integer.MIN_VALUE;
		
		int count=0;
		int info=root.data;
		if(info>x)
			count++;
		for(int i=0;i<root.children.size();i++) {
		     count+=numNodeGreater(root.children.get(i),x);        	
		}
		return count;	
	}
    
    public static TreeNode<Integer> ceil(TreeNode<Integer> root,int x) {
    	
    	if(root.data>x) {
    		if(root.data<ceil) {
    			larger=root;
    			ceil=root.data;
    		}
    	}

    	for(int i=0;i<root.children.size();i++) {
		    ceil(root.children.get(i),x);       	
		}
    	
    	return larger;
    }
    
    public static TreeNode<Integer> floor(TreeNode<Integer> root,int x) {
    	// largest among smaller values than x
    	if(root.data<x) {
   		if(root.data>floor) {
   			floor=root.data;
   			smaller=root;
   		   }	
    	}
    	for(int i=0;i<root.children.size();i++) {
		    floor(root.children.get(i),x);       	
		}
    	
    	return smaller;
    }
 
    public static TreeNode<Integer> kthlargest(TreeNode<Integer> root,int k){
    	
        floor=Integer.MIN_VALUE;
    	int fact=Integer.MAX_VALUE;
    	for(int i=0;i<k;i++) {
    		   TreeNode<Integer> nextsmall=floor(root,fact);  // floor becomes next small
    		   fact=nextsmall.data;
    		   floor=Integer.MIN_VALUE;  // otherwise floor is largest value
    	   } 
    	   return new TreeNode<Integer>(fact);
    }
    
    public static void main(String[] args) {
    	TreeNode<Integer> root= TreeUse.takeInputLevelWise();
    	TreeUse.printLevelWise(root);;
    	TreeNode<Integer> result= largest(root);
    	System.out.println("ans is " + ans.data);
    }
}
