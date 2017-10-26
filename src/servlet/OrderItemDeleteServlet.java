package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrderItem;
import bean.Product;
import dao.ProductDAO;

public class OrderItemDeleteServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("id"));

		List<OrderItem> ois = (List<OrderItem>) request.getSession().getAttribute("ois");
			
		OrderItem temp = null;
		for (OrderItem orderItem : ois) {
			if (orderItem.getProduct().getId() == productId) {
				temp = orderItem;
				
			}
		}
		ois.remove(temp);

		response.sendRedirect("/cart/listOrderItem");

	}
}