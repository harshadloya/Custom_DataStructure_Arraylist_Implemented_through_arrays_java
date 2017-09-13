package myArrayList;

import java.util.Arrays;

public class MyArrayList 
{
	public MyArrayList()
	{
		
	}
	
	int initialArraySize = 50;
	private int[] arrayList = new int[initialArraySize];
	
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
