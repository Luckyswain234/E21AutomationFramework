package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class consist of gerenic method related specific to java
 * @Baniprava swain
 */

public class javaUtility {
	/**
	 * This method will capture the current system date and return to caller
	 * @return Date
	 */
	public String getSystemData()//Screenshot name ,report name                              m
	{
		Date d = new Date();//04 june 2025 wednesday IST 12:54:34
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String Date = s.format(d);
		return Date;
		
	}

}
