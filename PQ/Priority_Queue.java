package PQ;
import java.util.*;
public class Priority_Queue {

	private static  ArrayList<Integer> heap;
	
	public Priority_Queue(){
		heap=new ArrayList<>();
	}
	
	boolean isEmpty() {
		return size()==0;
	}
	
	int size() {
		return heap.size();
	}
	
	int getMax() {
		if(isEmpty()) {
			return Integer.MIN_VALUE;
		}
		return heap.get(0);
	}
	
    void insert(int element) {
    	heap.add(element);
		int childindex=heap.size()-1;
		int parentindex=(childindex-1)/2;
		while(childindex>0) {
			if(heap.get(childindex)>heap.get(parentindex)) {  // maxheap
			  // swap child and parent
				int temp=heap.get(childindex);
				heap.set(childindex, heap.get(parentindex));
				heap.set(parentindex, temp);
				childindex=parentindex;
				parentindex=(childindex-1)/2;
			}else {
				return;
			}
		}
	}
	int removeMax() {
		if(isEmpty()) {
			return Integer.MIN_VALUE;
		}
		int temp=heap.get(0);
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		int index=0;
		int maxindex=index;
		int leftchildindex=1;
		int rightchildindex=2;
		while(leftchildindex<heap.size()) {
			if(heap.get(leftchildindex)>heap.get(maxindex)) {
				maxindex=leftchildindex;
			}
			if(rightchildindex<heap.size() &&  heap.get(rightchildindex)>heap.get(maxindex)) {
				maxindex=rightchildindex;
			}
			if(index==maxindex) {
				break;
			}else {
				int x=heap.get(index);
				heap.set(index, heap.get(maxindex));
				heap.set(maxindex, x);
				index=maxindex;
				leftchildindex=2*index+1;
				rightchildindex=2*index+2;
			}
		}
		
	return temp;
	}
	
  }
