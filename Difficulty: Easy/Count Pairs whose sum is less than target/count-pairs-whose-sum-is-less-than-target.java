//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
    int countPairs(int arr[], int target) {
        // Your code here
        
        // int sorted[]=new arr[];
        
        // for(int i=0;i<arr.length;i++){
        //     if(arr[i]<=target){
        //         sorted[j]=arr[i];
        //         j++;
        //     }
        // }
        // int j=0;
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=target){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]<target){
                    count++;
                }
            }
            }
        }
        return count;
    }
    
}

//{ Driver Code Starts.

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine());

            Solution obj = new Solution();

            System.out.println(obj.countPairs(nums, target));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends