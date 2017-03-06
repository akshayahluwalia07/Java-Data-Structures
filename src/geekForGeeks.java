

import java.util.HashMap;
import java.util.Scanner;

class Arrays{
	// 1. Given an array A[] and a number x, check for pair in A[] with sum as x
	
	public static void sumcheck(int[] array, int x)
	{
		boolean[] sum= new boolean[100000];
		
		for(int i=0;i<array.length;i++)
		{
			int temp = x -array[i];
		if(temp>=0 && sum[temp])
		{
			System.out.println("Sum of "+x+" is "+array[i]+" "+temp);
		}
		sum[array[i]]=true;
		}
	}
	
	/*A majority element in an array A[] of size n is an element that appears more than n/2 times (and hence there is at most one such element).

    Write a function which takes an array and emits the majority element (if it exists), otherwise prints NONE as follows:*/
  public static void majorityelement(int[]a)
  {
	  for(int i=0;i<a.length;i++)
	  {
		  int count=0;
		  for(int j=0;j<a.length;j++)
		  {
			  if(a[i]==a[j]){
				  count++;
			  }
				  
		  }
		  if(count>(a.length/2)){
			  System.out.print("Majority Element is "+a[i]);
			  break;
		  }
	  }
  }
  
  public static int findCandidate(int a[], int size) 
  {
      int maj_index = 0, count = 1;
      int i;
      for (i = 1; i < size; i++) 
      {
          if (a[maj_index] == a[i])
              count++;
          else
              count--;
          if (count == 0)
          {
              maj_index = i;
              count = 1;
          }
      }
      return a[maj_index];
  }
  
/*  Find the Number Occurring Odd Number of Times
  Given an array of positive integers. All numbers occur even number of times except one number which occurs odd number of times. Find the number in O(n) time & constant space. 
*/
  
  public static void oddelement(int[] a)
  {
	  HashMap<Integer,Integer> odd= new HashMap<Integer,Integer>();
	  int count=0;
	  for(int i=0; i<a.length;i++){
		  if(odd.size()!=0 && odd.containsKey(a[i]))
		  {
			  odd.replace(a[i],odd.get(a[i])+1);
		  }
		  else{
		  count=1;
	      odd.put(a[i],count);
		  }
	  }
	  
	  for(Integer key:odd.keySet()){
		  if(odd.get(key)%2!=0)
		  {
			  System.out.println("The odd occurance number is "+ key);
		  }
	  }
	  
  }
  
  // Contiguous sum array - find the largest contiguous sum of elements present in an array
  public static int kadanecontiguousesumarray(int temp[]){
	  
		int max, sum = 0;
		
		max = Integer.MIN_VALUE;

		int i;

		for(i = 0; i < temp.length; i++){
			sum += temp[i];

			if(sum > max){
				max = sum;
			}

			if(sum < 0){
				sum = 0;
			}
		}

		return max;
	}
  
  
  // Find the missing number in the array of string
  
  public static void missing(int[] a, int n)
  {
	   int total= (n+1)*((n+2)/2);
	   for(int i=0; i<n;i++)
	   {
		   total = total-a[i];
	   }
	   
	   System.out.print("Missing element is: "+total);
  }
  
  /*
   * Leaders in an array
Write a program to print all the LEADERS in the array. An element is leader if it is greater than all 
the elements to its right side. And the rightmost element is always a leader.
 For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
   */
  
  public static void leaders(int[] a)
  {
	  int pointer=0;
	  System.out.println("The Leaders are: ");
	  for(int i=0; i<a.length;i++)
	  {
		  for(int j=i+1; j<a.length;j++)
		  {
			  if(a[i]>a[j])
			  {
				  pointer=j;
				  continue;
			  }
				
			  else
				  break;
		  }
		  if(pointer==a.length-1) System.out.print(a[i]+" ");
		  pointer=0;
	  }
  }
  /*
   * An Array of integers is given, both +ve and -ve. 
   * You need to find the two elements such that their sum is closest to zero.
   */
  public static void closestZero(int[] a)
  {
	   int min = Math.abs(a[0]+a[1]);
	   int no1=0,no2=0;
	   for(int i=0;i<a.length;i++)
	   {
		   for(int j=0; j<a.length;j++)
		   {
			   if(i==j)
				   continue;
			   else
			   {
				   if(Math.abs(a[i]+a[j])<=min)
				   {
					   min= Math.abs(a[i]+a[j]);
				      no1=i;
				      no2=j;
				   }
			   }
		   }
	   }
	   System.out.println("The pair is: "+no1+" "+no2);
  }

}
  class Strings{	  
	  
	  /*
	  Given two strings, the task is to find if they are only less than or equal to k edit distance apart. It means that strings are only k edit distance apart when there are only k mismatches.
	 Print Yes if there are less than or equal to k mismatches, Else No.
	 Also print yes if both strings are already same.
	  */
   public static String distApart(String s1, String s2, int k)
{
	String min_s;
	String max_s;
	if(s1.length()>=s2.length())
	{
		min_s=s2;
	    max_s=s1;
	}
	else
	{
		min_s=s2;
	    max_s=s1;
	}
	
	int diff =Math.abs((s1.length()-s2.length()));
	if(diff>k)
		return "No";
	else
	{
		for(int i=0; i<min_s.length();i++)
		{
			if(!max_s.contains(String.valueOf(min_s.charAt(i))))
					return "No";			
		}
		return "Yes";
		
	}
}
   /*
    Given a string S and Q queries, each query contains a string T. The task is print “Yes” if T is subsequence of S, else print “No”.
    */
   public static String subSequence(String s1, String s2)
   {
	   char[] arr1;
	   char[] arr2; 
	   int max, min;
	   if(s1.length()>=s2.length())
	   {
		   arr1= s1.toCharArray();
		   arr2=s2.toCharArray();
	   }
	   else
	   {
		   arr1= s2.toCharArray();
		   arr2=s1.toCharArray();
	   }
	   int index=-1;
	   int count=0;
	   char[] temp = new char[arr2.length];
	   
	   for(int i=0; i<arr2.length;i++)
	   {
		   for(int j=0; j<arr1.length;j++)
		   {
			   if(arr1[j]==arr2[i])
			   {
				   if(j>index)
				   {
				   index= j;
				   temp[i]= arr2[i];
				   count++;
				   break;
				   }
				   else if(j<index && (!temp.toString().contains(String.valueOf(arr1.toString().charAt(j)))))
					   return "No";
				   
				   else if(j==index)
					   continue;
					   
			   }
		   }
	   }
	   if(count==arr2.length) return "Yes";
	   else return "No";
	   
	  
   }
   
   public static int getDivisors(int div)
   {   int sum=1;
	   for (int i = 2; i <= div / 2; i++) {
		    if (div % i == 0) {
		        sum=sum+i;
		    }
		}
	   return sum;
   }
   
   public static int amicableNumbers(int[] a)
   {
	   int pairs=0;
	   for(int i=0; i <a.length;i++)
	   {
		   for(int j=i+1; j<a.length;j++)
		   {
			   if(getDivisors(a[i])==a[j] && getDivisors(a[j])==a[i])
			   {
				   pairs++;
			   }
		   }
	   }
	   return pairs;
   }
   
   public static int indexPairs(int[] a)
   {
	   int pairs=0;
	   for(int i=0; i <a.length;i++)
	   {
		   for(int j=i+1; j<a.length;j++)
		   {
			   if(a[j]==a[i])
			   {
				   pairs++;
			   }
		   }
	   }
	   return pairs;
   }
   
  /*
   * Implement an space efficient algorithm to determine if a string (of characters from ‘a’ to ‘z’) 
   * has all unique characters or not. 
   * Use additional data structures like count array, hash, etc is not allowed.
   */
 public static void duplicate(String s)
 {
	boolean[] Char = new boolean[256];
	int count=0;
	for(int i=0; i<s.length();i++)
	{ 
		int val= s.charAt(i);
		if(Char[val])
		{
			System.out.println("Duplicate found");
			break;
		}
		Char[val]=true;
		count++;
	}
	if(count==s.length()) System.out.println("No Duplicates");
 }
   
   
   
   
 // end of Strings Class  
}


public class geekForGeeks {
	
public static void main(String args[])
{
	int []a = new int[8];
	for(int i = 0; i < a.length; i++) {
	   a[i] = (int)(Math.random()*10+1);
	  
	}

	Strings.duplicate("adsa");
	
	}
}


