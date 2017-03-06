
public class DoubleNode {

	private int data;
    private DoubleNode prev;
    private DoubleNode next;
    
    DoubleNode(int data)
    {
    	this.data = data;
    }
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public DoubleNode getPrev() {
		return prev;
	}
	public void setPrev(DoubleNode prev) {
		this.prev = prev;
	}
	public DoubleNode getNext() {
		return next;
	}
	public void setNext(DoubleNode next) {
		this.next = next;
	}
	
	@Override
	public String toString()
	{
		return "Data: "+this.data;
	}
	
}
