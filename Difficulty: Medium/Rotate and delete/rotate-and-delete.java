//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends


class Solution {
    public static int rotateDelete(ArrayList<Integer> arr) {
        int k = 1; // Operation count starts from 1
        while (arr.size() > 1) {
            // Right rotate the array by 1 (clockwise)
            int lastElement = arr.remove(arr.size() - 1); // Remove last element
            arr.add(0, lastElement); // Add it to the front
            
            // Print array after rotation (optional for debugging)
            // System.out.println("After rotation: " + arr);
            
            // Calculate the deletion index
            int deleteIndex = arr.size() - k;
            
            // If the calculated index is out of bounds, reset the index to the first element
            if (deleteIndex < 0) {
                deleteIndex = 0; // Safeguard against negative index
            }
            
            // Ensure deleteIndex is within bounds
            if (deleteIndex >= 0 && deleteIndex < arr.size()) {
                // System.out.println("Deleting element at index " + deleteIndex + ": " + arr.get(deleteIndex));
                arr.remove(deleteIndex);
            }

            // Increment operation count
            k++;
        }
        // Return the last remaining element
        return arr.get(0);
    }
}




//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> arr = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr.add(Integer.parseInt(token));
            }

            Solution obj = new Solution();
            int res = obj.rotateDelete(arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends