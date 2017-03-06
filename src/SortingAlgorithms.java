
public class SortingAlgorithms {
	
// find the GCD of two numbers presented to the user

public static int EuclidAlgorithm(int m, int n)
{
	if(n==0) return m;
	return EuclidAlgorithm(n,m%n);

  
}
/*Bubble Sort ---------- 
Bubble sort is an algorithm where each item starting from the left is compared to its next element on the right
After the first loop, the largest element would bubble to the right
For the next iteration the pointer from the last element can be removed since its sorted
Decrease pointer during each loop till we reach the first element as the pointer
Now the array is sorted
*/

public static void BubbleSort(int[] a)
{
	for(int i=a.length-1; i>0;i--)
	{
	for(int j=0;j<i;j++)
	{
		int temp;
		if(a[j]>a[j+1])
		{
			temp=a[j+1];
			a[j+1]=a[j];
			a[j]=temp;
		}
	}
	}
}

/*Selection Sort -------
Selection sort is an algorithm where the smallest element in the array is determined 
and placed in the first position. Now the pointer is moved to second position and the iteration
runs again finding the smallest element and placing it in the second position
until the pointer ends at the last index of the array
*/

public static void SelectionSort(int[] a)
{
for(int i=0;i<a.length;i++)
{
	for(int j=a.length-1;j>i;j--)
	{
		int temp;
		if(a[j]<a[j-1])
		{
			temp=a[j-1];
			a[j-1]=a[j];
			a[j]=temp;
		}
	}
}
}

/*Insertion Sort ------
Insertion sort is an algorithm where each element of an array is considered as if its inserted
We consider that the first element of the array is already present
Moving forward, the second element of the array is considered with all the elements present to 
its left and sorted, any element along the way would be sorted too.
The pointer moves from left to right as the insertion of elements move forward.
 */

public static void InsertionSort(int[] a)
{
	for(int i=1;i<a.length;i++)
	{
		for(int j=i;j>0;j--)
		{
			int temp;
			if(a[j]<a[j-1])
			{
				temp=a[j-1];
				a[j-1]=a[j];
				a[j]=temp;
			}
		}
	}
}

/*
 * In Binary Search, we find the mid point of the array and decide if the element to be
 * searched belongs to the left or the right side of the array
 * Once decided, we take that portion and repeat step 1 by finding the mid-point unless we 
 * find the element to be searched
 */
public static void BinarySearch(int[] n, int search)
{
	int low= 0;
	int high= n.length-1;
	int mid= (high+low)/2;
	
	while (n[mid]!=search && low<=high)
	{
	if(search>n[mid])
	{
		low=mid+1;
	}
	else
	{
		high=mid-1;
	}
	mid=(low+high)/2;
	}
	if(n[mid]==search) System.out.println("Element is present");
	else System.out.println("Element is not present");
}

/*
 * Merge sort is an algorithm which partitions your array into smaller sub-arrays until you
 * reach a single element of the array, this is done using recursion. Once the single element is
 * reached it is sorted with the corresponding element and merged to get a sorted array, then 
 * the calls move higher up the stack and next pair of elements are merged.
 */
public static void MergeSort(int[] a, int low, int high)
{
int mid= (low+high)/2;
if(low<high)
{
	MergeSort(a,low,mid);
	MergeSort(a, mid+1,high);
	Merge(a, low, mid, high);
}
}

public static void Merge(int[] a, int low, int mid, int high)
{
	int[] temp = new int[high-low+1];
	int left=low;
	int right=mid+1;
	int k=0;
	
	while(left<=mid && right<=high)
	{
		if(a[left]<=a[right])
		{
			temp[k]= a[left];
			left++;
			k++;
		}
		
		else{
			temp[k]= a[right];
			right++;
			k++;
		}
	}
	if(left<=mid)
	{
		while(left<=mid)
		{
			temp[k]=a[left];
			left++;
			k++;
		}
	}
	if(right<=high)
	{
		while(right<=high)
		{
			temp[k]=a[right];
			right++;
			k++;
		}
	}
	for(int m=0; m<temp.length;m++)
	{
		a[low+m]=temp[m]; 	 
	}
}

/*
 * Quick sort is an algorithm where a pivot element is choosen from the array. In this case
 * we take this as the last element in the array.
 * After deciding the pivot element, partitioning is applied to the array such that all the 
 * elements less than the pivot would be on the left side and all the elements greater than
 * the pivot would be on the right side. After this loop, quick sort recursion is applied to the elements on
 * the left on the array and then similarly quick sort is applied to the right side elements.
 */
public static void QuickSort(int[] a, int start, int end)
{
	if(start>=end)
		return;
	int pivot=a[end];
	int partition= Partition(a,start,end, pivot);
	QuickSort(a,0, partition-1);
	QuickSort(a,partition+1,end);
}

public static int Partition(int[] array, int start, int end, int pivot)
{
	int left= start;
	int right= end-1;
	
	while(left<right)
	{
		while(array[left]<pivot && left<=right)
			left++;
		while(array[right]>=pivot && right>0)
			right--;
		
		if(left>=right) break;
		int temp =array[left];
		array[left]=array[right];
		array[right]=temp;
	
	}
	int temp1 =array[left];
	array[left]=pivot;
	array[end]=temp1;
	
	return left;
}

/* Using Knuths algorithm a distance is generated to sort two elements, e.g. if distance is 4
 * first and fourth element are sorted and then the element is shifted to right maintaining 
 * the same distance, when the outer element exceeds the distance, new value of knuth's is
 * calculated until the value is 1. In the final iteration of value 1, insertion sort is
 * applied to all the elements one by one and the array is sorted. 
 */

public static void ShellSort(int[] array) {
    int inner, outer;
    int temp;
 
    int h = 1;
    while (h <= array.length / 3) {
      h = h * 3 + 1;
    }
    while (h > 0) {
      for (outer = h; outer < array.length; outer++) {
        temp = array[outer];
        inner = outer;
 
        while (inner > h - 1 && array[inner - h] >= temp) {
          array[inner] = array[inner - h];
          inner -= h;
        }
        array[inner] = temp;
      }
      h = (h - 1) / 3;
    }
  }

/*
 * Counting Sort - We assume that we have information about the data, e.g. we know the numbers 
 * lie in the range of 1-10, using this information we create an array of max size n, and count
 * each instances of the array and store it, and then retirve it in the sorted ascending order
 */

public static void CountingSort(int[] a)
{
	int temp[]= new int[11];
	for(int i=0;i<a.length;i++)
	{
		temp[a[i]]++;
	}
	
	for(int i=0;i<temp.length;i++)
	 {
		 if(temp[i]!=0)
		 {
			 while(temp[i]>0)
			 {
				 System.out.print(i+" ");
				 temp[i]--;
			 }
		 }
	 }
	
}

/* Radix Sort
 * Radix sort works on the principal of sorting by the radix number, in case of decimal, each
 * digit at each position is taken and the number is sorted until the last decimal place is 
 * reached for the number
 */

public static void RadixSort(int[] a)
{
	int max=0;
	for(int i=0;i<a.length;i++)
	{
		if(a[i]>max)
			max=a[i];
	}
	
	String s= Integer.toString(max);
	int slength= s.length();
	
	for(int i=0;i<a.length;i++)
	{
		
	}
	
	
}

// Bucket Sort - Algorithm



public static void main(String args[])
{
	int []a = new int[15];
	for(int i = 0; i < a.length; i++) {
	   a[i] = (int)(Math.random()*10+1);
	}
	
	System.out.println("Before Sort: ");
	for(int i=0;i<a.length;i++)
	 {
		 System.out.print(a[i]+" ");
	 }
	//CountingSort(a);
	System.out.println();
	System.out.println("After Sort: ");
	
	CountingSort(a);
	/*for(int i=0;i<a.length;i++)
	 {
		 System.out.print(a[i]+" ");
	 }
	 */
	
	//Euclid Algorithm
	//int gcds =EuclidAlgorithm(16,12);
	//System.out.println("GCD is: "+gcds);
	//QuickSort(a,0,a.length-1);
		
}
}
