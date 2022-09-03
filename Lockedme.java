package javaproject;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class Lockedme {
	static final String errorMessage = "error occured";
	static final String projectFilesPath = "C://MinGW//abbas";
	public static void main (String []args) throws IOException{
		Scanner obj = new Scanner (System.in);
		int opt;
	do {
		displayMenu();
		System.out.println("Enter your Option");
		opt = Integer.parseInt(obj.nextLine());
		switch (opt) {
		case 1 :
			 getAllFiles();
			 break;
		case 2 :
			 createFiles();
			 break;
		case 3: deleteAllFiles();
		  break;
		case 4: searchFiles();
		   break;
		case 5: System.exit(0);
		break;
		default : System.out.println("invalid option please between 1 to 5");
		} }
	while (opt>0);
	obj.close();
	}
	public static void displayMenu() {
		System.out.println("\t====================================");
		System.out.println("\tWelcome to LockedMe.Com");
		System.out.println("\t====================================");
		System.out.println("\tdeveloped by abbas");
		System.out.println("\t1. Display all the Files");
		System.out.println("\t2. Add a File");
		System.out.println("\t3. Delete a File");
		System.out.println("\t4. Search a File");
		System.out.println("\t5. Exit");
	}
	public static void getAllFiles() {
		try {
			File folder = new File (projectFilesPath);
			File[] listOfFiles= folder.listFiles();
		if (listOfFiles.length==0) {
			System.out.println("No Files Exist");
		}
		else {
			for (var l:listOfFiles) {
				System.out.println(l.getName());
			}
		}
			}
		catch(Exception Ex) {
			System.out.println(errorMessage);
		}
		
			
		}
	public static void createFiles() throws IOException{
		try {
			Scanner obj = new Scanner (System.in);
			System.out.println("Enter the File Name");
			String fileName = obj.nextLine();
			System.out.println("Enter how many lines in the file");
			int linesCount= Integer.parseInt(obj.nextLine());
			FileWriter myWriter = new FileWriter (projectFilesPath+"\\"+fileName);
			for (int i=1;i<=linesCount;i++){
				System.out.println("Enter the file line");
				myWriter.write(obj.nextLine()+"\n");
			}
			System.out.println("File has been created successfully");
		    myWriter.close();
			obj.close();
			
				
			}
		catch (Exception ex) {
			System.out.println("Some error has occured");
		}
		
	}
	public static void deleteAllFiles() {
		Scanner sc = new Scanner (System.in);
		try {
			System.out.println("Enter the file name to be deleted");
			String fileName = sc.nextLine();
			File file = new File(projectFilesPath + "\\"+fileName);
			if(file.exists()) {
				file.delete();
				System.out.println("File delelted Successfully ");
				
			}
			else {
				System.out.println("File does not exists");
			}
			
		}
		catch(Exception Ex) {
			System.out.println(errorMessage);
		}
		finally {
			sc.close();
		}
	}
	public static void searchFiles() {
		Scanner obj = new Scanner(System.in);
	  try {
		  String fileName;
		  System.out.println("Enter the file name to be Searched");
		  fileName = obj.nextLine();
		  
		  File folder = new File (projectFilesPath);
		  File[] listOfFiles = folder.listFiles();
		  LinkedList<String> filenames = new  LinkedList<String>();
		  
		  for(var l:listOfFiles) {
			  filenames.add(l.getName());
		  }
		  if (filenames.contains(fileName)) {
			  System.out.println("File is available");
		  }
		  else {
			  System.out.println("File is not available");
		  }
			  
	  }
	  catch (Exception Ex){
		  System.out.println(errorMessage);
	  }
	  finally {
		  obj.close();
	  }
	}
	
	}

