// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class HelloWorld {
    public static int[] sort(int []arr,int left,int right){
        if(left==right){
            int ele=arr[left];
            return new int[]{ele};
        }
        int m=left +(right-left)/2;
        int [] LeftArray =sort(arr,left,m);
        int [] RightArray=sort(arr,m+1,right);
        return merge(LeftArray, RightArray);
    } 
    
    private static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                merged[k++] = left[i++];
            } else {
                merged[k++] = right[j++];
            }
        }
        
        while (i < left.length) {
            merged[k++] = left[i++];
        }
        
        while (j < right.length) {
            merged[k++] = right[j++];
        }
        
        return merged;
    }
      public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
       int []arr=new int[]{3,2,1};
       int []ans=sort(arr,0,arr.length-1);
       printArray(ans);
    }
}
