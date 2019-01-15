
import java.util.Scanner;
public class QuickSort
{
	private int a[];
	public static void main(String args[])
	{
		QuickSort qs=new QuickSort();
		System.out.print("Enter the No.of Elements: ");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		qs.a=new int[n];
		System.out.println("Enter the values: ");
		for(int i=0;i<n;i++)
			qs.a[i]=sc.nextInt();
		qs.quickSort(0,n-1,qs.a);
		//quicksort(low,high,array)
		//
		//Displaying sorted array
		System.out.println("Resulting sorted array: ");
		for(int i=0;i<n;i++)
			System.out.print(qs.a[i]+" ");
		System.out.println();
	}
	private void quickSort(int start,int end,int a[])
	{
		if(start<end)
		{
			int low=start;
			int high=end;
			int pivot=low;
			while(low<=high)
			{
				while(high>=start && a[high]>a[pivot])
				{
					--high;
				}
				while(low<=end && a[low]<=a[pivot])
					++low;
				if(low<=high)
				{
					swap(low,high);
				}
			}
			swap(high,pivot);
			//System.out.println();
			//for(int i=0;i<a.length;i++)
				//System.out.print(a[i]+" ");
			//System.out.println();
			quickSort(start,high-1,a);
			quickSort(high+1,end,a);
		}
	}
	private void swap(int x,int y)
	{
		int temp;
		temp=a[x];
		a[x]=a[y];
		a[y]=temp;
	}
}
