package org.qalegend.utilities;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
	public static String getUserLoginDate(String format)
	{
		DateFormat dateformatObj = new SimpleDateFormat(format);
		Date currentDateObj = new Date();
		return dateformatObj.format(currentDateObj);
	}


}
