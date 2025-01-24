package com;

import java.io.*;
import java.util.Scanner;
public class FileHandlingUtility {


	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        String fileName = "abc.txt";
	        int choice;

	 

	        do {
	            System.out.println("\nChoose an operation:");
	            System.out.println("1. Write to File");
	            System.out.println("2. Read File");
	            System.out.println("3. Append to File");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();
	            sc.nextLine(); 

	            switch (choice) {
	                case 1:
	                    writeFile(fileName, sc);
	                    break;
	                case 2:
	                    readFile(fileName);
	                    break;
	                case 3:
	                    appendToFile(fileName, sc);
	                    break;
	                case 4:
	                    System.out.println("Exit succesfully");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        } while (choice != 4);

	        sc.close();
	    }

	    private static void writeFile(String fileName, Scanner sc) {
	        try (FileWriter writer = new FileWriter(fileName)) {
	            System.out.println("Enter text to write to the file:");
	            String text = sc.nextLine();
	            writer.write(text);
	            System.out.println("File written successfully.");
	        } catch (IOException e) {
	            System.out.println("Error writing to file: " + e.getMessage());
	        }
	    }

	    private static void readFile(String fileName) {
	        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	            String line;
	            System.out.println("\nContents of the file:");
	            while ((line = reader.readLine()) != null) {
	                System.out.println(line);
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("File not found. Please write to the file first.");
	        } catch (IOException e) {
	            System.out.println("Error reading file: " + e.getMessage());
	        }
	    }

	    private static void appendToFile(String fileName, Scanner sc) {
	        try (FileWriter writer = new FileWriter(fileName, true)) {
	            System.out.println("Enter text to append to the file:");
	            String text = sc.nextLine();
	            writer.write("\n" + text);
	            System.out.println("Text appended successfully.");
	        } catch (IOException e) {
	            System.out.println("Error appending to file: " + e.getMessage());
	        }
	    }
	

}
