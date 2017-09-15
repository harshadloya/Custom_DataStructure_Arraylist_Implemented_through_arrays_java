package myArrayList.test;

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
		results.storeNewResult("\n\nThe sum of all values in the arrayList is : " + myArrayList.sum());

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
							results.storeNewResult("\nTest "+ testName + " Passed");
						}
						else
						{
							results.storeNewResult("\nTest "+ testName + " Failed");
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
		System.out.println("Test Multiple Inserts");
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
		System.out.println("Test Multiple Removals");
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

	private boolean test3(MyArrayList myArrayList)
	{
		System.out.println("Test Multiple Sorted Inserts");
		testName = "Multiple Sorted Inserts";
		
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
		System.out.println("Test IndexOf");
		testName = "IndexOf function";
		
		int check = myArrayList.indexOf(55);
		if(check != -1)
		{
			return true;
		}
		return false;

	}

	private boolean test5(MyArrayList myArrayList)
	{
		System.out.println("Test Size");
		testName = "Test Size function";
		
		int check = myArrayList.size();
		if(check != 0)
		{
			return true;
		}		
		return false;

	}

	private boolean test6(MyArrayList myArrayList)
	{
		System.out.println("Test 6");
		testName = "Test 6";
		
		return false;

	}

	private boolean test7(MyArrayList myArrayList)
	{
		System.out.println("Test 7");
		testName = "Test 7";
		
		return false;

	}

	private boolean test8(MyArrayList myArrayList)
	{
		System.out.println("Test 8");
		testName = "Test 8";
		
		return false;

	}

	private boolean test9(MyArrayList myArrayList)
	{
		System.out.println("Test 9");
		testName = "Test 9";
		
		return false;

	}

	private boolean test10(MyArrayList myArrayList)
	{
		System.out.println("Test 10");
		testName = "Test 10";
		
		return false;

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
