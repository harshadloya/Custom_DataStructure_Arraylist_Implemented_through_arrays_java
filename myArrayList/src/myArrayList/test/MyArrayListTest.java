package myArrayList.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import myArrayList.MyArrayList;
import myArrayList.util.Results;

public class MyArrayListTest 
{
	boolean status = false;

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
							results.storeNewResult("\nTest "+ y + " Passed");
						}
						else
						{
							results.storeNewResult("\nTest "+ y + " Failed");
						}
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
		System.out.println("Test 1");
		myArrayList.insertSorted(10);
		myArrayList.insertSorted(372);
		myArrayList.insertSorted(55);
		myArrayList.insertSorted(9236);
		myArrayList.insertSorted(1245);
		
		if(myArrayList.insertOp)
		{
			myArrayList.insertOp = false;
			return true;
		}
			
		return false;

	}

	private boolean test2(MyArrayList myArrayList)
	{
		System.out.println("Test 2");
		
		myArrayList.removeValue(1);
		myArrayList.removeValue(372);
		myArrayList.removeValue(1245);
		myArrayList.removeValue(10);
		
		if(myArrayList.removeOp)
		{
			myArrayList.removeOp = false;
			return true;
		}
		return false;

	}

	private boolean test3(MyArrayList myArrayList)
	{
		return false;

	}

	private boolean test4(MyArrayList myArrayList)
	{
		return false;

	}

	private boolean test5(MyArrayList myArrayList)
	{
		return false;

	}

	private boolean test6(MyArrayList myArrayList)
	{
		return false;

	}

	private boolean test7(MyArrayList myArrayList)
	{
		return false;

	}

	private boolean test8(MyArrayList myArrayList)
	{
		return false;

	}

	private boolean test9(MyArrayList myArrayList)
	{
		return false;

	}

	private boolean test10(MyArrayList myArrayList)
	{
		return false;

	}

}
