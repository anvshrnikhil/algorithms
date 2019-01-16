/*In this code enter the inputs in fallowing format:

The no.of vertices enter only in integer

Enter the edges in the form of matrix
if there is no edge then enter "-1" at that position

finally choose the starting edge

*/

import java.util.Scanner;

public class Dijkstra
{
	private int max=1000000;
	public static void main(String p[])
	{
		new Dijkstra().init();
	}
	
	private void init()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the no.of vertices: ");
		int vertices=0;
		try{
			vertices=sc.nextInt();
		}catch(Exception e)
		{
			System.out.println("Enter only Intergers");
			return;
		}
		int matrix[][]=new int[vertices][vertices];
		for(int i=0;i<vertices;i++)
		{
			for(int j=0;j<vertices;j++)
			{
				try
				{
					matrix[i][j]=sc.nextInt();
				}catch(Exception e)
				{
					System.out.println("Enter only integers");
					return;
				}
			}
		}
		
		System.out.print("Enter the starting node: ");
		
		int start=0;
		try
		{
			start=sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Enter only integers");
		}
		
		//AS the required inputs are taken
		dijkstra(vertices,matrix,start);
	}
	
	private void dijkstra(int vertices,int matrix[][],int startnode)
	{
		int result_index[]=new int[vertices];
		int result[]=new int[vertices];


		for(int i=0;i<vertices;i++)
		{
			result[i]=max;
		}
		
			result[startnode]=0;
		for(int j=0;j<vertices;j++){
		
			for(int i=0;i<vertices;i++)
			{
				if(matrix[startnode][i]!=-1)
				{
					int temp=result[startnode]+matrix[startnode][i];
					if(temp<result[i])
					{
						result[i]=temp;
					}
				}
			}
			for(int i=0;i<vertices;i++)
			{
				matrix[i][startnode]=-1;
			}
			result_index[startnode]=1;
			//System.out.println("testing:");
			//printResult(result);
			//System.out.println();
			startnode=min(vertices,result,result_index);
		}
		System.out.println("Result: ");
		printResult(result);
		System.out.println();
	}
	
	private int min(int vertices,int result[],int result_index[])
	{
		int min=max+1;
		int min_index=-1;
		for(int i=0;i<vertices;i++)
		{
			if(result_index[i]==0)
			{
				if(min>result[i])
				{
					min=result[i];
					min_index=i;
				}
			}
		}
		return min_index;
	}
	
	private void printResult(int result[])
	{
		for(int i=0;i<result.length;i++)
		{
			if(result[i]==1000000)
			
				System.out.print("Infinity ");
			else
				System.out.print(result[i]+" ");
		}
	}
	
}