import java.util.Scanner;import java.io.IOException;import java.sql.*;import java.sql.Connection;import java.sql.DriverManager;import java.sql.PreparedStatement;import java.sql.ResultSet;
import java.sql.ResultSetMetaData;import java.sql.SQLException;import java.sql.Statement;import javax.swing.table.*;import java.util.ArrayList;import java.lang.IllegalStateException;
import java.nio.file.Paths;import java.util.NoSuchElementException;

class DataBaseJ
{

	static
			  {
			    try
			    {
			      // loads com.mysql.jdbc.Driver into memory
			      Class.forName("com.mysql.jdbc.Driver");
			    } 
			    catch (ClassNotFoundException cnf) 
			    {
			      System.out.println("Driver could not be loaded: " + cnf);
			    }
			  }
	
	public static void db()
	{
		int exit=1;
		while(exit!=0)
		{
			System.out.println("\n--------------------------------------------------Welcome To DataBase--------------------------------------------------");
			System.out.println("Select an Option\n1.DEBIT ACCOUNT\n2.CREDIT ACCOUNT\n3.ZERO ACCOUNT\n4.ALL ACCOUNTS\n5.EXIT");
			Scanner op = new Scanner(System.in);
			int optionNumber = op.nextInt();
			if(optionNumber !=5)
			requestList(optionNumber);
			else
			exit=0;
		}
	}
	private static void requestList(int option)
	{
		switch(option)
		{

			case 1:
			sqlCommand("select * from bankdata where account_balance < 0 ");
			break;
			case 2:
			sqlCommand("select * from bankdata where account_balance>0 ");
			break;
			case 3:
			sqlCommand("select * from bankdata where account_balance = 0 ");
			break;
			case 4:
			sqlCommand("select * from bankdata");
			break;
			default:
			System.out.println("Please enter the right option");
			break;
		
		}
		
	}
	private static void sqlCommand(String cmd)
		{
		 String align ="| %-4s | %-25s | %-40s | %2s |%n";
		 System.out.format("+------+-----------------------+-------------------+-----------------------------------%n");
		 System.out.format("| ID   +	   NAME	       +	    TYPE   +                          | BALANCE|%n");
			try
			{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");
			con.setAutoCommit(false);
			ResultSet rs;
			Statement smt = con.createStatement();
			long lStartTime = System.nanoTime();
			rs = smt.executeQuery(cmd);
			while(rs.next())
	 	 	 {
		  	 String id  =rs.getString(1);
		 	 String name  =rs.getString(2);
			 String type = rs.getString(3);
			 int balance = rs.getInt(4);
			 System.out.format(align,id,name,type,"$"+Integer.toString(balance));
	 	  	 }
	 	  	 long lEndTime = System.nanoTime();
			 double output = lEndTime - lStartTime;
		 	System.out.printf("\t\t\t\tFetch Time: %.3f Seconds\n\n",output / 1000000000);
			}catch(Exception e){}
		}

}