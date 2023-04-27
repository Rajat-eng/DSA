import java.util.ArrayList;
public class BookAllocation {
	
	public static boolean isPossible(ArrayList<Integer> arr, int n, int m, int curMin) {
        int studentsRequired = 1;
        int curSum = 0;
        for (int i = 0; i < n; i++) {
            
             if (arr.get(i) > curMin) {
                 return false;
             }
            
            if (curSum + arr.get(i) > curMin) {
                // Increment student count by '1'
                studentsRequired += 1;

                // Update curSum
                curSum = arr.get(i);

                // If students required becomes greater than given no. of students, return False
                if (studentsRequired > m) {
                    return false;
                }
            }
            // Else update curSum
            else {
                curSum += arr.get(i);
            }
        }
        return true;

    }

    public static int allocateBooks(ArrayList<Integer> arr, int n, int m) {

        // If number student is more than number of books
        if (n < m) {
            return -1;
        }

        // Count total number of pages
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr.get(i);
        }

        // Initialize start as 0 pages and
        // End as total pages
        int start = 0, end = sum;
        int result = -1;

        // Traverse until start <= end , binary search
        while (start <= end) {
            // Check if it is possible to distribute books by using mid as current minimum
            int mid = (end + start) / 2;
            if (isPossible(arr, n, m, mid)) {
                // check if pages can be reduced
                result = mid;
                end = mid - 1;
            }
               // pages need to be increased bcoz students have passed contraints
            else {
                start = mid + 1;
            }
        }

        return result;
    }

	public static void main(String[] args) {
		
		ArrayList<Integer> arr=new ArrayList<Integer>();
		arr.add(5);
		arr.add(7);
		arr.add(100);
		arr.add(11);
		
		int ans=allocateBooks(arr, arr.size(), 4);
		System.out.println(ans);
	}

}
