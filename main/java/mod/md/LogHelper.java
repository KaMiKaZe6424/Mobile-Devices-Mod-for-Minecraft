package mod.md;

//import java.util.logging.*;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogHelper {
	private static Logger logger;
	
	public enum LvEnum {
		TRACE, WARN, INFO, FATAL, DEBUG, ALL, ERROR
	}
	
	private static Level CURRENT_LEVEL = Level.INFO;
	
	public static void trace(String message) {
		log(Level.TRACE, message);
	}
	
	public static void warning(String message) {
		log(Level.WARN, message);
	}
	
	public static void info(String message) {
		log(Level.INFO, message);
	}
	
	public static void fatal(String message) {
		log(Level.FATAL, message);
	}
	
	public static void debug(String message) {
		log(Level.DEBUG, message);
	}
	public static void all(String message) {
		log(Level.ALL, message);
	}
	
	public static void error(String message) {
		log(Level.ERROR, message);
	}

	public static void init() {
		logger = LogManager.getLogger("MD-Mod");
	}

	public static void log(Level logLevel, String message) {
		logger.log(logLevel, message);
	}
}