Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: modified build file to compile when run command is executed

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=FIRST -Darg1=SECOND
eg: ant -buildfile src/build.xml run -Darg0=/import/linux/home1/hloya1/input_file/input_file.txt -Darg1=/import/linux/home1/hloya1/output_file/output_file.txt

#Note: 
1. Make sure input_file.txt is present at appropriate location
2. Output file location doesn't matter but its name should be "output_file.txt"
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 9/15/2017]

-----------------------------------------------------------------------
Data Structure Used is as per given in specifications - Arrays.
-----------------------------------------------------------------------