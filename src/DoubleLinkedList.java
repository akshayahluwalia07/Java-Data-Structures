
public class DoubleLinkedList {
	
	private DoubleNode head;
	
	public void insertAtHead(int data)
	{
		DoubleNode newNode = new DoubleNode(data);
		DoubleNode current = head;
		if(current==null)
			head= newNode;
		else
		{
			newNode.setNext(current);
			current.setPrev(newNode);
			head = newNode;
		}
		
	}
	
	public void insertionSort()
	{
		DoubleNode current = this.head;
		if(current ==null)
			return;
		while(current!=null){
			DoubleNode prev= current.getPrev();
			while(prev!=null)
			{
				prev= prev.getPrev();
			}
			
		
			
		}
		
	}
	
	@Override
    public String toString(){
		DoubleNode current=this.head;
		String result= "{";
		while(current!=null)
		{
			result=result+ current.toString()+",";
			current=current.getNext();
		}
		result=result + "}";
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DoubleLinkedList dl = new DoubleLinkedList();
        dl.insertAtHead(3);
        dl.insertAtHead(4);
        dl.insertAtHead(2);
        dl.insertAtHead(5);
        dl.insertionSort();
        System.out.println(dl);
	}

}
