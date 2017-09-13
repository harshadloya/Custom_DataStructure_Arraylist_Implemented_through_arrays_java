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
		arrayList = new int[initialArraySize];
		for(int x = 0; x < arrayList.length; x++)
			arrayList[x] = -1;
	}

	public MyArrayList(String inputFilePath, String outputFilePath)
	{
		this();
		fileProcessor = new FileProcessor(inputFilePath);


		String temp = "";
		int i = 0;
		while((temp = fileProcessor.readLine(inputFilePath)) != null)
		{
			if (i == arrayList.length)
			{
				resizeArrayList();
			}
			
			//remove leading or trailing whitespaces if any
			temp = temp.trim();

			if(-1 == arrayList[i] && temp.matches("\\d+"))
				arrayList[i] = Integer.parseInt(temp);
			i++;
		}

		/* 
		 * Temporary Code just to check values inside arrayList
		 */
		System.out.println("Sorted:");
		Arrays.sort(arrayList);
		for(int x = 0; x < arrayList.length; x++)
			System.out.println(arrayList[x]);
		
		//close the open file in the end of reading
		fileProcessor.closeFile();
	}

	//Dynamically Increasing the size of Array by 50% if exceeds beyond current size
	private void resizeArrayList() 
	{
		int[] tempArrayList = new int[arrayList.length];

		for(int x = 0; x < tempArrayList.length; x++)
		{
			tempArrayList[x] = arrayList[x];
		}
		Arrays.sort(tempArrayList);

		arrayList = new int[arrayList.length + (int)(arrayList.length*0.5)];

		for(int x = 0; x < arrayList.length; x++)
		{
			if(x < tempArrayList.length)
				arrayList[x] = tempArrayList[x];
			else
				arrayList[x] = -1;
		}
	}

	public void insertSorted(int newValue)
	{

	}

	public void removeValue(int value)
	{

	}

	public int indexOf(int value)
	{
		return -1;
	}

	//returns total number of values stored in arrayList
	public int size()
	{
		return 0;
	}

	//returns the sum of all values stored in arrayList
	public int sum()
	{
		return 0;
	}

	//print all values of the array
	@Override
	public String toString() {
		return "MyArrayList [arrayList=" + Arrays.toString(arrayList) + "]";
	}

	public int[] getArrayList() {
		return arrayList;
	}

	public void setArrayList(int[] arrayList) {
		this.arrayList = arrayList;
	}



}
