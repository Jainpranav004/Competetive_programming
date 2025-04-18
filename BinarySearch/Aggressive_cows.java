package BinarySearch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadPoolExecutor;

public class Aggressive_cows {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,8,4,9));
        int n = 5; //Stalls
        int c = 3;
        Collections.sort(arr); // Sort first
        int LargetAns = GetDistance(arr, n , c);
        System.out.println("Largest distance is : " +  LargetAns);


    }

    public static int GetDistance(ArrayList<Integer> arr, int n , int c){
        int start = 1;
        int ans = -1;
        int end = arr.get(n-1) - arr.get(0);


        Collections.sort(arr); // Sort first

        while(start <= end){
            int mid = start + (end - start)/2;
            if(IsPossible(arr, mid , n, c)){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }


    public static boolean IsPossible(ArrayList<Integer> arr, int mid , int n , int c){

              int cowsCount = 1;
              int lastPostion = arr.get(0);   //place first cow at starting index

              for(int i =1; i<n ; i++){
                  if(arr.get(i) - lastPostion >= mid){
                      cowsCount++;
                      lastPostion = arr.get(i);   //place next to lastpostion
                  }
                  if(cowsCount == c){
                      return true;
                  }
              }
              return false;
    }
}
