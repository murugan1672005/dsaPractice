import java.util.*;
class Solution{
    public void print(int arr[],int n){
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    // Two pointers -> Optimal Approach (Zeros / Positives)
    public int LengthOfLongestSubarray1(int arr[],int k)
    {
        int l =0;
        int r=0;
        int sum = arr[0];
        int maxLen =0;
        HashMap<Integer,Integer>map = new HashMap<Integer,Integer>();
        while(r<arr.length){
            while(sum > k && l<=r){
                sum-=arr[l];
                l++;
            }
            if(sum == k)
            {
                maxLen = Integer.max(maxLen,r-l+1);
            }
            r++;
            if(r<arr.length){
                sum+=arr[r];
            }
        }
        return maxLen;
    }
    // Hashing - >(Including negatives)
    public int LengthOfLongestSubarray2(int arr[],int k){
        HashMap<Integer,Integer>map = new HashMap<Integer,Integer>();
        int sum = 0;
        int maxLen =0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(sum == k)
            {
                maxLen = Integer.max(maxLen,i+1);
            }
            if(map.containsKey(sum-k)){
                maxLen = Integer.max(maxLen,i-map.get(sum-k));
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return maxLen;
    }
    // Two Sum ->(Sorted) ->Two pointers
    public int[] twoSum1(int arr[],int k)
    {
        int left =0;
        int right = arr.length-1;
        while(left<right)
        {
            int sum = arr[left]+arr[right];
            if(sum>k)
            {
                right--;
            }
            else if(sum<k)
            {
                left++;
            }
            else{
                return new int[]{left,right};
            }
        }
        return new int[]{-1,-1};
    }
    // Two Sum - Unsorted ->Hashing
    public int[] twoSum2(int arr[],int k)
    {
        int sum = 0;
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
           int rem = k-arr[i];
           if(map.containsKey(rem))
           {
               return new int[]{map.get(rem),i};
           }
           map.put(arr[i],i);
        }
        return new int[]{-1,-1};
    }
    // Kadane's algorithm for Maximum Sum Subarray 
    public int MaximumSumSubarray(int arr[])
    {
        int sum =0;
        int max_sum = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            max_sum = Integer.max(max_sum,sum);
            if(sum<0)
            {
                sum =0;
            }
        }
        return max_sum;
    }
    // Count Subarray with given sum
    public int CountSubarraysWithSum(int arr[],int k)
    {
         HashMap<Integer,Integer>map = new HashMap<Integer,Integer>();
        int sum = 0;
        int cnt =0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(sum == k)
            {
                cnt++;
            }
            if(map.containsKey(sum-k)){
             cnt++;
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return cnt;
    }
    // Stock buy and sell where buy and sell
    public int sellStocks(int stocks[])
    {
        int max_profit=Integer.MIN_VALUE;
        int min_cp = Integer.MAX_VALUE;
        for(int i=0;i<stocks.length;i++)
        {
            min_cp = Math.min(min_cp,stocks[i]);
            max_profit = Math.max(max_profit,stocks[i]-min_cp);
        }
        return max_profit;
    }
    
}
public class Harry{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        Solution obj = new Solution();
        obj.print(arr,n);
        int k = sc.nextInt();
        // int maxLen = obj.LengthOfLongestSubarray2(arr,k);
        // System.out.println(maxLen);
        // int[] index = obj.twoSum1(arr,k);
        // obj.print(index,index.length);
        // int sum = obj.MaximumSumSubarray(arr);
        // System.out.println(sum);
        // int cnt = obj.CountSubarraysWithSum(arr,k);
        // System.out.println(cnt);
        int profit = obj.sellStocks(arr);
        System.out.println(profit);
    }
}
