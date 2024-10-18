import java.util.*;
class Solution{
    public int findLargest(int arr[])
    {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(max<arr[i])
            {
                max = arr[i];
            }
        }
        return max;
    }
    public int SecondLargest(int arr[])
    {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(first<arr[i])
            {
                second = first;
                first = arr[i];
            }
            else if(second<arr[i]&&first>second)
            {
                second = arr[i];
            }
        }
        return second;
    }
    public boolean isSorted(int arr[])
    {
        for(int i=arr.length-1;i>=1;i--)
        {
            if(arr[i-1]>arr[i])
            {
                return false;
            }
        }
        return true;
    }
    public int find(int arr[],int search)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==search)
            {
                return i;
            }
        }
        return -1;
    }
    public void  reverse(int arr[],int left,int right)
    {
        while(left<=right)
        {
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
    public void RotateRight(int arr[],int k)
    {
        k=k%arr.length;
        reverse(arr,0,arr.length-1);
        reverse(arr,0,k-1);
        reverse(arr,k,arr.length-1);
    }
    public RotateLeft(int arr[],int k)
    {
         k=k%arr.length;
        reverse(arr,0,k-1);
        reverse(arr,k,arr.length-1);
        reverse(arr,0,arr.length-1);
    }
    public void  print(int arr[])
    {
        for(int ele:arr)
        {
            System.out.print(ele+" ");
        }
        System.out.println();
    }
}
public class Main
{
	public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  int n = sc.nextInt();
	  int arr[] = new int[n];
	  for(int i=0;i<n;i++)
	  {
	      arr[i]=sc.nextInt();
	  }
	  Solution obj = new Solution();
	  System.out.println("Largest element in the array : "+obj.findLargest(arr));
	  System.out.println(" Second Largest element in the array : "+obj.SecondLargest(arr));
	  if(obj.isSorted(arr))
	  {
	      System.out.println("Array is sorted");
	  }
	  else{
	      System.out.println("No Sorted Array");
	  }
	  if(obj.find(arr,sc.nextInt())!=-1)
	  {
	      System.out.println("Key found");
	  }
	  else{
	      System.out.println("No Key");
	  }
	  obj.print(arr);
	  obj.RotateRight(arr,3);
	  obj.print(arr);
	}
}
