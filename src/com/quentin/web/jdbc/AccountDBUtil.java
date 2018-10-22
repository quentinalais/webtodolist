package com.quentin.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;



public class AccountDBUtil {
	
	public DataSource dataSource;
	
	public AccountDBUtil(DataSource theDataSource) 
	{ 
		dataSource = theDataSource; 
	}
	
  
	
	
	public List<Account>getStudents()throws Exception{
		List<Account> comptes = new ArrayList<Account>();
		
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myRs=null;
		
		try {
			myConn = dataSource.getConnection();
			myStmt = myConn.createStatement();
			String sql ="select * from webtodolist.account order by username";
			myRs = myStmt.executeQuery(sql);
			
			while(myRs.next())
			{
				int id=myRs.getInt("id");
				String user=myRs.getString("username");
				String passw =myRs.getString("password");
			
				Account tempAccount = new Account(user,passw);
				comptes.add(tempAccount);
				
			}
			return comptes;
		}finally {
			close(myConn,myStmt,myRs);
		}	
		
	}
	
	
	private void close(Connection myConn , Statement myStmt,ResultSet myRs)
	{
		try {
			if(myStmt!=null)
				myStmt.close();
			if(myRs!=null)
				myRs.close();
			if(myConn!=null)
				myConn.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean CheckAccount(Account compte)
	{
		boolean resultat=false;
		Connection myConn=null; 
		PreparedStatement myStmt = null;
		ResultSet myRs= null;
		try
		{
			System.out.println("Y'a eu un ");
			
			myConn = dataSource.getConnection(); 
			System.out.println("Y'a eu deux");
			String sql = "select username,password from account where username=? and password=?;"; 
			
			 
			
			String user = compte.getUsername();    
			String passw = compte.getPassword();    
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, user); 
			myStmt.setString(2, passw); 
			
		
			myStmt.execute();
			resultat=true;
		} 
		catch(Exception e)
		{ 
			System.out.println("Y'a eu un problème dans le CheckAccount");
			
		}
	
		
		finally{ close(myConn,myStmt,myRs); 
		
		}
		return resultat;
	}

}
