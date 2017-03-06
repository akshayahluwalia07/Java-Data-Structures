
public class Stack {
	
	int top =-1;
	int[] array;
	
   Stack(int n){
	array = new int[n];
}
	
	public void push(int n)
	{
		if((top+1) <array.length)
		array[++top]=n;
		else
			System.out.print("Array size is full");
	}
	
	public int pop()
	{
		if(top <0)
			return -1;
		else
			return array[top--];
	}
	
	public int peek()
	{ if(top <0)
		return -1;
			return array[top];
	}
	
	public void print(){
		for(int i=0; i<=top;i++)
		{
			System.out.print(array[i]+" ");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Stack s1 = new Stack(4);
    s1.push(5);
    s1.push(4);
    s1.push(3);
    s1.push(2);
    s1.print();
    System.out.println();
    System.out.println(s1.pop());
    System.out.println(s1.pop());
    System.out.println(s1.pop());
    System.out.println(s1.pop());
	}

}
