package myArrayList.driver;

import myArrayList.MyArrayList;
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
			
			//String[] test = new String[11];
			//test[0] = myArrayList.toString();
			
			//System.out.println(myArrayList.toString());
			
			//myArrayList.removeValue(1);
			
			//test[1] = "\n";
			//System.out.println();
			
			//test[2] = myArrayList.toString();
			//System.out.println(myArrayList.toString());
			
			//testResults.setResultSetStrings(test);
			//testResults.writeToFile();
		}
		else
		{
			System.out.println("Invalid number of arguments, please recheck");
		}

	}

}
