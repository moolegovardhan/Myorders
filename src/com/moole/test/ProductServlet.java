
package com.moole.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ProductServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingKart","root","test");

			String sql = "select * from products";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			List<ProductForm> ls = new ArrayList<ProductForm>();

			while (rs.next()) {

				ProductForm products = new ProductForm();
				products.setProductId(rs.getInt("productId"));
				products.setProductName(rs.getString("productname"));
			/*	products.setPrice(rs.getFloat("productPrice"));
				products.setAvailableCount(rs.getInt("availableCount"));
				products.setCreationDate(rs.getTimestamp("creationDate"));*/

				ls.add(products);

				rs.getInt(1);
				System.out.println("productId:"+rs.getInt(1));
				rs.getString(2);
				System.out.println("productName:"+rs.getString(2));
				rs.getFloat(3);

			}
			PrintWriter pw = resp.getWriter();
			pw.println("<html><body>");
			pw.println("<h1 style=\"margin-left:548px\">List Of Products</h1>");
		
			pw.println("<table align=\"cenetr\" style=\"width:30%; margin:auto\" border=\"1\" cellspacing=\"0\">");
			pw.println("<th>PId</th>");
			pw.println("<th>ProductName</th>");
			

			for (Iterator iterator = ls.iterator(); iterator.hasNext();) {
				ProductForm productForm = (ProductForm) iterator.next();
				pw.println("<tr>");	
				pw.println("<td id=\"Id\">"+productForm.getProductId()+"</td>");
				pw.println("<td><a href=\"productpage?productid=" + productForm.getProductId() + "\">"+productForm.getProductName()+"</a></td>");
				/*pw.println("<td>"+productForm.getPrice()+"</td>");*/
				/*if (productForm.getAvailableCount()>0) {
					pw.println("<td id=\"Avl\">In stock ("+productForm.getAvailableCount()+")</td>");
					
				}else {
					pw.println("<td id=\"Avl\">Out Of stock</td>");
				}*/
				/*pw.println("<td>"+productForm.getAvailableCount()+"</td>");*/
				/*pw.println("<td>"+productForm.getCreationDate()+"</td>");*/
			/*	pw.println("<td ><input id=\"qnty\" type=\"text\" value=\"\"></td>");*/
				pw.println("</tr>");
			}
			pw.println("</table>");
			
			pw.println("</body></html>");

		} catch (Exception e) {
			e.printStackTrace();
		}


	}
/*
	public void productsList() {
		System.out.println("imside products list");
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingKart","root","test");

			String sql = "select * from products";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			List<ProductForm> ls = new ArrayList<ProductForm>();


			while (rs.next()) {

				ProductForm products = new ProductForm();
				products.setProductId(rs.getInt("productId"));
				products.setProductName(rs.getString("productname"));
				ls.add(products);

				rs.getInt(1);
				System.out.println("productId:"+rs.getInt(1));
				rs.getString(2);
				System.out.println("productName:"+rs.getString(2));
				rs.getFloat(3);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ProductServlet pdct = new ProductServlet();
		pdct.productsList();
	}*/

}
