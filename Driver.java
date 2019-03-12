/*
 Idehen Emmanuel 
2/1/2018
CS221-Java Programming 

Program:  This programs takes name, age, gender, major, classification and GPA as input
from file and calculates the age from current year, checks the users classification and returns
their classification. It outputs the students information to the monitor, calculates the GPA and 
write the students information to an output file. 

***Design (Pseudo/Algorithm)***
Declare file reader,open file, use buffered reader to read file in and store the information in variables
get name and read line , get gender and check if input from file is m, then gender is male else gender is female 
get year and subtract from current year to get age. get major  and store in variable, get classification, if student
less than or equal to 24 hours then freshman else between 25- 48, sophomore, else between 49-72 junior,
grater than 73 senior. Then read students information to output file. 
 

*******************************
 */
import java.io.BufferedReader;

import java.io.File;

import java.io.FileReader;

import java.io.PrintWriter;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;


public class Driver

{
	  
public static void main(String args[]) throws Exception
{
DecimalFormat money = new DecimalFormat("0.00"); // Decimal Formatter
    //...................................
DecimalFormat pricePattern = new DecimalFormat("0.00");
// File reader, reads file in 
File file = new File("file.txt");

FileReader fr;
// try and catch to see if the right file was opened 
try {

fr = new FileReader(file);
// Buffered 
BufferedReader br = new BufferedReader(fr);
// get name 
String name = br.readLine();
// get gender 
String gender = br.readLine();
// check if gender is M
if(gender.equals("M"))
//get M
gender = "Male";
// else gender is female 
else
// 
gender = "Female";
// get year 
//age
int year =Integer.parseInt( br.readLine());
int currentyear = 2018;
year = currentyear - year;
//major
String branch = br.readLine();
// hours 
// classification calculator
int hours = Integer.parseInt(br.readLine());

// pass gpa 
double gpa = Double.parseDouble(br.readLine());
// close reading
br.close();
// classification 
String classification = getClassification(hours);
// scanner 
Scanner in = new Scanner(System.in);
// initialize grade point 
int gradePoints = 0;
// Loop for response 
System.out.println("................................");
for(int i = 0; i < 4; i++){
// enter grades
System.out.println("Enter grade:");
// take input
String grade = in.nextLine();

// get grades point average 
gradePoints += getPoints(grade) * 3;

}
System.out.println("................................");
//calculate current GPA
double currentGPA = (double)gradePoints / 12;
// calculate final 
double finalGPA = (currentGPA + gpa) / 2;
// write to the file 
PrintWriter writer = new PrintWriter("outcome.txt", "UTF-8");

writer.println(name);

writer.println(gender);

writer.println(year);

writer.println(branch);

writer.println(classification);

writer.printf(money.format(finalGPA));

writer.close();

} catch (Exception e) 
{
e.printStackTrace();

}

}
// method to return each gardes value 
private static int getPoints(String grade) {

if(grade.equals("A") || grade.equals("a"))

return 4;

else if(grade.equals("B") || grade.equals("b"))

return 3;

else if(grade.equals("C") || grade.equals("c"))

return 2;

else if(grade.equals("D") || grade.equals("d"))

return 1;

else

return 0;

}
// get classification 
private static String getClassification(int hours) {

if(hours <= 24)

return "Freshman";

else if(hours >= 25 || hours <= 48 )

return "Sophomore";

else if(hours >= 49 || hours <= 72)

return "Junior";

else

return "Senior";

}

}



/*
Test case

............................
Enter grade:
A
Enter grade:
A
Enter grade:
B
Enter grade:
B
...........................

Emmanuel Idehen
Female
27
Computer Science
Senior
3.75

............................
Enter grade:
A
Enter grade:
A
Enter grade:
B
Enter grade:
B
............................

Mercy Mercy
Male
41
Computer Science
freshman
2.25
............................
Enter grade:
A
Enter grade:
A
Enter grade:
B
Enter grade:
B
............................
dane drake
Male
41
Computer Science
junior
2.25
............................



*/