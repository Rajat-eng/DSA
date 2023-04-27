package Trees;
import java.util.*;
public class countspecialnodes {
	
	 private static int countSpecialNodesHelper(TreeNode<Integer> root, Set<Integer> distinctElements) {
		 
		 if(distinctElements.contains(root.data))
			 return 0;
		 
		 distinctElements.add(root.data);
		 int count=0;
		 for(int i=0;i<root.children.size();i++) {
			 count+=countSpecialNodesHelper(root.children.get(i), distinctElements);
		 }
		 distinctElements.remove(root.data);
		 return 1+count;
	 }

	public static void main(String[] args) {
		TreeNode<Integer> root= TreeUse.takeInputLevelWise();		
		TreeUse.printLevelWise(root);
		Set<Integer> map=new HashSet<Integer>();
		System.out.println(countSpecialNodesHelper(root, map));
	}

}
