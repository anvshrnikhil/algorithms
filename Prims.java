import java.util.Scanner;
class Node
{
	int row;
	int column;
	int value;
	Node next;
	Node()
	{
		row=0;
		column=0;
		next=null;
	}
}
public class Prims
{
	private int count=0;
	private int noofnodes=0;
	public static void main(String args[])
	{
		Prims prims=new Prims();
		prims.initial();
		
	}
	private void initial()
	{
		try{
			int matrix[][];
			Node bufferHead=null;
			Node head=null;
			noofnodes=getNoOfNodes();
			matrix=new int[noofnodes][noofnodes];
			matrix=getData(matrix);
			int startvertex=startNode();
			head=algorithm(matrix,bufferHead,head,startvertex);
			System.out.println("Display's the process: ");
			display(head);
			int totalcost=totalMinimumCost(head);
			System.out.println("\nMinimum cost of spanning tree: "+totalcost);
		}
		catch(Exception e){System.out.println("I Got Error:(");}
	}
	private int totalMinimumCost(Node head)
	{
		int cost=0;
		while(head!=null)
		{
			cost=cost+head.value;
			head=head.next;
		}
		return cost;
	}
	private Node algorithm(int[][] matrix,Node bufferHead,Node head,int startvertex)
	{
		if(count!=noofnodes){
			bufferHead=insertToBuffer(matrix,bufferHead,startvertex);
			boolean formCycle=true;
			Node min=new Node();
			while(formCycle==true)
			{
				if(bufferHead!=null)
				{
					min=bufferHead;
					bufferHead=bufferHead.next;
					min.next=null;
				}
				else
				{
					//execution of algorithm stops
					return head;
				}
				formCycle=noCycle(head,min);
			}
			head=connectToHead(head,min);
			count++;
			return algorithm(matrix,bufferHead,head,min.row+1);//row+1 is due to insertToBuffer makes the startvertex reduces 1 
		}
		else
		{
			return head;
		}
		
	}
	private Node connectToHead(Node head,Node min)
	{
		Node temp1=head;
		Node temp2=head;
		if(head==null)
		{
			head=min;
		}else{
			while(temp1!=null)
			{
				temp2=temp1;
				temp1=temp1.next;
			}
			temp2.next=min;
		}
		return head;
	}
	private boolean noCycle(Node head,Node min)
	{
		boolean bool=false;
		while(head!=null)
		{
			if(min.row==head.column || min.row==head.row)
			{
				bool=true;//Can form cycle...
				break;
			}
			head=head.next;
		}
		return bool;
	}
	private Node insertToBuffer(int[][] matrix,Node bufferHead,int startnode)
	{
		//Inserts in sorted order
		for(int i=0;i<matrix.length;i++)
		{
			if(matrix[i][startnode-1]!=0)
			{
				Node temp=new Node();
				temp.row=i;
				temp.column=startnode-1;
				temp.value=matrix[i][startnode-1];
				if(bufferHead==null)
				{
					bufferHead=temp;
				}
				else
				{
					if(temp.value<bufferHead.value)
					{
						temp.next=bufferHead;
						bufferHead=temp;
					}else{
						Node temp1=bufferHead;
						Node temp2=bufferHead;
						while(temp1!=null && temp.value>temp1.value)
						{
							temp2=temp1;
							temp1=temp1.next;
						}
						temp2.next=temp;
						temp.next=temp1;
					}
				}
			}
		}
		return bufferHead;
	}
	private void display(Node head)
	{
		while(head!=null)
		{
			System.out.println("From: "+(head.column+1)+" To: "+(head.row+1)+" Value: "+head.value);
			head=head.next;
		}
	}
	private int getNoOfNodes()
	{
		System.out.print("Enter no.of Nodes in Graph: ");
		Scanner sc=new Scanner(System.in);
		int value=sc.nextInt();
		return value;
	}
	private int[][] getData(int matrix[][]) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the data into Matrix and with no edge b/w vertices can insert as'0': ");
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[i].length;j++)
			{
				matrix[i][j]=sc.nextInt();
			}
		}
		System.out.println();
		return matrix;
	}
	private int startNode()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Set the Starting Node of the graph: ");
		int value=sc.nextInt();
		return value;
	}
}
