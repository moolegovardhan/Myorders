package com.moole.test;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {try {
				Class.forName("com.mysql.jdbc.Driver");

				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingKart","root","test");

				String sql = "select * from orders";

				java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);

				ResultSet rs = pstmt.executeQuery();
				List<OrderForm> ls = new ArrayList<OrderForm>();
				while (rs.next()) {

					OrderForm orders = new OrderForm();
					orders.setOrderId(rs.getInt("orderId"));
					orders.setProductId(rs.getInt("productId"));
					orders.setProductname(rs.getString("productName"));
					orders.setTotelCost(rs.getFloat("Quantity"));
					orders.setQuantity(rs.getInt("TotalCost"));
					orders.setCreationDate(rs.getTimestamp("creationDate"));

					ls.add(orders);

					//rs.getInt(1);
					System.out.println("orderId:"+rs.getInt(1));
					//rs.getInt(2);
					System.out.println("productId:"+rs.getInt(2));
					//rs.getInt(3);
					System.out.println("productName:"+rs.getString(4));
					//rs.getString(4);
					System.out.println("Quantity:"+rs.getInt(3));
					//rs.getFloat(5);
					System.out.println("TotalCost:"+rs.getFloat(4));
					//rs.getTimestamp(6);
					System.out.println("CreationDate:"+rs.getTimestamp(5));
				}
				PrintWriter pw = resp.getWriter();
				pw.println("<html><body>");
				pw.println("<h1>Your orders are</h1>");
				/*pw.println("<form action=\"/orderview\" method=\"post\">");*/
				pw.println("<div align=\"top\">" );
				pw.println("<table align=\"cenetr\" style=\"width:100% margin:auto\" border=\"1\" cellspacing=\"0\">");
				pw.println("<th>orderId</th>");
				pw.println("<th>productId</th>");
				pw.println("<th>productName</th>");
				pw.println("<th>totalcost</th>");
				pw.println("<th>Quantity</th>");
				pw.println("<th>CreationDate</th>");

				for (Iterator iterator = ls.iterator(); iterator.hasNext();) {
					OrderForm orderForm = (OrderForm) iterator.next();
					pw.println("<tr>");	
					pw.println("<td>"+orderForm.getOrderId()+"</td>");
					pw.println("<td>"+orderForm.getProductId()+"</td>");
					pw.println("<td>"+orderForm.getProductname()+"</td>");
					pw.println("<td>"+orderForm.getQuantity()+"</td>");
					pw.println("<td>"+orderForm.getTotelCost()+"</td>");
					pw.println("<td>"+orderForm.getCreationDate()+"</td>");
					pw.println("</tr>");
				}
				pw.println("</table>");
				pw.println("<td><a href=\'Home.jsp\'><input type=\"button\" value=\"back\"></a></td>");
				/*pw.println("</form>");*/
				pw.println("</body></html>");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
