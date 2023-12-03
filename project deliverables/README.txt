Project Name: Basketball Simulator

README

How to Build, Import, and Run the Basketball Simulator Project


1. Prerequisites
   - Java Development Kit (JDK) installed on your machine
   - Eclipse IDE installed on your machine

2. Building the Source Code
   - Open a command prompt or terminal.
   - Navigate to the root folder of the project.
   - Execute the following command to compile the source code:
     ```
     javac -d bin src/*.java
     ```
   - This command will compile all the Java source files in the 'src' folder and save the compiled classes in the 'bin' folder.

3. Importing the Project into Eclipse
   - Open Eclipse IDE.
   - Choose "File" > "Open Projects from File System" or use the Import Wizard.
   - In the dialog box, click on "Directory" and browse to the root folder of the project.
   - Click "Finish" to import the project into Eclipse.
   - Eclipse will automatically recognize the source code and configuration files.

4. Running the Program
   - After importing the project, locate the main class 'Team' in the package 'main'.
   - Right-click on the 'Team' class and select "Run As" > "Java Application" from the context menu.
   - The program will start running, and you will see the output in the console.

5. Creating a JAR File
   - To create a JAR file of your program, follow these steps:
     - Open a command prompt or terminal.
     - Navigate to the root folder of the project.
     - Execute the following command:
       ```
       jar -cvf BasketballSim.jar -C bin .
       ```
     - This command will create a JAR file named 'BasketballSim.jar' in the current directory.
     - The JAR file will contain all the compiled classes and resources required to run the program.

6. Running the Program from JAR
   - To run the program from the JAR file, use the following command:
     ```
     java -jar BasketballSim.jar
     ```
   - Make sure you have Java installed on your machine.
   - The program will start running, and you will see the output in the console.


