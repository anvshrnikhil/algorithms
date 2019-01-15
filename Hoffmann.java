
import java.util.Scanner;

class Node
{
	Node left;
	int frequency;
	char data;
	int count;
	Node right;
	Node link;
	Node()
	{
		left=null;
		frequency=0;
		data=' ';
		right=null;
		link=null;
		count=0;
	}
}

class LList //->Linked->List->
{
	protected Node p=null;
	protected int count=0;
	protected int total=0;
	protected void init()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the String in CAPITAL letters without punctuations and space: ");
		String str=sc.nextLine();
		getFrequency(str);
	}
	private void getFrequency(String str)
	{
		int freq[]=new int[26];//frequency array...
		try{
			for(int i=0;i<str.length();i++)
			{
				char ch=str.charAt(i);
				int ascii=(int)ch-65;
				freq[ascii]++;
			}
			generateFrequencyLinkedList(freq);
		}
		catch(ArrayIndexOutOfBoundsException e){System.out.println("Out of array index");}
	}
	private void generateFrequencyLinkedList(int[] freq)
	{
		for(int i=0;i<26;i++)
		{
			if(freq[i]!=0)
			{
				Node block=new Node();
				block.frequency=freq[i];
				block.data=(char)(i+65);
				block.count=count++;
				insert(block);
				total+=block.frequency;
			}
		}
		display();
	}
	private void insert(Node block)
	{
		if(p==null)
		{
			p=new Node();
			p.link=block;
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
		while(temp1!=null && temp1.frequency<block.frequency)
		{
			temp2=temp1;
			temp1=temp1.link;
		}
		temp2.link=block;
		block.link=temp1;
	}
	protected void display()
	{
		Node temp=p.link;
		System.out.println();
		while(temp!=null)
		{
			System.out.print(temp.frequency+"@"+temp.data+"->");
			temp=temp.link;
		}
		System.out.println();
	}
}

public class Hoffmann extends LList
{
	public static void main(String args[])
	{
		Hoffmann hfm=new Hoffmann();
		hfm.init();
		hfm.convertionOfLLToTree();
		System.out.println("Obtained tree is displayed in Inorder...");
		hfm.displayTree();
		hfm.generateCode();
	}
	
	private void convertionOfLLToTree()
	{
		Node temp=p.link;
		if(temp.frequency != total)
		{
			Node block=new Node();
			Node min1=minimum(100000);
			Node min2=minimum(min1.count);
			block.frequency=min1.frequency+min2.frequency;
			Node temp1=p;
			Node temp2=p;
			while((temp1.frequency!=min1.frequency) && (temp1.frequency!=min2.frequency))
			{
				temp2=temp1;
				temp1=temp1.link;
			}
			temp2.link=block;
			if(temp1.frequency==min1.frequency)
			{
				block.link=min2.link;
				block.left=min1;
				block.right=min2;
			}
			else
			{
				block.link=min1.link;
				block.left=min2;
				block.right=min1;
			}
			min1.link=null;
			min2.link=null;
			block.count=count++;
			display();
			convertionOfLLToTree();
		}
	}
	private Node minimum(int notcount)
	{
		Node min=new Node();
		min.frequency=total;
		Node temp=p.link;
		while(temp!=null)
		{
			if(min.frequency>temp.frequency && temp.count!=notcount)
			{
				min=temp;
			}
			temp=temp.link;
		}
		return min;
	}
	private void displayTree()
	{
		Node temp=p.link;
		inorder(temp);
		System.out.println();
	}
	private void inorder(Node temp)
	{
		if(temp!=null)
		{
			inorder(temp.left);
			System.out.print(temp.frequency+"->");
			inorder(temp.right);
		}
	}
	private void generateCode()
	{
		String s="";
		Node temp=p.link;
		gettingData(s,temp);
	}
	private void gettingData(String s,Node temp)
	{
		if(temp!=null)
		{
			s=s+"0";
			gettingData(s,temp.left);
			if(temp.data!=' ')
			{
				System.out.println(temp.data+" : "+s.substring(0,s.length()-1));
			}
			s=s.substring(0,s.length()-1);
			s=s+"1";
			gettingData(s,temp.right);
		}	
	}
}
