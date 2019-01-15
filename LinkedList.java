import java.util.Scanner;
class Node
{
	int data;
	Node next;
}
public class LinkedList
{
	Scanner sc=new Scanner(System.in);
	Node p;
	public static void main(String a[])
	{
		//Scanner sc=new Scanner(System.in);
		int choice=0;
		LinkedList ll=new LinkedList();
		while(true)
		{
			System.out.println("Operations : 1.Insert 2.Display 3.Exit ");
			System.out.print("Enter the choice:");
			choice=ll.sc.nextInt();
			switch(choice)
			{
				case 1:ll.insert();
					break;
				case 2:ll.display();
					break;
				default:return;
			}
		}
	}
	private void insert()
	{
		int value;
		System.out.print("Enter the element to insert:");
		value=sc.nextInt();
		Node block=new Node();
		block.data=value;
		block.next=null;
		if(p==null)
		{
			p=new Node();
			p.next=block;
		}
		else
		{
			insertion(block);
		}
	}
	private void insertion(Node block)
	{
		Node temp1=p;
		Node temp2=p;
		while(temp1!=null && temp1.data < block.data)
		{
			temp2=temp1;
			temp1=temp1.next;
		}
		temp2.next=block;
		block.next=temp1;
	}
	private void display()
	{
		Node temp=p.next;
		System.out.println();
		while(temp!=null)
		{
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.println();
	}
}
