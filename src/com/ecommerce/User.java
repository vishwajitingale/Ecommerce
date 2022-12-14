package com.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class User {
	
	static ArrayList<String> a = new ArrayList<>();
	static ArrayList<Integer> b = new ArrayList<>();
	
	static ArrayList<String> proName = new ArrayList<>();
	static ArrayList<String> proPrice = new ArrayList<>();
	static ArrayList<Integer> price = new ArrayList<>();
	
	
	int code2;
	
	public void register(String name,String passward) {
		
		MakeConnection c=new MakeConnection();
		Connection con = c.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("insert into user values(?,?)");
			stmt.setNString(1,name);
			stmt.setNString(2,passward);
			stmt.executeUpdate();
			
			System.out.println();
			System.out.println("    ................................... <{ Registered Successfully }> ...................................     ");
			
		} catch (SQLException e) {	
			System.out.println();
			System.out.println();
			System.out.println("                               <{ UserName ( "+name+" ) is already exist }>");
			System.out.println();
			System.out.println("                   <{ Please Try with another UserName Or Login with existing UserName }>");
			System.out.println();
			System.out.println();
			System.out.println("    ................................... <{ Thank You. Visit Again }> ...................................");
			System.exit(0);
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void login(String name,String passward) {
		
		MakeConnection c=new MakeConnection();
		Connection con = c.getConnection();
		User u =new User();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from user where UserName = ? and Passward = ?");
			stmt.setString(1, name);
			stmt.setString(2, passward);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				System.out.println();
			    System.out.println("      ................................... <{ Login Successfully }> ...................................     ");
			}else {
				u.invalidCredential();
			}
			
		} catch (SQLException e) {
			u.invalidCredential();
		}
		
	}
	
	
	
	public void buyProduct(int num,String name) {
		
		User u = new User();
		MakeConnection c=new MakeConnection();
		Connection con = c.getConnection();
		PreparedStatement stmt=null;
		Statement s =null;
		String num1 = Integer.toString(num);
		
		
		try {
			s=con.createStatement();
			String query = "select Pro_Name, Pro_Price from product_info where Pro_Id="+num1;
			ResultSet rs = s.executeQuery(query);
			if(rs.next()) {
				
				proName.add(rs.getString("Pro_Name")); 
				proPrice.add(rs.getString("Pro_Price"));
				price.add(rs.getInt("Pro_Price") );
				
				a.add(rs.getString("Pro_Name"));
				b.add(rs.getInt("Pro_Price"));
					
			}else {
				System.out.println();
				System.out.println();
				System.out.println("      Invalid Input <{ Please Enter Valid Product Code }>");
				Scanner sc = new Scanner(System.in);
				int num2=sc.nextInt();
				u.buyProduct(num2,name);
			}
			
		} catch (SQLException e) {
			u.invalid();
			
		}	/*finally {
			try {
				s.close();
				//stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}*/
	}
	
	
	public void OrderPlace(String name) {
	
		MakeConnection c=new MakeConnection();
		Connection con = c.getConnection();
		PreparedStatement stmt=null;
		
		Iterator itr = proName.iterator();
		Iterator itr1 = proPrice.iterator();
		
		while(itr.hasNext()) {
			
			String pName= itr.next().toString();
			String pPrice = itr1.next().toString();
		
			try {
				stmt = con.prepareStatement("insert into user_history values (?,?,?)");
				stmt.setString(1,name);
				stmt.setString(2,pName);
				stmt.setString(3,pPrice);
				stmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}		
		
	}
	
	
	
	public int addMore(String name) {
		System.out.println();
		System.out.println("                                          <{ Enter Product Code }>");
		Scanner sc =new Scanner(System.in);
		int code1 = sc.nextInt();
		User u = new User();
		u.buyProduct(code1,name);
		System.out.println();
		System.out.println("                          <{ Add More (Press 1) }>          <{ Go to Cart (Press 2) }>");
		code2 = sc.nextInt();
		return code2;
	}

	
	public void invalid() {
		System.out.println();
		System.out.println();
		System.out.println("      Invalid Input <{ Please Try Again }>");
		System.out.println();
		System.out.println("  ................................... <{ Thank You. Visit Again }> ...................................");
		System.exit(0);
	}
	
	public void invalidCredential() {
		System.out.println();
		System.out.println("      <{ Invalied Credentials }>");
		System.out.println();
		System.out.println("      ................................... <{ Please Try Again }> ...................................     ");
		System.exit(0);
	}
	
}
