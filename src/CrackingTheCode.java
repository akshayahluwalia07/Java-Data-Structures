
import java.util.*;
import java.util.Arrays;
public class CrackingTheCode {
	
	/*
	 * Implement an algorithm to determine if a string has all unique characters. What if you
	 * cannot use any additional data-structures ? 
	 */
	public static String uniqueString(String s)
	{
		for(int i=0; i<s.length();i++)
		{
			int c = s.charAt(i);
			
			for(int j=0; j<s.length();j++)
			{
				if(i==j) continue;
				else
				{
					int y= s.charAt(j);
					if(c==y)
						return "String contains duplicate character";
				}
			}
		}
		return "String is unique";
	}
	
	// Using an additional data-structure to check if unique characters are present in the String
	
	public static void uniqueStringUsingDataStructures(String s)
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
	
	// Check if two strings are permutations of each other (anagram)
	
	public static String isPermutation(String s1, String s2)
	{
		if(s1.length()!=s2.length())
			System.out.println("The 2 given strings are not permutation of each other");
		
		Map<Character,Integer> h1 = new Hashtable<Character,Integer>();
		for(int i=0; i<s1.length();i++)
		{
			if(h1.containsKey(s1.charAt(i)))
				h1.replace(s1.charAt(i), h1.get(s1.charAt(i))+ 1);
			else
			h1.put(s1.charAt(i),1);
		}
		for(int i=0; i<s2.length();i++)
		{
			if(h1.containsKey(s2.charAt(i)))
				h1.replace(s2.charAt(i), h1.get(s2.charAt(i))- 1);

		}
		
		for(Character key: h1.keySet()){  
			   if(h1.get(key)==0)
				   continue;
			   else
				   return "The two strings are not permutations of each other";
				   
			  }  
		return "The two strings are permutations of each other";
		
		
	}
	
	// Given a string, replace all white-spaces by "%20".
	public static void stringReplace(String s)
	{
		char[] array= s.toCharArray();
		int spaces=0;
		for(char c:array)
		{
			if(c==' ')
				spaces++;
		}
		if(spaces ==0)
			System.out.println("There are no white spaces in the string");
		
		char[] newarray = new char[array.length+(spaces*2)];
		int index=0;
		for(int i=0; i< array.length;i++,index++)
		{
			if(array[i]!=' ')
				newarray[index]= array[i];
			
			else
			{
				newarray[index++]='%';
				newarray[index++]='2';
				newarray[index]='0';
			}
		}
		
		for(char c:newarray)
		{
			System.out.print(c);
		}
		
		
	}
	
	// Given a string apply compression on the string e.g. "aabbccd" becomes "a2b2bc2d1".
	
	public static void stringCompression(String s)
	{
		char[] array= s.toCharArray();
		Arrays.sort(array);
		int duplicates =1;
		int counter =0;
		for(int i=0; i<array.length;i++)
		{
			if((i+1)<array.length)
			{
			if(array[i]==array[i+1])
			{
				duplicates++;
				counter++;
			}
			else
			{
				if(counter!=0)
				{
				System.out.print(array[i]+ Integer.toString(duplicates));
				duplicates =1;
				}
				else
				{
					System.out.print(array[i]);
				}
			}
		}
		}
		if(counter!=0)
			System.out.print(array[array.length-1]+ Integer.toString(duplicates));
		else
			System.out.print(array[array.length-1]);
	}
	
	/*Write a code to remove duplicates from a LinkedList using an additional data structure
	and follow up by not using a data structure
	Please refer the removeDuplciates functions with DS and without to refer to the solutions
	and the methods used
	*/
	
	/*
	 Write a code to partition a linkedList on a given node x such that all elements lower than x
	 are to the left of x and all elements greater are to the right
	 Please refer to the partition LinkedList method in the LinkedList class
	 /*
	  You have two numbers represented by a linked list, where each node contains a single digit.
	  The digits are stored in reverse order, such that the 1's digit is at the head of the list. 
	  Write a function that adds the two numbers and returns teh sum as a linked list.
	  Please refer to the reverseSum function in the LinkedList class. 
	  */
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    // CrackingTheCode.stringCompression("aabccde");
		CrackingTheCode c= new CrackingTheCode();
		LinkedList l1= new LinkedList();
		l1.insertNodeAtHead(11);
		l1.insertNodeAtHead(41);
		l1.insertNodeAtHead(43);
		l1.insertNodeAtHead(12);
		l1.insertNodeAtHead(11);
		l1.insertNodeAtHead(12);
		l1.insertNodeAtHead(43);
		l1.insertNodeAtHead(41);
		l1.insertNodeAtHead(12);
		l1.insertNodeAtHead(12);
		l1.insertNodeAtHead(11);
		l1.insertNodeAtHead(12);
		l1.insertNodeAtHead(17);
		l1.insertNodeAtHead(5);
		l1.insertNodeAtHead(6);
		l1.insertNodeAtHead(24);
		l1.insertNodeAtHead(45);
		l1.insertNodeAtHead(51);
		l1.insertNodeAtHead(9);
		l1.removeDuplicates();
		System.out.println(l1);
		l1.reverseSum();
	}

}
