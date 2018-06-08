package com.moole.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProductPageServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ProductId = req.getParameter("productid");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingkart", "root","test");
			String sql = "select productName,productPrice,availableCount from products where productid="+ProductId;
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println(ps.toString());
			ResultSet rs = ps.executeQuery();
			ProductForm products = new ProductForm();
			
			while(rs.next()){
				//products.setProductId(rs.getInt("productId"));
				products.setProductName(rs.getString("productName"));
				products.setProductprice(rs.getFloat("productPrice"));
				products.setAvailableCount(rs.getInt("availablecount"));

				//System.out.println("productId:"+rs.getInt(1));
				System.out.println("productName:"+rs.getString(1));
				System.out.println("productPrice:"+rs.getFloat(2));
				System.out.println("availableCount:"+rs.getInt(3));
			}
			PrintWriter pw = resp.getWriter();
			pw.println("<html><head><script src=\"Javascript/Validation.js\"></script></head><body>");
			pw.println("<form action=\"saveorder\" method=\"post\">");
			pw.println("<h1>Product Page</h1>");
			pw.println("<table align=\"center\"style=\"width:20%; margin:auto\" border=\"1\" cellspacing=\"0\">");
			pw.println("<tr>");
			pw.println("<input type=\"hidden\" id=\"productid\" name=\"productid\" value=\" " +ProductId + "\" />");
			pw.println("<td colspan=\"2\" align=\"center\"style=\"font-size:25px;\">"+products.getProductName()+"</td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>"+products.getProductprice()+"</td>");
			if (products.getAvailableCount()>0) {
				pw.println("<input type=\"hidden\" id=\"availableCnt\" value=\"" + products.getAvailableCount() + "\" />");
				pw.println("<td>In stock ("+products.getAvailableCount()+")</td>");
				
			} else {
				pw.println("<input type=\"hidden\" id=\"availableCnt\" value=\"" + products.getAvailableCount() + "\" />");
				pw.println("<td>Out Of stock</td>");
			}
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Quantity</td><td><input type=\"text\" id=\"quantity\" name=\"quantity\"></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td><input type=\"submit\" value=\"Order\" onclick=\"return OrderSubmit()\"/></td>");
			pw.println("<td><a href=\'Home.jsp\'><input type=\"button\" value=\"cancel\"></a></td>");
			pw.println("</tr>");
			pw.println("</table>");
			pw.println("</form>");
			pw.println("</body></html>");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		public void ProductPageServlet(){
			String productId = "1";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingkart", "root", "test");
				String sql = "select productName,productPrice,availableCount from products where productid="+productId;
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				ProductForm products = new ProductForm();
				
				while(rs.next()){
				//products.setProductId(rs.getInt("productId"));
				products.setProductName(rs.getString("productName"));
				products.setProductprice(rs.getFloat("productPrice"));
				products.setAvailableCount(rs.getInt("availablecount"));
				
				//System.out.println("productId:"+rs.getInt(1));
				System.out.println("productName:"+rs.getString(1));
				System.out.println("productprice:"+rs.getFloat(2));
				System.out.println("availablecount:"+rs.getInt(3));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public static void main(String[] args) {
			ProductPageServlet pp = new ProductPageServlet();
			pp.ProductPageServlet();
		}
}
