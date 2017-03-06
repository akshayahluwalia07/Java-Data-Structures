import java.util.*;
public class LinkedList {
	
	// Other variation is a double ended list which uses head and tail as pointers to 
	// add elements to the head and tail of the list
	
	private Node head;
	
	public Node getHead()
	{
		return head;
	}
	
	public void removeDuplicates()
	{
		Node current=head;
		Node runner=current;
		while(current!=null && runner.getNode()!=null)
		{
			
			while(runner.getNode()!=null)
			{
				if(current.getData()==runner.getNode().getData())
				{
					runner.setNode(runner.getNode().getNode());
				}
				else
				runner = runner.getNode();
					
			}
			current = current.getNode();
			runner=current;
		}
	}
	
	public void deleteUniqueMiddleNode(Node n)
	{
		if(n==null || n.getNode()==null)
			return;
		
		n.setData(n.getNode().getData());
		n.setNode(n.getNode().getNode());
	}
	
	public void removeDuplicatesDS()
	{
		Node current=head;
		Map<Integer,Integer> ll= new Hashtable<Integer,Integer>();
		while(current!=null)
		{
			if(!ll.containsKey(current.getData()))
			{
				ll.put(current.getData(),1);
			}
			current=current.getNode();
		}
		
		for(Integer key: ll.keySet())
		{
			System.out.println("{Data :"+key+" ");
		}
		System.out.print(" }");
	}
	
public void partitionLinkedList(int data)
{
	LinkedList p1= new LinkedList();
	LinkedList p2= new LinkedList();
	LinkedList merged = new LinkedList();
	
	Node current = head;
	while(current!=null)
	{
		if(current.getData()> data)
			p2.insertNodeAtHead(current.getData());
		else
		{
			if(current.getData() < data)
			p1.insertNodeAtHead(current.getData());
			
		}
		
		current= current.getNode();
	}
    
	Node head1= p1.getHead();
	Node head2= p2.getHead();
	
	while(head2!=null)
	{
		merged.insertNodeAtHead(head2.getData());
		head2= head2.getNode();
	}
	
	merged.insertNodeAtHead(data);
	
	while(head1!=null)
	{
		merged.insertNodeAtHead(head1.getData());
		head1= head1.getNode();
	}
	
	System.out.println(merged);
	
	
	
}

public void reverseSum()
{
	LinkedList s1 = new LinkedList();
	LinkedList s2= new LinkedList();
	LinkedList no1 = new LinkedList();
	LinkedList no2 = new LinkedList();
	StringBuffer num1 = new StringBuffer();
	StringBuffer num2 = new StringBuffer();
	
	s1.insertNodeAtHead(6);
	s1.insertNodeAtHead(1);
	s1.insertNodeAtHead(7);
	
	s2.insertNodeAtHead(2);
	s2.insertNodeAtHead(9);
	s2.insertNodeAtHead(5);
	
	Node h1 = s1.getHead();
	Node h2 = s2.getHead();
	
	while(h1!=null)
	{
		no1.insertNodeAtHead(h1.getData());
		num1.append(Integer.toString(h1.getData()));
		h1= h1.getNode();
	}
	
	while(h2!=null)
	{
		no2.insertNodeAtHead(h2.getData());
		num2.append(Integer.toString(h2.getData()));
		h2= h2.getNode();
	}
	
   int sum = Integer.parseInt(num1.reverse().toString()) + Integer.parseInt(num2.reverse().toString());
	System.out.println(sum);
	
	
}
	
	public void insertNodeAtHead(int data)

	{
		Node newNode= new Node(data);
		
		if(head==null)
		{
			head= newNode;
		}
		
		else{
			newNode.setNode(head);
			head = newNode;
		}
	}
	
	public void deleteNodeAtHead()
	{
		this.head = this.head.getNode();
	}
	
	public String Search(int data)
	{
		Node current= this.head;
		while(current!=null)
		{
			if(data== current.getData())
				return "Yes";
			current= current.getNode();
		}
		 return "No";
	}
	
	public void insertNode(int data)
	{
		Node newNode= new Node(data);
		if(this.head==null)
		{
			head= newNode;
		return;
		}
		Node current= this.head;
		while(current!=null)
		{
		
			if(data<head.getData())
			{
				newNode.setNode(head);
				head = newNode;
				break;
			}
			
			else if(current.getNode()==null)
			{
				current.setNode(newNode);
				break;
			}
			else if(data<current.getNode().getData())
			{
				newNode.setNode(current.getNode());
				current.setNode(newNode);
				break;
			}
			current = current.getNode();
		}
			
	}
	
	@Override
    public String toString(){
		Node current=this.head;
		String result= "{";
		while(current!=null)
		{
			result=result+ current.toString()+",";
			current=current.getNode();
		}
		result=result + "}";
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList ll = new LinkedList();
		ll.insertNodeAtHead(10);
		ll.insertNode(11);
		System.out.print(ll);

	}

}
