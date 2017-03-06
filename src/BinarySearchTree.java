
public class BinarySearchTree {
	
	private TreeNode root;
	
	public void find(int data)
	{
		TreeNode current = root;
		if(root==null) return;
		
		while(current!=null)
		{
			if(current.getData()==data)
			{
				System.out.println("Element found");
				break;
			}
			
			else{
				
				if(data<current.getData())
					current=current.getLeft();
				
				else
					current=current.getRight();
			}
		}
		
		if(current==null)
			System.out.println("Element not found");
	}
	
	public TreeNode findRecursive(int data){
		if(root!=null)
			return root.findRecursive(data);
	
		return null;
			
	}
	
	public void insert(int data)
	{
		if(root==null)
			this.root= new TreeNode(data);
		
		else
			root.insert(data);
	}
	
	public void delete(int data)
	{
		
		TreeNode current = this.root;
		TreeNode parent = this.root;
		boolean isLeftChild = false;
		
		if(current==null)
			return;
		
		while(current!=null && current.getData()!=data)
		{
			parent = current;
			if(data>= current.getData())
			{
				current= current.getRight();
				isLeftChild= false;
			}
			else
			{
				current = current.getLeft();
			    isLeftChild= false;
			}
		}
		
		if(current==null)
			return;
		
		if(current.getLeft()==null && current.getRight()==null)
		{
			if(current==root)
				root=null;
			else
			{
			if(isLeftChild)
				parent.setLeft(null);
			else
				parent.setRight(null);
		    }
		}
		
		if(current.getLeft()!=null && current.getRight()==null)
		{
			if(current==root)
				root= current.getLeft();
			if(isLeftChild)
			parent.setLeft(current.getLeft());
			else
				parent.setRight(current.getLeft());
		}
		
		if(current.getLeft()==null && current.getRight()!=null)
		{
			if(current==root)
				root=current.getRight();
			if(isLeftChild)
				parent.setLeft(current.getRight());
				else
					parent.setRight(current.getRight());
		}
			
		
	}
	
	public void traverseInOrder() {
		if (this.root != null)
			this.root.inorderTraverse();
		System.out.println();
	}
	
	public void height() {
		if (this.root == null) System.out.println("empty tree");
		System.out.println("height: "+this.root.height());
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(15);
		tree.insert(10);
		tree.insert(18);
		tree.insert(5);
		tree.insert(12);
		tree.insert(16);
		tree.insert(20);
		tree.insert(19);
		tree.insert(21);
		tree.insert(22);
		tree.height();
        
	}

}
