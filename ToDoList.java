import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class ToDoList{
	static String fileName="Menu.txt";
	public static void main(String[] args) throws IOException{
		int menuitem=-1;
		while(menuitem!=0){
		  menuitem=menu();
		  switch(menuitem){
		    case 0 : 
				break;
		    case 1 :    showList();
				break;
		    case 2 : 	addItem();
				break;
		    case 3 : 	removeItem();
				break;
		    default :   System.out.println("Dont recognize input!");
			}
		}
	}
	static int menu(){
		int choice;
		Scanner input=new Scanner(System.in);
		System.out.println("\n Main Menu ");
		System.out.println("0. Exit Menu ");
		System.out.println("1. Display Menu ");
		System.out.println("2. Add item in Menu ");
		System.out.println("3. Remove item from Menu ");
		System.out.println("Make a choice");
		choice=input.nextInt();
		return choice;
	}
	static void showList(){
		System.out.println("\n To Do List ");
		try{
		Scanner inFile=new Scanner(new FileReader(fileName));
		String line;
		int number=1;
		while(inFile.hasNextLine()){
			line=inFile.nextLine();
			System.out.print(number+" ");
			System.out.println(line);
			//System.out.println();
			++number;
		}
			System.out.println();
			inFile.close();
		}
		catch(IOException ioe){
		   System.out.println("Can't access file");
		}
	}
	static void addItem(){
		System.out.println("\nAdd item");
		try{
		PrintWriter outFile=new PrintWriter(new FileWriter(fileName,true));
		Scanner input=new Scanner(System.in);
		String item;
		System.out.println("Enter an item to be added ");
		item=input.nextLine();
		outFile.println(item);
		outFile.close();
		}
		catch(IOException ioe){
		   System.out.println("Can't access file");
		}
		
	}
	static void removeItem(){
		int choice;
		showList();
		Scanner input=new Scanner(System.in);
		System.out.println("Which item do you want to remove?");
		choice=input.nextInt();
		int number=1;
		ArrayList<String> items=new ArrayList<String>();
		try{
		Scanner inFile=new Scanner(new FileReader(fileName)); 
		String item;
		while(inFile.hasNextLine()){
			item=inFile.nextLine();
			if(number!=choice)
				items.add(item);
			++number;
			}
		PrintWriter outFile=new PrintWriter(new FileWriter(fileName));
		for(int i=0;i<items.size();i++)
			outFile.println(items.get(i));
		outFile.close();
		}
		catch(IOException ioe){
		   System.out.println("Can't access file");
		}
      }
}