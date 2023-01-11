package edu.pitt.cs;

import java.util.ArrayList;
import java.util.List;
//TODO: Import libraries as needed
import java.util.NoSuchElementException;

public class SortedCollection {
	// TODO: Add member variables or methods as needed

	List<Integer> list = new ArrayList<Integer>();

	/**
	 * Adds the number n to the collection.
	 * 
	 * @param n the number to add to the collection
	 * @return always returns true
	 */
	public boolean add(int n) {
		// TODO: Implement
		list.add(n);
		return true;
	}

	/**
	 * Removes the smallest number in the collection and returns it.
	 * If the collection is empty, throws a NoSuchElementException.
	 * 
	 * @return the smallest number in the collection
	 */
	public int remove() throws NoSuchElementException {
		// TODO: Implement
		if (list.size() == 0)
		{
			throw new NoSuchElementException();
		}
		int min = Integer.MAX_VALUE;
		int loc = 0;
		for (int i = 0; i < list.size(); i ++)
		{
			int val = list.get(i);
			if (val < min)
			{
				min = val;
				loc = i;
			}
		}
		list.remove(loc);
		return min;
	}

	/**
	 * Prints usage information.
	 */
	public static void showUsage() {
		System.out.println("Usage: java SortedCollection [num1] [num2] [num3] ...");
	}

	/**
	 * Main method. Receives a list of numbers as commandline arguments and prints
	 * out the list in sorted order from smallest to largest.
	 * 
	 * @param args commandline arguments; see showUsage() for detailed information
	 */
	public static void main(String[] args) {
		SortedCollection collection = new SortedCollection();
		if (args.length == 0) {
			showUsage();
			return;
		}
		
		// TODO: add numbers in commandline arguments to collection using the add(int) method.
		// If any commandline argument is not a number, call showUsage() and return.
		for (int i = 0; i < args.length; i ++)
		{
			try {
				int num = Integer.parseInt(args[i]); 
				collection.add(num);
			} catch (Exception e){
				showUsage();
				return ;
			}
		}
		System.out.print("sorted: ");
		for (int i = 0; i < args.length; i++) {
			int num = collection.remove();
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
