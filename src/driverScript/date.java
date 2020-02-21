package driverScript;

import java.text.SimpleDateFormat;
import java.util.Date;

public class date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date d= new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY_MM_DD_hh_mm_SS");
        
		String rd= sdf.format(d);
          System.out.println(rd);
	}

}
