package org.iit.healthcare.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AppLibrary 
{
	public String path;
	private FileInputStream fis;
	//private static XSSFWorkbook workbook=null;
	//private static XSSFSheet sheet = null;
	static Random rand;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public AppLibrary(String path) 
	{

		this.path = path;
		try 
		{
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String selectFutureDate(int days) 
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		Date date = cal.getTime();
		System.out.println(date);

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		String formattedDate = sdf.format(date);
		return formattedDate;
	}

	public static Object[][] readXLSX(String filePath, String sheetName) throws  IOException 
	{
		File srcFile = new File(filePath);
		FileInputStream fis = new FileInputStream(srcFile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println("RowCount is:" + sheet.getLastRowNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) 
			{
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				System.out.println(data[i][j]);

			}

		}
		workbook.close();
		return data;
	}

	public Object[][] getTestData(String sheetName) throws IOException 
	{
		sheet = workbook.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) 
		{
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) 
			{
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				System.out.println(data[i][j]);
			}

		}
		workbook.close();
		return data;

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
	
	

	public static String generateRandom(int n, int range) 
	{
		rand = new Random();
		String str = "";
		for (int j = 0; j < n; j++) {
			str = str + 246;
			//str = str+8;
		}
		System.out.println("generate random number from app lib " + str);

		return str + rand.nextInt(range);
	}

	public static String getRandomState() 
	{
		String state = "";
		String[] sArray = new String[50];
		sArray[0] = "Alabama";
		sArray[1] = "Alaska";
		sArray[2] = "Arizona";
		sArray[3] = "Arkansas";
		sArray[4] = "California";
		sArray[5] = "Colorado";
		sArray[6] = "Connecticut";
		sArray[7] = "Delaware";
		sArray[8] = "Florida";
		sArray[9] = "Georgia";
		sArray[10] = "Hawaii";
		sArray[11] = "Idaho";
		sArray[12] = "Illinois";
		sArray[13] = "Indiana";
		sArray[14] = "Iowa";
		sArray[15] = "Kansas";
		sArray[16] = "Kentucky";
		sArray[17] = "Louisiana";
		sArray[18] = "Maine";
		sArray[19] = "Maryland";
		sArray[20] = "Massachusetts";
		sArray[21] = "Michigan";
		sArray[22] = "Minnesota";
		sArray[23] = "Mississippi";
		sArray[24] = "Missouri";
		sArray[25] = "Montana";
		sArray[26] = "Nebraska";
		sArray[27] = "Nevada";
		sArray[28] = "New Hampshire";
		sArray[29] = "New Jersey";
		sArray[30] = "New Mexico";
		sArray[31] = "New York";
		sArray[32] = "North Carolina";
		sArray[33] = "North Dakota";
		sArray[34] = "Ohio";
		sArray[35] = "Oklahoma";
		sArray[36] = "Oregon";
		sArray[37] = "Pennsylvania";
		sArray[38] = "Rhode Island";
		sArray[39] = "South Carolina";
		sArray[40] = "South Dakota";
		sArray[41] = "Tennessee";
		sArray[42] = "Texas";
		sArray[43] = "Utah";
		sArray[44] = "Vermont";
		sArray[45] = "Virginia";
		sArray[46] = "Washington";
		sArray[47] = "West Virginia";
		sArray[48] = "Wisconsin";
		sArray[49] = "Wyoming";
		int num = rand.nextInt(49);
		state = sArray[num];
		System.out.println(state);
		return state;
	}

	public static int getRandomNoOfDigits(int noOfDigits) 
	{
		rand = new Random();
		int addend1 = 0, addend2 = 0;
		String zero = "";
		String bound = "";
		int result = 0;
		for (int i = 1; i <= (noOfDigits - 1); i++) 
		{
			zero = zero + 0;
		}
		zero = 1 + zero;
		addend1 = Integer.parseInt(zero);
		for (int j = 1; j <= (noOfDigits - 1); j++) 
		{
			bound = bound + 9;
		}
		bound = 8 + bound;
		addend2 = Integer.parseInt(bound);
		result = addend1 + rand.nextInt(addend2);
		System.out.println("Random " + noOfDigits + " digit number is : " + result);
		return result;

	}
}
