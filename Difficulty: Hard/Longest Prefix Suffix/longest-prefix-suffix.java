//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int lps(String str) {
        int n = str.length();
        int[] lps = new int[n]; // Longest Prefix Suffix array
        int length = 0; // Length of the previous longest prefix suffix
        int i = 1; // Start from the second character

        while (i < n) {
            if (str.charAt(i) == str.charAt(length)) {
                length++;
                lps[i] = length; // Set the length for this position
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1]; // Fall back to the previous longest prefix suffix
                } else {
                    lps[i] = 0; // No match found
                    i++;
                }
            }
        }

        return lps[n - 1]; // Return the length of the longest proper prefix which is also a proper suffix
    }
}
