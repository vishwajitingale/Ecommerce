package com.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Admin {
	
	public void login(String name,String passward) {
		String n = "admin";
		String p = "admin@123";
		User u = new User();
		
			if(n.equals(name) && p.equals(passward)) {
				System.out.println();
			    System.out.println("     ................................... <{ Login Successfully }> ...................................     ");
			}else {
				u.invalidCredential();
			}
	}


	public void view(int num) {
		MakeConnection m =new MakeConnection();
		Connection con = m.getConnection();
		Statement s = null;
		Scanner sc = new Scanner(System.in);
		User u = new User();
		
		if (num==1) {
			System.out.println();
			System.out.println("      <{ Enter Product Code }>");
			int code = sc.nextInt();
			System.out.println();
			ProductList p = new ProductList();
			
			try {
				s = con.createStatement();
				ResultSet rs = s.executeQuery("select Pro_Id,Pro_Name,Quantity from product_info where Pro_Id ="+code);
				if(rs.next()) {
					System.out.println("      Product Code        : "+rs.getInt("Pro_Id"));
					System.out.println("      Product Name        : "+rs.getString("Pro_Name"));
					System.out.println("      Product Quantity    : "+rs.getString("Quantity"));
					
					System.out.println();
					System.out.println();
					System.out.println("    ................................... <{ Thank You. Visit Again }> ...................................");
					rs.close();
				}
				
			} catch (SQLException e) {
				System.out.println("      Invalied Product code <{ Please Try Again }>");
			}	finally {
				try {
					s.close();
					con.close();
					System.exit(0);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}else if (num==2) {
			System.out.println();
			try {
				s=con.createStatement();
				ResultSet rs= s.executeQuery("select UserName from user");
				while(rs.next()) {
					System.out.println();
					System.out.println("      "+rs.getString("UserName"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			u.invalid();
		}// end statement
			
		
		System.out.println();	
		System.out.println();
		System.out.println("      <{ To Check Order History then Enter UserName }>");
		String name2 = sc.next();
		
		System.out.println();
		System.out.println(" ..................................... <{ Order History of ("+name2+") }> .......................................");
		System.out.println();
		
		try {
			PreparedStatement stmt = con.prepareStatement("select Products,TotalPrice from user_history where UserName = ?");
			stmt.setString(1, name2);
			ResultSet rs= stmt.executeQuery();
			
			while(rs.next()) {
				System.out.println();
				System.out.println("Product Name  :"+rs.getString("Products"));
				System.out.println("Product Price :"+rs.getString("TotalPrice"));
				
			}
			System.out.println();
			   System.out.println();
			   System.out.println("      ................................... <{ Thank You. Visit Again }> ...................................");
			
			
		} catch (SQLException e) {
		u.invalid();
		}
			
			
	}
	

	
	

}
