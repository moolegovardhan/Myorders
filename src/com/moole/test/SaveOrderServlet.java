package com.moole.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.management.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveOrderServlet extends HttpServlet{
	private int count;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String Quantity = req.getParameter("quantity");
		String productId = req.getParameter("productid");

		System.out.println("Quantity :" + Quantity + "|" + productId);
		
		Boolean isValid=false;
		System.out.println("Inside Orders List");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingkart", "root","test");

			String sql = "select productname,productprice,availableCount from products where productId=" + productId;
			// select productname, productprice, availablecount from products where productId=1;
			
			String query = "insert into orders(orderId,productId,productName,quantity,totalCost,creationDate) values(?, ?, ?, ?, ?, ?)";
			String query1 = "select max(orderId) from orders";
			
			PreparedStatement psmt = conn.prepareStatement(sql);

			ResultSet rs = psmt.executeQuery();

			String productName = "";
			float price = 0f;
			int avl = 0;
			while (rs.next()) {
				productName = rs.getString("productName");
				price = rs.getFloat("productprice");
				avl = rs.getInt("availableCount");
			}
			int qty = Integer.parseInt(Quantity);
			float totalcost = price * qty;
			
			psmt = conn.prepareStatement(query1);
			rs = psmt.executeQuery();
			int orderId = 0;
			while (rs.next()) {
				 orderId = rs.getInt(1);
				 System.out.println("OrderId:"+rs.getInt(1)); 
			}
			
			psmt = conn.prepareStatement(query);
	
			Calendar cal = Calendar.getInstance();
			
		
			psmt.setInt(1, orderId+1);
			psmt.setInt(2, Integer.parseInt(productId));
			psmt.setString(3, productName);
			psmt.setInt(4, qty);
			psmt.setFloat(5, totalcost);
			psmt.setTimestamp(6, new Timestamp(cal.getTimeInMillis()));
			
			int count = psmt.executeUpdate();
			System.out.println("Sql Query Update query:" + psmt + "|" + count);
			if (count > 0){
				isValid = true;
				String query2 = "update products set availableCount =" + (avl - qty) + " where productId=" + productId;
				// update products set availableCount=5 where productid=2;
				psmt = conn.prepareStatement(query2);
				psmt.executeUpdate();
			}
			PrintWriter pw = resp.getWriter();
			pw.println("<html><body");
			if (isValid) {
				pw.println("<h1>your order has been created. </h1>");				
			} else {
				pw.println("<h1>your order has not created</h1> ");
			}
			pw.println("</body></html>");
			
			psmt.close();
			conn.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		
		public void SaveOrder(){
			String productId="1";
			String Quantity = "1";
			Boolean isValid = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingkart", "root","test");

			String sql = "select productname,productprice from products where productId="+productId;
			String query = "insert into orders(orderId,productId,productName,quantity,totalCost,creationDate) values(?, ?, ?, ?, ?, ?)";
			String query1 = "select max(orderId) from orders";
			PreparedStatement psmt = conn.prepareStatement(sql);

			ResultSet rs = psmt.executeQuery();

			String productName = "";
			Float price = 0f;
			while (rs.next()) {
				productName = rs.getString("productName");
				price = rs.getFloat("productprice");
			}
			int qty = Integer.parseInt(Quantity);
			float totalcost = price * qty;
			psmt = conn.prepareStatement(query1);
			rs = psmt.executeQuery();
			int orderId = 0;
			while (rs.next()) {
				 orderId = rs.getInt(1);
				
			}
			psmt = conn.prepareStatement(query);
			
			//Date - java.util.Date
			//Date - java.sql.Date
			Calendar cal = Calendar.getInstance();
			
			//int orderId = 4;
			psmt.setInt(1, orderId+1);
			psmt.setInt(2, Integer.parseInt(productId));
			psmt.setString(3, productName);
			psmt.setInt(4, Integer.parseInt(Quantity));
			psmt.setFloat(5, totalcost);
			psmt.setTimestamp(6, new Timestamp(cal.getTimeInMillis()));
			System.out.println("Sql Query:"+psmt);
			int count = psmt.executeUpdate();
			if (count > 0){
				isValid = true;
			}
			psmt.close();
			conn.close();

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
		public static void main(String[] args) {
			SaveOrderServlet sv = new SaveOrderServlet();
			sv.SaveOrder();
		}
}


