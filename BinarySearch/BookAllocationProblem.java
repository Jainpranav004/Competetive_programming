package BinarySearch;
import java.sql.SQLOutput;
import java.util.Arrays;

public class BookAllocationProblem {
    public static void main(String[] args) {
         int[]arr = {25 ,46 ,28 ,49 ,24};
         int n = 5;
         int m = 4;
         int final_answer = AllocateBooks(arr ,n ,m);
         System.out.println(final_answer);
    }

    public static boolean isValid(int[]arr,int n ,int m , int MaxAllowedPages){
          int student = 1;
          int pages = 0;
          for(int i = 0 ; i< arr.length ;i++){
              if(arr[i] > MaxAllowedPages){
                  return false;
              }

               if(pages + arr[i] <= MaxAllowedPages){
                   pages += arr[i];
               }else{
                   student++;
                   pages = arr[i];
               }
          }
          return student > m ? false : true;
    }

    public static int AllocateBooks(int[] arr , int n ,int m){
        if(m>n){
            return -1;
        }

        int st = 0 ;
        int sum = 0;
        for(int i=0 ; i<n ; i++){
            sum+=arr[i];
        }
        int end = sum;
        int ans = -1;

        while(st<=end){
            int mid = st + (end - st )/2;

            if(isValid(arr ,n,m, mid)){
                //left
                ans = mid;
                end = mid-1;
            }else{
                //right
                st = mid +1;
            }
        }
        return ans;
    }

    public static int Sum(int[]arr){
        int sum = 0;
        for(int i = 0 ; i<arr.length ; i++){
            sum += arr[i];
        }
        return sum;
    }


}


