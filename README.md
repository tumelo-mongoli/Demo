# Demo project
Vanilla Flavor

How to setup Environment Variables 

- Download and setup Java 
- Download Maven source zip file from https://maven.apache.org/download.cgi 
- Create new folder in the c drive under program files and name maven
- Right click - This PC >> Properties >> Advanced System Settings >> System Properties window will be displayed 

-  Click on Environment variables 

- Under the User variables
	For Java 
		- Click New 
		- Add a variable name: Java_Home 
		- Add a variable value: {location where the java file is created: e.g: C:\Program Files\Java\jdk-18}
		- Click Ok 
		- Click Path 
		- Edit 
		- Add the loacation [similar loation to the variable value]
		- Click Ok 
		
	For Maven 
		- Click on New....
		- Add a Variable name : MAVEN_HOME
		- Add a Variable value : {location where the maven file is created: e.g: C:\Program Files\maven\apache-maven-3.9.2}
		- Click Ok 
		
		
- Under the System variables
	For Java 
		- Click New 
		- Add a variable name: Java_Home 
		- Add a variable value: {location where the java file is created: e.g: C:\Program Files\Java\jdk-18}
		- Click Ok 
		- Click Path 
		- Edit 
		- Add %Java_Home%\bin
		- Click Ok 
		
	For Maven 
		- Click on New....
		- Add a Variable name : MAVEN_HOME
		- Add a Variable value : {location where the maven file is created: e.g: C:\Program Files\maven\apache-maven-3.9.2}
		- Click Ok 
		- Click Path 
		- Edit 
		- Add %MAVEN_HOME%\bin
		- Click Ok 

- Click Ok		

- Click Ok
		
- open cmd 

- Type: mvn -version 

-------

# Test execution:

- navigate to the folder where the project will be place
- git clone the project 
- open the project using vs code 
- on the terminal; run mvn clean install 
- navigate to the TestRunner.java file 
- run the test from that TestRunner.java class

# To retrieve the results:

- open cmd terminal as Admin
- navigate to the pom directory
- run allure generate allure-results -o allure-report --clean
- run allure serve allure-results
