
public class Node {

	private int data;
	private Node node;
	
	Node(int data)
	{
		this.data=data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
	}
	
	@Override
	public String toString()
	{
		return "Data: "+this.data;
	}
	
}
