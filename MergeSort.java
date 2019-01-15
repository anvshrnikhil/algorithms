
import java.util.Scanner;
public class MergeSort
{
	private int n;
	private int a[];
	public static void main(String a[])
	{
		MergeSort r=new MergeSort();
		System.out.print("Enter the No.of elements: ");
		Scanner sc=new Scanner(System.in);
		r.n=sc.nextInt();
		r.a=new int[r.n];
		System.out.println("\nEnter the elements: ");
		for(int i=0;i<r.n;i++)
			r.a[i]=sc.nextInt();
		r.mergeSort(r.a,0,r.n-1);
		System.out.println();
		for(int i=0;i<r.n;i++)
			System.out.print(r.a[i]+" ");
		System.out.println();
	}
	private void mergeSort(int a[],int low,int high)
	{
		
		if(n==1)
			System.out.println("No need to sort");
		if(low!=high)
		{
			int mid=(low+high)/2;
			mergeSort(a,low,mid);
			mergeSort(a,mid+1,high);
			merge(low,mid,high);
		}
	}
	private void merge(int low,int mid,int high)
	{
		int b[]=new int[mid+1-low];
		int c[]=new int[high-mid];
		for(int i=low,j=0;i<=mid;i++,j++)
			b[j]=a[i];
		for(int i=mid+1,j=0;i<=high;i++,j++)
			c[j]=a[i];
		int d[]=new int[high+1-low];
		int bindex=0;
		int cindex=0;
		for(int i=0;i<d.length;i++)
		{
			if(bindex>=b.length)
			{
				d[i]=c[cindex];
				cindex++;
			}
			else if(cindex>=c.length)
			{
				d[i]=b[bindex];
				bindex++;
			}
			else if(b[bindex]>c[cindex])
			{
				d[i]=c[cindex];
				cindex++;
			}
			else
			{
				d[i]=b[bindex];
				bindex++;
			}
		}
		for(int i=low,j=0;i<=high;i++,j++)
			a[i]=d[j];
	}
}
