package com.ksr.util.logger;

import org.apache.log4j.Logger;

public class KSRLogger{
	
	public static <T> void trace(Class<T> classObj,String message){
		Logger.getLogger(classObj).trace(message);
	}
	public static <T> void debug(Class<T> classObj,String message){
		Logger.getLogger(classObj).debug(message);
	}	
	public static <T> void info(Class<T> classObj,String message){
		Logger.getLogger(classObj).info(message);
	}
	
	public static <T> void warn(Class<T> classObj,String message){
		Logger.getLogger(classObj).warn(message);
	}
	
	public static  <T>void error(Class<T> classObj,Exception exception){
		Logger.getLogger(classObj).error(classObj, exception);
	}
	
	public static <T> void fetal(Class<T> classObj,String message){
		Logger.getLogger(classObj).fatal(message);
	}

}
