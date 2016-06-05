- What are different types of logging API's you know?
	Log4j, Morgan for NodeJS etc.

- Explain what is log4j?
	Log4j is fast, flexible and reliable logging framework written in Java.

- Important features of log4j?
	*) Loggers
	*) Appenders - Are used to write logs to the files.
	*) Layouts - To style log files.

- What are the different logger methods we have?
	*) All
	*) info
	*) error
	*) warn

- What are the static methods of log4j?
	public static Logger getRootLogger()
	public static Logger getLogger(String name)

- How do you create a logger using log4j?
	import org.apache.log4j.Logger;
	class LogEx {
		static Logger logger = Logger.getLogger(LogEx.class.getName());

		public static void main(String[] args) {
			logger.debug("Hello. I am log4j - debug");
			logger.info("Hello. I am log4j - info");
		}
	}

- Is log4j thread safe?
	YES

		