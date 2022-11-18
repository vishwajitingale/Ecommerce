package com.ecommerce;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

public class ProductList {
	
	public void productList() {
		
		MakeConnection c=new MakeConnection();
		Connection con = c.getConnection();
		
		
		try {
			Statement s1=con.createStatement();
			ResultSet rs = s1.executeQuery("select Pro_Id, Pro_Name, Pro_Description, Pro_Price, Quantity from product_info");
			
			while (rs.next()) {
				
				System.out.println("Product Code        : "+rs.getInt("Pro_Id"));
				System.out.println("Product Name        : "+rs.getString("Pro_Name"));
				System.out.println("Product Description : "+rs.getString("Pro_Description"));
				System.out.println("Product Price       : "+rs.getString("Pro_Price"));
				System.out.println();
				System.out.println(".................................................................................................................");
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	public void cart() {
		System.out.println("     .......................................... <{ C A R T }> ..........................................");
		System.out.println();
		System.out.println();
		
		User u = new User();
		
		Iterator itr = u.a.iterator();
		Iterator itr1 = u.b.iterator();
		
		while(itr.hasNext()) {
			System.out.println();
			System.out.println("     Product Name        : "+itr.next());
			System.out.println("     Product Price       : "+itr1.next());
			System.out.println("     ...............................................................................................");
		}
	
		System.out.println();
		System.out.println();
		
		int total=0;
		for(int i=0;i<u.b.size();i++) {
			total=total+u.b.get(i);
		}
		
		System.out.println("     Total Price        : "+total);
		
	}
	
}
