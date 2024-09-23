//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[]) {
        int n = arr.length;
        int[] result = new int[2]; // result[0] -> duplicate (B), result[1] -> missing (A)
        
        // Step 1: Find the duplicate by marking elements
        for (int i = 0; i < n; i++) {
            int absVal = Math.abs(arr[i]);

            if (arr[absVal - 1] < 0) {
                // If the number at index absVal - 1 is already negative, it's a duplicate
                result[0] = absVal;
            } else {
                // Mark the number at index absVal - 1 as negative
                arr[absVal - 1] = -arr[absVal - 1];
            }
        }
        
        // Step 2: Find the missing number by checking for positive values
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                // If arr[i] is positive, the missing number is i + 1
                result[1] = i + 1;
            }
        }
        
        return result;
    }
}
