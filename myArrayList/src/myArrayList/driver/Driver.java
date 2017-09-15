package myArrayList.driver;

import myArrayList.MyArrayList;
import myArrayList.test.MyArrayListTest;
import myArrayList.util.Results;

public class Driver {

	public static void main(String[] args) 
	{
		String inputFilePath = "";
		String outputFilePath = "";

		if (args.length == 2)
		{
			inputFilePath = args[0];
			outputFilePath = args[1];
			
			MyArrayList myArrayList = new MyArrayList(inputFilePath, outputFilePath);
			Results testResults = new Results(outputFilePath);
			MyArrayListTest testcases = new MyArrayListTest();
			testcases.testMe(myArrayList, testResults);
		}
		else
		{
			System.out.println("Invalid number of arguments, please recheck");
		}

	}

}
