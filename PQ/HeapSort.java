package PQ;

public class HeapSort {
	
	public static void insert(int[] arr,int i) { // maxheap
		int childindex=i;
		int parentindex=(childindex-1)/2;
		while(childindex>0) {
			if(arr[childindex]>arr[parentindex]) {
				int temp=arr[childindex];
				arr[childindex]=arr[parentindex];
				arr[parentindex]=temp;
				childindex=parentindex;
				parentindex=(childindex-1)/2;
			}else {
				return;
			}
		}	
	}
		
	public static int delete(int[] arr,int heapsize) {
	  int temp=arr[0];
	  arr[0]=arr[heapsize-1];
	  heapsize--;
	  int index=0;
	  int leftchildindex=2*index+1;
      int rightchildindex=2*index+2;
      while(leftchildindex<heapsize) {
    	  int maxindex=index;
    	  if(arr[leftchildindex]>arr[maxindex]) {
    		  maxindex=leftchildindex;
    	  }
    	  if(rightchildindex<heapsize && arr[rightchildindex]>arr[maxindex]) {
    		  maxindex=rightchildindex;
    	  }
    	  if(index==maxindex) {
    		  break;
    	  }else {
    		  int temp1=arr[index];
    		  arr[index]=arr[maxindex];
    		  arr[maxindex]=temp1;
    		  index=maxindex;
    		  leftchildindex=2*index+1;
    	      rightchildindex=2*index+2;
    	  }
      }
      return temp;
	}
	
	public static void main(String[] args) {
		int [] arr= {9,10,1,12,5,6};
		
		for(int i=0;i<arr.length;i++){
			insert(arr,i);
		  }
		for(int i:arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i=0;i<arr.length;i++){
			arr[arr.length-1-i]=delete(arr,arr.length-i);
		}
		for(int i:arr) {
			System.out.print(i + " ");
		}
		
	}
}
