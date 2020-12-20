package utility;

import org.apache.log4j.Logger;

public class loggers 
{
	
	public static void logges(String txt)
	{
		Logger log =Logger.getLogger(Class.class);
		log.info(txt);
	}
	
}
