
public class Queue {
	
	int head = -1;
	int tail =-1;
	int no_of_items =0;
	int[] queue;
	
   Queue(int n){
	queue = new int[n];
}
	
	public void enqueue(int n)
	{
		if(no_of_items>= queue.length)
			System.out.println("Array size is full");
		else
		{
			if(tail== queue.length-1)
				tail =-1;
			if(head==-1)
			head++;
			queue[++tail]= n;
			no_of_items++;
		}
	}
	
	public int dequeue()
	{
		if (no_of_items==0)
			throw new RuntimeException("Queue is empty");
		if(head==-1)
			head++;
		if(head==queue.length-1)
		{
			head =-1;
		no_of_items--;
		System.out.println("head: "+this.head+" tail: "+this.tail);
		return queue[queue.length-1];
		}
		no_of_items--;
		System.out.println("head: "+this.head+" tail: "+this.tail);
		return queue[head++];
		
	}
	
	public int peek()
	{ 
		return queue[head+1];
	}
	
	public void print(){
		for(int i=0; i<queue.length;i++)
		{
			System.out.print(queue[i]+" ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Queue q1= new Queue(6);
    q1.enqueue(3);
    q1.enqueue(5);
    q1.enqueue(6);
    q1.enqueue(1);
    q1.enqueue(9);
    q1.enqueue(12);
    q1.enqueue(13);
    q1.print();
    System.out.println();
    System.out.println(q1.dequeue());
    System.out.println(q1.dequeue());
    System.out.println(q1.dequeue());
    q1.enqueue(2);
    q1.enqueue(23);
    q1.enqueue(44);
    q1.print();
    System.out.println(q1.dequeue());
    System.out.println(q1.dequeue());
    System.out.println(q1.dequeue());
    System.out.println(q1.dequeue());
    System.out.println(q1.dequeue());
    System.out.println(q1.dequeue());
    System.out.println(q1.dequeue());
    q1.enqueue(123);
    q1.enqueue(444);
    q1.print();
    
	}

}
