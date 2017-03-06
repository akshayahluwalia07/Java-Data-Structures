
public class TreeNode {
	
	private int data;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int data)
	{
		this.data = data;
	}
	public int getData() {
		return data;
	}
	
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	public TreeNode findRecursive(int data)
	{
		if(this.data==data)
			return this;
		if(data<this.data && left!=null)
			return left.findRecursive(data);
		if(right!=null)
			return right.findRecursive(data);
		return null;
	}
	
	public void insert(int data)
	{
		if(data>=this.data)
		{
			if(this.getRight()==null)
				this.setRight(new TreeNode(data));
			else
				this.getRight().insert(data);
		}
		
		else
		{
			if(this.getLeft()==null)
				this.setLeft(new TreeNode(data));
			else
				this.getLeft().insert(data);
		}
	}
	
	public void inorderTraverse()
	{
		if(this.getLeft()!=null)
			this.getLeft().inorderTraverse();
		System.out.print(this.data+" ");
		if(this.getRight()!=null)
			this.getRight().inorderTraverse();
	}
	
	public int height()
	{
		if(this.left ==null && this.right==null)
			return 1;
		
		int left=0;
		int right=0;
		
		if(this.left!=null)
		{
			left = this.left.height();
		}
		
		if(this.right!=null)
		{
			right = this.right.height();
		}
		
		return(left>right? left+1:right+1);
	}
}
