
import java.util.Scanner;
public class JobSequencing
{
	int profit[];
	int deadline[];
	Scanner sc=new Scanner(System.in);
	public static void main(String args[])
	{
		JobSequencing js=new JobSequencing();
		System.out.print("Enter no.of Jobs: ");
		int n=js.sc.nextInt();
		System.out.println("\nPls..Enter the profits in sorted order:");
		js.profit=new int[n];
		for(int i=0;i<n;i++)
			js.profit[i]=js.sc.nextInt();
		js.deadline=new int[n];
		System.out.println("Enter the deadline for each job: ");
		for(int i=0;i<n;i++)
			js.deadline[i]=js.sc.nextInt();
		js.jobsequencing(js.profit,js.deadline);
	}
	private void jobsequencing(int profit[],int deadline[])
	{
		int max=0;
		for(int i=0;i<deadline.length;i++)
			if(max<deadline[i])
				max=deadline[i];
		int job[]=new int[max];
		int maxprofit=0;
		int getting_deadline=0;
		for(int i=0;i<profit.length;i++)
		{
			getting_deadline=deadline[i];
			for(int j=getting_deadline-1;j>=0;j--)
			{
				if(job[j]==0)
				{
					maxprofit=maxprofit+profit[i];
					job[j]=i+1;
					break;
				}
			}
		}
		System.out.println("Max profit is: "+maxprofit);
		display(job);
	}
	private void display(int job[])
	{
		System.out.println("Sequence of jobs...");
		for(int i=0;i<job.length;i++)
			System.out.print(job[i]+"->");
		System.out.println();
		System.out.println("No work is done at 0(zero) position");
	}
}

