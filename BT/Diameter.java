package BT;

 class pair {
	int height;  
	int diameter;  
}
 
 public class Diameter {
	
	public static pair hd(BinaryTreeNode<Integer> root){
		if(root==null) {
			pair output=new pair();
			output.height=0;
			output.diameter=0;
			return output;
		}
		pair lo=hd(root.left);
		pair ro=hd(root.right);
		int height=1+Math.max(lo.height, ro.height);
		int option1= lo.height+ro.height;  
		int option2= lo.diameter;
		int option3= ro.diameter;
		int diameter=Math.max(option1, Math.max(option2, option3));
		pair output=new pair();
		output.height=height;
		output.diameter=diameter;
		return output;
		
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root=BTUse.takeinput();
		BTUse.printlevelwise(root);
		System.out.println("height is: " + hd(root).height);
		System.out.println("diameter is: " + hd(root).diameter);
	}

}
