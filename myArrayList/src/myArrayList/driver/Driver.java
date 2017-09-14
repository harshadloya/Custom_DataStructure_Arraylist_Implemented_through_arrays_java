package myArrayList.driver;

import myArrayList.MyArrayList;

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
			System.out.println(myArrayList.toString());
			
			//myArrayList.removeValue(1);
			
			System.out.println();
			System.out.println(myArrayList.toString());
		}
		else
		{
			System.out.println("Invalid number of arguments, please recheck");
		}

	}

}
