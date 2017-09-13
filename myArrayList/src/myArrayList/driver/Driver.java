package myArrayList.driver;

public class Driver {

	public static void main(String[] args) 
	{
		String inputFilePath = "";
		String outputFilePath = "";

		if (args.length == 3)
		{
			inputFilePath = args[1];
			outputFilePath = args[2];
		}
		else
		{
			System.out.println("Invalid number of arguments, please recheck");
		}

	}

}
