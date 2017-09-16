package myArrayList.test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import myArrayList.MyArrayList;
import myArrayList.util.Results;

public class MyArrayListTest 
{
	private boolean status = false;
	private boolean insertOp[] = new boolean[3];
	private boolean sortOp = false;
	private boolean removeOp[] = new boolean[3];

	private String testName = "";

	public void testMe(MyArrayList myArrayList, Results results)
	{
		results.storeNewResult("\n\nThe sum of all values in the arrayList is : " + myArrayList.sum() + "\n");

		//Calling the 10 test case methods using the below loop
		Method test[];
		Object tempObj;

		try 
		{
			test = MyArrayListTest.class.getDeclaredMethods();
			for(int y = 1; y <= 10; y++)
			{
				String methodName = "test" + y;
				for (int x = 0; x < test.length; x++)
				{
					if(0 == test[x].getName().compareToIgnoreCase(methodName))
					{
						tempObj = test[x].invoke(this, myArrayList);
						status = (boolean) tempObj;

						if(status)
						{
							status = false;
							results.storeNewResult("\nTest "+ testName + "\t\t\t\t\t\t\t\t\t\tPassed");
						}
						else
						{
							results.storeNewResult("\nTest "+ testName + "\t\t\t\t\t\t\t\t\t\tFailed");
						}
						testName = "";
					}
				}
			}
		} 
		catch (IllegalAccessException e) 
		{
			System.err.println("Cannot access the method\n");
			e.printStackTrace();
		} 
		catch (InvocationTargetException e) 
		{
			System.err.println("Cannot invoke the method\n");
			e.printStackTrace();
		}

		//writing results to the output file
		results.writeToFile();
	}

	private boolean test1(MyArrayList myArrayList)
	{
		//System.out.println("Test Multiple Inserts");
		testName = "Multiple Inserts";

		myArrayList.insertSorted(10);
		myArrayList.insertSorted(55);
		myArrayList.insertSorted(9236);

		insertOp[0] = checkInserted(10, myArrayList);
		insertOp[1] = checkInserted(55, myArrayList);
		insertOp[2] = checkInserted(9236, myArrayList);

		if(insertOp[0] && insertOp[1] && insertOp[2])
		{
			insertOp = new boolean[3];
			sortOp = false;
			return true;
		}

		return false;
	}

	private boolean test2(MyArrayList myArrayList)
	{
		//System.out.println("Test Multiple Removals");
		testName = "Multiple Removals";

		myArrayList.removeValue(1);
		myArrayList.removeValue(10);
		myArrayList.removeValue(9236);

		removeOp[0] = checkRemoved(1, myArrayList);
		removeOp[1] = checkRemoved(10, myArrayList);
		removeOp[2] = checkRemoved(9236, myArrayList);

		if(removeOp[0] && removeOp[1] && removeOp[2])
		{
			removeOp = new boolean[3];
			return true;
		}
		return false;
	}

	//can change
	private boolean test3(MyArrayList myArrayList)
	{
		//System.out.println("Test Multiple Sorted Inserts");
		testName = "Multiple Inserts are Sorted";

		myArrayList.insertSorted(10);
		myArrayList.insertSorted(55);
		myArrayList.insertSorted(9236);

		insertOp[0] = checkInserted(10, myArrayList);
		insertOp[1] = checkInserted(55, myArrayList);
		insertOp[2] = checkInserted(9236, myArrayList);
		sortOp = checkSorted(myArrayList);

		if(insertOp[0] && insertOp[1] && insertOp[2] && sortOp)
		{
			insertOp = new boolean[3];
			sortOp = false;
			return true;
		}

		return false;
	}

	private boolean test4(MyArrayList myArrayList)
	{
		//System.out.println("Test IndexOf");
		testName = "IndexOf value which is present in arrayList";

		int check = myArrayList.indexOf(55);
		try
		{
			assert check != -1;
		}
		catch(AssertionError ae)
		{
			System.err.println("Value Present in arrayList");
			ae.printStackTrace();
			return false;
		}
		return true;
	}

	private boolean test5(MyArrayList myArrayList)
	{
		int checkSize = 0, checkSum = 0, checkIndex = 0;
		//System.out.println("Test All operations");
		testName = "All operations in same function";

		myArrayList.insertSorted(100);
		myArrayList.removeValue(9236);
		checkSize = myArrayList.size();
		checkSum = myArrayList.sum();
		checkIndex = myArrayList.indexOf(100);
		insertOp[0] = checkInserted(100, myArrayList);
		sortOp = checkSorted(myArrayList);
		removeOp[0] = checkRemoved(9236, myArrayList);

		if(insertOp[0] && sortOp && removeOp[0] && checkSize>0 && checkSum>0 && checkIndex>-1)
		{
			return true;
		}
		return false;

	}

	private boolean test6(MyArrayList myArrayList)
	{
		//System.out.println("IndexOf for a value not present in arrayList");
		testName = "IndexOf for a value not present in arrayList";

		int index = myArrayList.indexOf(3243);
		try
		{
			assert index < 0;
		}
		catch(AssertionError ae)
		{
			System.err.println("Value Present in arrayList");
			ae.printStackTrace();
			return false;
		}
		return true;
	}

	private boolean test7(MyArrayList myArrayList)
	{
		//System.out.println("IndexOf for a value, Sum and Size on empty arrayList");
		testName = "IndexOf for a value, Sum and Size on empty arrayList";

		boolean indexOfCheck = false, sumCheck = false, sizeCheck = false;

		//Setting the arrayList to empty
		for(int x = 0; x < myArrayList.getArrayList().length; x++)
		{
			myArrayList.getArrayList()[x] = Integer.MAX_VALUE;
		}

		int index = myArrayList.indexOf(12);
		int sum = myArrayList.sum();
		int size = myArrayList.size();

		try
		{
			assert index < 0: "Value Present in arrayList";
			indexOfCheck = true;
		}
		catch(AssertionError ae)
		{
			indexOfCheck = false;
			System.err.println();
			ae.printStackTrace();
			System.err.println();
		}

		try
		{
			assert sum == 0: "Sum of elements of arrayList incorrect, should be 0";
			sumCheck = true;
		}
		catch(AssertionError ae)
		{
			sumCheck = false;
			ae.printStackTrace();
			System.err.println();
		}
		try
		{
			assert size == 0: "Size of arrayList incorrect, should be 0";
			sizeCheck = true;
		}
		catch(AssertionError ae)
		{
			sizeCheck = false;
			ae.printStackTrace();
			System.err.println();
		}

		if (indexOfCheck && sumCheck && sizeCheck)
			return true;
		return false;
	}

	private boolean test8(MyArrayList myArrayList)
	{
		//System.out.println("Test Size");
		testName = "Size function test with fixed number of elements";

		myArrayList.insertSorted(0);
		myArrayList.insertSorted(5);
		myArrayList.insertSorted(10);
		myArrayList.insertSorted(35);

		int check = myArrayList.size();
		try
		{
			assert check == 4;
		}
		catch(AssertionError ae)
		{
			System.err.println("More/Less values present than expected");
			ae.printStackTrace();
			return false;
		}
		return true;
	}

	private boolean test9(MyArrayList myArrayList)
	{
		//System.out.println("Sum of Elements check");
		testName = "Sum of Elements check";

		int checkSum = myArrayList.sum();
		try
		{
			assert checkSum == 50;
		}
		catch(AssertionError ae)
		{
			System.err.println("Sum function not working correctly, Sum should be 50");
			ae.printStackTrace();
			return false;
		}
		return true;

	}

	private boolean test10(MyArrayList myArrayList)
	{
		//System.out.println("Array Resizing Check");
		testName = "Array Resizing Check";

		String inPath = "./src/input.txt";
		String outPath = "./src/output.txt";
		File inputFile = new File(inPath);
		File outputFile = new File(outPath);
		try 
		{
			if(!inputFile.exists())
			{
				inputFile.createNewFile();
			}
			if(!outputFile.exists())
			{
				outputFile.createNewFile();
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		myArrayList = new MyArrayList(inPath, outPath);
		
		int initialCapacity = myArrayList.getArrayList().length;
		for(int x = 0; x < 12; x++)
			myArrayList.insertSorted(x);
		int newCapacity = myArrayList.getArrayList().length;
		
		try
		{
			assert newCapacity == (initialCapacity+initialCapacity*0.5);
		}
		catch(AssertionError ae)
		{
			System.err.println("arrayList not resizing as per specification of 50%");
			ae.printStackTrace();
			return false;
		}
		
		inputFile.delete();
		outputFile.delete();

		return true;

	}

	private boolean checkInserted(int value, MyArrayList myArrayList)
	{
		for (int x = 0; x < myArrayList.getArrayList().length; x++)
		{
			if(value == myArrayList.getArrayList()[x])
			{
				return true;
			}
		}
		return false;
	}

	private boolean checkSorted(MyArrayList myArrayList)
	{
		for (int x = 0; x < myArrayList.getArrayList().length - 1; x++)
		{
			if(myArrayList.getArrayList()[x] > myArrayList.getArrayList()[x+1])
			{
				return false;
			}
		}
		return true;
	}

	private boolean checkRemoved(int value, MyArrayList myArrayList)
	{
		for (int x = 0; x < myArrayList.getArrayList().length; x++)
		{
			if(value == myArrayList.getArrayList()[x])
			{
				return false;
			}
		}
		return true;
	}

}
