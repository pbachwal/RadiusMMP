package org.iit.healthcare.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class AppLibrary 
{
	static Random rand;
	public static String selectFutureDate(int days) 
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		Date date = cal.getTime();
		System.out.println("Future Date is : " + date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
		String formattedDate = sdf.format(date);
		System.out.println("Formatted Date is : " + formattedDate);
		return formattedDate;
	}
	
	public static String getRandomString(int noOfChars) 
	{
		rand = new Random();
		String s = "";
		int length = noOfChars;
		for(int i=0; i<length; i++) 
		{
			char c = (char) ('a'+rand.nextInt(26));
			s = s+c;
		}
		System.out.println("List of the random string that has been genrated" +s);
		return s;
	}
	
	public static String getRandomNo(int n, int range) 
	{
		rand = new Random();
		String str = "";
		for(int i=0; i<n; i++) 
		{
			str = str+8;
		}
		System.out.println(str);
		return str+rand.nextInt(range);
	}
	
	public static String getRandomState()
	{

		String state = "";

		String[] sArray = {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
				"Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine","Maryland", "Massachusetts", "Michigan",
				"Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York",
				"North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
				"Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" };

		int num = rand.nextInt(49);
		state = sArray[num];
		System.out.println(state);		
		return state;
	}
	
public static int getRandomNoOfDigits(int noOfDigits)
{
		rand = new Random();
		int addend1=0, addend2=0; String zero ="";String bound = "";int result=0;
		for(int i=1;i<=(noOfDigits-1); i++)
		{
			zero = zero+0;
		}
		zero = 1+zero;
		addend1 = Integer.parseInt(zero);
		for (int j=1; j<=(noOfDigits-1); j++)
		{
			bound = bound+9;
		}
		bound = 8+bound;
		addend2 = Integer.parseInt(bound);
		result = addend1+ rand.nextInt(addend2);
		System.out.println("Random "+noOfDigits+ " digit number is : "+result);
		return result;
	}
}
