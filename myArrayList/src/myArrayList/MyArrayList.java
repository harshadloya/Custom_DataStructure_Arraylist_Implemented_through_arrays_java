package myArrayList;

import java.util.Arrays;

import myArrayList.util.FileProcessor;

public class MyArrayList 
{
	int initialArraySize = 9;
	private int[] arrayList;
	FileProcessor fileProcessor;
	
	public MyArrayList()
	{
		arrayList = new int[initialArraySize];
	}
	
	public MyArrayList(String inputFilePath, String outputFilePath)
	{
		this();
		fileProcessor = new FileProcessor(inputFilePath);
		
		
		String temp = "";
		int i = 0;
		while((temp = fileProcessor.readLine(inputFilePath)) != null)
		{			
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
