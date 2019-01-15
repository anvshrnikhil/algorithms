import java.util.Scanner;
class Node
{
	Node left;
	int data;
	Node right;
}

public class BinaryTree
{
	Scanner sc=new Scanner(System.in);
	Node p=null;
	public static void main(String a[])
	{
		int choice=0;
		BinaryTree bt=new BinaryTree();
		while(true)
		{
			System.out.println("Operations: 1.Insert 2.Display 3.Exit");
			System.out.print("Enter your choice: ");
			choice=bt.sc.nextInt();
			switch(choice)
			{
				case 1:bt.insert();
					break;
				case 2:bt.display();
					break;
				default:return;
			}
		}
	}
	private void insert()
	{
		System.out.print("Enter the number to insert: ");
		int value=sc.nextInt();
		Node block=new Node();
		block.left=null;
		block.data=value;
		block.right=null;
		if(p==null)
		{
			p=block;
		}
		else{
			insertion(block);
		}
	}
	private void insertion(Node block)
	{
		Node temp1=p;
		Node temp2=p;
		do
		{
			if(temp1.data==block.data)
			{
				System.out.println("Value: "+block.data+" is already present in tree..");
				System.out.println("This value is not inserted into tree");
				break;
			}
			else if(temp1.data<block.data)
			{
				temp2=temp1;
				temp1=temp1.right;
			}
			else{
				temp2=temp1;
				temp1=temp1.left;
			}
		}while(temp1!=null);
		
		if(temp2.data<block.data)
		{
			temp2.right=block;
		}
		else
			temp2.left=block;
	}
	private void display()
	{
		Node temp=p;
		System.out.println("Appearence: 1.Preorder 2.Inorder 3.Postorder\n");
		int choice=0;
		System.out.print("Enter your choice: ");
		choice=sc.nextInt();
		switch(choice)
		{
			case 1:preorder(temp);
				break;
			case 2:inorder(temp);
				break;
			case 3:postorder(temp);
				break;
			default:System.out.println("Cannot found the way to display...\n");
				break;
		}
		System.out.println();
	}
	private void preorder(Node temp)
	{
		if(temp==null)
			return;
		System.out.print(temp.data+"->");
		preorder(temp.left);
		preorder(temp.right);
	}
	private void postorder(Node temp)
	{
		if(temp==null)
			return ;
		postorder(temp.left);
		postorder(temp.right);
		System.out.print(temp.data+"->");
	}
	private void inorder(Node temp)
	{
		if(temp==null)
			return;
		else{
			inorder(temp.left);
			System.out.print(temp.data+"->");
			inorder(temp.right);
		}
	}
}	
