set LIB=%cd%

set CLASSPATH=%LIB%\lib\selenium-server-standalone-2.52.0.jar;%LIB%\bin;%LIB%\log4j.xml;%LIB%\lib\log4j-1.2.17.jar;

java org.testng.TestNG testng.xml

@pause  