import java.util.Scanner;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.*;
import java.util.ArrayList;
import java.lang.IllegalStateException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;

 
class BankManager 
{
	
	//private final static MenuOption[] choices = MenuOption.values();
	public static void main(String [] Args)
	{
		int exit = 1;
		System.out.println("\n-----------------------------------------------------------------------------------------------------------------------");
		System.out.println("|-------------------------------------------------BANK MANGER---------------------------------------------------------|");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------\n");
		while(exit!=0)
		{
			Scanner type = new Scanner(System.in);
			System.out.println("Do you want to fetch recrods using Files or DataBase? \n 1.Files \n 2.Database \n 3.Exit");
			int rec = type.nextInt();
			switch(rec)
			{
			case 2:
			//DataBaseJ dbj = new DataBaseJ();
			//dbj.db();
			System.out.println("Remove the comment and try running it again");
			break;
			case 1:
			CreditInquiry ci = new CreditInquiry();
			String[] start = {""};
			ci.main(start);
			break;
			case 3:
			exit = 0;
			break;
			default:
			System.out.println("Please enter the right option");
			break;
			}
		}
	}
	
	
}



