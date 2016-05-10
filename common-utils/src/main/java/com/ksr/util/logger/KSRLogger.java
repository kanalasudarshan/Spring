package com.ksr.util.logger;

import org.apache.log4j.Logger;

public class KSRLogger{
	
		
	public static void debug(Class classObj,String message){
		Logger.getLogger(classObj).debug(message);
	}
	
	public static void info(Class classObj,String message){
		Logger.getLogger(classObj).info(message);
	}
	
	public static void warn(Class classObj,String message){
		Logger.getLogger(classObj).warn(message);
	}
	
	public static void error(Class classObj,Exception exception){
		Logger.getLogger(classObj).error(classObj, exception);
	}
	
	public static void fetal(Class classObj,String message){
		Logger.getLogger(classObj).fatal(message);
	}

}
