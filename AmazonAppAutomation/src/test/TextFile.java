package test;

import java.io.FileWriter;

public class TextFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{    
	           FileWriter fw=new FileWriter("C:\\Users\\nikit\\eclipse-workspace\\AmazonAppAutomation\\Output.txt");    
	           fw.write("Welcome to Amazon");
	           fw.close();
	          }catch(Exception e){System.out.println(e);}    
	          System.out.println("Success...");
	}

}
