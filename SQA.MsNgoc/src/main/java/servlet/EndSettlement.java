package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TransactionHistoryDAO;
import model.BankAccount;
import model.BankPassbook;
import model.Customer;
import model.TransactionHistory;

/**
 * Servlet implementation class CheckSettlement
 */
@WebServlet("/CheckSettlement")
public class EndSettlement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EndSettlement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		String CCCD=request.getParameter("cccd");
		String confirmpassword=request.getParameter("confirmpassword");
		TransactionHistory trans= (TransactionHistory)session.getAttribute("trans");
		Customer c= (Customer) session.getAttribute("customer");
		String password= (String) session.getAttribute("password");
		if(!CCCD.equals(c.getCCCD())||!password.equals(confirmpassword)) {
			response.sendRedirect("error.jsp");
		}
		
		else {
			(new TransactionHistoryDAO()).addTransaction(trans);
			response.sendRedirect("success.jsp");
		}
		
		
	}

}
