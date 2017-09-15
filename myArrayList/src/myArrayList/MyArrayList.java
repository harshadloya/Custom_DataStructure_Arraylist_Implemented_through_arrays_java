package myArrayList;

import java.util.Arrays;

import myArrayList.util.FileProcessor;

public class MyArrayList 
{
	int initialArraySize = 10;
	private int[] arrayList;
	FileProcessor fileProcessor;

	public MyArrayList()
	{
		setArrayList(new int[initialArraySize]);
		for(int x = 0; x < getArrayList().length; x++)
			getArrayList()[x] = -1;
	}

	public MyArrayList(String inputFilePath, String outputFilePath)
	{
		this();
		fileProcessor = new FileProcessor(inputFilePath);


		String temp = "";
		int i = 0;
		while((temp = fileProcessor.readLine(inputFilePath)) != null)
		{
			if (i == getArrayList().length)
			{
				resizeArrayList();
			}

			//remove leading or trailing whitespaces if any
			temp = temp.trim();

			if(-1 == getArrayList()[i] && temp.matches("\\d+"))
			{
				getArrayList()[i] = Integer.parseInt(temp);
				i++;
			}
		}

		Arrays.sort(getArrayList());

		/* 
		 * Temporary Code just to check values inside arrayList
		System.out.println("Sorted:");
		Arrays.sort(getArrayList());
		for(int x = 0; x < getArrayList().length; x++)
			System.out.println(getArrayList()[x]);
		 */

		//close the open file in the end of reading
		fileProcessor.closeFile();
	}

	//Dynamically Increasing the size of Array by 50% if exceeds beyond current size
	private void resizeArrayList() 
	{
		int[] tempArrayList = new int[arrayList.length];

		for(int x = 0; x < tempArrayList.length; x++)
		{
			tempArrayList[x] = getArrayList()[x];
		}
		Arrays.sort(tempArrayList);

		setArrayList(new int[arrayList.length + (int)(arrayList.length*0.5)]);

		for(int x = 0; x < getArrayList().length; x++)
		{
			if(x < tempArrayList.length)
				getArrayList()[x] = tempArrayList[x];
			else
				getArrayList()[x] = -1;
		}

		Arrays.sort(getArrayList());
	}

	//inserts the value in the arrayList keeping it a sorted list
	public void insertSorted(int newValue)
	{
		if(getArrayList()[0] != -1)
		{
			resizeArrayList();
		}

		getArrayList()[0] = newValue;
		Arrays.sort(getArrayList());

	}

	//removes all occurrences of the passed value from arrayList
	public void removeValue(int value)
	{
		//initializing index to infinity
		int index = -2;
		int counter = 0;

		//fetching the number of occurrences for the given value
		index = indexOf(value);
		while (index != -1)
		{
			counter++;
			index = indexOf(value, index+1);	
		}
		
		//Removal Logic for any number of occurrences
		for (int i = 0; i < counter; i++)
		{
			index = indexOf(value);
			getArrayList()[index] = -1;
		}
		
		Arrays.sort(getArrayList());
		
		//value not found
		if (0 == counter)
		{
			System.err.println("\nSorry, The value to be removed " + value + " does not exist in the arrayList");
		}
	}

	
	//returns the index of the first occurrence of the passed value in the arrayList
	public int indexOf(int value)
	{

		for(int x = 0; x < getArrayList().length; x++)
		{
			if(value == getArrayList()[x])
				return x;
		}
		return -1;
	}
	
	private int indexOf(int value, int i) 
	{
		for(int x = i; x < getArrayList().length; x++)
		{
			if(value == getArrayList()[x])
				return x;
		}
		return -1;
	}

	//returns total number of values stored in arrayList
	public int size()
	{
		int count = 0;
		
		for(int x = 0; x < getArrayList().length; x++)
		{
			if(-1 != getArrayList()[x])
				count++;
		}
		return count;
		//return getArrayList().length;
	}

	//returns the sum of all values stored in arrayList
	public int sum()
	{
		int sum = 0;
		for(int x = 0; x < getArrayList().length; x++)
		{
			if(-1 != getArrayList()[x])
				sum += getArrayList()[x];
		}
		return sum;
	}

	//print all values of the array
	@Override
	public String toString() 
	{
		String temp = "\nArrayList:\n---------------------------------------------------------------------------------------------------------------\n";
		for(int x = 0; x < getArrayList().length; x++)
		{
			if(-1 != getArrayList()[x])
			{
				temp += "  " + getArrayList()[x] + "  ";
			}
		}	

		return temp;
	}

	public int[] getArrayList() {
		return arrayList;
	}

	public void setArrayList(int[] arrayList) {
		this.arrayList = arrayList;
	}

}
