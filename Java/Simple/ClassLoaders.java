/**
	What is a class loader?
	The Java Classloader is a part of the Java Runtime Environment that dynamically loads Java classes into the Java Virtual Machine. Usually classes are only loaded on demand. The Java run time system does not need to know about files and file systems because of classloaders.

	Types of classloaders: (Bootstrap, Extension, System) 
	(Refer ClassLoader.PNG)
		Bootstrap Class Loader:
		Bootstrap class loader loads java's core classes like java.lang, java.util etc. These are classes that are part of java runtime environment. Bootstrap class loader is native implementation and so they may differ across different JVMs. 

		Extensions Class Loader:
		JAVA_HOME/jre/lib/ext contains jar packages that are extensions of standard core java classes. Extensions class loader loads classes from this ext folder. Using the system environment propery java.ext.dirs you can add "ext" folders and jar files to be loaded using extensions class loader. 

		System Class Loader:
		Java classes that are available in the java classpath are loaded using System class loader.

	How class loaders actually work? (See image ClassLoader.PNG)
	 - As discussed on when a class is loaded and initialized in Java, a class is loaded in Java, when its needed. 
	 - Suppose you have an application specific class called Abc.class, first request of loading this class will come to Application ClassLoader which will delegate to its parent Extension ClassLoader which further delegates to Bootstrap or Bootstrap class loader. 
	 - Bootstrap will look for that class in rt.jar and since that class is not there, request comes to Extension class loader which looks on jre/lib/ext directory and tries to locate this class there, if class is found there than Extension class loader will load that class and Application class loader will never load that class but if its not loaded by extension class-loader than Application class loader loads it from Classpath in Java. 
	 - Remember Classpath is used to load class files while PATH is used to locate executable like javac or java command.

*/

class ClassLoaders {

}