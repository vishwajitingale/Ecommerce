package com.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		MakeConnection m=new MakeConnection();
		Connection con = m.getConnection();
		PreparedStatement stmt =null;
		
		System.out.println();
		System.out.println("      .................................. <{ W E L L C O M E }> ...................................");
		System.out.println();
		System.out.println("      <{ For Register (Press 1) }>     "+"<{ For Login (press 2) }>     "+"<{ For Admin Login (press 3) }>");
		Scanner sc =new Scanner(System.in);
		int num=sc.nextInt();
		String name="UserName";
		User u=new User();
		Admin ad =new Admin();
		
		if(num==1) {
			System.out.println();
			System.out.println("      <{ Enter UserName }>");
			name=sc.next();
			System.out.println();
			System.out.println("      <{ Enter Passward }>");
			String pass=sc.next();
			
			u.register(name, pass);
			
			
		}else if(num==2){
			System.out.println();
			System.out.println("      <{ Enter UserName }>");
			name=sc.next();
			System.out.println();
			System.out.println("      <{ Enter Passward }>");
			String pass=sc.next();
			
			u.login(name, pass);
			
		}else if(num==3) {
			System.out.println();
			System.out.println("      <{ Enter UserName }>");
			String username=sc.next();
			System.out.println();
			System.out.println("      <{ Enter Passward }>");
			String passward=sc.next();
	
		    ad.login(username, passward);
		    
		    System.out.println();
		    System.out.println();
		    System.out.println("         <{ View Product Quantity (Press 1) }>            <{ View Users List (Press 2) }> ");
		    int num2 = sc.nextInt();
		    ad.view(num2);
		    
			System.exit(0);
		}else {
			u.invalid();
		}
		
		System.out.println();
		System.out.println();
		System.out.println("  ................................... <{ Selct Product What You Want }> ...................................");
		System.out.println();
		System.out.println();
		
		ProductList l=new ProductList();
		l.productList();
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("                                    <{ Want to Buy (Enter Product Code)}>");
		
		int code = sc.nextInt();
		u.buyProduct(code,name);
		System.out.println();
		
		System.out.println("                          <{ Add More (Press 1) }>          <{ Go to Cart (Press 2) }>");
		int code1 = sc.nextInt();
		
		if(code1==1) {
			do {
				u.addMore(name);
			}while(u.code2 == 1);
			
		}else if(code1 !=2) {
			u.invalid();
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		l.cart();
		
		System.out.println();
		System.out.println();
		System.out.println("                         <{ Conform Order (Press 1) }>       <{ Cancel Order (Press 2) }>");
		int order = sc.nextInt();
		if(order==1) {
			System.out.println();
			System.out.println();
			u.OrderPlace(name);
		   System.out.println("                                         Order Place Successfully ! ! !");
		   
		   
		   
		  
		   
		}else if (order==2) {
			System.out.println();
			System.out.println();
		   System.out.println("                                         Order Cancel Successfully ! ! !");
		}else {
			u.invalid();
		}
		
		   System.out.println();
		   System.out.println();
		   System.out.println("      ................................... <{ Thank You. Visit Again }> ...................................");
		
		
		
		
		
	}

}
