import java.util.*;
class Solution{
    public void  print(int arr[],int n)
    {
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public void MoveZerosToEnd(int arr[])
    {
        if(arr.length<=1)
        {
            return;
        }
        int i =0;
        int j=1;
        while(j<arr.length)
        while(j<arr.length)
        {
            if(arr[i]==0)
            {
                if(arr[j]==0)
                {
                    j++;
                }
                else{
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                    i++;
                }
            }
            else{
                i++;
                j++;
            }
        }
    }
    public int RemoveDuplicates(int arr[]){
        if(arr.length<=1)
        {
            return arr.length;
        }
        int i=0;
        int j=1;
        while(j<arr.length)
        {
            if(arr[i]==arr[j])
            {
                j++;
            }
            else{
                int temp=arr[i+1];
                arr[i+1]=arr[j];
                arr[j]=temp;
                i++;
                j++;
            }
        }
        return i+1;
    }
    public List<Integer> findUnion(int arr1[],int arr2[])
    {
        List<Integer>union = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<arr1.length&&j<arr2.length)
        {
            if(arr1[i]<=arr2[j])
            {
                if(union.size()==0||union.get(union.size()-1)!=arr1[i])
                {
                    union.add(arr1[i]);
                }
                i++;
            }
            else{
                if(union.size()==0||union.get(union.size()-1)!=arr2[j])
                {
                    union.add(arr2[j]);
                }
                j++;
            }
        }
        while(i<arr1.length){
            
                if(union.size()==0||union.get(union.size()-1)!=arr1[i])
                {
                    union.add(arr1[i]);
                }
                i++;
        }
        while(j<arr2.length){
            
                if(union.size()==0||union.get(union.size()-1)!=arr2[j])
                {
                    union.add(arr2[j]);
                }
                j++;
        }
        return union;
        
    }
    // find missing Number (1-n+1)
    public int findMissing(int arr[])
    {
        int a = 1;
        for(int i=2;i<=arr.length+1;i++)
        {
            a^=i;
        }
        for(int i=0;i<arr.length;i++)
        {
            a^=arr[i];
        }
        return a;
    }
    // maximum consecutive ones - 1 -> two pointer approach
    public int maximumConsecutiveOnes(int arr[])
    {
        if(arr.length<=0){
            return 0;
        }
    if(arr.length == 1 && arr[0]==1)
    {
        return 1;
    }
    if(arr.length == 0)
    {
        return 0;
    }
    int max = 0;
    int cnt =0;
    for(int i=0;i<arr.length;i++)
    {
        if(arr[i]==1)
        {
            cnt++;
        }
        else{
            max = Integer.max(max,cnt);
            cnt=0;
        }
    }
    max = Integer.max(max,cnt);
    return max;
    }
}
public class Main1
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
	 obj.print(arr,n);
	 int size = obj.RemoveDuplicates(arr);
	 obj.print(arr,size);
	 obj.MoveZerosToEnd(arr);
	 obj.print(arr,n);
	 int arr2[] = new int[n];
	 for(int i=0;i<n;i++)
	 {
	     arr2[i]=sc.nextInt();
	 }
	 List<Integer>union = obj.findUnion(arr,arr2);
	 System.out.println(union);
	 System.out.println(obj.findMissing(arr));
	 System.out.println("Maximum Consecutive Ones are : "+obj.maximumConsecutiveOnes(arr));
	}
}
