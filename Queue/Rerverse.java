package Queue;
import java.util.Queue;
import java.util.Stack;
public class Rerverse {

	public static Queue<Integer> kreverse(Queue<Integer> input,int k) {
		Stack<Integer> st=new Stack<>();
		for(int i=0;i<k;i++) {
			int data=input.poll();
			st.push(data);
		}
		for(int i=0;i<k;i++) {
			int data=st.pop();
			input.add(data);
		}
		for(int i=0;i<input.size()-k;i++) {
			int data=input.poll();
			input.add(data);
		}
		
		return input;
		
	}
	
	public static Queue<Integer> reverse(Queue<Integer> input){
		if(input.isEmpty())
            return input;
		
        int data=input.poll();
        
        input=reverse(input);
        
        input.add(data);
        
        return input;
	}
}
